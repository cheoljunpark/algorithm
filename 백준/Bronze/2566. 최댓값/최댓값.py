a = []
max_num = 0
max_i = 0
max_j = 0

for i in range(9):
    a.append(list(map(int, input().split())))

for i in range(9):
    for j in range(9):
        if a[i][j] > max_num:
            max_num = a[i][j]
            max_i = i
            max_j = j

print(max_num)
print(max_i+1, max_j+1)