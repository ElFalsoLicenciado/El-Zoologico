package Base;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import Objects.*;
import Storage.*;
public class FunctionsActivities {
    static Scanner sc = new Scanner(System.in);
    private static boolean flag = false;

    public static void registerTour(){
        boolean guideFound = false;
        ArrayList<Worker> guides = new ArrayList<Worker>();
        ArrayList<Person> avClients = new ArrayList<Person>();
        avClients.addAll(Clients.clientList);

        for (Worker worker : Workers.workerList){
            if (worker.getRole().equals("Guide")) {
                guideFound = true;
                guides.add(worker);
            }
        }
        if(!guideFound && Clients.clientList.isEmpty()){
            System.out.println("There's no guides neither clients available.");
        }else if(!guideFound){
            System.out.println("There's no guides available,");
        }else if (Clients.clientList.isEmpty()){
            System.out.println("There's no clients available.");
        } else {
            ArrayList<String> visitors = new ArrayList<String>();
            int kids = 0;
            int adults = 0;
            int money = 0;
            int g = 0;
            do {
                do {
                    try {
                        showSpecificWorkers(guides);
                        System.out.print("Select an guide: ");
                        g = sc.nextInt();
                        flag = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input.");
                        sc.nextLine();
                    }
                } while (!flag);
                flag = false; sc.nextLine();
                if (g<1 || g>guides.size()){
                    System.out.println("Out of bonds.");
                }
            }while (g<1 || g>guides.size());
            String guide = guides.get(g-1).getName();

            int v = 0;
            int x = 0;
            int count = 0;
            do {
                try{
                    System.out.println("Wanna add an visitor?\n1.Yes 0. No");
                    x = sc.nextInt();
                }catch (InputMismatchException e ){
                    System.out.println("Invalid input.");
                    sc.nextLine();
                }
                switch (x){
                    case 1 -> {
                        if (!avClients.isEmpty()) {
                            do {
                                do {
                                    try {
                                        showAvailableClients(avClients);
                                        System.out.print("Select a visitor: ");
                                        v = sc.nextInt();
                                        flag = true;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input.");
                                        sc.nextLine();
                                    }
                                } while (!flag);
                                flag = false;
                                if (v < 1 || v > avClients.size()) {
                                    System.out.println("Out of bonds");
                                }
                            } while (v < 1 || v > avClients.size());

                            int aux = avClients.get(v - 1).getBirthday().lastIndexOf("/");
                            int year = Integer.parseInt(avClients.get(v - 1).getBirthday().substring(aux + 1));

                            if ((2024 - year) > 17) {
                                adults++;
                                Clients.clientList.get(Clients.clientList.indexOf(avClients.get(v - 1))).addVisit();
                                int visits = avClients.get(v - 1).getNumVisits();
                                if ((visits % 5) == 0) {
                                    money = money + 80;
                                } else {
                                    money = money + 100;
                                }
                            } else if ((2024 - year) < 18) {
                                kids++;
                                Clients.clientList.get(Clients.clientList.indexOf(avClients.get(v - 1))).addVisit();
                                int visits = avClients.get(v - 1).getNumVisits();
                                if ((visits % 5) == 0) {
                                    money = money + 40;
                                } else {
                                    money = money + 50;
                                }
                            }

                            visitors.add(avClients.get(v - 1).getName());
                            avClients.remove(v - 1);
                            count++;
                        }else {
                            System.out.println("There's no clients available.");
                            flag = true;
                        }
                    }
                    case 0 ->{
                        if (count<1){
                            System.out.println("Add at least one visitor.");
                        }else {
                            flag = true;
                        }
                    }
                    default -> System.out.println("Try again.");
                }

            }while (!flag);
            flag = false;
            sc.nextLine();

            System.out.println("Set the date.");
            String date = Functions.setDate();
            Tour tour = new Tour(guide,visitors,money,date,kids,adults);
            TourList.tourList.add(tour);
        }
    }

    public static void registerMaintenance(){
        boolean techFound = false;
        ArrayList<Worker> technicians = new ArrayList<Worker>();
        for (Worker worker : Workers.workerList){
            if (worker.getRole().equals("Technician")) {
                techFound = true;
                technicians.add(worker);
            }
        }
        if(!techFound && Animals.animalList.isEmpty()){
            System.out.println("There's neither technicians neither animals available.");
        }else if(!techFound){
            System.out.println("There's no technicians available,");
        }else if (Animals.animalList.isEmpty()){
            System.out.println("There's no animals available.");
        } else {
            int t = 0;
            do {
                do {
                    try {
                        showSpecificWorkers(technicians);
                        System.out.print("Select a technician: ");
                        t = sc.nextInt();
                        flag = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input.");
                        sc.nextLine();
                    }
                } while (!flag);
                flag = false; sc.nextLine();
                if (t<1 || t>technicians.size()){
                    System.out.println("Out of bonds.");
                }
            }while (t<1 || t>technicians.size());
            String technician = technicians.get(t-1).getName();

            int a = 0;
            do {
                do {
                    try {
                        Functions.showAnimals();
                        System.out.print("Select an animal: ");
                        a = sc.nextInt();
                        flag = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input.");
                        sc.nextLine();
                    }
                } while (!flag);
                flag = false; sc.nextLine();
                if (a<1 || a>Animals.animalList.size()){
                    System.out.println("Out of bonds.");
                }
            }while (a<1 || a>Animals.animalList.size());
            String animalID = Animals.animalList.get(a-1).getID();

            System.out.print("\nWrite the process: ");
            String process = sc.nextLine();
            System.out.println("Set the date: ");
            String date = Functions.setDate();

            String comments="";
            int i = 0;
            do {
                try {
                    System.out.println("Any comments?\n1. Yes 0. No");
                    System.out.print("\nInput: ");
                    i = sc.nextInt();
                    flag = true;
                } catch (InputMismatchException e) {
                    System.out.println("Incorrect input.\n");
                    sc.nextLine();
                }
            } while (!flag);
            flag = false; sc.nextLine();

            switch (i){
                case 1 -> {
                    System.out.println("Write the comment");
                    comments = sc.nextLine();
                }
                case 0 -> comments = "None";
            }

            Maintenance maintenance = new Maintenance(technician,animalID,process,date,comments);
            MaintenanceList.maintenanceList.add(maintenance);
        }
    }

    public static void showSpecificWorkers(ArrayList<Worker> list){
        int i = 0;
        for (Worker anyworker : list){
            i++;
            System.out.print("\n"+anyworker.getRole()+" #"+i);
            System.out.printf("\nID: %s   Full name: %s   \n",anyworker.getID(),anyworker.getName());
        }
        System.out.println();
    }

    public static void showAvailableClients(ArrayList<Person> list){
        int i = 0;
        for (Person anyperson : list){
            i++;
            System.out.print("\nClient #"+i);
            System.out.printf("\nID: %s   Full name: %s   \n",anyperson.getID(),anyperson.getName());
        }
    }

    public static void showTours(){
        if(TourList.tourList.isEmpty()){
            System.out.println("There's no tours registered.");
        }else {
            for(Tour anytour : TourList.tourList){
                System.out.println(anytour.getDetails());
            }
            System.out.println();
        }
    }

    public static  void showMaintenances(){
        if(MaintenanceList.maintenanceList.isEmpty()){
            System.out.println("There's no maintenances registered.");
        }else {
            for(Maintenance anymaintenance : MaintenanceList.maintenanceList){
                System.out.println(anymaintenance.getDetails());
            }
            System.out.println();
        }
    }
}
