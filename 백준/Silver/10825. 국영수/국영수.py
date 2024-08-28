n = int(input())

array = []

for _ in range(n):
    l = input().split()
    name, kor, eng, math = l[0], int(l[1]), int(l[2]), int(l[3])
    array.append((name, kor, eng, math))

array.sort(key=lambda x: (-x[1], x[2], -x[3], x[0]))

for name in array:
    print(name[0])
