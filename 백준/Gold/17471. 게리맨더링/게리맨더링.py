import sys
from itertools import combinations
from collections import deque

input = sys.stdin.readline

N = int(input())
populations = list(map(int, input().split()))
graph = [[0] * N for _ in range(N)]

for i in range(N):
    _, *datas = map(int, input().split())
    for data in datas:
        graph[i][data - 1] = 1


def is_connected(nodes):
    q = deque()
    visited = [False] * N
    q.append(nodes[0])
    visited[nodes[0]] = True

    while q:
        node = q.popleft()

        for i in range(len(graph[node])):
            if graph[node][i] == 0: continue
            if i not in nodes: continue
            if not visited[i]:
                visited[i] = True
                q.append(i)

    return visited.count(True) == len(nodes)


def get_total(nodes):
    total = 0
    for node in nodes:
        total += populations[node]
    return total


X = {i for i in range(N)}
INF = int(1e9)
ans = INF

for i in range(1, N // 2 + 1):
    As = tuple(combinations(X, i))
    for A in As:
        B = list(X.difference(A))

        if is_connected(A) and is_connected(B):
            a_total = get_total(A)
            b_total = get_total(B)
            ans = min(ans, abs(a_total - b_total))

if ans == INF:
    print(-1)
else:
    print(ans)
