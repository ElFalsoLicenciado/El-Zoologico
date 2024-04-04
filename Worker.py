import uuid

class Worker:
    __id = " "
    __name = " "
    __last_name = " "
    __birthday = " "
    __curp = " "
    __date_of_register = " "
    __rfc = " "
    __wage = 0
    __schedule = " "
    __role = " "

    def __init__(self, name, last_name, birthday, curp, date_of_register, rfc, wage, schedule, role):
        self.__name = name
        self.__last_name = last_name
        self.__birthday = birthday
        self.__curp = curp
        self.__date_of_register = date_of_register
        self.__rfc = rfc
        self.__wage = wage
        self.__schedule = schedule
        self.__role = role
        self.__set_id()

    def __set_id(self):
        if self.__role == "Technician" :
            xd = uuid.uuid4()
            id = "WT" + str(xd)
            id = id[0:12]
        elif self.__role == "Guide" :
            xd = uuid.uuid4()
            id = "WG" + str(xd)
            id = id[0:12]
        elif self.__role == "Administrador" :
            xd = uuid.uuid4()
            id = "WA" + str(xd)
            id = id[0:12]
        elif self.__role == "Veterinary" :
            xd = uuid.uuid4()
            id = "WV" + str(xd)
            id = id[0:12]

    def __set_name(self, name, last_name):
        self.__name = name
        self.__last_name = last_name

    def __set_birthday(self, birthday):
        self.__birthday = birthday
        self.__set_id()

    def __set_curp(self, curp):
        self.__curp = curp

    def __set_date_of_register(self, date_of_register):
        self.__date_of_register = date_of_register

    def __get_id(self):
        return id

    def __get_name(self):
        return self.__name + " " + self.__last_name
    
    def __get_birthday(self):
        return self.__birthday
    
    def __get_curp(self):
        return self.__curp
    
    def __get_date_of_register(self):
        return self.__date_of_register
    
    def __get_rfc(self):
        return self.__rfc
    
    def __set_rfc(self, rfc):
        self.__rfc = rfc

    def __get_wage(self):
        return self.__wage
    
    def __set_wage(self, wage):
        self.__wage = wage

    def __get_schedule(self):
        return self.__schedule

    def __set_schedule(self, schedule):
        self.__schedule = schedule

    def __get_role(self):
        return self.__role
    
    def __set_role(self, role):
        self.__role = role
        self.__set_id()