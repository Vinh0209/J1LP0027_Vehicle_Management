/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllos.Validation;

/**
 *
 * @author BAO TRAN
 */
public class Menu {

    public static final String[] STORE_MENU = {
        "|1.Add new vehicle                                                 |",
        "|2.Check exist vehicle                                             |",
        "|3.Update vehicle                                                  |",
        "|4.Delete vehicle                                                  |",
        "|5.Search vehicle                                                  |",
        "|6.Display all Vehecle                                             |",
        "|7.Save all vehicles to file                                       |",
        "|8.Print all vehicle from the file                                 |",
        "|9.Quit:                                                           |"

    };

    public static final String[] MENU_1 = {
        "|1.Search by name                                                  |",
        "|2.Search by id                                                    |",
        "|3.Back to main menu                                               |",};

    public static final String[] MENU_2 = {
        "|1.Show all                                                        |",
        "|2.Show by price                                                   |",
        "|3.Back to main menu                                               |",};

    public static final String[] MENU_3 = {
        "|1.Print all                                                       |",
        "|2.Print by year                                                   |",
        "|3.Back to main menu                                               |",};

    public static int getChoice(String[] menu) {
        Validation valid = new Validation();
        for (int i = 0; i < menu.length; i++) {
            System.out.println(menu[i]);
        }
        System.out.println("<==================================================================>");
        return valid.checkInt("Choose: ", 1, menu.length);
    }

}
