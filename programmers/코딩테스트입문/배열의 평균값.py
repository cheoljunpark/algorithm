def solution(numbers):
    sum = 0
    for number in numbers:
        sum += number
    return sum/len(numbers)
