
def baseNeg2(n) -> str:
        if n in [0, 1]: return str(n)
        if n % 2 == 0:
            return baseNeg2(n // -2) + '0'
        else:
            return baseNeg2((n - 1) // -2) + '1'


print(baseNeg2(83))