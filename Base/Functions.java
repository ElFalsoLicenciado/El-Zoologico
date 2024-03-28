package Base;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import Objects.*;
import Storage.*;

public class Functions {
    Scanner sc = new Scanner(System.in);
    private boolean flag = false;

    public void registerWorker(){
        System.out.print("\nWorker's name: ");
        String name = sc.nextLine();
        System.out.print("\nWorker's last name: ");
        String lasName = sc.nextLine();
        System.out.print("\nWorker's birthday: ");
        String birthday = setDate();
        System.out.print("\nWorker's CURP: ");
        String CURP = sc.nextLine();
        System.out.print("\nSet the date of register: ");
        String regDate = setDate();
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

    public void registerClient(){
        System.out.print("\nClient's name: ");
        String name = sc.nextLine();
        System.out.print("\nClient's last name: ");
        String lastName = sc.nextLine();
        System.out.print("\nClient's birthday: ");
        String birthday = setDate();
        System.out.print("\nSet the date of register: ");
        String regDate = setDate();
        System.out.print("\nClient's CURP: ");
        String CURP = sc.nextLine();

        Person client = new Person(name,lastName,birthday,CURP,regDate);
        Clients.clientList.add(client);
    }

    public void registerAnimal(){
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
        String arrDate= setDate();
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

    public void registerTour(){
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
            String date = setDate();
            Tour tour = new Tour(guide,visitors,money,date,kids,adults);
            TourList.tourList.add(tour);
        }
    }

    public void registerMaintenance(){
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
                        showAnimals();
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
            String date = setDate();

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

                sc.nextLine();
            Maintenance maintenance = new Maintenance(technician,animalID,process,date,comments);
            MaintenanceList.maintenanceList.add(maintenance);
        }
    }

    public void modifyWorker(){
        if (!Workers.workerList.isEmpty()) {
            int w = 0;
            do {
                do {
                    try {
                        showSlaves();
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
                        String birthday = setDate();
                        Workers.workerList.get(w - 1).setBirthday(birthday);
                    }
                    case 4 -> {
                        System.out.println("Worker's new registry date.");
                        String regDate = setDate();
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

    public void modifyClient(){
        if (!Clients.clientList.isEmpty()) {
            int cl = 0;
            do {
                do {
                    try {
                        showClients();
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
                        String birthday = setDate();
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
                        String regDate = setDate();
                        Clients.clientList.get(cl - 1).setDateOfRegister(regDate);
                    }
                    case 0 -> System.out.println("Cheers");
                }
            }while (c!=0);
        }else{
            System.out.println("There's no clients registered.");
        }
    }

    public void modifyAnimal(){
        if (!Animals.animalList.isEmpty()) {
            int a = 0;
            do {
                do {
                    try {
                        showAnimals();
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
                        String arrDate = setDate();
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
                        System.out.println("5");
                    }
                    case 6 -> {
                        System.out.print("\nAnimal's new feed type: ");
                        String feedType = sc.nextLine();
                        Animals.animalList.get(a-1).setFeedType(feedType);
                    }
                    case 7 -> {
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
                        sc.nextLine();
                        vac = v != 0;
                        Animals.animalList.get(a-1).setVaccines(vac);
                    }
                    case 0 -> {
                        System.out.println("Cheers");
                    }
                }
            }while (c!=0);
        }else{
            System.out.println("There's no animals registered.");
        }
    }


    public void showSpecificWorkers(ArrayList<Worker> list){
        int i = 0;
        for (Worker anyworker : list){
            i++;
            System.out.print("\n"+anyworker.getRole()+" #"+i);
            System.out.printf("\nID: %s   Full name: %s   \n",anyworker.getID(),anyworker.getName());
        }
        System.out.println();
    }

    public void showAvailableClients(ArrayList<Person> list){
        int i = 0;
        for (Person anyperson : list){
            i++;
            System.out.print("\nClient #"+i);
            System.out.printf("\nID: %s   Full name: %s   \n",anyperson.getID(),anyperson.getName());
        }
    }

    public void showSlaves(){
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

    public void showClients(){
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

    public void showAnimals(){
        int i = 0;
        for (Animal anyanimal : Animals.animalList){
            i++;
            System.out.print("\nAnimal #" + i);
            System.out.printf("\nID %s   Type: %s   Weight: %s   Date of arrival %s   Feed type: %s   Feed frequency: %s times/day   Vaccines: %s   \n",anyanimal.getID(),anyanimal.getType(),anyanimal.getWeight(),anyanimal.getDateOfArrival(),anyanimal.getFeedType(),anyanimal.getFeedFrequency(),anyanimal.isVaccinated());
            if(anyanimal.getDiseases().isEmpty()){
                System.out.println("The animal is healthy.\n");
            }else {
                System.out.print("Current diseases: ");
                for (int d = 0; d<anyanimal.getDiseases().size();d++){
                    System.out.printf("Disease #%d: %s ",d+1,anyanimal.getDiseases().get(d));
                }
                System.out.println();
            }
        }
    }

    public void showTours(){
        if(TourList.tourList.isEmpty()){
            System.out.println("There's no tours registered.");
        }else {
            int i = 0;
            for(Tour anytour : TourList.tourList){
                i++;
                System.out.print("\nTour #" + i);
                System.out.println(anytour.getDetails());
            }
            System.out.println();
        }
    }

    public void showMaintenances(){
        if(MaintenanceList.maintenanceList.isEmpty()){
            System.out.println("There's no maintenances registered.");
        }else {
            int i = 0;
            for(Maintenance anymaintenance : MaintenanceList.maintenanceList){
                i++;
                System.out.print("\nMaintenance #"+i);
                System.out.println(anymaintenance.getDetails());
            }
            System.out.println();
        }
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

    public String setRole (){
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

