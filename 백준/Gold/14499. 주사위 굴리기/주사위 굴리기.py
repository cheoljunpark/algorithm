import sys

input = sys.stdin.readline

row, column, x, y, k = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(row)]
commands = list(map(int, input().split()))

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]
dice = [0, 0, 0, 0, 0, 0]  # 위, 뒤, 오른쪽, 왼쪽, 앞, 아래


def turn(dir):
    a, b, c, d, e, f = dice[0], dice[1], dice[2], dice[3], dice[4], dice[5]

    if dir == 1:
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = d, b, a, f, e, c
    elif dir == 2:
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = c, b, f, a, e, d
    elif dir == 3:
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = e, a, c, d, f, b
    elif dir == 4:
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = b, f, c, d, a, e


nx, ny = x, y
for command in commands:
    nx += dx[command - 1]
    ny += dy[command - 1]

    if nx < 0 or nx >= row or ny < 0 or ny >= column:
        nx -= dx[command - 1]
        ny -= dy[command - 1]
        continue

    turn(command)
    if board[nx][ny] == 0:
        board[nx][ny] = dice[-1]
    else:
        dice[-1] = board[nx][ny]
        board[nx][ny] = 0

    print(dice[0])
