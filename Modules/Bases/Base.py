

pass_is_valid = False
safe_pass = "a"
while pass_is_valid == False :
    x = input("\nIntroduce the password: ")
    if x == safe_pass:
        pass_is_valid = True
        j = 0
        for i in range(10):
            y=9-i
            z=i+1
            j=j+10
            print("Access granted, please stand by " + '-'*y + '#'*z + " %" + str(j))
        print("\nYou are in.\n")
        from ..Bases.Menu import Menus
        Menus.__sys_execution()
    else:
        print("Password is incorrect, try again.")