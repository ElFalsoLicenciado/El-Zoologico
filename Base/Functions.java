package Base;

import Objects.*;
import Storage.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.ArrayList;


public class Functions {
    private Scanner sc = new Scanner(System.in);

    public void sysExecution () {
        int p = 0;

        do {

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

    public String setDate (int day, String month, int year){
        return String.format("%d/%s/%d",day,month,year);
    }


}
