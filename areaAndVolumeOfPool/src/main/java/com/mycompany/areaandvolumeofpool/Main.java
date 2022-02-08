package com.mycompany.areaandvolumeofpool;

import java.util.Scanner;

public class Main {

    private static final double PI = 3.14;
    private static Scanner sc = new Scanner(System.in);//input scanner
    private static double length, width, radius, height, shallowDepth, deepDepth, poolVolume, internalSurfaceArea, diameter, averageDepth;//variables for program
    private static String name;//name of person
    private static int option;//menu option

    public static void main(String[] args) {

        menu();
        //cylinderVolume();

    }

    private static void menu() {

        option = 0;

        while (option == 0) {
            System.out.println("Welcome to pool calculator");
            getName();//Get the name of the user

            System.out.println("Select 1 to re-enter name \n"
                    + "Select 2 for Rectangular pool \n"
                    + "Select 3 for Cylinderical pool\n"
                    + "Select 4 to Exit");

            option = sc.nextInt();
            if (option == 1) {
                getName();
            }//end of if statement
            switch (option) {
                case 2:
                    rectangleVolume();
                    rectangleInternalSurfaceArea();
                    break;
                case 3:
                    cylinderVolume();
                    cylinderInternalSurfaceArea();
                    break;
                case 4:
                    System.out.println("You've now exited the program");
                    System.exit(0);
                    break;

                default:
                    option = 0;
                    break;
            }//end of switch

        }//end of while loop

        menu();//puts the method in a loop even after selection until exit

    }//end of menu method

    private static void getName() {
        System.out.println("Please input your name");
        name = sc.nextLine();
    }

    private static void rectangleVolume() {
        System.out.println("Input shallow depth of the pool in meters");
        shallowDepth = sc.nextDouble();
        System.out.println("Input deep depth of the pool in meter");
        deepDepth = sc.nextDouble();
        System.out.println("Input the width of the pool meter");
        width = sc.nextDouble();
        System.out.println("Input the length of the pool meter");
        length = sc.nextDouble();

        poolVolume = (deepDepth + shallowDepth) * width * length / 2;
        System.out.println(" \n"
                + name + " The measurements you have entered for the pool are \n"
                + "Shallow Depth: " + shallowDepth + "m \n"
                + "Deep Depth: " + deepDepth + "m \n"
                + "Width: " + width + "m \n"
                + "Length: " + length + "m \n"
                + "\n"
                + "The volume of the pool and interior surface area is \n"
                + "Volume: " + poolVolume + "m\u00B3");

    }

    private static void rectangleInternalSurfaceArea() {

        internalSurfaceArea = length * width * 1.6;//Works out the internal surface area
        System.out.println("Internal surface area: " + internalSurfaceArea + "m\u00B2 \n"
                + " ");
        
        

    }

    private static void cylinderVolume() {
        System.out.println("Enter diameter of the pool in meters");
        diameter = sc.nextDouble();
        System.out.println("Enter the shallow depth in meters");
        shallowDepth = sc.nextDouble();
        System.out.println("Enter the deep depth in meters");
        deepDepth = sc.nextDouble();
        averageDepth = (shallowDepth + deepDepth) / 2;
        radius = diameter / 2;
        poolVolume = PI * radius * radius * averageDepth;

        System.out.println(name + " The measurements you have entered for the pool are \n"
                + "Diameter: " + diameter + "m \n"
                + "Shallow depth: " + shallowDepth + "m \n"
                + "Deep depth:" + deepDepth + "m \n"
                + "\n"
                + "The Volume for the pool and required internal surface area are \n"
                + "Volume: " + poolVolume + "m\u00B3");
    }

    private static void cylinderInternalSurfaceArea() {
        internalSurfaceArea = diameter * diameter * 1.65;
        System.out.println("Internal surface area: " + internalSurfaceArea + "m\u00B2" + "\n"
                + " ");
    }

}
