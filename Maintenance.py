class Maintenance:
    n = 0
    __id = 0
    __employee = " "
    __animal_id = " "
    __process = " " 
    __date = " "
    __comment = " "

    def __init__(self, employee, animal_id, process, date, comment, id):
        self.__employee = employee
        self.__animal_id = animal_id
        self.__process = process
        self.__date = date
        self.__comment = comment
        self.__id = id

    def get_details(self):
        print("\n Maintenance number: " + self.__id + "\nEmployee in charge: " + self.__employee + "\nDate: " +
        self.__date + "\nAnimal's ID: " + self.__animal_id + "\n Process: " + self.__process + "\nObservations: " + self.__comment)