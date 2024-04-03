class Maintenance:
    n = 0
    __id = 0
    __employee = " "
    __animal_id = " "
    __process = " " 
    __date = " "
    __comment = " "

    def __init__(self, employee, animal_id, process, date, comment):
        self.__employee = employee
        self.__animal_id = animal_id
        self.__process = process
        self.__date = date
        self.__comment = comment
        n = n + 1
        self.__id = n

    def __get_details(self):
        return"\n Maintenance number: %d \nEmployee in charge: %s \nDate: %s \nAnimal's ID: %s \n Process: %s \nObservations: %s \n", self.__id, self.__employee, self.__date, self.__animal_id, self.__process, self.__comment 
    