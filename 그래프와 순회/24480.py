import sys
sys.setrecursionlimit(10**9)
n, m, r = map(int, sys.stdin.readline().rstrip().split())

graph = [[] for _ in range(n+1)]
visited = [0]*(n+1)
cnt = 1

for _ in range(m):
    u, v = map(int, sys.stdin.readline().rstrip().split())
    graph[u].append(v)
    graph[v].append(u)

for i in range(n+1):
    graph[i].sort(reverse=True)


def dfs(graph, v, visited):
    global cnt
    visited[v] = cnt
    cnt += 1
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)


dfs(graph, r, visited)

for i in visited[1:]:
    print(i)
