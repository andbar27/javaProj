const job = () => {
    new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log("ciao mondo")
            resolve("ciao mondo");
        }, 2000);
    });
    console.log( "hello world");
}

let jobP = new Promise((resolve, reject) => {
    console.log("hello world P")
    setTimeout(() => {
        resolve("ciao mondo P");
    }, 3000);
});

jobP.then((ris) => {
    console.log(ris);
}).catch((err)=>{
    console.log(err);
});
job();
/*
job.then((ris) => {
    console.log(ris);
}).catch( (err) => {
    console.log(err);
})
*/