package Base;

import java.util.Scanner;
import java.util.InputMismatchException;
import Objects.*;
import Storage.*;

public class Functions {
    static Scanner sc = new Scanner(System.in);
    private static boolean flag = false;

    public static void registerWorker(){
        FunctionsWorker.registerWorker();
    }

    public static void registerClient(){
        FunctionsClient.registerClient();
    }

    public static void registerAnimal(){
        FunctionsAnimal.registerAnimal();
    }

    public static void registerTour(){
        FunctionsActivities.registerTour();
    }

    public static void registerMaintenance(){
        FunctionsActivities.registerMaintenance();
    }

    public static void modifyWorker(){
        FunctionsWorker.modifyWorker();
    }

    public static void modifyClient(){
        FunctionsClient.modifyClient();
    }

    public void modifyAnimal(){
        FunctionsAnimal.modifyAnimal();
    }

    public void removeWorker(){
        FunctionsWorker.removeWorker();
    }

    public void removeClient(){
        FunctionsClient.removeClient();
    }

    public void removeAnimal(){
        FunctionsAnimal.removeAnimal();
    }

    public static void showSlaves(){
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

    public static void showClients(){
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

    public static void showAnimals(){
        if (!Animals.animalList.isEmpty()) {
            int i = 0;
            for (Animal anyanimal : Animals.animalList) {
                i++;
                System.out.print("\nAnimal #" + i);
                System.out.printf("\nID %s   Type: %s   Weight: %s   Date of arrival %s   Feed type: %s   Feed frequency: %s times/day   Vaccines: %s   \n", anyanimal.getID(), anyanimal.getType(), anyanimal.getWeight(), anyanimal.getDateOfArrival(), anyanimal.getFeedType(), anyanimal.getFeedFrequency(), anyanimal.isVaccinated());
                if (anyanimal.getDiseases().isEmpty()) {
                    System.out.println("The animal is healthy.\n");
                } else {
                    System.out.print("Current diseases: ");
                    for (int d = 0; d < anyanimal.getDiseases().size(); d++) {
                        System.out.printf("Disease #%d: %s ", d + 1, anyanimal.getDiseases().get(d));
                    }
                    System.out.println();
                }
            }
        }else {
            System.out.println("There's no animals registered");
        }
    }

    public void showTours(){
        FunctionsActivities.showTours();
    }

    public static void showMaintenances(){
        FunctionsActivities.showMaintenances();
    }


    public static String setDate (){
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
        return date;
    }


}

