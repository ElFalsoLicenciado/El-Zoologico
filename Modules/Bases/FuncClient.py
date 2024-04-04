from ..Objects import Person
from ..Storage import ClientRepo
import Functions

class Functions_client:

    def __register_client():
        name = input("\nClient's name: ")
        last_name = input("\nClient's last name: ")
        print("\nClient's birthday: ")
        birthday = Functions.Functions.__set_date()
        print("\nSet date of register: ")
        reg_date = Functions.Functions.__set_date()
        curp = input("\nClient's CURP: ")
    
        client = Person.Person(name, last_name, birthday, curp, reg_date)
        ClientRepo.Clients.client_list.add(client)

    def __modify_client():
        if not ClientRepo.Clients.client_list:
            print("There's no clients registered.")
        else:
            cl = 0
            while cl<= 0 or cl > len(ClientRepo.Clients.client_list):
                Functions.Functions.__show_clients()   
                cl = input("Select a client: ")
                if  cl> 0 and cl <= len(ClientRepo.Clients.client_list):
                    break
                else:    
                    print("Invalid input")
            c = 0
            while True:
                while True:
                    print("\n1. Change ID\n2.Change full name\n3.Change birthday\n4.Change CURP\n5.Change number of visits\n6.Change date of register\n0. Return")
                    c = input("Input: ")
                    if c == 0:
                        break
                    elif c == 1:
                        Person.Person.__set_id(ClientRepo.Clients.client_list[cl-1])
                        print("\nNew ID: " + Person.Person.__get_id(ClientRepo.Clients.client_list[cl-1]))
                        break
                    elif c == 2:
                        name = input("\nClient's new name: ")
                        last_name = input("\nClient's new last name: ")
                        Person.Person.__set_name(ClientRepo.Clients.client_list[cl-1], name, last_name)
                        break
                    elif c== 3:
                        print("Client's new birthday: ")
                        birthday = Functions.Funtions.__set_date()
                        Person.Person.__set_birthday(ClientRepo.Clients.client_list[cl-1], birthday)
                        break
                    elif c == 4:
                        curp = input("\nClient's new curp: ")
                        Person.Person.__set_curp(ClientRepo.Clients.client_list[cl-1], curp)
                        break
                    elif c == 5:
                        visits = 0
                        while True :
                            visits = input("\nClient's visits: ")
                            if visits >= 0:
                                Person.Person.__set_num_visits(ClientRepo.Clients.client_list[cl-1], visits)
                                break
                            else:
                                print("Invalid input.")
                        break
                    elif c == 6:
                        print("Client's new registry date: ")
                        reg_date = Functions.Funtions.__set_date()
                        Person.Person.__set_date_of_register(ClientRepo.Clients.client_list[cl-1], reg_date)
                        break
                    else:
                        print("Invalid input.")
    
    def __remove_client():
        if not ClientRepo.Clients.client_list:
            print("There are no clients registered.")
        else:
            cl = 0
            while cl<= 0 or cl > len(ClientRepo.Clients.client_list):
                Functions.Functions.__show_clients()   
                cl = input("Select a client: ")
                if  cl> 0 and cl <= len(ClientRepo.Clients.client_list):
                    del ClientRepo.Clients.client_list[cl-1]
                else:    
                    print("Invalid input")