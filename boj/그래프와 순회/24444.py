from collections import deque
import sys

n, m, r = map(int, sys.stdin.readline().rstrip().split())

graph = [[] for _ in range(n+1)]
visited = [0]*(n+1)

for _ in range(m):
    u, v = map(int, sys.stdin.readline().rstrip().split())
    graph[u].append(v)
    graph[v].append(u)

for i in range(n+1):
    graph[i].sort()


def bfs(graph, r, visited):
    queue = deque([r])
    visited[r] = 1
    count = 2

    while queue:
        v = queue.popleft()

        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = count
                count += 1


bfs(graph, r, visited)

for i in visited[1:]:
    print(i)
