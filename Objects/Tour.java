package Objects;

import Objects.Person;

import java.util.ArrayList;

public class Tour {
    private static int n = 0;
    private int ID;
    private String guide = "";
    private ArrayList<Person> visitors = new ArrayList<Person>();
    private int money = 0;
    private String date = "";
    private int kidsAmount = 0;
    private int adultsAmount = 0;

    public Tour(String guide, ArrayList<Person> visitors, int money, String date, int kidsAmount, int adultsAmount) {
        this.guide = guide;
        this.visitors = visitors;
        this.money = money;
        this.date = date;
        this.kidsAmount = kidsAmount;
        this.adultsAmount = adultsAmount;
        n++;
        ID = n;
    }

    public String getDetails(){
        String info = String.format("%nTour number: %d %nGuide in charge: %s",ID,guide);
        for(Person us: visitors){
            info = info + us.getName()+" ";
        }
        info = info+String.format("%nTotal in tickets: $%d, date: %s, number of kids: %d & number of adults: %d",money,date,kidsAmount,adultsAmount);
        return info;
    }
}
