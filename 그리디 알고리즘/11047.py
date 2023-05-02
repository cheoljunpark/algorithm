n, k = map(int, input().split())

coins = []

for _ in range(n):
    a = int(input())
    coins.append(a)

coins.sort(reverse=True)

result = 0

for coin in coins:
    result += k // coin
    k %= coin

print(result)
