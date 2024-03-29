package Base;

import java.util.InputMismatchException;
import java.util.Scanner;
import Objects.*;
import Storage.*;
public class FunctionsWorker {
    static Scanner sc = new Scanner(System.in);
    private static boolean flag = false;
    public static void registerWorker(){
        System.out.print("\nWorker's name: ");
        String name = sc.nextLine();
        System.out.print("\nWorker's last name: ");
        String lasName = sc.nextLine();
        System.out.print("\nWorker's birthday: ");
        String birthday = Functions.setDate();
        System.out.print("\nWorker's CURP: ");
        String CURP = sc.nextLine();
        System.out.print("\nSet the date of register: ");
        String regDate = Functions.setDate();
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

    public static void modifyWorker(){
        if (!Workers.workerList.isEmpty()) {
            int w = 0;
            do {
                do {
                    try {
                        Functions.showSlaves();
                        System.out.print("\nSelect a worker: ");
                        w = sc.nextInt();
                        flag = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input.");
                        sc.nextLine();
                    }
                }while (!flag);
                flag = false;sc.nextLine();
                if (w < 1 || w > Workers.workerList.size()) {
                    System.out.println("Out of bonds.");
                }
            }while (w<1 || w>Workers.workerList.size());

            int c = 0;
            do {
                do {
                    do {
                        try {
                            System.out.print("\n1. Change ID\n2.Change full name\n3.Change birthday\n4.Change date of registry\n5.Change CURP\n6.Change RFC\n7.Change wage\n8.Change schedule\n9.Change role\n0. Return");
                            System.out.print("\nInput: ");
                            c = sc.nextInt();
                            flag = true;
                        }catch (InputMismatchException e) {
                            System.out.println("Invalid input.");
                            sc.nextLine();
                        }
                    } while (!flag);
                    flag = false; sc.nextLine();
                    if (c<0 || c>9){
                        System.out.println("Out of bonds.");
                    }
                }while (c<0 || c>9);

                switch (c){
                    case 1 -> {
                        Workers.workerList.get(w-1).setID();
                        System.out.println("New ID: "+Workers.workerList.get(w-1).getID());
                    }
                    case 2 -> {
                        System.out.print("\nWrite the worker's new name: ");
                        String name = sc.nextLine();
                        System.out.print("\nWrite the worker's new last name: ");
                        String lastName = sc.nextLine();
                        Workers.workerList.get(w-1).setName(name,lastName);
                    }
                    case 3 -> {
                        System.out.println("Worker's new birthday.");
                        String birthday = Functions.setDate();
                        Workers.workerList.get(w - 1).setBirthday(birthday);
                    }
                    case 4 -> {
                        System.out.println("Worker's new registry date.");
                        String regDate = Functions.setDate();
                        Workers.workerList.get(w - 1).setDateOfRegister(regDate);
                    }
                    case 5 -> {
                        System.out.print("\nWorker's new CURP: ");
                        String CURP = sc.nextLine();
                        Workers.workerList.get(w - 1).setCURP(CURP);
                    }
                    case 6 -> {
                        System.out.print("\nWorker's new RFC: ");
                        String RFC = sc.nextLine();
                        Workers.workerList.get(w - 1).setRFC(RFC);
                    }
                    case 7 -> {
                        int wage = 0;
                        do {
                            do {
                                try {
                                    System.out.print("\nWorker's new wage: $");
                                    wage = sc.nextInt();
                                    flag = true;
                                }catch (InputMismatchException e){
                                    System.out.println("Invalid input");
                                    sc.nextLine();
                                }
                            }while (!flag);
                            flag = false; sc.nextLine();
                        }while (wage<1);

                        Workers.workerList.get(w - 1).setWage(wage);
                    }
                    case 8 -> {
                        System.out.print("\nWorker's new schedule: ");
                        String schedule = sc.nextLine();
                        Workers.workerList.get(w - 1).setSchedule(schedule);
                    }
                    case 9 -> {
                        System.out.println("Worker's new role.");
                        String role = setRole();
                        Workers.workerList.get(w - 1).setRole(role);
                    }
                    case 0 -> System.out.println("Cheers");
                }
            }while (c!=0);
        }else{
            System.out.println("There's no workers registered.");
        }
    }

    public static void removeWorker(){
        if (!Workers.workerList.isEmpty()){
            int w = 0;
            do {
                do {
                    try {
                        Functions.showSlaves();
                        System.out.print("\nSelect a worker: ");
                        w = sc.nextInt();
                        flag = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input");
                        sc.nextLine();
                    }
                } while (!flag);
                flag = false; sc.nextLine();
                if (w < 1 || w > Workers.workerList.size()) {
                    System.out.println("Out of bonds.");
                }
            } while (w < 1 || w > Workers.workerList.size());
            Workers.workerList.remove(w-1);
        }else {
            System.out.println("There's no worker registered.");
        }
    }

    public static String setRole(){
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
            sc.nextLine();
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
