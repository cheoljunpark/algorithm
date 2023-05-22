def solution(numbers, direction):
    numbers.reverse()
    if direction == 'right':
        a = numbers[:1]
        b = numbers[1:]
        b.reverse()
        return a+b
    else:
        a = numbers[:-1]
        b = numbers[-1:]
        a.reverse()
        return a+b
