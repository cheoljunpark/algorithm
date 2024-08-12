def solution(answers):
    answer = []
    
    one = [1,2,3,4,5] 
    two = [2,1,2,3,2,4,2,5] 
    three = [3,3,1,1,2,2,4,4,5,5]
    
    scores= [0,0,0]
    
    for i in range(len(answers)):
        if one[i%len(one)] == answers[i]:
            scores[0] += 1
        if two[i%len(two)] == answers[i]:
            scores[1] += 1
        if three[i%len(three)] == answers[i]:
            scores[2] += 1

    max_score = max(scores)
    
    result = [i+1 for i, score in enumerate(scores) if score == max_score]
    
    return result