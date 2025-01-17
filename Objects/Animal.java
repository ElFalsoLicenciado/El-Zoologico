package Objects;

import java.util.UUID;
import java.util.ArrayList;
public class Animal {
    private String ID = "";
    private String type;
    private String dateOfArrival;
    private double weight;
    private ArrayList<String> diseases = new ArrayList<>();
    private int feedFrequency;
    private String feedType;
    private boolean vaccines;

    public Animal(String type, String dateOfArrival, double weight, ArrayList<String> diseases, int feedFrequency, String feedType, boolean vaccines) {
        this.type = type;
        this.dateOfArrival = dateOfArrival;
        this.weight = weight;
        this.diseases = diseases;
        this.feedFrequency = feedFrequency;
        this.feedType = feedType;
        this.vaccines = vaccines;
        setID();
    }

    public String getID() {
        return ID;
    }

    public void setID(){
        ID = "A" + UUID.randomUUID().toString().substring(1,12);
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(String dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public ArrayList<String> getDiseases() {
        return diseases;
    }

    public void showDiseases(){
        int d=0;
        for (String disease : diseases){
            d++;
            System.out.println("Disease #"+d+": "+disease);
        }
    }

    public void removeDisease(int i){
        diseases.remove(i);
    }

    public void addDisease(String disease){
        diseases.add(disease);
    }

    public int getFeedFrequency() {
        return feedFrequency;
    }

    public void setFeedFrequency(int feedFrequency) {
        this.feedFrequency = feedFrequency;
    }

    public String getFeedType() {
        return feedType;
    }

    public void setFeedType(String feedType) {
        this.feedType = feedType;
    }

    public boolean isVaccinated() {
        return vaccines;
    }

    public void setVaccines(boolean vaccines) {
        this.vaccines = vaccines;
    }
}
