def solution(my_string, letter):
    answer = my_string
    for i in my_string:
        if i in letter:
            answer = answer.replace(i,'')
    return answer
