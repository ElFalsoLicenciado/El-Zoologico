class Tour:
    __guide = " "
    __visitors = []
    __money = 0
    __date = " "
    __kids_amount = 0
    __adults_amount = 0

    def __init__(self, guide, visitors, money, date, kids_amount, adults_amount):
        self.__guide = guide
        self.__visitors = visitors
        self.__money = money
        self.__date = date
        self.__kids_amount = kids_amount
        self.__adults_amount = adults_amount

    def __get_details(self, visitors, money, date, kids_amount, adults_amount):
        info = "\nGuide in charge: " + self.__guide + ". Visitors: "
        for visitor in visitors:
            kk = " "
            kk = kk + visitor + ", "
        
        info = kk + "\nTotal in tickets: $" + money + ", date: " + date + ", number of kids: " + kids_amount + ", number of adults: " + adults_amount
        return info