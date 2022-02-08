
package com.mycompany.areaandvolumeofpool;

import java.util.Scanner;


public class Main {

    private static final double PI = 3.14;
    private static Scanner sc = new Scanner(System.in);
    private static double length, width, radius, height, shallowDepth, deepDepth, poolVolume, internalSurfaceArea, crossSection;
    private static String name;//name of person
    private static int option;//menu option

    public static void main(String[] args) {
        //call the menu method
        //menu();
        rectangleVolume();
        cylinderInternalSurfaceArea();
        //System.out.println("m\u00B3");
    }

    private static void menu() {

        int option = 0;

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
                    break;
                case 3:
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

    }
 
    private static void getName() {
        System.out.println("Please input your name");
        name = sc.nextLine();
    }

    private static void rectangleInternalSurfaceArea() {
        // = 2x (2x4 + 2x2 + 4x2) = 40m^2
        length = sc.nextInt();
        width = sc.nextInt();
        shallowDepth = sc.nextInt();

        internalSurfaceArea = (2 * (length * width) + (width * shallowDepth));

    }

    private static void rectangleVolume() {
        System.out.println("Input shallow depth of the pool");
        shallowDepth = 3;
        System.out.println("Input deep depth of the pool");
        deepDepth = 1;
        System.out.println("Input the width of the pool");
        width = 11;
        System.out.println("Input the length of the pool");
        length = 11;
        
        poolVolume = (deepDepth + shallowDepth) * width * length / 2;
        
        
        System.out.println("The volume of the pool is " + poolVolume + "m\u00B3");
        
        
        
    }

    private static void cylinderInternalSurfaceArea() {
        
    }

    private static void cylinderVolume() {

    }

    private static void outputMethod() {

    }
}
