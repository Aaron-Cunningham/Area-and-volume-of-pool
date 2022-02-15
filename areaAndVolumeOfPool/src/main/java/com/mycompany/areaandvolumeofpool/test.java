/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.areaandvolumeofpool;

import static com.mycompany.areaandvolumeofpool.test.menu;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author aaroncunningham
 */
public class test {

    private static final double PI = 3.14;
    private static Scanner sc = new Scanner(System.in);//input scanner
    private static double length, width, radius, sideHeightEqual, floorArea, sideHeight1, sideHeight2, shallowEnd, deepEnd, shallowDepth, deepDepth, poolVolume, internalSurfaceArea, diameter, averageDepth;//variables for program
    private static String firstName, lastName;//name of person
    private static int option;//menu option

    public static void menu() {

        option = 0;

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
                    rectangleVolume();//These two methods will run if opetion 2 is picked
                    rectangleInternalSurfaceArea();

                    break;
                case 3:
                    cylinderVolume();//These two methods will run if opetion 3 is picked
                    cylinderInternalSurfaceArea();
                    break;
                case 4:
                    System.out.println("You've now exited the program");
                    System.exit(0);//This method will run if opetion 4 is picked
                    break;
                default://if any number apart from 1,2,3, or 4 is picked then it will default the loop to run again
                    option = 0;
                    break;
            }//end of switch

            menu();//puts the method in a loop even after selection until exit
        } while (option != 0);
        System.out.println(option);
    }//end of menu method

    public static void getName() {

        System.out.println("Enter your name");
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
                continue;
            } else {
                System.out.println("Hello " + firstName + " " + lastName);
                break;
            }
        }

    }

    public static void rectangleVolume() {
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

        floorArea = width * length; //total Floor SQM
        shallowEnd = width * shallowDepth; //Total Shallow End Wall
        deepEnd = width * deepDepth; //Total Deep End wall
        sideHeightEqual = (shallowDepth + deepDepth) / 2; //Calculate side height average
        sideHeight1 = sideHeightEqual * length; //Side 1 sqm calculation
        sideHeight2 = sideHeightEqual * length; //Side 2 sqm calculation
        internalSurfaceArea = sideHeight1 + sideHeight2 + floorArea + deepEnd + shallowEnd; //Total Area

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

        internalSurfaceArea = (PI * 2) * (radius * radius) + (2 * PI) * (radius * averageDepth);

        System.out.println("Internal surface area: " + internalSurfaceArea + "m\u00B2" + "\n"
                + " ");

    }//End of cylinderInternalSurfaceArea method

}
