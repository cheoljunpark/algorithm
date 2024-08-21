n = input()

a = [int(i) for i in n[:len(n) // 2]]
b = [int(i) for i in n[len(n) // 2:]]

if sum(a) == sum(b):
    print("LUCKY")
else:
    print("READY")
