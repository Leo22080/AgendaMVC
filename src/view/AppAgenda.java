/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AgendaController;
import model.Agenda;

/**
 *
 * @author Leonardo
 */
public class AppAgenda {
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Agenda model = Agenda.getInstance();
        AgendaController ctrl = AgendaController.getInstance();
        AgendaView view  = new AgendaView(); 
            view.display();
    }
}
