def solution(sizes):
    widths = []
    heights = []
    
    for size in sizes:
        if size[1] > size[0]:
            width = size[1]
            height = size[0]
        else:
            width = size[0]
            height = size[1]
        widths.append(width)
        heights.append(height)
        
    widths.sort()
    heights.sort()
    
    return widths[-1]*heights[-1]