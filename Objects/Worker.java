package Objects;

import java.util.UUID;
import java.util.Scanner;

public class Worker {

    private static int n = 0;
    private String ID = "";
    private String name = "";
    private String lastName = "";
    private String birthday = "";
    private String CURP = "";
    private String dateOfRegister = "";
    private String RFC = "";
    private int wage = 0;
    private String schedule = "";
    private String role = "";

    public Worker(String name, String lastName, String birthday, String CURP, String dateOfRegister, String RFC, int wage, String schedule, String role) {
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.dateOfRegister = dateOfRegister;
        this.RFC = RFC;
        this.CURP = CURP;
        this.wage = wage;
        this.schedule = schedule;
        this.role = role;
        n++;
        setID();
    }

    public String getID(){
        return ID;
    }

    public void setID(){
        switch (this.role) {
            case "Technician" -> ID = "WT" + UUID.randomUUID().toString().substring(2, 12);
            case "Guide" -> ID = "WG" + UUID.randomUUID().toString().substring(2, 12);
            case "Administrator" -> ID = "WA" + UUID.randomUUID().toString().substring(2, 12);
            case "Veterinary" -> ID = "WV" + UUID.randomUUID().toString().substring(2, 12);
        }
    }

    public String getName() {
        return String.format("%s %S",name,lastName);
    }

    public void setName(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }


    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getDateOfRegister() {
        return dateOfRegister;
    }

    public void setDateOfRegister(String dateOfRegister) {
        this.dateOfRegister = dateOfRegister;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
        setID();
    }
}

