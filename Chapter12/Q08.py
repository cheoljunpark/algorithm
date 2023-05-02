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


################################################################################

# A08.py
data = input()

result = []
value = 0

for x in data:
    if x.isalpha():
        result.append(x)
    else:
        value += int(x)

        
result.sort()

if value != 0:
    result.append(str(value))


print(''.join(result))
