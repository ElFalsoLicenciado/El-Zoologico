package Base;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {
    Functions zoo = new Functions();
    private Scanner sc = new Scanner(System.in);
    private boolean flag = false;
    public void sysExecution () {
        int p = 0;
        do {
            do {
                try {
                    System.out.println("1. Register.");
                    System.out.println("2. Update.");
                    System.out.println("3. Delete.");
                    System.out.println("4. View details.");
                    System.out.println("0. Quit\n");
                    System.out.print("Input: ");
                    p = sc.nextInt();
                    flag = true;
                }catch (InputMismatchException e){
                    System.out.println("Invalid input.\n");
                    sc.nextLine();
                }
            }while (!flag);
            flag = false;

            switch (p) {
                case 1 -> {
                    int i = 0;
                    do {
                        do {
                            try {
                                System.out.println("1. Register a worker.");
                                System.out.println("2. Register a client.");
                                System.out.println("3. Register an animal.");
                                System.out.println("4. Register a tour.");
                                System.out.println("5. Register a maintenance.");
                                System.out.println("0. Return");
                                System.out.print("\nInput: ");
                                i = sc.nextInt();
                                flag = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Incorrect input.\n");
                                sc.nextLine();
                            }
                        } while (!flag);
                        flag = false;

                    switch (i) {
                        case 1 -> {
                            System.out.println("Registering a worker");
                            zoo.registerWorker();
                            i=0;
                        }
                        case 2 -> {
                            System.out.println("Registering a client");
                            zoo.registerClient();
                            i=0;
                        }
                        case 3 -> {
                            System.out.println("Registering an animal");
                            zoo.registerAnimal();
                            i=0;
                        }
                        case 4 -> {
                            System.out.println("Registering a tour");
                            zoo.registerTour();
                            i=0;
                        }
                        case 5 -> {
                            System.out.println("Registering a maintenance");
                            zoo.registerMaintenance();
                            i=0;
                        }
                        case 0 -> System.out.println("Returning");
                        default -> System.out.println("Try again.");
                    }
                    }while (i!=0);
                }
                case 2 -> {
                    int i = 0;
                    do {
                        do {
                            try {
                                System.out.println("1. Modify a worker.");
                                System.out.println("2. Modify a client.");
                                System.out.println("3. Modify an animal.");
                                System.out.println("0. Return");
                                System.out.print("\nInput: ");
                                i = sc.nextInt();
                                flag = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Incorrect input.\n");
                                sc.nextLine();
                            }
                        } while (!flag);
                        flag = false;

                        switch (i) {
                            case 1 -> {
                                System.out.println("Modifying a worker");

                                i=0;
                            }
                            case 2 -> {
                                System.out.println("Modifying a client");

                                i=0;
                            }
                            case 3 -> {
                                System.out.println("Modifying an animal");

                                i=0;
                            }
                            case 0 -> System.out.println("Returning");
                            default -> System.out.println("Try again.");
                        }
                    }while (i!=0);
                }

                case 3 -> {
                    int i = 0;
                    do {
                        do {
                            try {
                                System.out.println("1. Remove a worker.");
                                System.out.println("2. Remove a client.");
                                System.out.println("3. Remove an animal.");
                                System.out.println("0. Return");
                                System.out.print("\nInput: ");
                                i = sc.nextInt();
                                flag = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Incorrect input.\n");
                                sc.nextLine();
                            }
                        } while (!flag);
                        flag = false;

                        switch (i) {
                            case 1 -> {
                                System.out.println("Removing a worker");

                                i=0;
                            }
                            case 2 -> {
                                System.out.println("Removing a client");

                                i=0;
                            }
                            case 3 -> {
                                System.out.println("Removing an animal");

                                i=0;
                            }
                            case 0 -> System.out.println("Returning");
                            default -> System.out.println("Try again.");
                        }
                    }while (i!=0);
                }
                case 4 -> {
                    int i = 0;
                    do {
                        do {
                            try {
                                System.out.println("1. Show workers.");
                                System.out.println("2. Show clients.");
                                System.out.println("3. Show animals.");
                                System.out.println("4. Show tours.");
                                System.out.println("5. Show maintenances.");
                                System.out.println("0. Return");
                                System.out.print("\nInput: ");
                                i = sc.nextInt();
                                flag = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Incorrect input.\n");
                                sc.nextLine();
                            }
                        } while (!flag);
                        flag = false;

                        switch (i) {
                            case 1 -> {
                                System.out.println("Showing workers");
                                zoo.showSlaves();
                                i=0;
                            }
                            case 2 -> {
                                System.out.println("Showing clients");
                                zoo.showClients();
                                i=0;
                            }
                            case 3 -> {
                                System.out.println("Showing animals");
                                zoo.showAnimals();
                                i=0;
                            }
                            case 4 -> {
                                System.out.println("Showing tours");
                                zoo.showTours();
                                i=0;
                            }
                            case 5 -> {
                                System.out.println("Showing maintenances");
                                zoo.showMaintenances();
                                i=0;
                            }
                            case 0 -> System.out.println("Returning");
                            default -> System.out.println("Try again.");
                        }
                    }while (i!=0);
                }
                case 0 -> System.out.println("Cheers");
                default -> System.out.println("Try again");
            }
        } while (p != 0);
    }
}
