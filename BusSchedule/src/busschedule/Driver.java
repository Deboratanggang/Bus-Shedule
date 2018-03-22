package busschedule;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Debora S. Sitanggang
 */
// Driver program to test methods of graph class
public class Driver {
   
    public static void main(String[] args) {
     int arr[] = {900, 940, 950, 1100, 1500, 1800};
    int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
    int n = arr.length;
    System.out.println("Minimum Number of Platforms Required = " + BusShedule.findPlatform(arr, dep, n));
    }

    
    }
    
