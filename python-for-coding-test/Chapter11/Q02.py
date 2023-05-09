# # 내 풀이

# n = input()

# result = 0

# for i in n:
#     result = max(result*int(i), result+int(i))

# print(result)

# 정답 풀이

data = input()

result = data[0]

for i in range(1,len(data)):
    num = int(data[i])
    if num<=1 or result<=1:
        result += num
    else:
        result *= num

print(result)
