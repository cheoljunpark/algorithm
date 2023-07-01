def solution(angle):
    if angle > 0 and angle < 90:
        result = 1
    elif angle == 90:
        result = 2
    elif angle > 90 and angle < 180:
        result = 3
    elif angle == 180:
        result = 4
    
    return result
