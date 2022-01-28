(
    function (){
        'use strict'

        var form = document.querySelector('#joinfrm');
        form.addEventListener('submit',(e)=>{
            if(form.checkValidity()===false){
                e.preventDefault();
                e.stopPropagation();
                form.classList.add('was-validated');
            }
        });
    }

)