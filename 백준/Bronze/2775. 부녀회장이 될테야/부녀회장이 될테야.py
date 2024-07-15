test_case = int(input())


for _ in range(test_case):
    k = int(input())
    n = int(input())

    board = [[(lambda x: x)(0) for _ in range(n)] for _ in range(k+1)]
    dp = [[(lambda x: x)(0) for _ in range(n)] for _ in range(k+1)]


    # print("--------------board----------------")
    # for i in range(k+1):
    #     for j in range(n):
    #         print(board[i][j], end=" ")
    #     print()

    for i in range(n):
        dp[0][i] = i+1

    # print("--------------dp----------------")
    # for i in range(k+1):
    #     for j in range(n):
    #         print(dp[i][j], end=" ")
    #     print()

    for i in range(1, k+1):
        for j in range(n):
            if board[i][j] == 0:
                if j == 0:
                    dp[i][j] = dp[i - 1][j]
                    board[i][j] = dp[i][j]
                    continue
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
                board[i][j] = dp[i][j]

    print(board[k][n-1])
    # print(board[k][n])