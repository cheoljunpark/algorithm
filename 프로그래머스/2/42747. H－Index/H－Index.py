def solution(citations):
    # 내림차순으로 정렬
    # 하나씩 늘려가며 리스트를 잘라서
    # 리스트 모든 원소가 리스트 길이보다 크면 됨
    
    citations.sort(reverse=True)
    
    for i in range(1,len(citations)+1):
        result = True
        arr = citations[:i]
        arr_len = len(arr)
        
        for a in arr:
            if a < arr_len:
                result = False
                
        if not result:
            return i-1
    
    return len(citations)
        
        


