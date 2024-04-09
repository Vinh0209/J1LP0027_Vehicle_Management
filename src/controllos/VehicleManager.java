
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import model.Vehicle;

/**
 *
 * @author BAO TRAN
 */
public class VehicleManager {

    public List<Vehicle> vehicleList; 
    Validation valid = new Validation();
    FileManage fm = new FileManage();
    Scanner scanner = new Scanner(System.in);

    public VehicleManager() {

        this.vehicleList = new ArrayList<>();
    }

    public void addVehicle() {

        while (true) {
            String idVehicle = valid.checkVehicleID("Enter id of vehicle: ", vehicleList);
            String typeVehicle = valid.checkString("Enter type of vehicle: ");
            String nameVehicle = valid.checkString("Enter name of vehicle: ");
            String colorVehicle = valid.checkString("Enter color of vehicle: ");
            double priceVehicle = valid.checkDouble("Enter price of vehicle: ", 0, Double.MAX_VALUE);
            String brandVehicle = valid.checkString("Enter brand of vehicle: ");
            int productYear = valid.checkInt("Enter product year: ", 0, Integer.MAX_VALUE);

            vehicleList.add(new Vehicle(idVehicle, typeVehicle, nameVehicle, colorVehicle, priceVehicle, brandVehicle, productYear));
            System.out.println("Successfully !!!");
            System.out.println("The vehicle has been added to the system !");
            if (valid.checkYesOrNo("Do you want to add more(Y/N)? ")) {
                continue;
            }
            return;
        }
    }

    public void updateVehicle() {
        Vehicle vehicle = getVehicleByID(valid.checkString("Enter ID to update: "));

        String typeVehicle = valid.checkString("Enter type of vehicle: ");
        String nameVehicle = valid.checkString("Enter name of vehicle: ");
        String colorVehicle = valid.checkString("Enter color of vehicle: ");
        double priceVehicle = valid.checkDouble("Enter price of vehicle: ", 0, Double.MAX_VALUE);
        String brandVehicle = valid.checkString("Enter brand of vehicle: ");
        int productYear = valid.checkInt("Enter product year: ", 0, Integer.MAX_VALUE);

        vehicle.setType(typeVehicle);
        vehicle.setName(nameVehicle);
        vehicle.setColor(colorVehicle);
        vehicle.setPrice(priceVehicle);
        vehicle.setBrand(brandVehicle);
        vehicle.setProductYear(productYear);

        System.out.println("Vehicle with ID " + vehicle + " has been updated.");

    }

    public void deleteVehicle() {
        valid.displayVehicles(vehicleList);
        String idToDelete = valid.checkString("Enter the ID of the vehicle to delete: ");

        Vehicle vehicleToDelete = getVehicleByID(idToDelete);

        if (vehicleToDelete == null) {
            System.out.println("Vehicle with ID " + idToDelete + " does not exist.");
            return;
        }

        boolean confirmation = valid.checkYesOrNo("Are you sure you want to delete this vehicle? (Y/N): ");

        if (confirmation) {
            vehicleList.remove(vehicleToDelete);
            System.out.println("Vehicle with ID " + idToDelete + " has been deleted.");
        } else {
            System.out.println("Deletion canceled.");
        }
    }

    public void searchVehicleByID() {
        String idToSearch = valid.checkString("Enter id of the vehicle to search: ");
        boolean found = false;

        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getId().equalsIgnoreCase(idToSearch)) {
                System.out.println("Vehicle found:\n" + vehicle.toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Vehicle not found!!");
        }
    }

    public void searchVehicleByName1() {
        String nameToSearch = valid.checkString("Enter Name of the vehicle to search: ");
        boolean found = false;

        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getName().equalsIgnoreCase(nameToSearch)) {
                System.out.println("Vehicle found:\n" + vehicle.toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Vehicle with Name " + nameToSearch + " not found.");
        }
    }

    public void checkVehicle() {
        String check = valid.checkString("Enter Id vehicle to check: ");
        if (vehicleExists(check)) {
            System.out.println("Existed Vehicle");
        } else {
            System.out.println("No Vehicle Found! ");
        }
    }

