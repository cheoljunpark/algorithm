# n=int(input())
# print(n*n -n)

from itertools import permutations

n = int(input())
a = [i for i in range(1,n+1)]

print(len(list(permutations(a,2))))
