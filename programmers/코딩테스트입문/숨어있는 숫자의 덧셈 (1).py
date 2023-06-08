def solution(my_string):
    sum = 0
    for i in my_string:
        if ord(i) in range(ord('a'), ord('z')+1):
            pass
        elif ord(i) in range(ord('A'), ord('Z')+1):
            pass
        else:
            sum += int(i)
    return sum
