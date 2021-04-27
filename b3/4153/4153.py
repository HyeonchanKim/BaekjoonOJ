while True:
    side = sorted(list(map(int, input().split())))
    if side[0]==side[1]==side[2]==0:
        break
    print("right" if side[0]*side[0] + side[1]*side[1] == side[2]*side[2] else "wrong")
