s = input()

a = []

for i in range(len(s)):
    word = ""
    j = i
    while j < len(s):
        word += s[j]
        a.append(word)
        j += 1

print(len(set(a)))