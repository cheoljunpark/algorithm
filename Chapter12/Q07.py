n = input()


# 중간을 기준으로 왼쪽부분과 오른쪽 부분 나누기
half = len(n)//2

left = n[:half]
right = n[half:]


# 왼쪽부분 합, 오른쪽부분 합 0으로 초기화
left_sum = 0
right_sum = 0


# 왼쪽 부분의 각 자릿수 합
for i in left:
    left_sum += int(i)
# 오른쪽 부분의 각 자릿수 합
for i in right:
    right_sum += int(i)


# 왼쪽 부분의 합과 오른쪽 부분의 합 값 비교
if left_sum == right_sum:
    print("LUCKY")
else:
    print("READY")
