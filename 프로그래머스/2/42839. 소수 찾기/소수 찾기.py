from itertools import permutations
from math import sqrt

def solution(numbers):
    # numbers 쪼개서 리스트에 담는다
    arrays = list(numbers)
    # numbers에서 부분집합을 구한다
    subsets = set()
    for i in range(1, len(arrays)+1):
        for permutation in permutations(arrays,i):
            subsets.add(int(''.join(permutation)))
    # 부분집합중 소수의 개수를 구한다
    count = 0
    for subset in subsets:
        is_prime = True
        for i in range(2,int(sqrt(subset))+1):
            if subset % i == 0:
                is_prime = False
                break
        if is_prime and subset!=0 and subset!=1:
            count += 1

    
    return count

