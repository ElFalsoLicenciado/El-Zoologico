import java.util.ArrayList;

public class System {
    private ArrayList<Worker> workList = new ArrayList<Worker>();
    private ArrayList<Person> vistList = new ArrayList<Person>();
    private ArrayList<Animal> animList = new ArrayList<Animal>();
    private ArrayList<Tour> tourList = new ArrayList<Tour>();
    private ArrayList<Maintenance> mainList = new ArrayList<Maintenance>();




    public String setDate (int day, String month, int year){
        String date = String.format("%d/%s/%d",day,month,year);
        return date;
    }


}
