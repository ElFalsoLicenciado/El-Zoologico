package Base;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import Objects.*;
import Storage.*;
public class FunctionsClient {
    static Scanner sc = new Scanner(System.in);
    private static boolean flag = false;

    public static void registerClient(){
        System.out.print("\nClient's name: ");
        String name = sc.nextLine();
        System.out.print("\nClient's last name: ");
        String lastName = sc.nextLine();
        System.out.print("\nClient's birthday: ");
        String birthday = Functions.setDate();
        System.out.print("\nSet the date of register: ");
        String regDate = Functions.setDate();
        System.out.print("\nClient's CURP: ");
        String CURP = sc.nextLine();

        Person client = new Person(name,lastName,birthday,CURP,regDate);
        Clients.clientList.add(client);
    }

    public static void modifyClient(){
        if (!Clients.clientList.isEmpty()) {
            int cl = 0;
            do {
                do {
                    try {
                        Functions.showClients();
                        System.out.print("\nSelect a client: ");
                        cl = sc.nextInt();
                        flag = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input.");
                        sc.nextLine();
                    }
                }while (!flag);
                flag = false;sc.nextLine();
                if (cl<1 || cl>Clients.clientList.size()) {
                    System.out.println("Out of bonds.");
                }
            }while (cl<1 || cl>Clients.clientList.size());

            int c = 0;
            do {
                do {
                    do {
                        try {
                            System.out.print("\n1. Change ID\n2.Change full name\n3.Change birthday\n4.Change CURP\n5.Change number of visits\n6.Change date of register\n0. Return");
                            System.out.print("\nInput: ");
                            c = sc.nextInt();
                            flag = true;
                        }catch (InputMismatchException e) {
                            System.out.println("Invalid input.");
                            sc.nextLine();
                        }
                    } while (!flag);
                    flag = false; sc.nextLine();
                    if (c<0 || c>6){
                        System.out.println("Out of bonds.");
                    }
                }while (c<0 || c>6);

                switch (c){
                    case 1 -> {
                        Clients.clientList.get(cl - 1).setID();
                        System.out.print("\nNew ID: " + Clients.clientList.get(cl - 1).getID());
                    }
                    case 2 -> {
                        System.out.print("\nClient's new name: ");
                        String name = sc.nextLine();
                        System.out.print("\nClient's new last name: ");
                        String lastName = sc.nextLine();
                        Clients.clientList.get(cl - 1).setName(name,lastName);
                    }
                    case 3 -> {
                        System.out.println("Client's new birthday.");
                        String birthday = Functions.setDate();
                        Clients.clientList.get(cl - 1).setBirthday(birthday);
                    }
                    case 4 -> {
                        System.out.print("\nClient's new CURP: ");
                        String CURP = sc.nextLine();
                        Clients.clientList.get(cl - 1).setCURP(CURP);
                    }
                    case 5 -> {
                        int visits = 0;
                        do {
                            do {
                                try {
                                    System.out.print("\nClient's visits: $");
                                    visits = sc.nextInt();
                                    flag = true;
                                }catch (InputMismatchException e){
                                    System.out.println("Invalid input");
                                    sc.nextLine();
                                }
                            }while (!flag);
                            flag = false; sc.nextLine();
                            if (visits<0){
                                System.out.println("Invalid number of visits.");
                            }
                        }while (visits<0);
                        Clients.clientList.get(cl-1).setNumVisits(visits);
                    }
                    case 6 -> {
                        System.out.println("Client's new registry date.");
                        String regDate = Functions.setDate();
                        Clients.clientList.get(cl - 1).setDateOfRegister(regDate);
                    }
                    case 0 -> System.out.println("Cheers");
                }
            }while (c!=0);
        }else{
            System.out.println("There's no clients registered.");
        }
    }

    public static void removeClient(){
        if (!Clients.clientList.isEmpty()){
            int cl = 0;
            do {
                do {
                    try {
                        Functions.showClients();
                        System.out.print("\nSelect a client: ");
                        cl = sc.nextInt();
                        flag = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input");
                        sc.nextLine();
                    }
                } while (!flag);
                flag = false; sc.nextLine();
                if (cl < 1 || cl > Clients.clientList.size()) {
                    System.out.println("Out of bonds.");
                }
            } while (cl < 1 || cl > Clients.clientList.size());
            Clients.clientList.remove(cl-1);
        }else {
            System.out.println("There's no client registered.");
        }
    }

}
