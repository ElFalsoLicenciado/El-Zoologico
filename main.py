from Menu import Menus
import getpass

pass_is_valid = False
safe_pass = "candeChamba"

while pass_is_valid == False :
    cande = getpass.getpass('\nIntroduce the password:')
    if cande == safe_pass:
        pass_is_valid = True
        j = 0
        for i in range(10):
            y=9-i
            z=i+1
            j=j+10
            print("Access granted, please stand by " + '-'*y + '#'*z + " %" + str(j))
        print("\nYou are in.\n")
        menu = Menus()
        
    else:
        print("Password is incorrect, try again.")
