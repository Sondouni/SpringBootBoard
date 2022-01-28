console.log(icategory);
if(icategory){
    fetch(`/ajax/board/${icategory}`).then(res=>res.json()).then((data)=>{
        console.log(data);
    });
}