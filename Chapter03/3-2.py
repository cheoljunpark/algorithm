# # 내가 푼 방식

# n, m, k = map(int, input().split())

# a = list(map(int, input().split()))

# a.sort()

# first = a[-1]
# second = a[-2]

# result = 0
# count = 0

# for _ in range(m):
#     if count == k:
#         result += second
#         count = 0
#         continue

#     count += 1
#     result += first


# print(result)



n, m, k = map(int, input().split())

data = list(map(int, input().split()))

data.sort()
first = data[n-1]
second = data[n-2]

count = int(m/(k+1))*k
count += m % (k+1)

result = 0
result += (count)*first
result += (m-count)*second

print(result)
