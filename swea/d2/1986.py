T = int(input())

for i in range(1,T+1):
    n= int(input())

    sum=0
    for j in range(1,n+1):
        if j%2 ==1:
            sum+=j
        else:
            sum-=j

    print(f"#{i} {sum}")