    public boolean vehicleExists(String vehicleId) {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getId().equalsIgnoreCase(vehicleId)) {
                return true;
            }
        }
        return false;
    }

    public Vehicle getVehicleByID(String IDVehicle) {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getId().equals(IDVehicle)) {
                return vehicle;
            }
        }
        return null;
    }

    public void saveToFile() {

        fm.saveToFile(vehicleList, "src/output/vehicles.dat");
        System.out.println("successfully !!!");
    }

    public void loadToFile() {

        loadVehicle(fm.loadFromFile("src/output/vehicles.dat"));
    }

    public void loadVehicle(List<String> dataFile) {
        if (vehicleList == null) {
            vehicleList = new ArrayList<>();
        }
        for (String line : dataFile) {
            String[] data = line.split(", ");
            String id = data[0].trim();
            String type = data[1].trim();
            String name = data[2].trim();
            String color = data[3].trim();
            double price = Double.parseDouble(data[4].trim());
            String brand = data[5].trim();
            int productYear = Integer.parseInt(data[6].trim());

            vehicleList.add(new Vehicle(id, type, name, color, price, brand, productYear));

        }
    }

    public void showAll() {
        valid.displayVehicles(vehicleList);
    }

    public void showByPrice() {
        List<Vehicle> sortedList = new ArrayList<>();
        double price = valid.checkDouble("Enter price: ", 0, Double.MAX_VALUE);
        for (Vehicle v : vehicleList) {
            if (v.getPrice() < price) {
                sortedList.add(v);
            }
        }
        if (sortedList == null) {
            System.err.println("Not found with this price");
            return;
        }
        Collections.sort(sortedList, compPrice);

        System.out.println("Vehicles by Price (Descending Order):");
        valid.displayVehicles(sortedList);
    }

    public static Comparator<Vehicle> compPrice = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Vehicle s1 = (Vehicle) o1;
            Vehicle s2 = (Vehicle) o2;

            if (s1.getPrice() < s2.getPrice()) {
                return 1;
            } else if (s1.getPrice() == (s2.getPrice())) {
                return 0;
            } else {
                return -1;
            }
        }
    };

    public void showByYear() {
        List<Vehicle> sortedList = new ArrayList<>();
        int year = valid.checkInt("Enter year: ", 0, Integer.MAX_VALUE);
        for (Vehicle v : vehicleList) {
            if (v.getProductYear() >= year) {
                sortedList.add(v);
            }
        }
        if (sortedList.isEmpty()) {
            System.err.println("Not found with this year");
            return;
        }
        Collections.sort(sortedList, compYear);

        System.out.println("Vehicles by Product Year (Descending Order):");
        valid.displayVehicles(sortedList);
    }
    public static Comparator<Vehicle> compYear = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Vehicle s1 = (Vehicle) o1;
            Vehicle s2 = (Vehicle) o2;

            if (s1.getProductYear() < s2.getProductYear()) {
                return 1;
            } else if (s1.getProductYear() == (s2.getProductYear())) {
                return 1;
            } else {
                return -1;
            }
        }
    };

    public void searchVehicleByName2() {

         String name = valid.checkString("Enter Name of the vehicle to search: ");

        if (name.length() < 4) {
            System.err.println("Enter must have at least 4 characters");
            return;
        }

        List<Vehicle> searchResults = new ArrayList<>();

        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getName().toLowerCase().contains(name.toLowerCase())) {
                searchResults.add(vehicle);
            }
        }

        if (searchResults.isEmpty()) {
            System.err.println("Not found vehicle");
            return;
        }

        Collections.sort(searchResults, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                return v2.getName().compareToIgnoreCase(v1.getName());
            }
        });
        System.out.println("Vehicles by Name (Descending Order):");
        valid.displayVehicles(searchResults);
    }

    public void searchVehicleByName() {
        String name = valid.checkString("Enter Name of the vehicle to search: ");
        List<Vehicle> sortedList = new ArrayList<>();
        for (Vehicle v : vehicleList) {
            if (v.getName().contains(name)) {
                sortedList.add(v);
            }
        }
        if (sortedList.isEmpty()) {
            System.err.println("Not found vehicle");
            return;
        }

        Collections.sort(sortedList, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                return v2.getName().compareToIgnoreCase(v1.getName());
            }
        });

        System.out.println("Vehicles by Name (Descending Order):");
        valid.displayVehicles(sortedList);
    }
}
