package Base;

import Objects.*;
import Storage.*;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;


public class Functions {
    private Scanner sc = new Scanner(System.in);
    private boolean flag = false;
    public void sysExecution () {
        int p = 0;

        do {

            setDate();
            setDate();

            System.out.println("1. Register.");
            System.out.println("2. Update.");
            System.out.println("3. Delete.");
            System.out.println("4. View details.");
            System.out.println("0. Quit\n");
            System.out.print("Input: ");
            p = sc.nextInt(); sc.nextLine();


            switch (p) {
                case 1:
                    System.out.println("1. Worker.");
                    System.out.println("2. Client.");
                    System.out.println("3. Animal.");
                    System.out.println("4. Tour.");
                    System.out.println("5. Maintenance.");

                    break;
                case 2:

                    break;

                case 3:

                    break;
                case 4:

                    break;
                default:
                    System.out.println("Try again");
                    break;
            }
        } while (p != 0);
        System.out.println("Goodbye");
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
                            System.out.println("Write the year: ");
                            y = sc.nextInt();
                            flag = true;
                        }catch (InputMismatchException e){
                            System.out.println("Invalid input");
                        }
                    }while (!flag);
                    flag = false;
                    if (y<1000 || y>2024){
                        System.out.println("Out of bonds.");
                    }
                }while (y<1000 || y>2024);

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
                        }
                    }while (!flag);
                    flag = false;
                    if (y<1000 || y>2024){
                        System.out.println("Out of bonds.");
                    }
                }while (y<1000 || y>2024);

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
                        }
                    }while (!flag);
                    flag = false;
                    if (y<1000 || y>2024){
                        System.out.println("Out of bonds.");
                    }
                }while (y<1000 || y>2024);

                date = String.format("%d/%d/%d",d,m,y);
            }
        }
        return date;
    }


}
