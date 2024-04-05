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
        self.set_id()
    
    def get_id(self):
        return self.__id
     
    def set_id(self):
        xd = uuid.uuid4()
        id = "A" + str(xd)
        self.__id = id[0:12]

    def get_type(self):
        return type
        
    def set_type(self, type):
        self.__type = type

    def get_date_of_arrival(self):
        return self.__date_of_arrival
     
    def set_date_of_arrival(self, date_of_arrival):
        self.__date_of_arrival = date_of_arrival

    def get_weight(self):
        return self.__weight
     
    def set_weight(self, weight):
        self.__weight = weight

    def get_diseases(self):
        return self.__diseases
     
    def show_diseases(self):
        disease = 0
        for disease in range(len(self.__diseases)):
            print("Disease #"+str(disease + 1)+": "+ self.__diseases[disease])
            disease = disease + 1
          
    def remove_disease(self, i):
        del self.__diseases[i]

    def add_disease(self, disease):
        self.__diseases.append(disease)

    def get_feed_frequency(self):
        return self.__feed_frequency
    
    def set_feed_frequency(self, feed_frequency):
        self.__feed_frequency = feed_frequency

    def get_feed_type(self):
        return self.__feed_type
    
    def set_feed_type(self, feed_type):
        self.__feed_type = feed_type

    def is_vaccinated(self):
        return self.__vaccines

    def set_vaccines(self, vaccines):
        self.__vaccines = vaccines

    def show_animal(self):
        print("\nID: " + self.__id + "  Type: " + self.__type + "  Weight: " + str(self.__weight) + "  Date of arrival: " +
              self.__date_of_arrival + "  Feed type: " + self.__feed_type + "   Feed frequency: " + self.__feed_frequency + "  Is vaccinated: " + str(self.__vaccines))  
        if not self.__diseases:
            print("The animal is healthy")
        else: 
            self.show_diseases()