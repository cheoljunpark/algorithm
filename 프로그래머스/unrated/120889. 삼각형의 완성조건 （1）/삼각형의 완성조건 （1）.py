def solution(sides):
    longest_side = max(sides)
    sides.remove(longest_side)
    if longest_side < sides[0]+sides[1]:
        return 1
    else:
        return 2