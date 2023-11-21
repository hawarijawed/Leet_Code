def minimumNumber(n, password):
    # Return the minimum number of characters to make the password strong
    numeric = 0
    lower = 0
    upper = 0
    special = ['!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+']
    spcl = 0
    count = 4
    req_char = 0
    if n<6:
        req_char = 6-n
    for i in range(n):
        if numeric<1 and password[i].isnumeric():
            numeric+=1
        if lower<1 and password[i].islower():
            lower+=1
        if upper < 1 and password[i].isupper():
            upper +=1
        if spcl < 1 and password[i] in special:
            spcl+=1
    if numeric>0:
        count-=1
    if lower>0:
        count-=1
    if upper>0:
        count-=1
    if spcl>0:
        count-=1   
    return max(count, req_char)
