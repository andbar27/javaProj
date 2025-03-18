const callback1 = () => {
    return new Promise((res, rej) => {
        setTimeout(() => res("c1"), 2000);
    });
}

const callback2 = () => {
    return new Promise((res, rej) => {
        setTimeout(() => res("c2"), 1000);
    });
}

let promise = callback1();

promise.then((res1) => {
    console.log(res1);
    return callback2();
}).then((res2) => {
    console.log(res2);
    return callback2();
}).then((res3) => {
    console.log(res3);
    return callback2();
}).then((res4) => {
    console.log(res4);
});

