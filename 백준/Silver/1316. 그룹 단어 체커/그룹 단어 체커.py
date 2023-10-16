n = int(input())

cnt = 0


for _ in range(n):
    word = input()
    visited = []
    group = True

    for i in range(len(word)):
        if word[i] in visited:
            if word[i] == prev:
                continue
            group = False
            break
        else:
            visited.append(word[i])
            prev = word[i]

    if group:
        cnt += 1

print(cnt)