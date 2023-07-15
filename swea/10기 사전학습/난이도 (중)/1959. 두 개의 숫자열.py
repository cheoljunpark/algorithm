t = int(input())

for i in range(t):
    n, m = map(int, input().split())

    a = list(map(int, input().split()))
    b = list(map(int, input().split()))

    max_result = 0

    for j in range(max(n, m) - min(n, m) + 1):
        result = 0
        if n > m:
            for k in range(m):
                result += a[k+j] * b[k]
        else:
            for k in range(n):
                result += a[k] * b[k+j]

        if result > max_result:
            max_result = result

    print(f"#{i + 1} {max_result}")
