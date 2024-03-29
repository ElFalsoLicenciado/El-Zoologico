package Base;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import Objects.*;
import Storage.*;
public class FunctionsAnimal {
    static Scanner sc = new Scanner(System.in);
    private static boolean flag = false;

    public static void registerAnimal(){
        System.out.print("\nAnimal's type: ");
        String type = sc.nextLine();
        double weight=0;
        do {
            do {
                try {
                    System.out.print("\nAnimal's weight: ");
                    weight = sc.nextDouble();
                    flag = true;
                }catch (InputMismatchException e){
                    System.out.println("Invalid input.");
                    sc.nextLine();
                }
            }while (!flag);
            flag = false; sc.nextLine();
        }while(weight<0);

        System.out.print("\nAnimal's date of arrival: ");
        String arrDate= Functions.setDate();
        System.out.print("\nAnimal's feed type: ");
        String feedType = sc.nextLine();
        int feedFreq=0;
        do {
            do {
                try {
                    System.out.print("\nAnimal's feed frequency: ");
                    feedFreq = sc.nextInt();
                    flag = true;
                }catch (InputMismatchException e){
                    System.out.println("Invalid input.");
                    sc.nextLine();
                }
            }while (!flag);
            flag = false; sc.nextLine();
        }while(feedFreq<0);


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
        vac = v != 0;

        sc.nextLine();
        Animal animal = new Animal(type,arrDate,weight,diseases,feedFreq,feedType,vac);
        Animals.animalList.add(animal);
    }

    public static void modifyAnimal(){
        if (!Animals.animalList.isEmpty()) {
            int a = 0;
            do {
                do {
                    try {
                        Functions.showAnimals();
                        System.out.print("\nSelect an animal: ");
                        a = sc.nextInt();
                        flag = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input.");
                        sc.nextLine();
                    }
                }while (!flag);
                flag = false;sc.nextLine();
                if (a<1 || a>Animals.animalList.size()) {
                    System.out.println("Out of bonds.");
                }
            }while (a<1 || a>Animals.animalList.size());

            int c = 0;
            do {
                do {
                    do {
                        try {
                            System.out.print("\n1.Change ID\n2. Change type\n3. Change date of arrival\n4. Change weight\n5. Manage diseases\n6. Change feed type\n7. Change feed frequency\n8. Set diseases\n0. Return");
                            System.out.print("\nInput: ");
                            c = sc.nextInt();
                            flag = true;
                        }catch (InputMismatchException e) {
                            System.out.println("Invalid input.");
                            sc.nextLine();
                        }
                    } while (!flag);
                    flag = false; sc.nextLine();
                    if (c<0 || c>8){
                        System.out.println("Out of bonds.");
                    }
                }while (c<0 || c>8);

                switch (c){
                    case 1 -> {
                        Animals.animalList.get(a - 1).setID();
                        System.out.print("\nNew ID: " + Animals.animalList.get(a - 1).getID());
                    }
                    case 2 -> {
                        System.out.print("\nAnimal's new type: ");
                        String type = sc.nextLine();
                        Animals.animalList.get(a - 1).setType(type);
                    }
                    case 3 -> {
                        System.out.println("Animal's new date of arrival.");
                        String arrDate = Functions.setDate();
                        Animals.animalList.get(a - 1).setDateOfArrival(arrDate);
                    }
                    case 4 -> {
                        double weight = 0;
                        do {
                            do {
                                try {
                                    System.out.print("\nAnimal's new weight: ");
                                    weight = sc.nextDouble();
                                    flag = true;
                                }catch (InputMismatchException e){
                                    System.out.println("Invalid input");
                                    sc.nextLine();
                                }
                            }while (!flag);
                            flag = false; sc.nextLine();
                            if (weight<0){
                                System.out.println("Invalid weight.");
                            }
                        }while (weight<0);
                        Animals.animalList.get(a-1).setWeight(weight);
                    }
                    case 5 -> {
                        int d = 0;
                        do {
                            do {
                                do {
                                    try {
                                        System.out.print("\n1. Register disease 2. Dismiss disease\nInput: ");
                                        d = sc.nextInt();
                                        flag = true;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input.");
                                        sc.nextLine();
                                    }
                                } while (!flag);
                                flag = false; sc.nextLine();
                                if (d<0 || d>1){
                                    System.out.println("Out of bonds.");
                                }
                            }while (d<0 || d>2);

                            switch (d){
                                case 1 -> {
                                    System.out.println("\nDisease to add: ");
                                    String disease = sc.nextLine();
                                    Animals.animalList.get(a-1).addDisease(disease);
                                }
                                case 2 -> {
                                    if (!Animals.animalList.get(a-1).getDiseases().isEmpty()){
                                        int rd = 0;
                                        do {
                                            do {
                                                try {
                                                    System.out.print("\nDisease to dismiss: ");
                                                    Animals.animalList.get(a-1).showDiseases();
                                                    rd = sc.nextInt();
                                                    flag = true;
                                                }catch (InputMismatchException e){
                                                    System.out.println("Invalid input");
                                                    sc.nextLine();
                                                }
                                            }while (!flag);
                                            flag = false; sc.nextLine();
                                            if (rd<1 || rd>Animals.animalList.get(a-1).getDiseases().size()){
                                                System.out.println("Out of bonds.");
                                            }
                                        }while (rd<1 || rd>Animals.animalList.get(a-1).getDiseases().size());
                                        Animals.animalList.get(a-1).removeDisease(rd-1);
                                    }else{
                                        System.out.println("There's no disease to remove.");
                                    }
                                }
                            }

                        }while (d!=0);
                    }
                    case 6 -> {
                        System.out.print("\nAnimal's new feed type: ");
                        String feedType = sc.nextLine();
                        Animals.animalList.get(a-1).setFeedType(feedType);
                    }
                    case 7 -> {
                        int feedFrequency = 0;
                        do {
                            do {
                                try {
                                    System.out.print("\nAnimal's feed frequency: ");
                                    feedFrequency = sc.nextInt();
                                    flag = true;
                                }catch (InputMismatchException e){
                                    System.out.println("Invalid input");
                                    sc.nextLine();
                                }
                            }while (!flag);
                            flag = false; sc.nextLine();
                            if (feedFrequency<0){
                                System.out.println("Invalid number.");
                            }
                        }while (feedFrequency<0);
                        Animals.animalList.get(a-1).setFeedFrequency(feedFrequency);
                    }
                    case 8 -> {
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
                        vac = v != 0;
                        sc.nextLine();
                        Animals.animalList.get(a-1).setVaccines(vac);
                    }
                    case 0 -> System.out.println("Cheers");
                }
            }while (c!=0);
        }else{
            System.out.println("There's no animals registered.");
        }
    }

    public static void removeAnimal(){
        if (!Animals.animalList.isEmpty()){
            int a = 0;
            do {
                do {
                    try {
                        Functions.showAnimals();
                        System.out.print("\nSelect an animal: ");
                        a = sc.nextInt();
                        flag = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input");
                        sc.nextLine();
                    }
                } while (!flag);
                flag = false; sc.nextLine();
                if (a < 1 || a > Animals.animalList.size()) {
                    System.out.println("Out of bonds.");
                }
            } while (a < 1 || a > Animals.animalList.size());
            Animals.animalList.remove(a-1);
        }else {
            System.out.println("There's no animal registered.");
        }
    }
}

