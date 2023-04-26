from collections import deque


n = int(input())
m = int(input())

graph = [[] for _ in range(n+1)]
visited = [False]*(n+1)

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)


def bfs(graph, start, visited):
    result = 0
    queue = deque([start])
    visited[start] = True
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
                result += 1

    return result


print(bfs(graph, 1, visited))
