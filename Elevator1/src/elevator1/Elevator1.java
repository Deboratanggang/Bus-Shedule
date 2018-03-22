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
public class Elevator1 {

    // A utility function to get maximum of two integers
    static int max(int a, int b) { return (a > b)? a: b; }
      
    /* Function to get minimum number of trials needed in worst
    case with n passengers and k floors */
    static int Passenger(int n, int k)
    {
       /* A 2D table where entery passFllor[i][j] will represent minimum
       number of trials needed for i passengers and j floors. */
        int passFloor[][] = new int[n+1][k+1];
        int res;
        int i, j, x;
          
        // We need one trial for one floor and0 trials for 0 floors
        for (i = 1; i <= n; i++)
        {
            passFloor[i][1] = 1;
            passFloor[i][0] = 0;
        }
          
       // We always need j trials for one passenger and j floors.
        for (j = 1; j <= k; j++)
            passFloor[1][j] = j;
          
        // Fill rest of the entries in table using optimal substructure
        // property
        for (i = 2; i <= n; i++)
        {
            for (j = 2; j <= k; j++)
            {
                passFloor[i][j] = Integer.MAX_VALUE;
                for (x = 1; x <= j; x++)
                {
                     res = 1 + max(passFloor[i-1][x-1], passFloor[i][j-x]);
                     if (res < passFloor[i][j])
                        passFloor[i][j] = res;
                }
            }
        }
          
        // passFloor[n][k] holds the result
        return passFloor[n][k];
 
    }
          
    
}
