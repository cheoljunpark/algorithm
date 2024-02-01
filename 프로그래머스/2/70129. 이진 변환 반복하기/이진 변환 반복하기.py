def solution(s):
    answer = []
    cnt = 0
    zero = 0
    while s != '1':
        cnt += 1
        for i in s:
            if i in '0':
                s = s.replace(i,'')
                zero += 1
        s= str(bin(len(s)))[2:]
    answer.append(cnt)
    answer.append(zero)
    return answer