import sys
from itertools import combinations
import math

# 입력받기
input = sys.stdin.readline
N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]

# 1부터 N번 리스트 만들기
array = [i for i in range(1, N + 1)]


def get_sum(array):
    global graph

    sum_array = 0

    for i in range(len(array)):
        for j in range(len(array)):
            if i == j:
                continue
            sum_array += graph[array[i] - 1][array[j] - 1]

    return sum_array


result = 1e9

for team_start in combinations(array, N // 2):
    team_link = [i for i in array if i not in team_start]

    sum_start = get_sum(team_start)
    sum_link = get_sum(team_link)

    result = min(abs(sum_start - sum_link), result)

print(result)
