/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator1;

/**
 *
 * @author user
 */
public class Driver {
     public static void  main(String args[] )
    {
        int n = 5, k = 6;
        System.out.println("Minimum number of trials in worst case with "+n+"  eggs and "+k+" floors is "+Elevator1.Passenger(n, k));   
    }
}
