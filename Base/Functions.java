package Base;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import Objects.*;
import Storage.*;

public class Functions {
    Scanner sc = new Scanner(System.in);
    private boolean flag = false;

    public void registerWorker(){
        System.out.print("\nWorker's name: ");
        String name = sc.nextLine();
        System.out.print("\nWorker's last name: ");
        String lasName = sc.nextLine();
        System.out.print("\nWorker's birthday: ");
        String birthday = setDate();
        System.out.print("\nWorker's CURP: ");
        String CURP = sc.nextLine();
        System.out.print("\nSet the date of register: ");
        String regDate = setDate();
        System.out.print("\nWorker's RFC: ");
        String RFC = sc.nextLine();
        System.out.print("\nWorker's wage: $");
        int wage = sc.nextInt(); sc.nextLine();
        System.out.print("\nWorker's schedule: ");
        String schedule = sc.nextLine();
        String role = setRole();

        Worker worker = new Worker(name,lasName,birthday,CURP,regDate,RFC,wage,schedule,role);
        Workers.workerList.add(worker);
    }

    public void registerClient(){
        System.out.print("\nClient's name: ");
        String name = sc.nextLine();
        System.out.print("\nClient's last name: ");
        String lastName = sc.nextLine();
        System.out.print("\nClient's birthday: ");
        String birthday = setDate();
        System.out.print("\nClient's CURP: ");
        String CURP = sc.nextLine();
        System.out.print("\nSet the date of register: ");
        String regDate = setDate();

        Person client = new Person(name,lastName,birthday,CURP,regDate);
        Clients.clientList.add(client);
    }

    public void registerAnimal(){
        System.out.print("\nAnimal's type: ");
        String type = sc.nextLine();
        System.out.print("\nAnimal's weight: ");
        double weight = sc.nextDouble();
        System.out.print("\nAnimal's date of arrival: ");
        String arrDate= setDate();
        System.out.print("\nAnimal's feed type: ");
        String feedType = sc.nextLine();
        System.out.print("\nAnimal's feed frequency: ");
        int feedFreq = sc.nextInt();
        sc.nextLine();

        ArrayList<String> diseases = new ArrayList<>();
        int d = 0;
        boolean flag2 = false;
        do {
            do {
                try {
                    System.out.println("\nDoes the animal has a disease?\n1. Yes 0. No");
                    d = sc.nextInt();
                    flag2 = true;
                }catch (InputMismatchException e) {
                    System.out.println("Invalid input");
                    sc.nextLine();
                }
            }while (!flag2);
            flag2 = false;
            sc.nextLine();

            switch (d) {

                case 1 -> {
                    System.out.print("Write the disease: ");
                    String disease = sc.nextLine();
                    diseases.add(disease);
                }

                case 0 -> flag = true;

                default -> System.out.println("Invalid.");

            }
        }while (!flag);
        flag = false;

        boolean vac;
        int v = 0;
        do {
            try {
                System.out.println("Is the animal vaccinated?\n1. Yes 2. No");
                v = sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Invalid input.");
                sc.nextLine();
            }
        }while (v<0 || v>1);
            if (v==0){
                 vac = false;
            }else {
                 vac = true;
            }

            Animal animal = new Animal(type,arrDate,weight,diseases,feedFreq,feedType,vac);
            Animals.animalList.add(animal);
    }

    public void registerTour(){

    }

    public void registerMaintenance(){

    }

    public void showSlaves(){
        if(Workers.workerList.isEmpty()){
            System.out.println("There's no workers registered.");
        }else {
            int i = 0;
            for(Worker anyworker : Workers.workerList){
                i++;
                System.out.print("\nWorker #"+i);
                System.out.printf("\nID: %s   Full name: %s   Birthday: %s   Role: %s   Date of register: %s   CURP: %s   RFC: %s   Wage: $%d   Schedule %s\n",anyworker.getID(),anyworker.getName(),anyworker.getBirthday(),anyworker.getRole(),anyworker.getDateOfRegister(),anyworker.getCURP(),anyworker.getRFC(),anyworker.getWage(),anyworker.getSchedule());
            }
            System.out.println();
        }
    }

    public void showClients(){
        if(Clients.clientList.isEmpty()){
            System.out.println("There's no clients registered.");
        }else {
            int i = 0;
            for(Person anyperson : Clients.clientList){
                i++;
                System.out.print("\nClient #" + i);
                System.out.printf("\nID: %s   Full name: %s   Birthday: %s   Date of register: %s   CURP: %s   Number of visits %s\n",anyperson.getID(),anyperson.getName(),anyperson.getBirthday(),anyperson.getDateOfRegister(),anyperson.getCURP(),anyperson.getNumVisits());
            }
            System.out.println();
        }
    }

    public void showAnimals(){
        int i = 0;
        for (Animal anyanimal : Animals.animalList){
            i++;
            System.out.print("\nAnimal #" + i);
            System.out.printf("\nID %s   Type: %s   Weight: %s   Date of arrival %s   Feed type: %s   Feed frequency: %s times/day   Vaccines: %s   \n",anyanimal.getID(),anyanimal.getType(),anyanimal.getWeight(),anyanimal.getDateOfArrival(),anyanimal.getFeedType(),anyanimal.getFeedFrequency(),anyanimal.isVaccinated());
            if(anyanimal.getDiseases().isEmpty()){
                System.out.println("The animal is healthy.\n");
            }else {
                System.out.print("Current diseases: ");
                for (int d = 0; d<anyanimal.getDiseases().size();d++){
                    System.out.printf("Disease #%d: %s ",d+1,anyanimal.getDiseases().get(d));
                }
                System.out.println();
            }
        }
    }

