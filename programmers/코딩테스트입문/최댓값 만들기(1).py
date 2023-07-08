def solution(numbers):
    max_num1 = max(numbers)
    numbers.remove(max_num1)
    max_num2 = max(numbers)
    
    return max_num1 * max_num2
