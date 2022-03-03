
var target = 31;
console.log(`Convert ${target} to binary`)

function decimalToBinary(decimal) {
    return (decimal >>> 0).toString(2);
}

var storedBinary = decimalToBinary(target);
console.log(`${target} in binary is ${storedBinary}`)
