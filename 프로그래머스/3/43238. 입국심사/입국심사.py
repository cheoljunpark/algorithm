# 최대 10^18분이 걸릴 수 있음
# 최대로 걸리는 시간(사람*최대시간)에서 이진탐색을 해 times 에 있는 요소 순서대로 뺀다
# 0이 되면 리턴
# 크거나 작으면 mid 조정

def solution(n, times):
    times.sort()
    
    start = 0
    end = times[-1]*n
    
    while start<=end:
        mid = (start+end) // 2
        
        checked = 0
        
        for time in times:
            checked += mid // time
            
        if  checked >= n:
            answer = mid
            end = mid - 1
        elif checked < n:
            start = mid + 1
            
    return answer