import sys

input = sys.stdin.readline

n, m = map(int, input().split())
r, c, d = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]

# 북, 동, 남, 서
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

cnt = 0  # 청소한 칸 수

while True:
    # 현재 위치 청소
    if graph[r][c] == 0:
        graph[r][c] = 2
        cnt += 1

    # 청소되지 않은 칸이 있는지 확인
    cleanable = False
    for i in range(4):
        nd = (d + 3 - i) % 4  # 반시계 방향으로 회전
        nr = r + dx[nd]
        nc = c + dy[nd]

        if graph[nr][nc] == 0:  # 청소할 수 있는 칸이 있는 경우
            r, c = nr, nc
            d = nd
            cleanable = True
            break

    if not cleanable:  # 청소할 수 있는 칸이 없을 때
        # 후진할 위치 계산
        nr = r - dx[d]
        nc = c - dy[d]

        if graph[nr][nc] == 1:  # 후진할 수 없으면 종료
            break
        else:
            r, c = nr, nc  # 후진

print(cnt)
