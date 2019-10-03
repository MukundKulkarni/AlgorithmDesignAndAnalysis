n = 5
S = [i for i in range(n+1)]
A = [5,1,2,3,4]

temp = [False for i in range(n + 1)]

for i  in range(n):
    temp[A[i]] = True
for i in range(n + 1):
    if(temp[i] == False):
        print(i)
