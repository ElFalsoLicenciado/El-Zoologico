package Objects;

import java.util.ArrayList;

public class Tour {
    private static int n = 0;
    private final int ID;
    private final String guide;
    private ArrayList<String> visitors = new ArrayList<String>();
    private final int money;
    private final String date;
    private final int kidsAmount;
    private final int adultsAmount;

    public Tour(String guide, ArrayList<String> visitors, int money, String date, int kidsAmount, int adultsAmount) {
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
        String info = String.format("\nTour number: #%s%nGuide in charge: %s, Visitors: ",ID,guide);
        for (String visitor : visitors) {
            info = info + visitor + ". ";
        }
        info = info+String.format("%nTotal in tickets: $%d, date: %s, number of kids: %d & number of adults: %d",money,date,kidsAmount,adultsAmount);
        return info;
    }
}
