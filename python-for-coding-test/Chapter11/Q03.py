# 내 풀이
s = input()

zero = 0
one = 0

for i in range(len(s)-1):
    if s[i] != s[i+1]:
        if s[i] == '0':
            zero += 1
        elif s[i] == '1':
            one += 1


if s[-1] == '0':
    zero += 1
else:
    one += 1


print(min(zero, one))
