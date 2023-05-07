def solution(s):
    answer = []
    
    for i in s:
        if i == '(':
            answer.append(i)
        elif i == ')':
            if '(' not in answer:
                answer.append(i)
                continue
            answer.pop()
            
    if len(answer)==0:
        return True
    else:
        return False
