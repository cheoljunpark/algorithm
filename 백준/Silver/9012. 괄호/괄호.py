n = int(input())

for _ in range(n):
    a = []
    l = input()

    for i in l:
        if i == '(':
            a.append(i)
        elif len(a) == 0 and i == ')':
            a.append(i)
            break
        elif i == ')':
            a.pop()

    if len(a) == 0:
        print('YES')
    else:
        print('NO')