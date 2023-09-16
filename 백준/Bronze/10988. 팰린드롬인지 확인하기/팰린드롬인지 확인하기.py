word = input()

palinedrome = True

for i in range(len(word)//2):
    if word[i] == word[len(word)-1-i]:
        continue
    else:
        palinedrome = False
        break

if palinedrome:
    print(1)
else:
    print(0)