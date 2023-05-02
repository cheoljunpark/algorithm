c = int(input())

for i in range(c):
    a = list(map(int, input().split()))
    a = a[1:]

    avg = sum(a)/len(a)
    cnt = 0

    for _ in a:
        if _ > avg:
            cnt += 1

    print(f'{cnt/len(a)*100:.3f}%')
