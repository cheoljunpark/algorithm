from itertools import combinations


n, m = map(int, input().split())

l = list(map(int, input().split()))

result = list(combinations(l, 3))

max_num = 0
for i in result:
    if sum(i) > max_num and sum(i) <= m:
        max_num = sum(i)

print(max_num)