n = int(input())

p = list(map(int, input().split()))

p.sort()

a = 0
result = 0

for i in p:
    a += i
    result += a

print(result)
