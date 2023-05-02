def solution(emergency):
    sorted_emergency = sorted(emergency, reverse=True)

    a = {}

    for i in sorted_emergency:
        a[i] = sorted_emergency.index(i) + 1


    answer = []

    for i in emergency:
        answer.append(a[i])
        
    return answer
