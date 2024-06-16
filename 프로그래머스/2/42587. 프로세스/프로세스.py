'''
1. 맨 앞에 있는 걸 꺼낸다
2. 맨 앞 값보다 큐에 큰 값이 있다면 맨 뒤에 넣는다
3. location을 -1 한다
4. 맨 앞 값보다 큐에 큰 값이 없다면 순서를 하나 증가한다
5. location의 값이 0이고 맨 앞 값이 가장 크다면 순서를 하나 증가하고 그 값을 출력
'''

from collections import deque

def solution(priorities, location):
    # deque에 (인덱스, 중요도) 형태로 저장
    q = deque((i, p) for i, p in enumerate(priorities))
    order = 0

    while q:
        # 큐에서 첫 번째 프로세스를 꺼냄
        index, value = q.popleft()
        
        # 큐에 더 높은 중요도의 프로세스가 있는지 확인
        if any(value < item[1] for item in q):
            # 있다면 현재 프로세스를 큐의 맨 뒤로 보냄
            q.append((index, value))
        else:
            # 그렇지 않다면 프로세스를 실행
            order += 1
            if index == location:
                return order
            