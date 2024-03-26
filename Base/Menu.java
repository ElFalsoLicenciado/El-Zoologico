package Base;

import java.io.Console;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Functions zoo = new Functions();
        Random rn = new Random();
        Console cs = System.console();
        final String safePass = "candeChamba";
        boolean passIsValid = false;

        do {
            char[] get = cs.readPassword("Enter the password: ");
            String in = new String(get);
            System.out.print("\033[H\033[2J");


            if (in.equals(safePass)) {
                passIsValid = true;
                String n;
                StringBuilder mes = new StringBuilder("Access granted, please stand by ---------- %00");
                int x = mes.indexOf("%")+1;
                for (int i = 1; i<11;i++){
                    n = String.valueOf(i);
                    mes.setCharAt(mes.indexOf("-"),'#');
                    mes.replace(x,x+1,n);
                    System.out.print("\033[H\033[2J");
                    System.out.println(mes);

                    try{
                        TimeUnit.SECONDS.sleep(rn.nextLong(0,2));
                    }catch (InterruptedException e){
                        System.out.println("Interruption");
                    }
                }
                System.out.print("\033[H\033[2J");
                System.out.println("\nYou are in.\n");
                zoo.sysExecution();
            } else {
                System.out.println("\nPassword is incorrect, try again.");
            }
        } while (!passIsValid);
    }

    }
