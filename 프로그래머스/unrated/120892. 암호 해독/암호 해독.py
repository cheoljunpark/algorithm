def solution(cipher, code):
    answer = ''
    for i in range(len(cipher)):
        if i % code == code - 1:    # 별로인듯...
            answer += cipher[i]
    return answer