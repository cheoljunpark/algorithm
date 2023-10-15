import sys
sys.setrecursionlimit(10**4)

t = int(sys.stdin.readline().rstrip())


def dfs(x, y):
    if x <= -1 or x >= n or y <= -1 or y >= m:
        return False

    if graph[x][y] == 1:
        graph[x][y] = 0

        dfs(x-1, y)
        dfs(x+1, y)
        dfs(x, y-1)
        dfs(x, y+1)
        return True

    return False


for _ in range(t):
    n, m, k = map(int, sys.stdin.readline().rstrip().split())

    graph = [[0]*m for _ in range(n)]

    for _ in range(k):
        x, y = map(int, sys.stdin.readline().rstrip().split())
        graph[x][y] = 1

    result = 0
    for i in range(n):
        for j in range(m):
            if dfs(i, j) == True:
                result += 1

    print(result)
