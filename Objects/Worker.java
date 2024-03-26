package Objects;

import java.util.UUID;
import java.util.Scanner;

public class Worker {

    private static int n = 0;
    private String ID;
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
        ID = UUID.randomUUID().toString().substring(0,12);
    }

    public String getID(){
        return ID;
    }
}
