package Base;

import java.util.Scanner;
public class Menu {
    private Scanner sc = new Scanner(System.in);
    private Functions zoo = new Functions();
    private final String safePass = "contraSegura12";

    public void logIN() {
        boolean passIsValid = false;

        do {
            System.out.println("Please input the password.");
            String in = sc.nextLine();

            if (in.equals(safePass)) {
                passIsValid = true;
                ejecutarMenuSistema();
            } else {
                System.out.println("\nPassword is incorrect, try again.");
            }
        } while (!passIsValid);
    }

    private void sysExecution() {
        int p = 0;

        do {
            System.out.println("\n** BIENVENIDO AL SISTEMA **");
            System.out.println("1. Registrar Producto");
            System.out.println("11. Salir");

            switch (p) {
                case 1:

                    break;
                case 0 -> System.out.println("Goodbye");
            }
        } while(p != 0);
    }
}