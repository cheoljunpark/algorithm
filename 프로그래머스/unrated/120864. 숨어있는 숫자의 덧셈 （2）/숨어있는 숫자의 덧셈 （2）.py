def solution(my_string):
    l = []
    number = ""
    
    for i in my_string:
        if ('a'<=i<='z' or 'A'<=i<='Z'):
            if number=="":
                continue
            else:
                l.append(int(number))
                number = ""
                continue
        number += i
    
    if number!="":
        l.append(int(number))
    
    return sum(l)