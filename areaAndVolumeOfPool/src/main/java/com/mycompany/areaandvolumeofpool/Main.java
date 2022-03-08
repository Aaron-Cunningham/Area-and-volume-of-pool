package com.mycompany.areaandvolumeofpool;

import java.util.Scanner;

public class Main {

    private static final double PI = 3.14;
    private static final Scanner sc = new Scanner(System.in);//input scanner
    private static double length, width, radius, sideHeight1, sideHeight2, shallowEnd, deepEnd, shallowDepth, deepDepth, poolVolume, internalSurfaceArea, diameter, averageDepth, hypDepth, hypotenuse;//variables for program
    private static String firstName, lastName;//name of person
    private static int option;//menu option

    public static void main(String[] args) {
        getName();
        menu();
 
        
    }

    private static void menu() {

        option = 0;

        /* The do while is asking for user input, but only accepting numbers*/
        do {
            System.out.println("Welcome to pool calculator");
            System.out.println("""
                                       Select 1 to re-enter name 
                                       Select 2 for Rectangular pool 
                                       Select 3 for Cylinderical pool
                                       Select 4 to Exit""");

            while (!sc.hasNextInt()) {

                System.out.println("You can only input a number");

                sc.next();

            }
            option = sc.nextInt();

            if (option == 1) {
                getName();//This method will run if option1 is picked
            }//end of if statement

            switch (option) {
                case 2:
                    /*These two methods will run if opetion 2 is picked*/
                    rectangleVolume();
                    rectangleInternalSurfaceArea();

                    break;
                case 3:
                    /*These two methods will run if opetion 3 is picked*/
                    cylinderVolume();
                    cylinderInternalSurfaceArea();
                    break;
                case 4:
                    /*This methods will run if opetion 4 is picked*/
                    System.out.println("You've now exited the program");
                    System.exit(0);
                    break;

                /*if any number apart from 1,2,3, or 4 is picked then it will default the loop to run again*/
                default:
                    option = 0;
                    break;
            }//end of switch

            menu();//puts the method in a loop even after selection until exit
        } while (option != 0);
        System.out.println(option);
    }//end of menu method

    /*This method uses a while loop and if statement to allow only letters to be entered*/
    private static void getName() {

        System.out.println("Enter your first name");
        while (true) {
            firstName = sc.nextLine();

            if (!firstName.matches("[a-zA-Z]+")) {
                System.out.println("Letters only!");
                continue;
            } else {
                System.out.println("Enter your second name");
                break;
            }
        }

        while (true) {
            lastName = sc.nextLine();

            if (!lastName.matches("[a-zA-Z]+")) {
                System.out.println("Letters only!");
            } else {
                System.out.println("Hello " + firstName + " " + lastName);
                break;
            }
        }

    }//end of getName method

    private static void rectangleVolume() {
        System.out.println("Input shallow depth of the pool in meters");
        shallowDepth = sc.nextDouble();//allowing user to input a double number to save as shallowDepth
        System.out.println("Input deep depth of the pool in meter");
        deepDepth = sc.nextDouble();
        System.out.println("Input the width of the pool meter");
        width = sc.nextDouble();
        System.out.println("Input the length of the pool meter");
        length = sc.nextDouble();

        poolVolume = (deepDepth + shallowDepth) * width * length / 2;//pool volume formula
        System.out.println(" \n"
                + firstName + " " + lastName + " The measurements you have entered for the rectangular pool are \n"
                + "Shallow Depth: " + shallowDepth + "m \n"
                + "Deep Depth: " + deepDepth + "m \n"
                + "Width: " + width + "m \n"
                + "Length: " + length + "m \n"
                + "\n"
                + "The volume of the pool and interior surface area is \n"
                + "Volume: " + poolVolume + "m\u00B3");

    }//End of rectangleVolume method

    private static void rectangleInternalSurfaceArea() {

        hypDepth = deepEnd - shallowEnd;
        hypotenuse = Math.sqrt((Math.pow(length, 2)) + (Math.pow(hypDepth, 2)));
        shallowEnd = width * shallowDepth;
        deepEnd = width * deepDepth;
        sideHeight1 = (shallowDepth + deepDepth) / 2 * length;
        sideHeight2 = width * hypotenuse;
        internalSurfaceArea = shallowEnd + deepEnd + (sideHeight1 * 2) + sideHeight2;
        System.out.println("Internal surface area: " + internalSurfaceArea + "m\u00B2" + "\n"
                + " ");

    }//End of rectangleInternalSurfaceArea method

    private static void cylinderVolume() {
        System.out.println("Enter diameter of the pool in meters");
        diameter = sc.nextDouble();
        System.out.println("Enter the shallow depth in meters");
        shallowDepth = sc.nextDouble();
        System.out.println("Enter the deep depth in meters");
        deepDepth = sc.nextDouble();
        averageDepth = (shallowDepth + deepDepth) / 2;
        radius = diameter / 2;
        poolVolume = PI * radius * radius * averageDepth;//formula for circular pool volume

        System.out.println(firstName + " " + lastName + " The measurements you have entered for the circular pool are \n"
                + "Diameter: " + diameter + "m \n"
                + "Shallow depth: " + shallowDepth + "m \n"
                + "Deep depth:" + deepDepth + "m \n"
                + "\n"
                + "The Volume for the pool and required internal surface area are \n"
                + "Volume: " + poolVolume + "m\u00B3");
    }//End of cylinderVolume method

    private static void cylinderInternalSurfaceArea() {

        internalSurfaceArea = PI * (radius * radius) + (2 * PI) * (radius * averageDepth);

        System.out.println("Internal surface area: " + internalSurfaceArea + "m\u00B2" + "\n"
                + " ");

    }//End of cylinderInternalSurfaceArea method

}
