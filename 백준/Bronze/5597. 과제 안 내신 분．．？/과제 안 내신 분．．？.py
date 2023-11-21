students = [i for i in range(1, 31)]
students_submitted = []

for _ in range(28):
    students_submitted.append(int(input()))


students_not_submitted = set(students)-set(students_submitted)

print(min(students_not_submitted))
print(max(students_not_submitted))