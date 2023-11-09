a, b = map(int, input().split())
c = int(input())

if b+c < 60:
    print(f"{a} {b+c}")
else:
    print(f"{(a+(b+c)//60)%24} {(b+c)%60}")
