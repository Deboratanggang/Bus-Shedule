/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;

/**
 *
 * @author Debora S. Sitangganh
 */
import javax.swing.JFrame;
//Class Lifting sebagai Runner program
public class Lifting {
 //Main Method
 public static void main(String[] args) {
 ElevatorSimulation go = new ElevatorSimulation();
 go.setTitle("Elevator Simulation New PTIIK Building Program");
 go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 go.setBounds(455, 50, 455, 660);
 go.setVisible(true);
 go.setResizable(false);
 go.show();
 }
}