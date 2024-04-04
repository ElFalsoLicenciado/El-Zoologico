import uuid

class Person:
    __id = " "
    __name = " "
    __last_name = " "
    __birthday = " "
    __curp = " "
    __num_visits = 0
    __date_of_register = " "

    def __init__(self, name, last_name, birthday, curp, date_of_register):
        self.__name = name
        self.__last_name = last_name
        self.__birthday = birthday
        self.__curp = curp
        self.__date_of_register = date_of_register
        self._id = self.set_id()

    def set_name(self, name, last_name):
        self.__name = name
        self.__last_name = last_name

    def set_birthday(self, birthday):
        self.__birthday = birthday
        self._id = self.set_id()

    def set_curp(self, curp):
        self.__curp = curp

    def set_num_visits(self, num_visits):
        self.__num_visits = num_visits

    def add_visit(self):
        __num_visits = __num_visits + 1

    def set_date_of_register(self, date_of_register):
        self.__date_of_register = date_of_register

    def get_id(self):
        return self.__id
    
    def set_id(self):
        year = 0
        print(self.__birthday)
        year = int(self.__birthday[-4:])
        if 2024 - year > 17 : 
            xd = uuid.uuid4()
            id = "CA" + str(xd)
            id = id[0:12]
        elif 2024 - year < 18 :
            xd = uuid.uuid4()
            id = "CC" + str(xd)
            id = id[0:12]
        return id

    def get_name(self):
        return self.__name + " " + self.__last_name
    
    def get_birthday(self):
        return self.__birthday
    
    def get_curp(self):
        return self.__curp
    
    def get_num_visits(self):
        return self.__num_visits
    
    def get_date_of_register(self):
        return self.__date_of_register
    
    def show_client(self):
        print("\nID: "+ self.__id +   "  Full name: " + self.__name + " " + self.__last_name + "  Birthday: " + self.__birthday +  
        "  Date of register: " + self.__date_of_register + "  CURP: " + self.__curp +  "  Number of visits: "+ str(self.__num_visits))