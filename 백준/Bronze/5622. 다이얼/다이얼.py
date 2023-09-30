tel = ['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ']

letters = input()

time = 0

for letter in letters:
    for i in range(len(tel)):
        if letter in tel[i]:
            time += 3 + i

print(time)
