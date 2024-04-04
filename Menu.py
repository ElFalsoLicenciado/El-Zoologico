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
    
    def __exec(self):
        p = 0
        while True:
            print("\n1. Register. \n2. Update. \n3. Delete. \n4. View details. \n0. Quit. \n")
            p = input("Input: ")
            if p == 0:
                print("Cheers")
                break
            elif p == 1:
                i = 0
                while True:
                    print("\n1. Register a worker. \n2. Register a client. \n3. Register an animal. \n4.Register a "
                          "tour. \n5. Register a maintenance. \n0. Return. \n")
                    i = input("Input: ")
                    if i == 0:
                        break
                    elif i == 1:
                        print("Registering a worker")
                        Menus.__register_worker()
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
                    print("\n1. Modify a worker.\n2. Modify a client. \n3. Modify an animal. \n0. Return.")
                    i = input("Input: ")
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
                    i = input("Input: ")
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
                    i = input("Input: ")
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
        type = input("\nAnimal's type")
        weight = 0.0
        while weight <= 0 :
            weight = float(input("\nAnimal's weight: "))
            if weight >= 0:
                break
            else:
                print("Invalid input.")

        print("\nAnimal' date of arrival: ")
        arr_date = self.__set_date()
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
            jk = input("Would you like to add a disease to the animal?\n1.Yes   0.No")
            if jk != 0 and jk != 1:
                 print("Invalid input")
            elif jk == 1 :
                disease = input("Write the disease: ")
                diseases.add(disease)
            elif jk == 0 :
                break
            tt = 0
        while True :
            tt = input("Is the animal vaccinated?\n1.Yes   0.No")
            if tt != 0 and tt != 1:
                 print("Invalid input")
            elif tt == 1 :
                vac = True
                break
            elif tt == 0 :
                vac = False
                break
        animal = Animal(type, arr_date, weight, diseases, feed_freq, feed_type, vac)
        Menus.animal_list.add(animal)

    def __modify_animal(self):
        if not Menus.animal_list:
            print("There are no animals registered")
        else:
            a = 0
            while a<= 0 or a > len(Menus.animal_list):
                self.__show_animals()
                a = input("Select an animal: ")
                if  a> 0 and a <= len(Menus.animal_list):
                    break
                else:
                    print("Invalid input")
            c = 0
            while True:
                while True:
                    print("\n1.Change ID\n2. Change type\n3. Change date of arrival\n4. Change weight\n5. Manage diseases\n6. Change feed type\n7. Change feed frequency\n8. Set diseases\n0. Return")
                    c = input("Input: ")
                    if c == 0:
                        break
                    elif c == 1:
                        Animal.__set_id(Menus.animal_list[a-1])
                        print("\nNew ID: " + Animal.__get_id(Menus.animal_list[a-1]))
                        break
                    elif c == 2:
                        type = input("\nAnimal's new type: ")
                        Animal.__set_type(Menus.animal_list[a-1], type)
                        break
                    elif c== 3:
                        print("Animal's new date of arrival: ")
                        arr_date = self.__set_date()
                        Animal.__set_date_of_arrival(Menus.animal_list[a-1], arr_date)
                        break
                    elif c == 4:
                        weight = 0.0
                        while weight <= 0 :
                            weight = float(input("\nAnimal's new weight: "))
                            if weight > 0:
                                Animal.__set_weight(Menus.animal_list[a-1], weight)
                                break
                            else:
                                print("Invalid input.")
                        break
                    elif c == 5:
                        d = 0
                        while True:
                            d = input("\n1. Register disease 2. Dismiss disease\nInput: ")
                            if d != 0 and d != 1:
                                print("Invalid input")
                            elif d == 1 :
                                disease = input("disease to add: ")
                                Animal.__add_disease[Menus.animal_list[a-1], disease]
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
                                            vv = input("Disease to dismiss: ")
                                        if  vv> 0 and vv <= len(Menus.animal_list):
                                            Animal.__remove_disease[Menus.animal_list[a-1],vv-1]
                                            break
                                        else:
                                            print("Invalid input")
                                    break
                    elif c == 6:
                        feed_type = input("\nAnimal's new type: ")
                        Animal.__set_feed_type(Menus.animal_list[a-1], feed_type)
                        break
                    elif c == 7:
                        feed_freq = ""
                        while feed_freq <= "" :
                            feed_freq = input("\nAnimal's new feed frequency: ")
                            if feed_freq != "":
                                Animal.__set_feed_frequency(Menus.animal_list[a-1], feed_freq)
                                break
                            else:
                                print("Invalid input.")
                        break
                    elif c == 8:
                        tt = 0
                        while True :
                            tt = input("Is the animal vaccinated?\n1.Yes   0.No")
                            if tt != 0 and tt != 1:
                                print("Invalid input")
                            elif tt == 1 :
                                vac = True
                                break
                            elif tt == 0 :
                                vac = False
                                break
                        Animal.__set_vaccines(Menus.animal_list[a-1], vac)
                    else:
                        print("Invalid input.")

    def __remove_animal(self):
        if not Menus.animal_list:
            print("There are no animals registered.")
        else:
            a = 0
            while a<= 0 or a > len(Menus.animal_list):
                self.__show_animals()
                a = input("Select an animal: ")
                if  a> 0 and a <= len(Menus.animal_list):
                    del Menus.animal_list[a-1]
                else:
                    print("Invalid input")

    def __register_tour(self):
        guide_found = False
        guides = []
        av_clients = []
        av_clients = Menus.client_list

        for worker in Menus.worker_list:
            if Worker.__get_role(worker) == "Guide":
                guide_found = True
                guides.add(worker)

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
                g = input("Select a guide")
                if g < 1 and g > len(guides)+1 :
                    print("Invalid input")
                else:
                    guide = Worker.__get_name(guides[g-1])
                    break
            count = 0
            while True :
                g = input("Would you like to add a visitor?\n1.Yes   0.No")
                if g != 0 and g != 1:
                    print("Invalid input")
                elif g == 1 :
                    if not av_clients:
                        print("There are no clients available")
                    else:
                        self.__show_available_clients(av_clients)
                        b = input("Select a visitor: ")
                        if b < 1 and b > len(guides)+1 :
                            print("Invalid input")
                        else:
                            aux = Person.__get_id(Menus.client_list[b-1])
                            ine = aux[1]
                            if ine == "A" :
                                adults = adults + 1
                                Person.__add_visit(Menus.client_list[b-1])
                                visits = Person.__get_num_visits(Menus.client_list[b-1])
                                if visits%5 == 0 :
                                    money = money + 80
                                else:
                                    money = money + 100
                        if ine == "C" :
                            adults = adults + 1
                            Person.add_visit(Menus.client_list[b-1])
                            visits = Person.__get_num_visits(Menus.client_list[b-1])
                            if visits%5 == 0 :
                                money = money + 40
                            else:
                                money = money + 50
                        visitors.add(Person.__get_name(av_clients(b-1)))
                        av_clients.remove(b-1)
                        count = count + 1
                elif g == 0 :
                    if count < 1:
                        print("Add at least one visitor")
                    else:
                        break
            print("Set the date.")
            date = " "
            date = self.__set_date()
            tour = Tour(guide, visitors, money, date, kids, adults)
            Menus.tour_list.add(tour)

    def __register_maintenance(self):
        tech_found = False
        technicians = []
        for worker in Menus.worker_list:
            if Worker.__get_role(worker) == "Technician":
                tech_found = True
                technicians.add(worker)
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
                g = input("Select a technician")
                if g < 1 and g > len(technicians)+1 :
                    print("Invalid input")
                else:
                    technician = Worker.__get_name(technicians[g-1])
                    break
            t=0
            while True :
                self.__show_animals()
                t = input("Select an animal: ")
                if t < 1 and t > len(Menus.animal_list)+1 :
                    print("Invalid input")
                else:
                    animal_id = Animal.__get_id(Menus.animal_list[t-1])
                    break

            process = input("\nWrite the process: ")
            print("Set the date: ")
            date = self.__set_date()

            comments = " "
            jk = 0
            while True :
                jk = input("Would you like to add a comment?\n1.Yes   0.No")
                if jk != 0 and jk != 1:
                    print("Invalid input")
                elif jk == 1 :
                    comments = comments + "\n" + input("Write the comment: ")
                elif jk == 0 :
                    comments = "None"
                    break

            maintenance = Maintenance(technician, animal_id, process, date, comments)
            Menus.maintenance_list.add(maintenance)

    def __show_specific_workers(self, list):
        i = 0
        for anyworker in list :
            i = i + 1
            print("\n"+ Worker.__get_role(anyworker) + " #"+ i)
            print("\nID: " + Worker.__get_id(anyworker) + "  Full name: " + Worker.__get_name(anyworker)+ "\n")
        print(" ")

    def __show_available_clients(self, list):
        i = 0
        for anyperson in list:
            i = i + 1
            print("\nClient #"+ i)
            print("\nID: " + Person.__get_id(anyperson) + "  Full name: " + Person.__get_name(anyperson)+ "\n")
        print(" ")

    def __show_tours(self):
        if not Menus.tour_list:
            print("There's no tours registered")
        else:
            i = 0
            for anytour in Menus.tour_list:
                i = i + 1
                print("\nTour #"+ i)
                print(Tour.__get_details(anytour))
            print(" ")

    def __show_maintenance(self):
        if not Menus.maintenance_list:
            print("There's no maintenances registered")
        else:
            i = 0
            for anymain in Menus.maintenance_list:
                i = i + 1
                print("\nTour #"+ i)
                print(Maintenance.__get_details(anymain))
            print(" ")

    def __register_client(self):
        name = input("\nClient's name: ")
        last_name = input("\nClient's last name: ")
        print("\nClient's birthday: ")
        birthday = self.__set_date()
        print("\nSet date of register: ")
        reg_date = self.__set_date()
        curp = input("\nClient's CURP: ")

        client = Person(name, last_name, birthday, curp, reg_date)
        Menus.client_list.add(client)

    def __modify_client(self):
        if not Menus.client_list:
            print("There's no clients registered.")
        else:
            cl = 0
            while cl<= 0 or cl > len(Menus.client_list):
                self.__show_clients()
                cl = input("Select a client: ")
                if  cl> 0 and cl <= len(Menus.client_list):
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
                        Person.__set_id(Menus.client_list[cl-1])
                        print("\nNew ID: " + Person.__get_id(Menus.client_list[cl-1]))
                        break
                    elif c == 2:
                        name = input("\nClient's new name: ")
                        last_name = input("\nClient's new last name: ")
                        Person.__set_name(Menus.client_list[cl-1], name, last_name)
                        break
                    elif c== 3:
                        print("Client's new birthday: ")
                        birthday = self.__set_date()
                        Person.__set_birthday(Menus.client_list[cl-1], birthday)
                        break
                    elif c == 4:
                        curp = input("\nClient's new curp: ")
                        Person.__set_curp(Menus.client_list[cl-1], curp)
                        break
                    elif c == 5:
                        visits = 0
                        while True :
                            visits = input("\nClient's visits: ")
                            if visits >= 0:
                                Person.__set_num_visits(Menus.client_list[cl-1], visits)
                                break
                            else:
                                print("Invalid input.")
                        break
                    elif c == 6:
                        print("Client's new registry date: ")
                        reg_date = self.__set_date()
                        Person.__set_date_of_register(Menus.client_list[cl-1], reg_date)
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
                cl = input("Select a client: ")
                if  cl> 0 and cl <= len(Menus.client_list):
                    del Menus.client_list[cl-1]
                else:
                    print("Invalid input")

    def __register_worker(self):
        name = input("\nWorker's name: ")
        last_name = input("\nWorker's last name: ")
        print("\nWorker's birthday: ")
        birthday = self.__set_date()
        print("\nSet date of register: ")
        reg_date = self.__set_date()
        curp = input("\nWorker's CURP: ")
        rfc = input("\nWorker's RFC: ")
        wage = input("\nWorker's wage: ")
        schedule = input("\nWorker's schedule: ")
        role = self.__set_role()

        worker = Worker(name, last_name, birthday, curp, reg_date, rfc, wage, schedule, role)
        Menus.worker_list.add(worker)

    def __modify_worker(self):
        if not Menus.worker_list:
            print("There's no workers registered.")
        else:
            cl = 0
            while cl<= 0 or cl > len(Menus.worker_list):
                self.__show_slaves()
                cl = input("Select a worker: ")
                if  cl> 0 and cl <= len(Menus.worker_list):
                    break
                else:
                    print("Invalid input")
            c = 0
            while True:
                while True:
                    print("\n1. Change ID\n2.Change full name\n3.Change birthday\n4.Change date of registry\n5.Change CURP\n6.Change RFC\n7.Change wage\n8.Change schedule\n9.Change role\n0. Return")
                    c = input("Input: ")
                    if c == 0:
                        break
                    elif c == 1:
                        Worker.__set_id(Menus.worker_list[cl-1])
                        print("\nNew ID: " + Worker.__get_id(Menus.worker_list[cl-1]))
                        break
                    elif c == 2:
                        name = input("\nWorker's new name: ")
                        last_name = input("\nWorker's new last name: ")
                        Worker.__set_name(Menus.worker_list[cl-1], name, last_name)
                        break
                    elif c== 3:
                        print("Worker's new birthday: ")
                        birthday = self.__set_date()
                        Worker.__set_birthday(Menus.worker_list[cl-1], birthday)
                        break
                    elif c == 4:
                        print("Workers's new registry date: ")
                        reg_date = self.__set_date()
                        Worker.__set_date_of_register(Menus.worker_list[cl-1], reg_date)
                        break
                    elif c == 5:
                        curp = input("\nWorkers's new curp: ")
                        Worker.__set_curp(Menus.worker_list[cl-1], curp)
                        break
                    elif c == 6:
                        rfc = input("Workers's new RFC: ")
                        Worker.__set_rfc(Menus.worker_list[cl-1], rfc)
                        break
                    elif c == 7:
                        wage = 0
                        while wage <= 0:
                            wage = input("Workers's new wage: ")
                            if wage>0:
                                Worker.__set_wage(Menus.worker_list[cl-1], wage)
                            else:
                                print("Invalid input")
                        break
                    elif c == 8:
                        schedule = input("Workers's new schedule: ")
                        Worker.__set_schedule(Menus.worker_list[cl-1], schedule)
                        break
                    elif c == 9:
                        print("Workers's new RFC: ")
                        role = self.__set_role()
                        Worker.__set_role(Menus.worker_list[cl-1], role)
                        break
                    else:
                        print("Invalid input.")

    def __remove_worker(self):
        if not Menus.worker_list:
            print("There are no workers registered.")
        else:
            cl = 0
            while cl<= 0 or cl > len(Menus.worker_list):
                self.__show_slaves()
                cl = input("Select a worker: ")
                if  cl> 0 and cl <= len(Menus.worker_list):
                    del Menus.worker_list[cl-1]
                else:
                    print("Invalid input")

    def __set_role(self):
        r = 0
        while True:
            r = input("\nSelect a role: \nTechnician.\nGuide.\nAdministrator.\nVeterinary.")
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
    
    def __show_clients():
        if not Menus.client_list:
            print("There are no clients registered.")
        else:
            i = 0
            for anyperson in Menus.client_list:
                i = i + 1
                print("\nClient #"+i)
                print("\nID: %s   Full name: %s   Birthday: %s  Date of register: %s   CURP: %s   Number of visits %s\n", Person.Person.__get_id(anyperson) ,Person.Person.__get_name(anyperson), Person.Person.__get_birthday(anyperson), Person.Person.__get_date_of_register(anyperson), Person.Person.__get_curp(anyperson), Person.Person.__get_num_visits(anyperson))
        print(" ") 
    
    def __show_animals():
        if not Menus.animal_list:
            print("There are no animals registered.")
        else:
            i = 0
            for anyanimal in Menus.animal_list:
                i = i + 1
                print("\nAnimal #"+i)
                print("\nID %s   Type: %s   Weight: %s   Date of arrival %s   Feed type: %s   Feed frequency: %s  Vaccines: %s   \n", Animal.Animal.__get_id(anyanimal), Animal.Animal.__get_type(anyanimal), Animal.Animal.__get_weight(anyanimal), Animal.Animal.__get_date_of_arrival(anyanimal), Animal.Animal.__get_feed_type(anyanimal), Animal.Animal.__get_feed_frequency(anyanimal), Animal.Animal.__is_vaccinated(anyanimal))
            if not Animal.__diseases(anyanimal):
                print("The animal is healthy")
            else: 
                Animal.__show_diseases(anyanimal)
        print(" ")


    def __set_date():
        date = ""
        m = 0
        y = 0
        d = 0
        while y <= 0 or y > 2024:
            y = input("Write the year: ")
            if y <= 0 or y > 2024:
                print("Are you even human?")
        
        if y%4 == 0:
            while m <=0 or m >12:
                m = input("\nSelect a month.\n1.January 2. February 3. March 4. April 5. May 6. June\n7. July 8. August 9. September 10. October 11. November 12. December\nInput: ")
                if m <= 0 or m > 12:
                    print("Invalid input.")
            if m == 1 or m == 3 or m ==5 or m==7 or m==8 or m==10 or m==12 :
                while d<= 0 or d>31:
                    d = input("Write the day: ")
                    if d<= 0 or d>31:
                        print("invalid input")
            elif m == 2:
                while d<= 0 or d>29:
                    d = input("Write the day: ")
                    if d<= 0 or d>29:
                        print("invalid input")
            elif m == 4 or m==6 or m==9 or m==11:
                while d<= 0 or d>30:
                    d = input("Write the day: ")
                    if d<= 0 or d>30:
                        print("invalid input")
        else:
            while m <=0 or m >12:
                m = input("\nSelect a month.\n1.January 2. February 3. March 4. April 5. May 6. June\n7. July 8. August 9. September 10. October 11. November 12. December\nInput: ")
                if m <= 0 or m > 12:
                    print("Invalid input.")
            if m == 1 or m == 3 or m ==5 or m==7 or m==8 or m==10 or m==12 :
                while d<= 0 or d>31:
                    d = input("Write the day: ")
                    if d<= 0 or d>31:
                        print("invalid input")
            elif m == 2:
                while d<= 0 or d>28:
                    d = input("Write the day: ")
                    if d<= 0 or d>28:
                        print("invalid input")
            elif m == 4 or m==6 or m==9 or m==11:
                while d<= 0 or d>30:
                    d = input("Write the day: ")
                    if d<= 0 or d>30:
                        print("invalid input")
        date = "%d/%d/%d",d,m,y
        return date
    
    def __show_slaves():
        if not Menus.worker_list:
            print("There are no workers registered.")
        else:
            i = 0
            for anyworker in Menus.worker_list:
                i = i + 1
                print("\nWorker #"+i)
                print("\nID: %s   Full name: %s   Birthday: %s   Role: %s   Date of register: %s   CURP: %s   RFC: %s   Wage: $%d   Schedule %s\n", Worker.__get_id(anyworker) ,Worker.__get_name(anyworker), Worker.__get_birthday(anyworker), Worker.__get_role(anyworker), Worker.__get_date_of_register(anyworker), Worker.__get_curp(anyworker), Worker.__get_rfc(anyworker), Worker.__get_wage(anyworker), Worker.__get_schedule(anyworker))
        print(" ")