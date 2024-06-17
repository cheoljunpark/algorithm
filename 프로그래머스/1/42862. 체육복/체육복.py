def solution(n, lost, reserve):
    lost_set = set(lost)
    reserve_set = set(reserve)
    
    lost = list(lost_set - reserve_set)
    reserve = list(reserve_set - lost_set)
    
    lost.sort()
    reserve.sort()
    # reserve를 순회하면서 각 요소 앞뒤 번호가 lost에 있다면 해당 lost 삭제
    for r in reserve:
        if r-1 in lost:
            lost.remove(r-1)
        elif r+1 in lost:
            lost.remove(r+1)
            
    # n - len(lost) 리턴
    return n - len(lost)