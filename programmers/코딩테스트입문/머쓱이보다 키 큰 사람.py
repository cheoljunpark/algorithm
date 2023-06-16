def solution(array, height):
    answer = 0
    for arr in array:
        if arr>height:
            answer += 1
    return answer
