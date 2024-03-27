package Objects;

import java.util.UUID;

public class Person {

    private static int n = 0;
    private String ID = "";
    private String name = "";
    private String lastName = "";
    private String birthday = "";
    private String CURP = "";
    private int numVisits = 0;
    private String dateOfRegister = "";

    public Person(String name, String lastName, String birthday, String CURP, int numVisits, String dateOfRegister) {
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.CURP = CURP;
        this.numVisits = numVisits;
        this.dateOfRegister = dateOfRegister;
        n++;
        setID();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
        setID();
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public void addVisit() {
        numVisits++;
    }

    public void setDateOfRegister(String dateOfRegister) {
        this.dateOfRegister = dateOfRegister;
    }

    public String getID() {
        return ID;
    }

    public void setID(){
        int x = birthday.lastIndexOf("/");
        int year = Integer.parseInt(birthday.substring(x+1));
        System.out.println(year); //Verificar edad
        if((year-2024)>18){
            ID = "CA" + UUID.randomUUID().toString().substring(2,12);
        }else if((year-2024)<18){
            ID = "CC" + UUID.randomUUID().toString().substring(2,12);
        }

        }

    public String getName() {
        return String.format("%s %s",name,lastName);
    }

    public String getBirthday() {
        return birthday;
    }

    public String getCURP() {
        return CURP;
    }

    public int getNumVisits() {
        return numVisits;
    }

    public String getDateOfRegister() {
        return dateOfRegister;
    }
}
