import sys
from collections import deque

input = sys.stdin.readline

N, L, R = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
day = 0

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(i, j):
    global visited, graph
    q = deque()
    q.append((i, j))
    visited[i][j] = True
    populations = graph[i][j]
    areas = [(i, j)]

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue
            if visited[nx][ny]:
                continue
            if L <= abs(graph[x][y] - graph[nx][ny]) <= R:
                visited[nx][ny] = True
                q.append((nx, ny))
                populations += graph[nx][ny]
                areas.append((nx, ny))

    for area in areas:
        num = populations // len(areas)
        graph[area[0]][area[1]] = num

    return len(areas) > 1


while True:
    visited = [[False for _ in range(N)] for _ in range(N)]
    move_occurred = False

    for i in range(N):
        for j in range(N):
            if not visited[i][j]:
                if bfs(i, j):
                    move_occurred = True

    if not move_occurred:
        break

    day += 1

print(day)
