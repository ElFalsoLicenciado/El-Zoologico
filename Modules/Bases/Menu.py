
class Menus:
    

    def __exec():
        from ..Bases import Functions
        zoo = Functions.Functions()
        p = 0
        while True:
            print ("\n1. Register. \n2. Update. \n3. Delete. \n4. View details. \n0. Quit. \n")
            p = input("Input: ")
            if p  == 0:
                print("Cheers")
                break
            elif  p == 1:
                i = 0
                while True:
                    print("\n1. Register a worker. \n2. Register a client. \n3. Register an animal. \n4.Register a tour. \n5. Register a maintenance. \n0. Return. \n")
                    i = input("Input: ")
                    if  i == 0:
                        break
                    elif i == 1:
                        print("Registering a worker")
                        zoo.__register_worker()
                        break
                    elif i == 2:
                        print("Registering a client")
                        zoo.__register_client() 
                        break
                    elif i == 3:
                        print("Registering an animal")
                        zoo.__register_animal() 
                        break
                    elif i == 4:
                        print("Registering a tour")
                        zoo.__register_tour() 
                        break
                    elif i == 5:
                        print("Registering a maintenance")
                        zoo.__register_maintenance() 
                        break         
                    else:
                        print("Invalid input.")
            elif p == 2:
                i = 0
                while True:
                    print("\n1. Modify a worker.\n2. Modify a client. \n3. Modify an animal. \n0. Return.")
                    i = input("Input: ")
                    if  i == 0:
                        break
                    elif i == 1:
                        print("Modifying a worker")
                        zoo.__modify_worker()
                        break
                    elif i == 2:
                        print("Modifying a client")
                        zoo.__modify_client() 
                        break
                    elif i == 3:
                        print("Modifying an animal")
                        zoo.__modify_animal()
                    else:
                        print("Invalid input.")
            elif p == 3:
                i = 0  
                while True: 
                    print("\n1. Remove a worker.\n2. Remove a client. \n3. Remove an animal. \n0. Return.")
                    i = input("Input: ")
                    if  i == 0:
                        break
                    elif i == 1:
                        print("Removing a worker")
                        zoo.__remove_worker()
                        break
                    elif i == 2:
                        print("Removing a client")
                        zoo.__remove_client() 
                        break
                    elif i == 3:
                        print("Removing a client")
                        zoo.__remove_animal()
                    else:
                        print("Invalid input.")
            elif p == 4:
                i = 0
                while True:
                    print("\n1. Show a workers. \n2. Show a clients. \n3. Show an animals. \n4. Show a tours. \n5. Show a maintenances. \n0. Return. \n")
                    i = input("Input: ")  
                    if  i == 0:
                        break
                    elif i == 1:
                        print("Showing workers")
                        zoo.__show_slaves()
                        break
                    elif i == 2:
                        print("Showing clients")
                        zoo.__show_clients() 
                        break
                    elif i == 3:
                        print("Showing animals")
                        zoo.__show_animals() 
                        break
                    elif i == 4:
                        print("Showing tours")
                        zoo.__show_tours() 
                        break
                    elif i == 5:
                        print("Showing maintenances")
                        zoo.__show_maintenance() 
                        break         
                    else:
                        print("Invalid input.")
            else:
                print ("Invalid input")