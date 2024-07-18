T = int(input())

for i in range(1, T + 1):
    a = list(map(int, input().split()))
    print(f"#{i} {(sum(a) / len(a)):.0f}")