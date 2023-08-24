def divide_and_sum(n):
    a = []

    for i in n:
        a.append(int(i))

    return int(n)+sum(a)


n = int(input())

result = 0

for i in range(n+1):
    if divide_and_sum(str(i)) == n:
        result = i
        break

print(result)