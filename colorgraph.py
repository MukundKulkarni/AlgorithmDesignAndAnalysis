n = 4
m = 1
graph = [[0,0,1,3],
         [0,0,0,2],
         [1,0,0,0],
         [3,2,0,0]]


adjl = []

for i in range(n):
    nadj = 0
    for j in range(n):
        if graph[i][j] != 0:
            nadj += 1
    adjl.append(nadj)

print(max(adjl) <= m)
