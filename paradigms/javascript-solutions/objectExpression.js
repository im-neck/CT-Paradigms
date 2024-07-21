"use strict"

function Operation(sign, op, ...operands) {
    this.sign = sign
    this.op = op
    this.operands = operands
}

const mapOperation = {}

function createOperation(sign, op) {
    const x = function (...operands) {
        this.operands = operands
    }
    x.prototype = Object.create(Operation.prototype)
    x.prototype.sign = sign
    x.prototype.op = op
    mapOperation[sign] = [x, op.length];
    return x
}

Operation.prototype.evaluate = function (...args) {
    return this.op(...this.operands.map((a) => a.evaluate(...args)))
}
Operation.prototype.toString = function () {
    return `${this.operands.map((a) => a.toString()).join(' ')} ${this.sign}`
}
Operation.prototype.prefix = function () {
    return `(${this.sign} ${this.operands.map((a) => a.prefix()).join(' ')})`
}

const Negate = createOperation("negate", (a) => -a)
const Sinh = createOperation("sinh", (a) => Math.sinh(a))
const Cosh = createOperation("cosh", (a) => Math.cosh(a))

const Add = createOperation("+", (a, b) => a + b)
const Subtract = createOperation("-", (a, b) => a - b)
const Multiply = createOperation("*", (a, b) => a * b)
const Divide = createOperation("/", (a, b) => a / b)

const Product = createOperation("product", (...ops) => ops.reduce((a, b) => a * b, 1))
const Geom = createOperation("geom", (...ops) => Math.pow(Math.abs(ops.reduce((a, b) => a * b, 1)), (1 / (ops.length))))

function Const(a) {
    this.a = a
    Operation.call(this, "", (a) => parseFloat(a), a)
}

Const.prototype = Object.create(Operation.prototype)
Const.prototype.evaluate = function (...args) {
    return parseFloat(this.a)
}
Const.prototype.toString = function () {
    return String(this.a)
}
Const.prototype.prefix = function () {
    return String(this.a)
}

const mapVar = {
    "x": 0,
    "y": 1,
    "z": 2
}


function Variable(name) {
    Operation.call(this, "", (a) => a, name)
}


Variable.prototype = Object.create(Operation.prototype)
Variable.prototype.evaluate = function (...args) {
    return args[mapVar[this.operands[0]]]
}
/*Variable.prototype.evaluate =  (...args) => args[mapVar[this.operands[0]]]*/
Variable.prototype.toString = function () {
    return (this.operands[0])
}
Variable.prototype.prefix = function () {
    return (this.operands[0])
}


function parseOperand(operand) {
    if (operand instanceof Operation) {
        return operand
    } else if (!isNaN(operand)) {
        return (new Const(parseFloat(operand)))
    } else if (operand in mapVar) {
        return (new Variable(operand))
    }
}

function makeExpr(op, stackOperands) {
    let ops = []
    for (let i = 0; i < mapOperation[op][1]; i++) {
        ops.push(stackOperands.pop())
    }
    stackOperands.push(new mapOperation[op][0](...ops.reverse()))
}

function parse(expr) {
    expr = expr.trim()
    const stack = expr.split(/\s+/g)
    stack.reverse()
    let stackOperands = [];
    while (stack.length > 0) {
        let temp = stack.pop();
        if (temp in mapOperation) {
            makeExpr(temp, stackOperands)
        } else {
            stackOperands.push(parseOperand(temp))
        }
    }
    return stackOperands.pop()
}

function createError(message) {
    //const x = function (...operands) {this.operands = operands}
    //const x;
    const x = Object.create(Error)
    x.message = message
    return x
}


function makeExprPref(St) {
    const op = St.pop()
    let operands = []
    if (!(op in mapOperation)) {
        throw new ExpressionError("no arguments for operation")
    }
    let temp = St.pop();
    while (temp !== ')') {
        if (parseOperand(temp) === undefined) {
            throw new ExpressionError("no arguments for operation")
        }
        operands.push(temp)
        temp = St.pop();
    }
    if (mapOperation[op][1] === 0) {

    } else if (mapOperation[op][1] < operands.length) {
        throw new ExpressionError("there are too many arguments")
    } else if (mapOperation[op][1] > operands.length) {
        throw new ExpressionError("not enough arguments") // :NOTE: more info
    }
    St.push(new mapOperation[op][0](...operands))
}


function ExpressionError(message) {
    this.message = message
}


function parsePrefix(expr) {
    expr = expr.replaceAll("(", " ( ")
    expr = expr.replaceAll(")", " ) ")
    expr = expr.trim()
    const stack = expr.split(/\s+/g).filter(Boolean)
    const St = []
    let bracketBalance = 0
    while (stack.length > 0) {
        let temp = stack.pop();
        if (temp === ")") {
            St.push(temp)
            bracketBalance--
        } else if (temp in mapOperation) {
            St.push(temp)
        } else if (parseOperand(temp) !== undefined) {
            St.push(parseOperand(temp))
        } else if (temp === '(') {
            bracketBalance++
            if (bracketBalance > 1 || !(St.includes(')'))) {
                throw new ExpressionError("incorrect number of brackets")
            }
            makeExprPref(St)
        } else {
            throw new ExpressionError("incorrect symbol")
        }
    }
    if (bracketBalance !== 0) {
        throw BracketErorr
    }
    if (St.length !== 1) {
        throw new ExpressionError("no arguments for operation")
    }
    return St.pop()
}
