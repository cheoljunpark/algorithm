def solution(my_string):
    answer = ''
    s = list(set(list(my_string)))
    for i in my_string:
        if i in s:
            answer += i
            s.remove(i)
    return answer
