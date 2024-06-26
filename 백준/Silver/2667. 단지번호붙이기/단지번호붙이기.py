from collections import deque

n = int(input())

graph = []

for _ in range(n):
    graph.append(list(map(int, input())))


dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
cnt = 0
house = []


def dfs(x, y):
    global cnt

    if x <= -1 or x >= n or y <= -1 or y >= n:
        return False

    if graph[x][y] == 1:
        cnt += 1
        graph[x][y] = 0
        dfs(x-1, y)
        dfs(x, y-1)
        dfs(x+1, y)
        dfs(x, y+1)
        return True
    return False


result = 0

for i in range(n):
    for j in range(n):
        if dfs(i, j) == True:
            result += 1
            house.append(cnt)
            cnt = 0

print(result)
house.sort()
for h in house:
    print(h)
