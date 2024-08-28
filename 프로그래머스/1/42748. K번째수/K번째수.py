def solution(array, commands):
    result = []
    
    for command in commands:
        i=command[0]
        j=command[1]
        k=command[2]
        
        slice_array = sorted(array[i-1:j])
        result.append(slice_array[k-1])
        
    return result