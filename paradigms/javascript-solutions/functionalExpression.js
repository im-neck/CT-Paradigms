"use strict"
const cnst = (value) =>()=>value;
const variable = (name) => {
    switch (name){
        case 'x' : return (...args) => args[0];
        case 'y' : return (...args) => args[1];
        case 'z' : return (...args) => args[2];
    }
};
// :NOTE:  не исправились ошибки
const add = (a, b) => (...args) => a(...args) + b(...args);
const subtract = (a, b) => (...args) => a(...args) - b(...args);
const multiply = (a, b) => (...args) => a(...args) * b(...args);
const divide = (a, b) => (...args) => a(...args) / b(...args);
const negate = (a) => (...args) => -a(...args);
const square = (a) => (...args) => Math.pow(a(...args),2);
const sqrt = (a) => (...args) => Math.sqrt(Math.abs(a(...args)));
const pi = cnst(Math.PI);
const e = cnst(Math.E);
const cbrt = (a) => (...args) => Math.cbrt(a(...args));
const cube = (a) => (...args) => Math.pow(a(...args),3);








