numbers = list(map(int, input().split()))

numbers_without_duplication = list(set(numbers))


sub_list = [x for x in numbers if x not in numbers_without_duplication]

if len(numbers_without_duplication) == 1:
    print(10000+1000*numbers[0])
elif len(numbers_without_duplication) == 2:
    numbers.remove(numbers_without_duplication[0])
    numbers.remove(numbers_without_duplication[1])
    print(1000+100*numbers[0])
elif len(numbers_without_duplication) == 3:
    print(100*max(numbers))
