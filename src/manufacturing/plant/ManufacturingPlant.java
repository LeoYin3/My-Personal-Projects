/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manufacturing.plant;

import java.util.*;

/**
 *
 * @author leoyi
 */

public class ManufacturingPlant {

    /**
     * @param args the command line arguments
     */
    public static int getUser(){
        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        int user = 0;
        System.out.println("What would you like to do? (Please enter the number)\n1. Create new component\n2. Destroy component\n3. Edit existing component"
                + "\n4. Repair broken component\n5. View all components\n6. Exit the program");
            while (!valid) {
                try {
                user = sc.nextInt();
                    if (6 < user || 1 > user) {
                        System.out.println("Not in the range of values, please try again.");
                        }
                    else 
                        valid = true;
                                }
                catch(Exception e) {
                    System.out.println("That is not an integer, please try again:");
                     sc.nextLine();
                    }
                }
        return user;
    }
    
    public static int getCreate(){
        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        int user = 0;
        System.out.println("Which component type would you like to create?\n1. CPU\n2. Memory\n3. Disk\n4. Back to Main Menu");
            while (!valid) {
                try {
                user = sc.nextInt();
                    if (4 < user || 1 > user) {
                        System.out.println("Not in the range of values, please try again.");
                        }
                    else 
                        valid = true;
                                }
                catch(Exception e) {
                    System.out.println("That is not an integer, please try again:");
                     sc.nextLine();
                    }
                }
        return user;
    }
    
    public static int correctInt(int a, int b){
        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        int user = 0;
        while (!valid) {
                        try {
                        user = sc.nextInt();
                            if (b < user || a > user) {
                                System.out.println("Not in the range of values, please try again.");
                                }
                            else 
                                valid = true;
                                        }
                        catch(Exception e) {
                            System.out.println("That is not a valid input, please try again:");
                             sc.nextLine();
                            }
                        }
        return user;
    }
    
    public static int checkInt(){
        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        int user = 0;
        while (!valid) {
                        try {
                        user = sc.nextInt();
                            if (0 > user) {
                                System.out.println("Value must be positive, please try again.");
                                }
                            else 
                                valid = true;
                                        }
                        catch(Exception e) {
                            System.out.println("That is not a valid input, please try again:");
                             sc.nextLine();
                            }
                        }
        return user;
    }
    
    public static double correctDouble(){
        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        double user = 0;
        while (!valid) {
                        try {
                        user = sc.nextDouble();
                            if (0 > user) {
                                System.out.println("Value must be positive, please try again.");
                                }
                            else 
                                valid = true;
                                        }
                        catch(Exception e) {
                            System.out.println("That is not a valid input, please try again:");
                             sc.nextLine();
                            }
                        }
        return user;
    }
    
