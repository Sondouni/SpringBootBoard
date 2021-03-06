package com.koreait.springbootboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration //똑같은 빈 등록인데 설정파일로 등록함 ( application.xml,dispat....xml같이)
@EnableWebSecurity //SpringSecurityFilterChain이 자동으로 포함
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource; //Hikari DB연결

    /*
    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/css/**","/js/**");
    }
    쓰게되면 첫 로그인때 에러가 발생
     */



    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers(              //로그인과 상관없이 매칭.
                "/","/css/**","/js/**","/board/list","/board/detil","/board/detail_item"
                        ,"/ajax/comment","/ajax/board/**"
                ).permitAll() // 위 주소창들을 승인하겠다.
                .anyRequest().authenticated()//위 주소값 이외에 것들은 인증 authenitcated 해야한다

                .and() //그대로 이 값(http)를 사용하겠다

                .formLogin() //세큐리티 로그인 폼
                .loginPage("/user/login")
                .usernameParameter("uid") //defualt : username
                .passwordParameter("upw") //default : password -> 같으면 안적어도 됨
                .successHandler(new MyLoginSuccessHandler())
                .permitAll()

                .and()

                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/user/login")

                .permitAll();

    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT uid as username, upw as password, 1 as enabled "
                        + " FROM t_user "
                        + " WHERE uid = ?")
                .authoritiesByUsernameQuery("SELECT uid as username, auth as authority "
                        + "FROM t_user "
                        + "WHERE uid = ?");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
