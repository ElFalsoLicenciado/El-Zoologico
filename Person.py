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
        self.__set_id()

    def __set_name(self, name, last_name):
        self.__name = name
        self.__last_name = last_name

    def __set_birthday(self, birthday):
        self.__birthday = birthday
        self.__set_id()

    def __set_curp(self, curp):
        self.__curp = curp

    def __set_num_visits(self, num_visits):
        self.__num_visits = num_visits

    def __add_visit(self):
        __num_visits = __num_visits + 1

    def __set_date_of_register(self, date_of_register):
        self.__date_of_register = date_of_register

    def __get_id(self):
        return self.__id
    
    def __set_id(self):
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

    def __get_name(self):
        return self.__name + " " + self.__last_name
    
    def __get_birthday(self):
        return self.__birthday
    
    def __get_curp(self):
        return self.__curp
    
    def __get_num_visits(self):
        return self.__num_visits
    
    def __get_date_of_register(self):
        return self.__date_of_register
    
    def show_client(self):
        
        print("\nID: %s   Full name: %s   Birthday: %s  Date of register: %s   CURP: %s   Number of visits %s\n", self.__get_id , self.__get_name, self.__get_birthday, self.__get_date_of_register, self.__get_curp, self.__get_num_visits)
        anyperson = anyperson + 1