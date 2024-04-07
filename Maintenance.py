class Maintenance:
    n = 0
    __id = 0
    __employee = " "
    __animal_id = " "
    __process = " " 
    __date = " "
    __comments = []

    def __init__(self, employee, animal_id, process, date, comments, id):
        self.__employee = employee
        self.__animal_id = animal_id
        self.__process = process
        self.__date = date
        self.__comments = comments
        self.__id = id
    
    def get_animal(self):
        return self.__animal_id
    
    def show_comments(self):
        comment = 0
        for comment in range(len(self.__comments)):
            print("Comment #"+str(comment + 1)+": "+ self.__comments[comment])
            comment = comment + 1
    
    def get_empployee(self):
        return self.__employee

    def get_details(self):
        print("\nMaintenance number: " + str(self.__id) + "\nEmployee in charge: " + self.__employee + "\nDate: " +
        self.__date + "\nAnimal's ID: " + self.__animal_id + "\nProcess: " + self.__process + "\nObservations: ")
        if not self.__comments:
            print("No comments")
        else: 
            self.show_comments()