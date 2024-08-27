from itertools import combinations

vowels = ('a', 'e', 'i', 'o', 'u')

l, c = map(int, input().split())

letters = input().split()
letters.sort()

for password in combinations(letters, l):
    count = 0
    for i in password:
        if i in vowels:
            count += 1

    if count >= 1 and count <= l - 2:
        print(''.join(password))
