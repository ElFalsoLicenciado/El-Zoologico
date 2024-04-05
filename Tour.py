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

    def get_details(self):
        info = "\nGuide in charge: " + self.__guide + ". Visitors: "
        i = 0
        for i in self.__visitors:
            kk = " " + self.__visitors[i] + ", "
            i = i + 1
        info = info + kk + "\nTotal in tickets: $" + str(self.__money) + ", date: " + self.__date + ", number of kids: " + str(self.__kids_amount) + ", number of adults: " + str(self.__adults_amount)
        return info
