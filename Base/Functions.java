package Base;

import Objects.Maintenance;
import Objects.Tour;
import Things.Animal;
import Objects.Person;
import Objects.Worker;

import java.util.ArrayList;

public class Functions {
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