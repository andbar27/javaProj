const job = (data) => {
    return new Promise((resolve, reject) => {
        if(isNaN(data))
            reject("errore");

        if(data % 2)
            setTimeout(() => {
                resolve("dispari");
            }, 1000);

        else
            setTimeout(() => {
                resolve("pari")
            }, 2000);

    });
}

job("2").then((res) => console.log(res)).catch((err) => console.log(err));
