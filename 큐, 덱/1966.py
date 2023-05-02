from collections import deque

test_cases = int(input())


for test_case in range(test_cases):
    queue = deque()
    n, m = map(int, input().split())
    importances = input().split()

    for i in range(n):
        queue.append(i)

    cnt = 0
    number_to_find = queue[m]

    while True:
        if max(importances) != importances[0]:
            queue.append(queue[0])
            queue.popleft()
            importances.append(importances[0])
            importances.remove(importances[0])
        else:
            number = queue.popleft()
            del importances[0]
            cnt += 1
            if number == number_to_find:
                break

    print(cnt)