    public void showTours(){
        if(TourList.tourList.isEmpty()){
            System.out.println("There's no tours registered.");
        }else {
            int i = 0;
            for(Tour anytour : TourList.tourList){
                i++;
                System.out.print("\nTour #"+i);
                anytour.getDetails();
            }
            System.out.println();
        }
    }

    public void showMaintenances(){
        if(MaintenanceList.maintenanceList.isEmpty()){
            System.out.println("There's no maintenances registered.");
        }else {
            int i = 0;
            for(Maintenance anymaintenance : MaintenanceList.maintenanceList){
                i++;
                System.out.print("\nMaintenance #"+i);
                anymaintenance.getDetails();
            }
            System.out.println();
        }
    }


    public String setDate (){
        String date = "";
        int m = 0;
        do{
            do {
                try{
                    System.out.print("\nSelect a month.\n1.January 2. February 3. March 4. April 5. May 6. June\n7. July 8. August 9. September 10. October 11. November 12. December\nInput: ");
                    m = sc.nextInt();
                    flag = true;
                }catch (InputMismatchException e){
                    System.out.println("Invalid input");
                    sc.nextLine();
                }
            }while (!flag);
            flag = false;
            if (m<0 || m>12){
                System.out.println("Out of bonds.");
            }
        }while (m<0 || m>12);

        switch (m) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                int d = 0;
                do {
                    do {
                        try {
                            System.out.print("\nWrite the day: ");
                            d = sc.nextInt();
                            flag = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input");
                            sc.nextLine();
                        }
                    } while (!flag);
                    flag = false;
                    if(d < 0 || d > 31){
                        System.out.println("Out of bonds.");
                    }
                } while (d < 0 || d > 31);

                int y = 0;
                do{
                    do {
                        try {
                            System.out.print("\nWrite the year: ");
                            y = sc.nextInt();
                            flag = true;
                        }catch (InputMismatchException e){
                            System.out.println("Invalid input");
                            sc.nextLine();
                        }
                    }while (!flag);
                    flag = false;
                    if (y<0 || y>2024){
                        System.out.println("Are you even human?");
                    }
                }while (y<0 || y>2024);

                date = String.format("%d/%d/%d",d,m,y);
            }

            case 2 -> {
                int d = 0;
                do {
                    do {
                        try {
                            System.out.print("\nWrite the day: ");
                            d = sc.nextInt();
                            flag = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input");
                            sc.nextLine();
                        }
                    } while (!flag);
                    flag = false;
                    if (d < 0 || d > 28){
                        System.out.println("Out of bonds.");
                    }
                } while (d < 0 || d > 28);

                int y = 0;
                do{
                    do {
                        try {
                            System.out.print("\nWrite the year: ");
                            y = sc.nextInt();
                            flag = true;
                        }catch (InputMismatchException e){
                            System.out.println("Invalid input");
                            sc.nextLine();
                        }
                    }while (!flag);
                    flag = false;
                    if (y<0 || y>2024){
                        System.out.println("Are you even human?");
                    }
                }while (y<0 || y>2024);

                date = String.format("%d/%d/%d",d,m,y);
            }

            case 4,6,9,11 -> {
                int d = 0;
                do {
                    do {
                        try {
                            System.out.print("\nWrite the day: ");
                            d = sc.nextInt();
                            flag = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input");
                            sc.nextLine();
                        }
                    } while (!flag);
                    flag = false;
                    if (d < 0 || d > 30){
                        System.out.println("Out of bonds.");
                    }
                } while (d < 0 || d > 30);

                int y = 0;
                do{
                    do {
                        try {
                            System.out.print("\nWrite the year: ");
                            y = sc.nextInt();
                            flag = true;
                        }catch (InputMismatchException e){
                            System.out.println("Invalid input");
                            sc.nextLine();
                        }
                    }while (!flag);
                    flag = false;
                    if (y<0 || y>2024){
                        System.out.println("Are you even human?");
                    }
                }while (y<0 || y>2024);

                date = String.format("%d/%d/%d",d,m,y);
            }
        }
        sc.nextLine();
        System.out.print(date);
        return date;
    }

    public String setRole (){
        String role="";
        int r = 0;
        do {
            do {
                try {
                    System.out.print("\n\nSelect a role: 1. Technician 2. Guide 3. Administrator 4. Veterinary\nInput: ");
                    r = sc.nextInt();
                    flag = true;
                }catch (InputMismatchException e){
                    System.out.println("Invalid input.");
                    sc.nextLine();
                }
            }while (!flag);
            flag = false;
            if (r<1 || r>4){
                System.out.println("Out of bonds.");
            }
        }while (r<1 || r>4);

        switch (r){
            case 1 -> role = "Technician";
            case 2 -> role = "Guide";
            case 3 -> role = "Administrator";
            case 4 -> role = "Veterinary";
        }
        return role;
    }
}

