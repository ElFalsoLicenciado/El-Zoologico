from Objects import Animal
from Storage import AnimalRepo
import Functions

class Funtions_animal:
     
    def __register_animal():
        type = input("\nAnimal's type")
        weight = 0.0
        while weight <= 0 :
            weight = float(input("\nAnimal's weight: "))
            if weight >= 0:
                break
            else:
                print("Invalid input.")
        
        print("\nAnimal' date of arrival: ")
        arr_date = Functions.Funtions.__set_date()
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
        animal = Animal.Animal(type, arr_date, weight, diseases, feed_freq, feed_type, vac)
        AnimalRepo.Animals.animal_list.add(animal)

    def __modify_animal():
        if not AnimalRepo.Animals.animal_list:
            print("There are no animals registered")
        else:
            a = 0
            while a<= 0 or a > len(AnimalRepo.Animals.animal_list):
                Functions.Functions.__show_animals()   
                a = input("Select an animal: ")
                if  a> 0 and a <= len(AnimalRepo.Animals.animal_list):
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
                        Animal.Animal.__set_id(AnimalRepo.Animals.animal_list[a-1])
                        print("\nNew ID: " + Animal.Animal.__get_id(AnimalRepo.Animals.animal_list[a-1]))
                        break
                    elif c == 2:
                        type = input("\nAnimal's new type: ")
                        Animal.Animal.__set_type(AnimalRepo.Animals.animal_list[a-1], type)
                        break
                    elif c== 3:
                        print("Animal's new date of arrival: ")
                        arr_date = Functions.Funtions.__set_date()
                        Animal.Animal.__set_date_of_arrival(AnimalRepo.Animals.animal_list[a-1], arr_date)
                        break
                    elif c == 4:
                        weight = 0.0
                        while weight <= 0 :
                            weight = float(input("\nAnimal's new weight: "))
                            if weight >= 0:
                                Animal.Animal.__set_weight(AnimalRepo.Animals.animal_list[a-1], weight)
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
                                Animal.Animal.__add_disease[AnimalRepo.Animals.animal_list[a-1], disease]
                                break
                            elif d == 0 :
                                if not Animal.Animal.__diseases:
                                    print("There are no diseases to dismiss")
                                    break
                                else:
                                    while True:
                                        vv = 0
                                        while vv<= 0 or vv > len(Animal.Animal.__diseases):
                                            Animal.Animal.__show_diseases  
                                            vv = input("Disease to dismiss: ")
                                        if  vv> 0 and vv <= len(AnimalRepo.Animals.animal_list):
                                            Animal.Animal.__remove_disease[AnimalRepo.Animals.animal_list[a-1],vv-1]
                                            break
                                        else:    
                                            print("Invalid input")
                                    break
                    elif c == 6:
                        feed_type = input("\nAnimal's new type: ")
                        Animal.Animal.__set_feed_type(AnimalRepo.Animals.animal_list[a-1], feed_type)
                        break
                    elif c == 7:
                        feed_freq = ""
                        while feed_freq <= "" :
                            feed_freq = input("\nAnimal's new feed frequency: ")
                            if feed_freq != "":
                                Animal.Animal.__set_feed_frequency(AnimalRepo.Animals.animal_list[a-1], feed_freq)
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
                        Animal.Animal.__set_vaccines(AnimalRepo.Animals.animal_list[a-1], vac)
                    else:
                        print("Invalid input.")
    
    def __remove_animal():
        if not AnimalRepo.Animals.animal_list:
            print("There are no animals registered.")
        else:
            a = 0
            while a<= 0 or a > len(AnimalRepo.Animals.animal_list):
                Functions.Functions.__show_animals()   
                a = input("Select an animal: ")
                if  a> 0 and a <= len(AnimalRepo.Animals.animal_list):
                    del AnimalRepo.Animals.animal_list[a-1]
                else:    
                    print("Invalid input")
