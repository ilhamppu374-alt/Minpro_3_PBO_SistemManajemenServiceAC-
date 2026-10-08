/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

/**
 *
 * @author USER
 */
import controller.ServiceController;
import view.ServiceView;

public class Main {

    public static void main(String[] args) {

        ServiceController controller =
                new ServiceController();

        ServiceView view =
                new ServiceView(controller);

        view.jalankanProgram();
    }
}