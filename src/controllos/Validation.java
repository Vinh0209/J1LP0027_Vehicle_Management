/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllos;


import java.util.List;
import java.util.Scanner;
import model.Vehicle;

/**
 *
 * @author BAO TRAN
 */
public class Validation {

    public Scanner sc = new Scanner(System.in);

    public boolean checkYesOrNo(String msg) {
        while (true) {
            String input = checkString(msg);
            if (input.equalsIgnoreCase("Y")) {
                return true;
            } else if (input.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.err.println("Must input Y or N to select option");
                continue;
            }
        }
    }

    public void displayVehicles(List<Vehicle> vehicleList) {
        System.out.println("                                          ***LIST OF VEHICLES***                                                         ");
        System.out.println("_________________________________________________________________________________________________________________________");
        System.out.println("|ID        |Type               |Name       |Color                |Price                |Brand           |Product Year    |");
        System.out.println("_________________________________________________________________________________________________________________________");

        for (Vehicle p : vehicleList) {
            String idstr = String.format("%-10s", "ID|");
            String id = String.format("%-10s", p.getId());
            String type = String.format("%-18s", p.getType());
            String name = String.format("%-10s", p.getName());
            String color = String.format("%-20s", p.getColor());
            String price = String.format("%-20s", p.getPrice());
            String brand = String.format("%-15s", p.getBrand());
            String productYear = String.format("%-15s", p.getProductYear());

            System.out.println("|" + id + "| " + type + "| " + name + "| " + color + "| " + price + "| " + brand + "| " + productYear + "|");
        }

        System.out.println("_________________________________________________________________________________________________________________________");
       

        System.out.println("");
        System.out.println("");

        
    }

    public String checkString(String msg) {
        while (true) {
            System.out.println(msg);
            String input_raw = sc.nextLine().trim();
            if (input_raw == null || input_raw.length() == 0) {
                System.err.println("Must input a string not empty !!!");
                System.out.println("Please enter again!");
                continue;
            }
            return input_raw;
        }
    }

    public int checkInt(String msg, int min, int max) {

        while (true) {

            String input_raw = checkString(msg);

            try {
                int input = Integer.parseInt(input_raw);
                if (input < min || input > max) {
                    System.err.println("Must input a number large than " + min + " and less than " + max);
                    continue;
                }
                return input;
            } catch (NumberFormatException e) {

                System.err.println("Must enter a number");
                continue;
            }

        }
    }

    public double checkDouble(String msg, double min, double max) {

        while (true) {

            String input_raw = checkString(msg);

            try {
                int input = Integer.parseInt(input_raw);
                if (input < min || input > max) {
                    System.err.println("Must input a number large than " + min + " and less than " + max);
                    continue;
                }
                return input;
            } catch (NumberFormatException e) {

                System.err.println("Must enter a number");
                continue;
            }

        }
    }

    public String checkVehicleID(String msg, List<Vehicle> vehicles) {
        while (true) {
            String input = checkString(msg);
          
            String flightNumberPattern = "^V\\d{4}$";
            if (!input.matches(flightNumberPattern)) {
                System.err.println("The vehicle id must be format Fxyzt ! Please enter again !");
                continue;
            }
            if (getVehicleID(input, vehicles) != null) {
                System.err.println("The vehicle id must be not existed in system! Please enter again !");
                continue;

            }

            return input;
        }
    }

    public Vehicle getVehicleID(String vehicleID, List<Vehicle> vehicles) {
        for (Vehicle v : vehicles) {
            if (v.getId().equals(vehicleID)) {
                return v;
            }
        }
        return null;
    }

}
