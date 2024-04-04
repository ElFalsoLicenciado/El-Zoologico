import uuid


class Animal:
    i = 0
    __id = " "
    __type = " "
    __date_of_arrival = " "
    __weight = " "
    __diseases = []
    __feed_frequency = ""
    __feed_type = " "
    __vaccines = False

    def __init__(self, type, date_of_arrival, weight, diseases, feed_frequency, feed_type, vaccines):
        self.__type = type
        self.__date_of_arrival = date_of_arrival
        self.__weight = weight
        self.__diseases = diseases
        self.__feed_frequency = feed_frequency
        self.__feed_type = feed_type
        self.__vaccines = vaccines
        self.__set_id()
    
    def __get_id(self):
        return self.__id
     
    def __set_id(self):
        xd = uuid.uuid4()
        id = "A" + str(xd)
        self.__id = id[0:12]

    def __get_type(self):
        return type
        
    def __set_type(self, type):
        self.__type = type

    def __get_date_of_arrival(self):
        return self.__date_of_arrival
     
    def __set_date_of_arrival(self, date_of_arrival):
        self.__date_of_arrival = date_of_arrival

    def __get_weight(self):
        return self.__weight
     
    def __set_weight(self, weight):
        self.__weight = weight

    def __get_diseases(self):
        return self.__diseases
     
    def __show_diseases(self):
        lol = 0
        for disease in self.__diseases:
            lol = lol + 1
            print("Disease #"+lol+": "+disease)
          
    def __remove_disease(self, i):
        del self.__diseases[i]

    def __add_disease(self, disease):
        self.__diseases.add(disease)

    def __get_feed_frequency(self):
        return self.__feed_frequency
    
    def __set_feed_frequency(self, feed_frequency):
        self.__feed_frequency = feed_frequency

    def __get_feed_type(self):
        return self.__feed_type
    
    def __set_feed_type(self, feed_type):
        self.__feed_type = feed_type

    def __is_vaccinated(self):
        return self.__vaccines

    def set_vaccines(self, vaccines):
        self.__vaccines = vaccines