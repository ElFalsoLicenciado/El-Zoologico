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
        self.__id = self.set_id()

    def set_id(self):
        if self.__role == "Technician" :
            xd = uuid.uuid4()
            id = "WT" + str(xd)
            id = id[0:12]
        elif self.__role == "Guide" :
            xd = uuid.uuid4()
            id = "WG" + str(xd)
            id = id[0:12]
        elif self.__role == "Administrator" :
            xd = uuid.uuid4()
            id = "WA" + str(xd)
            id = id[0:12]
        elif self.__role == "Veterinary" :
            xd = uuid.uuid4()
            id = "WV" + str(xd)
            id = id[0:12]
        return id

    def set_name(self, name, last_name):
        self.__name = name
        self.__last_name = last_name

    def set_birthday(self, birthday):
        self.__birthday = birthday
        self.__id = self.set_id()

    def set_curp(self, curp):
        self.__curp = curp

    def set_date_of_register(self, date_of_register):
        self.__date_of_register = date_of_register

    def get_id(self):
        return id

    def get_name(self):
        return self.__name + " " + self.__last_name
    
    def get_birthday(self):
        return self.__birthday
    
    def get_curp(self):
        return self.__curp
    
    def get_date_of_register(self):
        return self.__date_of_register
    
    def get_rfc(self):
        return self.__rfc
    
    def set_rfc(self, rfc):
        self.__rfc = rfc

    def get_wage(self):
        return self.__wage
    
    def set_wage(self, wage):
        self.__wage = wage

    def get_schedule(self):
        return self.__schedule

    def set_schedule(self, schedule):
        self.__schedule = schedule

    def get_role(self):
        return self.__role
    
    def set_role(self, role):
        self.__role = role
        self.__id = self.set_id()

    def show_slave(self):
        print("ID: "+ self.__id +   "  Full name: " + self.__name + " " + self.__last_name +  "  Birthday: " + self.__birthday +  
        "  Date of register: " + self.__date_of_register + "  CURP: " + self.__curp +  "  RFC: "+ self.__rfc +
        "  Role: " + self.__role + "  Wage: " + str(self.__wage) + "  Schedule:  " + self.__schedule)

