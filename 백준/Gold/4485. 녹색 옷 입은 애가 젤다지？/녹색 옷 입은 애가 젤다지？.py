from collections import deque

count = 0
dx = [-1,1,0,0]
dy = [0,0,-1,1]


def bfs():
    q = deque()
    q.append([0,0])
    dist[0][0] = board[0][0]

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if -1<nx<n and -1<ny<n:
                if dist[x][y] + board[nx][ny] < dist[nx][ny]:
                    dist[nx][ny] = dist[x][y] + board[nx][ny]
                    q.append([nx,ny])
    return dist[n-1][n-1]


while True:
    n = int(input())
    if n == 0:
        break

    count += 1

    board = [list(map(int,input().split())) for _ in range(n)]
    dist = [[1e9 for _ in range(n)] for _ in range(n)]

    print(f"Problem {count}: {bfs()}")
