def solution(array):
    array_list = list(set(array))
    array_list_count = []
    
    for i in array_list:
        array_list_count.append(array.count(i))
        
    max_apperance = max(array_list_count)
    
    if array_list_count.count(max_apperance) > 1:
        return -1
    else:
        for i in array:
            if array.count(i) == max_apperance:
                most_appeared_number = i
                return most_appeared_number
