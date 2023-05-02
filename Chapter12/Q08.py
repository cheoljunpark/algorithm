s = list(input())

result = []
cnt = 0

for i in s:
    if 'A' <= i <= 'Z':
        result.append(i)
    elif '0' <= i <= '9':
        cnt += int(i)


result.sort()
r = ""
for i in result:
    r += i

print(r+str(cnt))
