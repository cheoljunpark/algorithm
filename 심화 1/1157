word = list(input())

x = []

for i in range(len(word)):
    if ord('a') <= ord(word[i]) <= ord('z'):
        word[i] = chr(ord(word[i])-ord('a')+ord('A'))
    if word[i] not in x:
        x.append(word[i])

a = []
for j in x:
    a.append(word.count(j))

if a.count(max(a)) > 1:
    print("?")
else:
    print(x[a.index(max(a))])