    public static String getString(){
        boolean valid = false;
        String temp = "";
        Scanner sc = new Scanner(System.in);
        while (!valid){
            try{
                    temp = sc.nextLine();
                    if (temp.equals("0")){
                        System.out.println("");
                        valid = true;
                    }
                    else if (temp.trim().equals("")){
                        System.out.println("Please enter a non-empy value (non-empty values include just entering space(s))");
                }
                    else valid = true;
                }
                        catch(Exception e){
                            System.out.println("");
                        }
                    }
        return temp;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        boolean cont = true;
        boolean valid = false;
        String temp = null;
        int user = 0;
        double stuff = 0;
        Component tempComponent;
        String type;
        
        ArrayList<CPU> myCPU = new ArrayList<CPU>();
        ArrayList<Disk> myDisk = new ArrayList<Disk>();
        ArrayList<Memory> myMemory = new ArrayList<Memory>();
        ArrayList<Component> myComponent = new ArrayList<Component>();
        
        while (cont == true){
            Collections.sort(myComponent, Component.compName);
            user = getUser();
            if (user == 1){
                user = getCreate();
                if (user == 1){
                    CPU tempCPU= new CPU();
                    System.out.println("Please enter CPU name (or enter 0 to return to main menu)");
                    temp = getString();
                    if (!temp.equals("0")){
                        tempCPU.setName(temp);
                        System.out.println("Please type 0 if CPU is broken or 1 if CPU is not broken (type -1 to return to main menu): ");
                        user = correctInt(-1, 1);
                        if(user == 0){
                            valid = true;
                        }
                        else if (user == 1) valid = false;
                        tempCPU.setBroken(valid);
                        if (user != -1){
                                System.out.println("Please enter the CPU's speed in GHz (or type 0 to go back to main menu): ");
                                stuff = correctDouble();
                                if (stuff != 0){
                                    tempCPU.setSpeed(stuff);
                                    System.out.println("Please enter the CPU's number of processors (or type 0 to go back to main menu): ");
                                    user = checkInt();
                                    if (user != 0) {
                                        tempCPU.setProcessors(user);
                                        System.out.println("Please type 0 if the CPU does not have virtualization and 1 if it does (or type -1 to go back to main menu): ");
                                        user = correctInt(-1, 1);
                                        if(user == 0){
                                            valid = false;
                                        }
                                        else if (user == 1) valid = true;
                                        if (user != -1){
                                            System.out.println("Successfully create CPU " + tempCPU.getName() + "!");
                                            tempCPU.setVirtualization(valid);
                                            myCPU.add(tempCPU);
                                            tempComponent = (Component) tempCPU;
                                            myComponent.add(tempComponent);
                                }
                                    }
                    
                        }
                        }
                    }
                }
                else if (user == 2){
                    Memory tempMemory = new Memory();
                    System.out.println("Please enter Memory name (or enter 0 to return to main menu)");
                    temp = getString();
                    if (!temp.equals("0")){
                        tempMemory.setName(temp);
                        System.out.println("Please type 0 if Memory is broken or 1 if Memory is not broken (type -1 to return to main menu): ");
                        user = correctInt(-1, 1);
                        if(user == 0){
                            valid = true;
                        }
                        else if (user == 1) valid = false;
                        if (user != -1){
                            tempMemory.setBroken(valid);
                                    tempMemory.setResponse(stuff);
                                    System.out.println("Please enter the Memory's Capacity in GigaBytes (or type 0 to go back to main menu): ");
                                    stuff = correctDouble();
                                    if (stuff !=0){
                                        tempMemory.setCapacity(stuff);
                                        System.out.println("Please enter the Memory's response speed in GHz (or type 0 to go back to main menu): ");
                                        stuff = correctDouble();
                                        if (stuff != 0){
                                        tempMemory.setResponse(stuff);
                                        System.out.println("Please type 0 if the Memory has space or 1 if it is full (or type -1 to go back to main menu): ");
                                        user = correctInt(-1, 1);
                                        if(user == 0){
                                            valid = false;
                                        }
                                        else if (user == 1) valid = true;
                                        if (user != -1){
                                            System.out.println("Successfully create Memory " + tempMemory.getName() + "!");
                                            tempMemory.setFull(valid);
                                            myMemory.add(tempMemory);
                                            tempComponent = (Component) tempMemory;
                                            myComponent.add(tempComponent);
                                        }
                                    }
                                    }
                }
                           
                }
                    
                }
                else if (user == 3){
                    Disk tempDisk = new Disk();
                    System.out.println("Please enter Disk name (or enter 0 to return to main menu)");
                    temp = getString();
                    if (!temp.equals("0")){
                        tempDisk.setName(temp);
                        System.out.println("Please type 0 if Disk is broken or 1 if Disk is not broken (type -1 to return to main menu): ");
                        user = correctInt(-1, 1);
                        if(user == 0){
                            valid = true;
                        }
                        else if (user == 1) valid = false;
                        if (user != -1){
                            tempDisk.setBroken(valid);
                            System.out.println("Please enter how much storage the Disk has in GigaBytes (or type 0 to return to main menu): ");
                            stuff = correctDouble();
                            if (stuff != 0){
                                    tempDisk.setStorage(stuff);
                                    System.out.println("Please enter how many slots the Disk has (or type 0 to go back to main menu): ");
                                    user = checkInt();
                                    if (user !=0){
                                        tempDisk.setSlots(user);
                                        System.out.println("Please type 0 if the Disk is full or 1 if it has space (or type -1 to go back to main menu): ");
                                        user = correctInt(-1, 1);
                                        if(user == 0){
                                            valid = true;
                                        }
                                        else if (user == 1) valid = false;
                                        if (user != -1){
                                            System.out.println("Successfully create Disk " + tempDisk.getName() + "!");
                                            tempDisk.setFull(valid);
                                            myDisk.add(tempDisk);
                                            tempComponent = (Component) tempDisk;
                                            myComponent.add(tempComponent);
                                        }
                                    
                                
                            }
                        }
                    }
                    }
                }
                else System.out.println();
            }   
            else if (user == 2){
                valid = myComponent.isEmpty();
                if (valid == true) System.out.println("There are no components in stock, please create one first!");
                else{
                System.out.println(myComponent);
                System.out.println("Which Component would you like to destroy? (Please enter the name (Case Sensitive)) (Enter 0 to return to main menu)");
                temp = getString();
                boolean found = false;
                for(int i = 0; i < myComponent.size() && !found; i ++){
                    if (myComponent.get(i).getName().equals(temp)){
                        myComponent.remove(i);
                        System.out.println(temp + " has been destroyed!");
                        found = true;
                    }
                    else if (temp.equals("0")){
                        found = true;
                    }
                        }
                if (found == false) System.out.println("Name not found, please pick another option or try again.");
                }
            }
            else if (user == 3){
                CPU tempCPU = new CPU();
                Memory tempMemory = new Memory();
                Disk tempDisk = new Disk();
                valid = myComponent.isEmpty();
                if (valid == true) System.out.println("There are no components in stock, please create one first!");
                else{
                System.out.println(myComponent);
                System.out.println("Which Component would you like to edit? (Please enter the name (Case Sensitive)) (or enter 0 to return to main menu)");
                temp = getString();
                boolean found = false;
                for(int i = 0; i < myComponent.size() && !found; i ++){
                    if (myComponent.get(i).getName().equals(temp) && !temp.equals("0")){
                        type = myComponent.get(i).getType();
                        System.out.println("What would you like to edit about this component? (Please enter the parameter name or type 0 to go back)");
                        temp = getString();
                        if (type.equals("CPU")){
                            tempCPU = (CPU) myComponent.get(i);
                            if (temp.toLowerCase().equals("name")){
                                System.out.println("Please enter new name (or enter 0 to return to main menu)");
                                temp = getString();
                                if (!temp.equals("0")){
                                    if(temp.equals(myComponent.get(i).getName())) System.out.println("That's the same name, please try another option.");
                                    else{
                                        myComponent.get(i).setName(temp);
                                        System.out.println("Changed!");
                                    }
                                }
                            }
                            else if (temp.toLowerCase().equals("broken")){
                                System.out.println("Please use the repair function (Option 4) on the main menu to repair broken components, "
                                        + "Manufacturing plant cannot damage components.");
                            }
                            else if (temp.toLowerCase().equals("speed")){
                                System.out.println("Please enter new speed (or enter 0 to return to main menu)");
                                user = checkInt();
                                tempCPU = (CPU) myComponent.get(i);
                                if (user != 0){
                                    if (user == tempCPU.getSpeed()) System.out.println("That's the same speed, please try another option.");
                                    else{
                                    tempCPU.setSpeed(user);
                                    myComponent.remove(i);
                                    tempComponent = (Component) tempCPU;
                                    myComponent.add(tempComponent);
                                    System.out.println("Changed!");
                                    }
                                }
                            }
                            else if (temp.toLowerCase().equals("processors")){
                                System.out.println("Please enter the new processors amout (or enter 0 to return to main menu)");
                                user = checkInt();
                                tempCPU = (CPU) myComponent.get(i);
                                if (user != 0){
                                    if(user == tempCPU.getProcessors()) System.out.println("That's the same processor amount, please try another option.");
                                    else{
                                    tempCPU.setProcessors(user);
                                    myComponent.remove(i);
                                    tempComponent = (Component) tempCPU;
                                    myComponent.add(tempComponent);
                                    System.out.println("Changed!");
                                    }
                                }
                            }
                            else if (temp.toLowerCase().equals("virtualization")){
                                System.out.println("Please enter 0 to set to false or 1 to set to true (or enter -1 to return to main menu)");
                                user = correctInt(-1, 1);
                                tempCPU = (CPU) myComponent.get(i);
                                if (user == 0){
                                    if (tempCPU.getVirtualization() == false) System.out.println("Already false, please pick another option.");
                                    else{
                                        tempCPU.setVirtualization(false);
                                        myComponent.remove(i);
                                        tempComponent = (Component) tempCPU;
                                        myComponent.add(tempComponent);
                                        System.out.println("Changed!");
                                    }
                                }
                                else if (user == 1){
                                    if (tempCPU.getVirtualization() == true) System.out.println("Already true, please pick another option.");
                                    else{
                                        tempCPU.setVirtualization(true);
                                        myComponent.remove(i);
                                        tempComponent = (Component) tempCPU;
                                        myComponent.add(tempComponent);
                                        System.out.println("Changed!");
                                    }
                                }
                            }
                            else System.out.println("Not a parameter of CPU, please try another option.");
                        }
                        else if (type.equals("Disk")){
                            tempDisk = (Disk) myComponent.get(i);
                            if (temp.toLowerCase().equals("name")){
                                System.out.println("Please enter new name (or enter 0 to return to main menu)");
                                temp = getString();
                                if (!temp.equals("0")){
                                    if(temp.equals(myComponent.get(i).getName())) System.out.println("That's the same name, please try another option.");
                                    else{
                                        myComponent.get(i).setName(temp);
                                        System.out.println("Changed!");
                                    }
                                }
                            }
                            else if (temp.toLowerCase().equals("broken")){
                                System.out.println("Please use the repair function (Option 4) on the main menu to repair broken components, "
                                        + "Manufacturing plant cannot damage components.");
                            }
                            else if (temp.toLowerCase().equals("storage")){
                                System.out.println("Please enter new storage amount (or enter 0 to return to main menu)");
                                stuff = correctDouble();
                                if(stuff != 0){
                                    if (stuff == tempDisk.getStorage()) System.out.println("That's the same Storage amount, please try another option.");
                                    else{
                                        tempDisk.setStorage(stuff);
                                        myComponent.remove(i);
                                        tempComponent = (Component) tempDisk;
                                        myComponent.add(tempComponent);
                                        System.out.println("Changed!");
                                    }
                                }
                            }
                            else if (temp.toLowerCase().equals("slots")){
                                System.out.println("Please enter the new slots amount (or enter 0 to return to main menu)");
                                user = checkInt();
                                tempDisk = (Disk) myComponent.get(i);
                                if (user != 0){
                                    if(user == tempDisk.getSlots()) System.out.println("That's the same Slots amount, please try another option.");
                                    else{
                                    tempDisk.setSlots(user);
                                    myComponent.remove(i);
                                    tempComponent = (Component) tempDisk;
                                    myComponent.add(tempComponent);
                                    System.out.println("Changed!");
                                    }
                                }
                            }
                            else if (temp.toLowerCase().equals("full")){
                                System.out.println("Please enter 0 to set to false or 1 to set to true (or enter -1 to return to main menu)");
                                user = correctInt(-1, 1);
                                tempDisk = (Disk) myComponent.get(i);
                                if (user == 0){
                                    if (tempDisk.getFull() == false) System.out.println("Already false, please pick another option.");
                                    else{
                                        tempDisk.setFull(false);
                                        myComponent.remove(i);
                                        tempComponent = (Component) tempDisk;
                                        myComponent.add(tempComponent);
                                        System.out.println("Changed!");
                                    }
                                }
                                else if (user == 1){
                                    if (tempDisk.getFull() == true) System.out.println("Already true, please pick another option.");
                                    else{
                                        tempDisk.setFull(true);
                                        myComponent.remove(i);
                                        tempComponent = (Component) tempDisk;
                                        myComponent.add(tempComponent);
                                        System.out.println("Changed!");
                                    }
                                }
                            }
                            else System.out.println("Not a parameter of Disk, please try another option.");
                        }
                        else if (type.equals("Memory")){
                            tempMemory = (Memory) myComponent.get(i);
                            if (temp.toLowerCase().equals("name")){
                                System.out.println("Please enter new name (or enter 0 to return to main menu)");
                                temp = getString();
                                if (!temp.equals("0")){
                                    if(temp.equals(myComponent.get(i).getName())) System.out.println("That's the same name, please try another option.");
                                    else{
                                        myComponent.get(i).setName(temp);
                                        System.out.println("Changed!");
                                    }
                                }
                            }
                            else if (temp.toLowerCase().equals("broken")){
                                System.out.println("Please use the repair function (Option 4) on the main menu to repair broken components, "
                                        + "Manufacturing plant cannot damage components.");
                            }
                            else if (temp.toLowerCase().equals("reponse")){
                                System.out.println("Please enter new response speed amount (or enter 0 to return to main menu)");
                                stuff = correctDouble();
                                if(stuff != 0){
                                    if (stuff == tempMemory.getResponse()) System.out.println("That's the same Response speed, please try another option.");
                                    else{
                                        tempMemory.setResponse(stuff);
                                        myComponent.remove(i);
                                        tempComponent = (Component) tempMemory;
                                        myComponent.add(tempComponent);
                                        System.out.println("Changed!");
                                    }
                                }
                            }
                            else if (temp.toLowerCase().equals("capacity")){
                                System.out.println("Please enter new capacity amount (or enter 0 to return to main menu)");
                                stuff = correctDouble();
                                if(stuff != 0){
                                    if (stuff == tempMemory.getCapacity()) System.out.println("That's the same Capacity amount, please try another option.");
                                    else{
                                        tempMemory.setCapacity(stuff);
                                        myComponent.remove(i);
                                        tempComponent = (Component) tempMemory;
                                        myComponent.add(tempComponent);
                                        System.out.println("Changed!");
                                    }
                                }
                            }
                            else if (temp.toLowerCase().equals("full")){
                                System.out.println("Please enter 0 to set to false or 1 to set to true (or enter -1 to return to main menu)");
                                user = correctInt(-1, 1);
                                tempMemory = (Memory) myComponent.get(i);
                                if (user == 0){
                                    if (tempMemory.getFull() == false) System.out.println("Already false, please pick another option.");
                                    else{
                                        tempMemory.setFull(false);
                                        myComponent.remove(i);
                                        tempComponent = (Component) tempMemory;
                                        myComponent.add(tempComponent);
                                        System.out.println("Changed!");
                                    }
                                }
                                else if (user == 1){
                                    if (tempMemory.getFull() == true) System.out.println("Already true, please pick another option.");
                                    else{
                                        tempMemory.setFull(true);
                                        myComponent.remove(i);
                                        tempComponent = (Component) tempMemory;
                                        myComponent.add(tempComponent);
                                        System.out.println("Changed!");
                                    }
                                }
                            }
                            else System.out.println("Not a parameter of Memory, please try another option.");
                        }
                        found = true;
                    }
                    else if (temp.equals("0")){
                        found = true;
                    }
                        }
                if (found == false) System.out.println("Name not found, please pick another option or try again.");
    
                }
            }
            else if (user == 4){
                valid = myComponent.isEmpty();
                boolean found = false;
                for(int i = 0; i < myComponent.size() && !found; i ++){
                    if (myComponent.get(i).getBroken() == true){
                        found = true;
                        valid = false;
                    }
                    else valid = true;
                }
                if (valid == true) System.out.println("There are no broken components in stock, please create one first!");
                else{
                System.out.println(myComponent);
                System.out.println("Which Component would you like to repair? (Please enter the name (Case Sensitive)) (or enter 0 to return to main menu)");
                temp = getString();
                found = false;
                for(int i = 0; i < myComponent.size() && !found; i ++){
                    if (myComponent.get(i).getName().equals(temp)){
                        if(myComponent.get(i).getBroken() == false){
                            System.out.println("That component is not broken, please pick another option or try again.");
                        }
                        else{
                            myComponent.get(i).setBroken(false);
                            System.out.println(temp + " has been repaired!");
                        }
                        found = true;
                    }
                    else if (temp.equals("0")){
                        found = true;
                    }
                        }
                if (found == false) System.out.println("Name not found, please pick another option or try again.");
                }
            }
            else if (user == 5){
                valid = myComponent.isEmpty();
                if (valid == true) System.out.println("There are no components in stock, please create one first!");
                else{
                System.out.println(myComponent);
                }
            }
            else{
                System.out.println("Your final component list: ");
                System.out.println(myComponent);
                cont = false;
            }
        }
    }
    
}