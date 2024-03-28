package Objects;

import Objects.Person;
import java.util.ArrayList;

public class Tour {

    private String guide;
    private ArrayList<String> visitors = new ArrayList<String>();
    private int money;
    private String date;
    private int kidsAmount;
    private int adultsAmount;

    public Tour(String guide, ArrayList<String> visitors, int money, String date, int kidsAmount, int adultsAmount) {
        this.guide = guide;
        this.visitors = visitors;
        this.money = money;
        this.date = date;
        this.kidsAmount = kidsAmount;
        this.adultsAmount = adultsAmount;
    }

    public String getDetails(){
        String info = String.format("\nGuide in charge: %s, Visitors: ",guide);
        for (String visitor : visitors) {
            info = info + visitor + ". ";
        }
        info = info+String.format("%nTotal in tickets: $%d, date: %s, number of kids: %d & number of adults: %d",money,date,kidsAmount,adultsAmount);
        return info;
    }
}
