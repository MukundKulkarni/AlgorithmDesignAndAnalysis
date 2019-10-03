arrival = [1200,1200,1300,1400,1400]
departure = [1215,1230,1315,1415,1430]

temp = arrival + departure
temp = sorted(temp)

platforms = 0

atinstant = []



for i in range(len(temp)):
    if temp[i] in arrival:
        platforms += 1
        atinstant.append(platforms)
    else:
        platforms -= 1
        atinstant.append(platforms)

print(max(atinstant))
