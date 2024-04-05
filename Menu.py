from Animal import Animal
from Worker import Worker
from Maintenance import Maintenance
from Tour import Tour
from Person import Person

class Menus:

    animal_list = []
    client_list = []
    maintenance_list = []
    tour_list = []
    worker_list = []
    
    def __init__(self):
        self.__exec()

    def __exec(self):
        p = 0
        while True:
            print("\n1. Register. \n2. Update. \n3. Delete. \n4. View details. \n0. Quit. \n")
            p = int(input("Input: "))
            if p == 0:
                print("Cheers")
                break
            elif p == 1:
                i = 0
                while True:
                    print("\n1. Register a worker. \n2. Register a client. \n3. Register an animal. \n4. Register a "
                          "tour. \n5. Register a maintenance. \n0. Return. \n")
                    i = int(input("Input: "))
                    if i == 0:
                        break
                    elif i == 1:
                        print("Registering a worker")
                        self.__register_worker()
                        break
                    elif i == 2:
                        print("Registering a client")
                        self.__register_client()
                        break
                    elif i == 3:
                        print("Registering an animal")
                        self.__register_animal()
                        break
                    elif i == 4:
                        print("Registering a tour")
                        self.__register_tour()
                        break
                    elif i == 5:
                        print("Registering a maintenance")
                        self.__register_maintenance()
                        break
                    else:
                        print("Invalid input.")
            elif p == 2:
                i = 0
                while True:
                    print("\n1. Modify a worker.\n2. Modify a client. \n3. Modify an animal. \n0. Return.\n")
                    i = int(input("Input: "))
                    if i == 0:
                        break
                    elif i == 1:
                        print("Modifying a worker")
                        self.__modify_worker()
                        break
                    elif i == 2:
                        print("Modifying a client")
                        self.__modify_client()
                        break
                    elif i == 3:
                        print("Modifying an animal")
                        self.__modify_animal()
                    else:
                        print("Invalid input.")
            elif p == 3:
                i = 0
                while True:
                    print("\n1. Remove a worker.\n2. Remove a client. \n3. Remove an animal. \n0. Return.")
                    i = int(input("Input: "))
                    if i == 0:
                        break
                    elif i == 1:
                        print("Removing a worker")
                        self.__remove_worker()
                        break
                    elif i == 2:
                        print("Removing a client")
                        self.__remove_client()
                        break
                    elif i == 3:
                        print("Removing a client")
                        self.__remove_animal()
                    else:
                        print("Invalid input.")
            elif p == 4:
                i = 0
                while True:
                    print("\n1. Show a workers. \n2. Show a clients. \n3. Show an animals. \n4. Show a tours. \n5. "
                          "Show a maintenances. \n0. Return. \n")
                    i = int(input("Input: "))
                    if i == 0:
                        break
                    elif i == 1:
                        print("Showing workers")
                        self.__show_slaves()
                        break
                    elif i == 2:
                        print("Showing clients")
                        self.__show_clients()
                        break
                    elif i == 3:
                        print("Showing animals")
                        self.__show_animals()
                        break
                    elif i == 4:
                        print("Showing tours")
                        self.__show_tours()
                        break
                    elif i == 5:
                        print("Showing maintenances")
                        self.__show_maintenance()
                        break
                    else:
                        print("Invalid input.")
            else:
                print("Invalid input")

    def __register_animal(self):
        type = input("\nAnimal's type: ")
        weight = 0.0
        while weight <= 0 :
            weight = float(input("\nAnimal's weight: "))
            if weight >= 0:
                break
            else:
                print("Invalid input.")

        print("\nAnimal' date of arrival: ")
        arr_date = Menus.__set_date()
        feed_type = input("\nAnimal's feed type: ")
        feed_freq = ""
        while feed_freq <= "" :
            feed_freq = input("\nAnimal's feed frequency: ")
            if feed_freq != "":
                break
            else:
                print("Invalid input.")
        diseases = []
        jk = 0
        while True :
            jk = int(input("Would you like to add a disease to the animal?\n1.Yes   0.No"))
            if jk != 0 and jk != 1:
                 print("Invalid input")
            elif jk == 1 :
                disease = input("Write the disease: ")
                diseases.append(disease)
            elif jk == 0 :
                break
            tt = 0
        while True :
            tt = int(input("Is the animal vaccinated?\n1.Yes   0.No"))
            if tt != 0 and tt != 1:
                 print("Invalid input")
            elif tt == 1 :
                vac = True
                break
            elif tt == 0 :
                vac = False
                break
        animal = Animal(type, arr_date, weight, diseases, feed_freq, feed_type, vac)
        Menus.animal_list.append(animal)

    def __modify_animal(self):
        if not Menus.animal_list:
            print("There are no animals registered")
        else:
            a = 0
            while a<= 0 or a > len(Menus.animal_list):
                self.__show_animals()
                a = int(input("Select an animal: "))
                if  a> 0 and a <= len(Menus.animal_list):
                    break
                else:
                    print("Invalid input")
            c = 0
            while True:
                while True:
                    print("\n1.Change ID\n2. Change type\n3. Change date of arrival\n4. Change weight\n5. Manage diseases\n6. Change feed type\n7. Change feed frequency\n8. Set diseases\n0. Return")
                    c = int(input("Input: "))
                    if c == 0:
                        break
                    elif c == 1:
                        Animal.set_id(Menus.animal_list[a-1])
                        print("\nNew ID: " + Animal.get_id(Menus.animal_list[a-1]))
                        break
                    elif c == 2:
                        type = input("\nAnimal's new type: ")
                        Animal.set_type(Menus.animal_list[a-1], type)
                        break
                    elif c== 3:
                        print("Animal's new date of arrival: ")
                        arr_date = Menus.__set_date()
                        Animal.set_date_of_arrival(Menus.animal_list[a-1], arr_date)
                        break
                    elif c == 4:
                        weight = 0.0
                        while weight <= 0 :
                            weight = float(input("\nAnimal's new weight: "))
                            if weight > 0:
                                Animal.set_weight(Menus.animal_list[a-1], weight)
                                break
                            else:
                                print("Invalid input.")
                        break
                    elif c == 5:
                        d = 0
                        while True:
                            d = int(input("\n1. Register disease 2. Dismiss disease\nInput: "))
                            if d != 0 and d != 1:
                                print("Invalid input")
                            elif d == 1 :
                                disease = input("disease to add: ")
                                Animal.add_disease[Menus.animal_list[a-1], disease]
                                break
                            elif d == 0 :
                                if not Animal.__diseases:
                                    print("There are no diseases to dismiss")
                                    break
                                else:
                                    while True:
                                        vv = 0
                                        while vv<= 0 or vv > len(Animal.__diseases):
                                            Animal.__show_diseases
                                            vv = int(input("Disease to dismiss: "))
                                        if  vv> 0 and vv <= len(Menus.animal_list):
                                            Animal.remove_disease[Menus.animal_list[a-1],vv-1]
                                            break
                                        else:
                                            print("Invalid input")
                                    break
                    elif c == 6:
                        feed_type = input("\nAnimal's new type: ")
                        Animal.set_feed_type(Menus.animal_list[a-1], feed_type)
                        break
                    elif c == 7:
                        feed_freq = ""
                        while feed_freq <= "" :
                            feed_freq = input("\nAnimal's new feed frequency: ")
                            if feed_freq != "":
                                Animal.set_feed_frequency(Menus.animal_list[a-1], feed_freq)
                                break
                            else:
                                print("Invalid input.")
                        break
                    elif c == 8:
                        tt = 0
                        while True :
                            tt = int(input("Is the animal vaccinated?\n1.Yes   0.No"))
                            if tt != 0 and tt != 1:
                                print("Invalid input")
                            elif tt == 1 :
                                vac = True
                                break
                            elif tt == 0 :
                                vac = False
                                break
                        Animal.set_vaccines(Menus.animal_list[a-1], vac)
                    else:
                        print("Invalid input.")

    def __remove_animal(self):
        if not Menus.animal_list:
            print("There are no animals registered.")
        else:
            a = 0
            while a<= 0 or a > len(Menus.animal_list):
                self.__show_animals()
                a = int(input("Select an animal: "))
                if  a> 0 and a <= len(Menus.animal_list):
                    del Menus.animal_list[a-1]
                else:
                    print("Invalid input")

    def __register_tour(self):
        guide_found = False
        guides = []
        av_clients = []
        worker = 0
        for worker in range(len(Menus.worker_list)):
            if  Worker.get_role(Menus.worker_list[worker]) == "Guide":
                guide_found = True
                guides.append(worker)
            worker = worker + 1

        if guide_found == False and not Menus.client_list :
            print("There's no guides neither clients available")
        elif guide_found == False :
            print("There's is no guides available")
        elif not Menus.client_list :
            print("There's no clients available")
        else :
            visitors = []
            kids = 0
            adults = 0
            money = 0
            g = 0
            while True :
                self.__show_specific_workers(guides)
                g = int(input("Select a guide: "))
                if g < 1 and g > len(guides) :
                    print("Invalid input")
                else:
                    guide = Worker.get_name(Menus.worker_list[g-1])
                    break
            count = 0
            g = 0
            while True :
                if (len(Menus.client_list)-len(av_clients)) < 1 and count == 0:
                    print("There are no clients available")
                    break
                elif (len(Menus.client_list)-len(av_clients)) < 1:
                    print("There are no more clients available")
                    break
                else:
                    g = print("Would you like to add a visitor?\n1.Yes   0.No")
                    g = int(input("Input: "))
                    if g != 0 and g != 1:
                        print("Invalid input")
                    elif g == 0 :
                        if count < 1:
                            print("Add at least one visitor")
                        else:
                            break
                    else:
                        self.__show_available_clients(av_clients)
                        b = int(input("Select a visitor: "))
                        if b < 1 and b > (len(Menus.client_list)-len(av_clients)):
                            print("Invalid input")
                            break
                        else:
                            aux = Person.get_id(Menus.client_list[b-1])
                            av_clients.append(b)
                            ine = aux[1]
                            if ine == "A" :
                                adults = adults + 1
                                Person.add_visit(Menus.client_list[b-1])
                                visits = Person.get_num_visits(Menus.client_list[b-1])
                                if visits%5 == 0 :
                                    money = money + 80
                                else:
                                    money = money + 100
                            elif ine == "C" :
                                adults = adults + 1
                                Person.add_visit(Menus.client_list[b-1])
                                visits = Person.get_num_visits(Menus.client_list[b-1])
                                if visits%5 == 0 :
                                    money = money + 40
                                else:
                                    money = money + 50
                            visitors.append(Person.get_name(Menus.client_list[b-1]))
                            av_clients.append(b-1)
                            count = count + 1 
            if count > 0:                  
                print("Set the date.")
                date = " "
                date = Menus.__set_date()
                tour = Tour(guide, visitors, money, date, kids, adults)
                Menus.tour_list.append(tour)

    def __register_maintenance(self):
        tech_found = False
        technicians = []
        for worker in Menus.worker_list:
            if Worker.get_role(worker) == "Technician":
                tech_found = True
                technicians.append(worker)
        if tech_found == False and not  Menus.animal_list :
            print("There's neither technicians neither animals available.")
        elif tech_found == False :
            print("There's no technicians available.")
        elif not Menus.animal_list :
            print("There's no animals available.")
        else :
            g = 0
            while True :
                self.__show_specific_workers(technicians)
                g = int(input("Select a technician"))
                if g < 1 and g > len(technicians) :
                    print("Invalid input")
                else:
                    technician = Worker.get_name(technicians[g-1])
                    break
            t=0
            while True :
                self.__show_animals()
                t = input("Select an animal: ")
                if t < 1 and t > len(Menus.animal_list) :
                    print("Invalid input")
                else:
                    animal_id = Animal.get_id(Menus.animal_list[t-1])
                    break

            process = input("\nWrite the process: ")
            print("Set the date: ")
            date = Menus.__set_date()

            comments = " "
            jk = 0
            while True :
                jk = int(input("Would you like to add a comment?\n1.Yes   0.No"))
                if jk != 0 and jk != 1:
                    print("Invalid input")
                elif jk == 1 :
                    comments = comments + "\n" + input("Write the comment: ")
                elif jk == 0 :
                    comments = "None"
                    break

            maintenance = Maintenance(technician, animal_id, process, date, comments)
            Menus.maintenance_list.append(maintenance)

    def __show_specific_workers(self, list):
        if not list:
            print("There isn't any workers of this type registered.")
        else:
            i = 0
            anyworker = 0
            for anyworker in range(len(Menus.worker_list)):
                if anyworker in list:
                    i = i + 1
                    print("\nWorker #"+str(i))
                    Worker.show_slave(Menus.worker_list[anyworker])
                anyworker = anyworker + 1
        print(" ")

    def __show_available_clients(self, list):
        i = 0
        anyperson = 0
        for anyperson in range(len(Menus.client_list)):
            if anyperson not in list:
                i = i + 1
                print("\nClient #"+ str(i))
                Person.show_client(Menus.client_list[anyperson])
            anyperson = anyperson + 1
        print(" ")

    def __show_clients(self):
        if not Menus.client_list:
            print("There are no clients registered.")
        else:
            anyperson = 0
            for anyperson in range(len(Menus.client_list)):
                print("\nClient #"+ str(anyperson+1))
                Person.show_client(Menus.client_list[anyperson])
                anyperson = anyperson + 1
        print(" ") 

    def __show_tours(self):
        if not Menus.tour_list:
            print("There's no tours registered")
        else:
            anytour = 0
            for anytour in range(len(Menus.tour_list)):
                print("\nTour #"+ str(anytour+1))
                print(Tour.get_details(Menus.tour_list[anytour]))
                anytour = anytour + 1
            print(" ")

    def __show_maintenance(self):
        if not Menus.maintenance_list:
            print("There's no maintenances registered")
        else:
            anymain = 0
            for anymain in range(len(Menus.maintenance_list)):
                print("\nTour #"+ str(anymain+1))
                print(Maintenance.get_details(Menus.maintenance_list[anymain]))
                anymain = anymain + 1
            print(" ")

    def __register_client(self):
        name = input("\nClient's name: ")
        last_name = input("\nClient's last name: ")
        print("\nClient's birthday: ")
        birthday = Menus.__set_date()
        print("\nSet date of register: ")
        reg_date = Menus.__set_date()
        curp = input("\nClient's CURP: ")

        client = Person(name, last_name, birthday, curp, reg_date)
        Menus.client_list.append(client)

    def __modify_client(self):
        if not Menus.client_list:
            print("There's no clients registered.")
        else:
            cl = 0
            while cl<= 0 or cl > len(Menus.client_list):
                self.__show_clients()
                cl = int(input("Select a client: "))
                if  cl> 0 and cl <= len(Menus.client_list):
                    break
                else:
                    print("Invalid input")
            c = 0
            while True:
                while True:
                    print("\n1. Change ID\n2.Change full name\n3.Change birthday\n4.Change CURP\n5.Change number of visits\n6.Change date of register\n0. Return")
                    c = int(input("Input: "))
                    if c == 0:
                        break
                    elif c == 1:
                        Person.set_id(Menus.client_list[cl-1])
                        print("\nNew ID: " + Person.get_id(Menus.client_list[cl-1]))
                        break
                    elif c == 2:
                        name = input("\nClient's new name: ")
                        last_name = input("\nClient's new last name: ")
                        Person.set_name(Menus.client_list[cl-1], name, last_name)
                        break
                    elif c== 3:
                        print("Client's new birthday: ")
                        birthday = Menus.__set_date()
                        Person.set_birthday(Menus.client_list[cl-1], birthday)
                        break
                    elif c == 4:
                        curp = input("\nClient's new curp: ")
                        Person.set_curp(Menus.client_list[cl-1], curp)
                        break
                    elif c == 5:
                        visits = 0
                        while True :
                            visits = int(input("\nClient's visits: "))
                            if visits >= 0:
                                Person.set_num_visits(Menus.client_list[cl-1], visits)
                                break
                            else:
                                print("Invalid input.")
                        break
                    elif c == 6:
                        print("Client's new registry date: ")
                        reg_date = Menus.__set_date()
                        Person.set_date_of_register(Menus.client_list[cl-1], reg_date)
                        break
                    else:
                        print("Invalid input.")

    def __remove_client(self):
        if not Menus.client_list:
            print("There are no clients registered.")
        else:
            cl = 0
            while cl<= 0 or cl > len(Menus.client_list):
                self.__show_clients()
                cl = int(input("Select a client: "))
                if  cl> 0 and cl <= len(Menus.client_list):
                    del Menus.client_list[cl-1]
                else:
                    print("Invalid input")

    def __register_worker(self):
        name = input("\nWorker's name: ")
        last_name = input("\nWorker's last name: ")
        print("\nWorker's birthday: ")
        birthday = Menus.__set_date()
        print("\nSet date of register: ")
        reg_date = Menus.__set_date()
        curp = input("\nWorker's CURP: ")
        rfc = input("\nWorker's RFC: ")
        wage = input("\nWorker's wage: ")
        schedule = input("\nWorker's schedule: ")
        role = self.__set_role()

        worker = Worker(name, last_name, birthday, curp, reg_date, rfc, wage, schedule, role)
        Menus.worker_list.append(worker)

    def __modify_worker(self):
        if not Menus.worker_list:
            print("There's no workers registered.")
        else:
            cl = 0
            while cl<= 0 or cl > len(Menus.worker_list):
                self.__show_slaves()
                cl = int(input("Select a worker: "))
                if  cl> 0 and cl <= len(Menus.worker_list):
                    break
                else:
                    print("Invalid input")
            c = 0
            while True:
                while True:
                    print("\n1. Change ID\n2.Change full name\n3.Change birthday\n4.Change date of registry\n5.Change CURP\n6.Change RFC\n7.Change wage\n8.Change schedule\n9.Change role\n0. Return")
                    c = int(input("Input: "))
                    if c == 0:
                        break
                    elif c == 1:
                        Worker.set_id(Menus.worker_list[cl-1])
                        print("\nNew ID: " + Worker.get_id(Menus.worker_list[cl-1]))
                        break
                    elif c == 2:
                        name = input("\nWorker's new name: ")
                        last_name = input("\nWorker's new last name: ")
                        Worker.set_name(Menus.worker_list[cl-1], name, last_name)
                        break
                    elif c== 3:
                        print("Worker's new birthday: ")
                        birthday = Menus.__set_date()
                        Worker.set_birthday(Menus.worker_list[cl-1], birthday)
                        break
                    elif c == 4:
                        print("Workers's new registry date: ")
                        reg_date = Menus.__set_date()
                        Worker.set_date_of_register(Menus.worker_list[cl-1], reg_date)
                        break
                    elif c == 5:
                        curp = input("\nWorkers's new curp: ")
                        Worker.set_curp(Menus.worker_list[cl-1], curp)
                        break
                    elif c == 6:
                        rfc = input("Workers's new RFC: ")
                        Worker.set_rfc(Menus.worker_list[cl-1], rfc)
                        break
                    elif c == 7:
                        wage = 0
                        while wage <= 0:
                            wage = int(input("Workers's new wage: "))
                            if wage>0:
                                Worker.set_wage(Menus.worker_list[cl-1], wage)
                            else:
                                print("Invalid input")
                        break
                    elif c == 8:
                        schedule = input("Workers's new schedule: ")
                        Worker.set_schedule(Menus.worker_list[cl-1], schedule)
                        break
                    elif c == 9:
                        print("Workers's new role: ")
                        role = self.__set_role()
                        Worker.set_role(Menus.worker_list[cl-1], role)
                        break
                    else:
                        print("Invalid input.")
                break

    def __remove_worker(self):
        if not Menus.worker_list:
            print("There are no workers registered.")
        else:
            cl = 0
            while cl<= 0 or cl > len(Menus.worker_list):
                self.__show_slaves()
                cl = int(input("Select a worker: "))
                if  cl> 0 and cl <= len(Menus.worker_list):
                    del Menus.worker_list[cl-1]
                else:
                    print("Invalid input")

    def __set_role(self):
        r = 0
        while True:
            print("\nSelect a role: \n1. Technician.\n2. Guide.\n3. Administrator.\n4. Veterinary.\n")
            r = int(input("Input: "))
            if r == 1:
                role = "Technician"
                break
            elif r == 2:
                role = "Guide"
                break
            elif r == 3:
                role = "Administrator"
                break
            elif r == 4:
                role = "Veterinary"
                break
            else:
                print("Invalid input")
        return role
    
    def __show_clients(self):
        if not Menus.client_list:
            print("There are no clients registered.")
        else:
            anyperson = 0
            for anyperson in range(len(Menus.client_list)):
                print("\nClient #"+ str(anyperson+1))
                Person.show_client(Menus.client_list[anyperson])
                anyperson = anyperson + 1
        print(" ") 
    
    def __show_animals(self):
        if not Menus.animal_list:
            print("There are no animals registered.")
        else:
            anyanimal = 0
            for anyanimal in range(len(Menus.animal_list)):
                print("\nAnimal #"+str(anyanimal+1))
                Animal.show_animal(Menus.animal_list[anyanimal])
                anyanimal = anyanimal + 1
        print(" ")


    def __set_date():
        date = ""
        m = 0
        y = 0
        d = 0
        while y < 1000 or y > 2024:
            y = int(input("Write the year: "))
            if y < 1000 or y > 2024:
                print("Are you even human?")
        
        if y%4 == 0:
            while m <=0 or m >12:
                m = int(input("\nSelect a month.\n1.January 2. February 3. March 4. April 5. May 6. June\n7. July 8. August 9. September 10. October 11. November 12. December\nInput: "))
                if m <= 0 or m > 12:
                    print("Invalid input.")
                elif m == 1 or m == 3 or m ==5 or m==7 or m==8 or m==10 or m==12 :
                    while d<= 0 or d>31:
                        d = int(input("Write the day: "))
                        if d<= 0 or d>31:
                            print("invalid input")
                elif m == 2:
                    while d<= 0 or d>29:
                        d = int(input("Write the day: "))
                        if d<= 0 or d>29:
                            print("invalid input")
                elif m == 4 or m==6 or m==9 or m==11:
                    while d<= 0 or d>30:
                        d = int(input("Write the day: "))
                        if d<= 0 or d>30:
                            print("invalid input")
        else:
            while m <=0 or m >12:
                m = int(input("\nSelect a month.\n1.January 2. February 3. March 4. April 5. May 6. June\n7. July 8. August 9. September 10. October 11. November 12. December\nInput: "))
                if m <= 0 or m > 12:
                    print("Invalid input.")
                elif m == 1 or m == 3 or m ==5 or m==7 or m==8 or m==10 or m==12 :
                    while d<= 0 or d>31:
                        d = int(input("Write the day: "))
                        if d<= 0 or d>31:
                            print("invalid input")
                elif m == 2:
                    while d<= 0 or d>28:
                        d = int(input("Write the day: "))
                        if d<= 0 or d>28:
                            print("invalid input")
                elif m == 4 or m==6 or m==9 or m==11:
                    while d<= 0 or d>30:
                        d = int(input("Write the day: "))
                        if d<= 0 or d>30:
                            print("invalid input")
        date = " "+str(d)+"/"+str(m)+"/"+str(y)
        return date


    def __show_slaves(self):
        if not Menus.worker_list:
            print("There are no workers registered.")
        else:
            anyworker = 0
            for anyworker in range(len(Menus.worker_list)):
                print("\nWorker #"+str(anyworker + 1))
                Worker.show_slave(Menus.worker_list[anyworker])
                anyworker = anyworker + 1
        print(" ")