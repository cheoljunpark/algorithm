from collections import deque

import sys
sys.setrecursionlimit(10**6)

n, m, v = map(int, sys.stdin.readline().rstrip().split())


graph = [[] for _ in range(n+1)]
visited = [False]*(n+1)


for _ in range(m):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(n+1):
    graph[i].sort()


def dfs(graph, v, visited):
    visited[v] = True
    print(v, end=' ')

    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)


def bfs(graph, v, visited):
    queue = deque([v])
    visited[v] = True

    while queue:
        v = queue.popleft()
        print(v, end=' ')
        for i in graph[v]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)


dfs(graph, v, visited)
print()
visited = [False]*(n+1)
bfs(graph, v, visited)