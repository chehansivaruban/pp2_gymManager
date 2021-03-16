package com.company;
import java.lang.reflect.Method;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Scanner;

import static java.time.Year.isLeap;


public class Menu {
    //initializing
    private static final Manager manager = new Manager();
    private static int memberCount = 0;
    private static Stage window;



    //displays the console
    public static void readFile(){
        manager.readData();
    }
    public static void menu(){


        //initializing Scanner to get user inputs
        Scanner input = new Scanner(System.in);
        //Display the options
        System.out.println("\n==================Main Menu===========================");
        System.out.println("\n\tAdd a new member        : Enter 1");
        System.out.println("\tDelete a member        : Enter 2");
        System.out.println("\tPrint member list      : Enter 3");
        System.out.println("\tSort according to Name : Enter 4");
        System.out.println("\tOpen GUI member list   : Enter 5");
        System.out.println("\tTo Exit                : Enter 6");
        System.out.print("\n\tEnter required task    : ");
         String option = input.next();

         //switch case to navigate to required functionalities
         switch (option){
             case "1":
                 addMemberToManager();
             case "2":
                 removeMember();
                 break;
             case "3":
                 showList();
                 break;
             case "4":
                 sort();
                 break;
             case "5":
                 startGui();
                 break;
             case "6":
                 System.exit(0);
             default:
                 System.err.println("Inavalid Input : Please Enter Correct Option.");
                 menu();

         }
    }

    private static void startGui() {
        Gui ti = new Gui();

        // Get all methods of TargetInvocationClass:
        Method[] m = Gui.class.getMethods();
        try {
            // Invoke the first method of the class:
            javafx.application.Application.launch(Gui.class);
            m[0].invoke(ti);
        }
        catch(Exception e) {
            // Print the wrapper exception:
            System.out.println("Wrapper exception: " + e);

            // Print the 'actual' exception:
            System.out.println("Underlying exception: " + e.getCause());
        }

        menu();
                }


            private static void showList() {
        manager.showList();
        String toExit = "chehan";
        while (!(toExit.equals("r") || toExit.equals("m") || toExit.equals("e"))) {
            System.out.println("\nTo Review the Members : Enter = r");
            System.out.println("Main Menu               : Enter = m");
            System.out.println("To Exit                 : Enter = e");
            System.out.println("  ");
            System.out.print("Enter required task  : ");
            Scanner input = new Scanner(System.in);
            toExit = input.next();
            toExit = toExit.toLowerCase();
        }
        if (toExit.equals("r")) {
            showList();
        } else if (toExit.equals("m")) {
            menu();
        } else {
            System.exit(0);
        }
    }

    private static void sort() {
        manager.sort();
        menu();
    }

    private static void removeMember() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter member ID     : ");
        String memberIdForRemoving = input.next();
        boolean result = manager.removeMember(memberIdForRemoving);
        if(result){
            memberCount--;
        }
        else {
            System.out.println("Member not found");
        }
        menu();

    }

    private static void addMemberToManager() {
        Scanner input = new Scanner(System.in);

        if (memberCount<=100) {
            String memberId = null;
            while (true) {
                System.out.print("Enter Member Id (please input a number range from 2020 to 2120)   : ");
                memberId = input.next();
                int intInputValue = 0;
                try {
                    intInputValue = Integer.parseInt(memberId);
                    if ((intInputValue >= 2020) && (intInputValue <= 2120)) {
                        break;
                    } else {
                        NumberFormatException ne;

                    }

                } catch (NumberFormatException ne) {
                    System.out.println("Input is not a number");
                }
            }

            System.out.print("enter name   :");
            String name = input.next();

            //get year
            int year;
            int month;
            int day;
            while (true) {
                String forYear = null;
                int intInputValue1;
                while (true) {
                    System.out.print("enter year");
                    forYear = input.next();
                    intInputValue1 = 0;
                    try {
                        intInputValue1 = Integer.parseInt(forYear);
                        if (intInputValue1 > 0) {
                            System.out.println("Correct input, exit");

                            break;
                        } else {
                            System.out.println("Input error please enter a valid year");
                            NumberFormatException ne;

                        }

                    } catch (NumberFormatException ne) {
                        System.out.println("Input error please enter a valid year");
                    }
                }
                year = intInputValue1;


                String forMonth = null;
                int intInputValue2;
                while (true) {
                    System.out.print("enter month");
                    forMonth = input.next();
                    intInputValue2 = 0;
                    try {
                        intInputValue2 = Integer.parseInt(forMonth);
                        if ((intInputValue2 > 0) && (intInputValue2 <= 12)) {
                            System.out.println("Correct input, exit");

                            break;
                        } else {
                            System.out.println("Input error please enter a valid month");
                            NumberFormatException ne;

                        }

                    } catch (NumberFormatException ne) {
                        System.out.println("Input error please enter a valid month");
                    }
                }
                month = intInputValue2;


                System.out.print("enter day");
                day = input.nextInt();

                if (isValid(year, month, day)) {
                    break;
                } else {
                    System.out.println("Date not valid");
                }
            }
            Date startDate = new Date(year, month, day);
            int repeat = 0;
            String memberType = "null";
            while (!(memberType.equals("s") || memberType.equals("d") || memberType.equals("o"))) {
                System.out.println("Enter Type of Membership - Default Member = d / Student Member = s / Over 60 Member = o");
                System.out.print("Enter Type : ");
                memberType = input.next();
            }
            DefaultMember member = null;

            switch (memberType) {
                case "d":

                    member = new DefaultMember(memberId, name, startDate);
                    break;
                case "s":

                    String school = null;
                    System.out.print("Enter School    : ");
                    school = input.next();
                    member = new StudentMember(memberId, name, startDate, school);
                    break;
                case "o":

                    int age = 0;
                    System.out.print("Enter Age    : ");
                    age = input.nextInt();
                    member = new Over60Member(memberId, name, startDate, age);
                    break;
                default:
                    System.err.println("Invalid Input");
            }
            manager.addNewMember(member);
            memberCount++;
        }
        else {
            System.out.println("Members registration Full");
        }

        menu();
    }
    public static boolean isValid(int year, int month, int day) {
        if (year < 0) return false;
        if ((month < 1) || (month > 12)) return false;
        if ((day < 1) || (day > 31)) return false;
        switch (month) {
            case 1: return true;
            case 2: return (isLeap(year) ? day <= 29 : day <= 28);
            case 3: return true;
            case 4: return day < 31;
            case 5: return true;
            case 6: return day < 31;
            case 7: return true;
            case 8: return true;
            case 9: return day < 31;
            case 10: return true;
            case 11: return day < 31;
            default: return true;
        }
    }
}