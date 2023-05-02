def solution(my_str, n):
    answer = []
    i = 0

    while True:
        answer.append(my_str[i:i+n])
        i += n
        if i+n >= len(my_str):
            if i >= len(my_str):
                break
            answer.append(my_str[i:])
            break

    return answer
