/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllos.VehicleManager;
import java.text.ParseException;

/**
 *
 * @author BAO TRAN
 */
public class Program {

    public void execute() throws ParseException {
        VehicleManager vm = new VehicleManager();
        vm.loadToFile();
        int choice;

        do {
            System.out.println("<<<========================== MAIN MENU =========================>>>");
            choice = Menu.getChoice(Menu.STORE_MENU);

            switch (choice) {
                case 1:
                    vm.addVehicle();
                    break;
                case 2:
                    vm.checkVehicle();
                    break;

                case 3:
                    vm.updateVehicle();
                    break;

                case 4:
                    vm.deleteVehicle();
                    break;

                case 5:
                    int c6;
                    do {

                        c6 = Menu.getChoice(Menu.MENU_1);

                        switch (c6) {
                            case 1:
                                vm.searchVehicleByName();
                                break;
                            case 2:
                                vm.searchVehicleByID();
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Invalid selection");
                        }
                    } while (c6 != 3);
                    break;
                case 6:
                    int c7;
                    do {

                        c7 = Menu.getChoice(Menu.MENU_2);

                        switch (c7) {
                            case 1:
                                vm.showAll();
                                break;
                            case 2:
                                vm.showByPrice();
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Invalid selection");
                        }
                    } while (c7 != 3);
                    break;
                case 7:
                    vm.saveToFile();
                    break;

                case 8:
                    int c8;
                    do {

                        c8 = Menu.getChoice(Menu.MENU_3);

                        switch (c8) {
                            case 1:
                                vm.showAll();
                                break;
                            case 2:
                                vm.showByYear();
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Invalid selection");
                        }
                    } while (c8 != 3);
                    break;
                case 9:
                    System.out.println("Good bye");
                    break;

            }

            System.out.println();
        } while (choice != Menu.STORE_MENU.length);
    }
}
