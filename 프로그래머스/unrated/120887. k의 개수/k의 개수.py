def solution(i, j, k):
    cnt = 0
    for number in range(i,j+1):
            cnt += str(number).count(str(k))
    return cnt