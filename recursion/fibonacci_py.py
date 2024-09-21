def fibo(n):
    if n<=1:
        return n
    first = fibo(n-1)
    last = fibo(n-2)
    return first+last
no = 7
print(fibo(no))