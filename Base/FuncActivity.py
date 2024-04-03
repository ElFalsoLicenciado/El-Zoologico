from Objects import Worker, Person, Tour, Maintenance, Animal
from Storage import WorkerRepo, ClientRepo, TourRepo, MaintenanceRepo, AnimalRepo
import Functions

class Functions_activities:
    
    def __register_tour():
        guide_found = False
        guides = []
        av_clients = []
        av_clients = ClientRepo.Clients.client_list

        for worker in WorkerRepo.Workers.worker_list:
            if worker.__get_role() == "Guide":
                guide_found = True
                guides.add(worker)

        if guide_found == False and not ClientRepo.Clients.client_list :
            print("There's no guides neither clients available")
        elif guide_found == False :
            print("There's is no guides available")
        elif not ClientRepo.Clients.client_list :
            print("There's no clients available")
        else :
            visitors = []
            kids = 0
            adults = 0
            money = 0
            g = 0
            while True :
                Functions_activities.__show_specific_workers(guides)
                g = input("Select a guide")
                if g < 1 and g > len(guides)+1 :
                    print("Invalid input")
                else:
                    guide = Worker.Worker.__get_name(guides[g-1])
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
                        Functions_activities.__show_available_clients(av_clients)
                        b = input("Select a visitor: ")
                        if b < 1 and b > len(guides)+1 :
                            print("Invalid input")
                        else:
                            aux = Person.Person.__get_id(ClientRepo.Clients.client_list[b-1])
                            ine = aux[1]
                            if ine == "A" :
                                adults = adults + 1
                                Person.Person.__add_visit(ClientRepo.Clients.client_list[b-1])
                                visits = Person.Person.__get_num_visits(ClientRepo.Clients.client_list[b-1])
                                if visits%5 == 0 :
                                    money = money + 80
                                else:
                                    money = money + 100
                            if ine == "C" :
                                adults = adults + 1
                                Person.add_visit(ClientRepo.Clients.client_list[b-1])
                                visits = Person.get_visits(ClientRepo.Clients.client_list[b-1])
                                if visits%5 == 0 :
                                    money = money + 40
                                else:
                                    money = money + 50
                            visitors.add(Person.Person.__get_name(av_clients(b-1)))
                            av_clients.remove(b-1)
                            count = count + 1
                elif g == 0 :
                    if count < 1:
                        print("Add at least one visitor")
                    else:
                        break
            print("Set the date.")
            date = " "
            date = Functions.Funtions.__set_date()
            tour = Tour.Tour(guide, visitors, money, date, kids, adults)
            TourRepo.Tour_list.tour_list.add(tour)
    
    def __register_maintenance():
        tech_found = False
        technicians = []
        for worker in WorkerRepo.Workers.worker_list:
            if worker.Worker.__get_role() == "Technician":
                tech_found = True
                technicians.add(worker)
        if tech_found == False and not AnimalRepo.Animals.animal_list :
            print("There's neither technicians neither animals available.")
        elif tech_found == False :
            print("There's no technicians available.")
        elif not AnimalRepo.Animals.animal_list :
            print("There's no animals available.")
        else :
            g = 0
            while True :
                Functions_activities.__show_specific_workers(technicians)
                g = input("Select a technician")
                if g < 1 and g > len(technicians)+1 :
                    print("Invalid input")
                else:
                    technician = Worker.Worker.__get_name(technicians[g-1])
                    break
            t=0
            while True :
                Functions.Functions.__show_animals()
                t = input("Select an animal: ")
                if t < 1 and t > len(AnimalRepo.Animals.animal_list)+1 :
                    print("Invalid input")
                else:
                    animal_id = Animal.Animal.__get_id(AnimalRepo.Animals.animal_list[t-1])
                    break

            process = input("\nWrite the process: ")
            print("Set the date: ")
            date = Functions.Funtions.__set_date()

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
            
            maintenance = Maintenance.Maintenance(technician, animal_id, process, date, comments)
            MaintenanceRepo.Maintenance_list.maintenance_list.add(maintenance)

    def __show_specific_workers(list):
        i = 0
        for anyworker in list :
            i = i + 1
            print("\n"+ Worker.Worker.__get_role(anyworker) + " #"+ i)
            print("\nID: " + Worker.Worker.__get_id(anyworker) + "  Full name: " + Worker.get_name(anyworker)+ "\n")
        print(" ")    

    def __show_available_clients(list):
        i = 0
        for anyperson in list:
            i = i + 1
            print("\nClient #"+ i)
            print("\nID: " + Person.Person.__get_id(anyperson) + "  Full name: " + Person.Person.__get_name(anyperson)+ "\n")
        print(" ")  
    
    def __show_tours():
        if not TourRepo.Tour_list.tour_list:
            print("There's no tours registered")
        else:
            i = 0
            for anytour in TourRepo.Tour_list.tour_list:
                i = i + 1
                print("\nTour #"+ i)
                print(anytour.Tour.__get_details)
            print(" ")
    
    def __show_maintenance():
        if not MaintenanceRepo.Maintenance_list.maintenance_list:
            print("There's no maintenances registered")
        else:
            i = 0
            for anymain in MaintenanceRepo.Maintenance_list.maintenance_list:
                i = i + 1
                print("\nTour #"+ i)
                print(anymain.Maintenance.__get_details)
            print(" ")