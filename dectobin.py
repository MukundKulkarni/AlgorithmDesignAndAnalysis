def dectobin( n ):
    if n == 0:
        return 0
    else:
        return (n % 2 + 10 *
                dectobin(int(n / 2)))

decimal_number = 10
print(dectobin(decimal_number))
