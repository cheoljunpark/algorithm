a = int(input())
b = int(input())

print(b % 10*a)
print(b//10 % 10*a)
print(b//100*a)
print(b//100*a*100 + b//10 % 10*a*10 + b % 10*a)