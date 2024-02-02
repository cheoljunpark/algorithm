from collections import deque
import math
def solution(progresses, speeds):
    answer = []
    li = deque()
    for i in range(len(speeds)):
        li.append(math.ceil((100-progresses[i])/speeds[i]))
    answer = []
    a = li.popleft()
    cnt = 1
    while li:
        if li[0]<=a:
            li.popleft()
            cnt = cnt + 1
        else:
            a = li.popleft()
            answer.append(cnt)
            cnt = 1
    answer.append(cnt)
    return answer