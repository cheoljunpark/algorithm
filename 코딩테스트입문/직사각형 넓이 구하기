def solution(dots):
    x = []
    y = []
    
    for i in range(4):
        if dots[i][0] not in x:
            x.append(dots[i][0])
        if dots[i][1] not in y:
            y.append(dots[i][1])
            
    return (max(x)-min(x))*(max(y)-min(y))
