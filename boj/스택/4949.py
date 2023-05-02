while True:
    a = []
    l = input()

    if len(l) == 1 and l == '.':
        break

    for i in l:
        if i == '(':
            a.append(i)
        elif i == '[':
            a.append(i)
        elif len(a) > 0 and a[-1] == '(' and i == ')':
            a.pop()
        elif len(a) > 0 and a[-1] == '[' and i == ']':
            a.pop()
        elif (len(a) == 0 and i == ')') or (len(a) == 0 and i == ']') or (len(a) > 0 and a[-1] == '(' and i == ']') or (len(a) > 0 and a[-1] == '[' and i == ')'):
            a.append(i)
            break

    if len(a) == 0:
        print('yes')
    else:
        print('no')
