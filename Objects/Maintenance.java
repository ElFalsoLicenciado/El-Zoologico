package Objects;

public class Maintenance {
    private static int n = 0;
    private int ID;
    private String employee="";
    private int idAnimal = 0;
    private String process="";
    private String date="";
    private String comment="";

    public Maintenance(String employee, int idAnimal, String process, String date, String comment) {
        this.employee = employee;
        this.idAnimal = idAnimal;
        this.process = process;
        this.date = date;
        this.comment = comment;
        n++;
        ID = n;
    }

    public String getDetails(){
        if(comment.isEmpty()){
            return String.format("%nMaintenance number: %d %nEmployee in charge: %s, date: %s, animal's ID: %d%n Process: %s",ID,employee,date,idAnimal,process);
        }else{
            return String.format("%nMaintenance number: %d %nEmployee in charge: %s, date: %s, animal's ID: %d%n Process: %s%n Observations: %s" ,ID,employee,date,idAnimal,process,comment);
        }
    }

}
