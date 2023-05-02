import sys
n = int(sys.stdin.readline())

a = []

for _ in range(n):
    command = sys.stdin.readline().split()

    if command[0] == 'push':
        a.append(int(command[1]))

    elif command[0] == 'pop':
        if len(a) == 0:
            print(-1)
            continue
        print(a.pop())

    elif command[0] == 'size':
        print(len(a))

    elif command[0] == 'empty':
        if len(a) == 0:
            print(1)
        else:
            print(0)

    elif command[0] == 'top':
        if len(a) == 0:
            print(-1)
            continue
        print(a[-1])
