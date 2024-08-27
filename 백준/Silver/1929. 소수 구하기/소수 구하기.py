import math

m, n = map(int, input().split())

array = [True] * 1_000_001
array[1]=0

for i in range(2, int(math.sqrt(n)) + 1):
    if array[i] == True:
        # 현재 수를 제외한 모든 배수 제거
        j = 2
        while i * j <= n:
            array[i * j] = False
            j += 1

for i in range(m, n + 1):
    if array[i]:
        print(i)
