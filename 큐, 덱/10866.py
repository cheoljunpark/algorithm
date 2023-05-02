from collections import deque
import sys

n = int(sys.stdin.readline())
deque = deque()


for _ in range(n):
    command = sys.stdin.readline().split()

    if command[0] == 'push_front':
        deque.appendleft(command[1])
    elif command[0] == 'push_back':
        deque.append(command[1])
    elif command[0] == 'pop_front':
        if not deque:
            print(-1)
        else:
            print(deque.popleft())
    elif command[0] == 'pop_back':
        if not deque:
            print(-1)
        else:
            print(deque.pop())
    elif command[0] == 'size':
        print(len(deque))
    elif command[0] == 'empty':
        if deque:
            print(0)
        else:
            print(1)
    elif command[0] == 'front':
        if not deque:
            print(-1)
        else:
            print(deque[0])
    elif command[0] == 'back':
        if not deque:
            print(-1)
        else:
            print(deque[-1])
