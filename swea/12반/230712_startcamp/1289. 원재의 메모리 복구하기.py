t = int(input())

for i in range(t):
    n = input()
    a = "0"*len(n)
    cnt = 0

    for j in range(len(a)):
        if n == a:
            break
        elif n[j] == a[j]:
            continue
        elif n[j] == '1':
            a = a[:j]+a[j:].replace('0', '1')
            cnt += 1
        elif n[j] == '0':
            a = a[:j]+a[j:].replace('1', '0')
            cnt += 1

    print(f"#{i+1} {cnt}")
