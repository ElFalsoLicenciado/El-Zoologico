public class Person {
    private static int ID = 0;
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
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public static int getID() {
        return ID;
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
