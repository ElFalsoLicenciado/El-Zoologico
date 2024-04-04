from ..Objects import Worker, Person, Animal
from ..Storage import WorkerRepo, ClientRepo, AnimalRepo
import FuncActivity, FuncAnimal, FuncClient, FuncWorker

class Functions:

    def __register_worker():
        FuncWorker.Functions_worker.__register_worker()

    def __register_client():
        FuncClient.Functions_client.__register_client()

    def __register_animal():
        FuncAnimal.Funtions_animal.__register_animal()

    def __register_tour():
        FuncActivity.Functions_activities.__register_tour()

    def __register_maintenance():
        FuncActivity.Functions_activities.__register_maintenance()
    
    def __modify_worker():
        FuncWorker.Functions_worker.__modify_worker()

    def __modify_client():
        FuncClient.Functions_client.__modify_client()

    def __modify_animal():
        FuncAnimal.Funtions_animal.__modify_animal()

    def __remove_worker():
        FuncWorker.Functions_worker.__remove_worker()

    def __remove_client():
        FuncClient.Functions_client.__remove_client()

    def __remove_animal():
        FuncAnimal.Funtions_animal.__remove_animal()

    def __show_slaves():
        if not WorkerRepo.Workers.worker_list:
            print("There are no workers registered.")
        else:
            i = 0
            for anyworker in WorkerRepo.Workers.worker_list:
                i = i + 1
                print("\nWorker #"+i)
                print("\nID: %s   Full name: %s   Birthday: %s   Role: %s   Date of register: %s   CURP: %s   RFC: %s   Wage: $%d   Schedule %s\n", Worker.Worker.__get_id(anyworker) ,Worker.Worker.__get_name(anyworker), Worker.Worker.__get_birthday(anyworker), Worker.Worker.__get_role(anyworker), Worker.Worker.__get_date_of_register(anyworker), Worker.Worker.__get_curp(anyworker), Worker.Worker.__get_rfc(anyworker), Worker.Worker.__get_wage(anyworker), Worker.Worker.__get_schedule(anyworker))
        print(" ")

    def __show_clients():
        if not ClientRepo.Clients.client_list:
            print("There are no clients registered.")
        else:
            i = 0
            for anyperson in ClientRepo.Clients.client_list:
                i = i + 1
                print("\nClient #"+i)
                print("\nID: %s   Full name: %s   Birthday: %s  Date of register: %s   CURP: %s   Number of visits %s\n", Person.Person.__get_id(anyperson) ,Person.Person.__get_name(anyperson), Person.Person.__get_birthday(anyperson), Person.Person.__get_date_of_register(anyperson), Person.Person.__get_curp(anyperson), Person.Person.__get_num_visits(anyperson))
        print(" ") 
    
    def __show_animals():
        if not AnimalRepo.Animals.animal_list:
            print("There are no animals registered.")
        else:
            i = 0
            for anyanimal in AnimalRepo.Animals.animal_list:
                i = i + 1
                print("\nAnimal #"+i)
                print("\nID %s   Type: %s   Weight: %s   Date of arrival %s   Feed type: %s   Feed frequency: %s  Vaccines: %s   \n", Animal.Animal.__get_id(anyanimal), Animal.Animal.__get_type(anyanimal), Animal.Animal.__get_weight(anyanimal), Animal.Animal.__get_date_of_arrival(anyanimal), Animal.Animal.__get_feed_type(anyanimal), Animal.Animal.__get_feed_frequency(anyanimal), Animal.Animal.__is_vaccinated(anyanimal))
            if not anyanimal.Animal.__diseases :
                print("The animal is healthy")
            else: 
                anyanimal.Animal.__show_diseases
        print(" ")

    def __show_tours():
        FuncActivity.Functions_activities.__show_tours()

    def __show_maintenance():
        FuncActivity.Functions_activities.__show_maintenance()

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