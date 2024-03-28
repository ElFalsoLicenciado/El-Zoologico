package Objects;

public class Maintenance {
    private static int n = 0;
    private int ID;
    private String employee="";
    private String animalID = "";
    private String process="";
    private String date="";
    private String comment="";

    public Maintenance(String employee, String animalID, String process, String date, String comment) {
        this.employee = employee;
        this.animalID = animalID;
        this.process = process;
        this.date = date;
        this.comment = comment;
        n++;
        ID = n;
    }

    public String getDetails(){
        if(comment.isEmpty()){
            return String.format("%nMaintenance number: %d %nEmployee in charge: %s, date: %s, animal's ID: %d%n Process: %s",ID,employee,date,animalID,process);
        }else{
            return String.format("%nMaintenance number: %d %nEmployee in charge: %s, date: %s, animal's ID: %d%n Process: %s%n Observations: %s" ,ID,employee,date,animalID,process,comment);
        }
    }

}
