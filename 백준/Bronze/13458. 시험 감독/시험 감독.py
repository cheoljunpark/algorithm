import sys

input = sys.stdin.readline

n = int(input())

a = list(map(int, input().split()))

b, c = map(int, input().split())

# 일단 총감독관은 1명 무조건 있어야 하므로 모든 방에 한명 들어간 값 계산
cnt = len(a)

for i in range(len(a)):
    a[i] -= b

# 이제는 부감독관만 들어갈 수 있으므로 부감독관 들어갈 자리 계산
new_a = [i for i in a if i > 0]

for i in range(len(new_a)):
    if new_a[i] % c == 0:
        cnt += new_a[i] // c
    else:
        cnt += new_a[i] // c + 1

print(cnt)
