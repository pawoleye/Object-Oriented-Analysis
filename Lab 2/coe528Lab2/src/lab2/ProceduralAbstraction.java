/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author preva
 */
public class ProceduralAbstraction {
    
//Requires: None
//Modifies: None
//Effects: Returns the smallest positive integer n for which n!
// (i.e. 1*2*3*...*n) is greater than or equal to x, for positive
// integer x. Otherwise returns 1.
public static int reverseFactorial(int x) { 
    int n=1,m =1;
    boolean rFac = false;
  
     if (x > 0){  
        while (!rFac){
        for (int i=1; i <= n; i++){
            m = m*i;
        }
        if (m >= x ){
            return n;
        }
           rFac =false;
           m = 1;
           n = n+1;  
        }
     }
     
    return 1;
}

//Requires: None
//Modifies: None
//Effects: If the matrix arr satisfies Nice property, prints the sum and
// returns true. Otherwise returns false.
public static boolean isMatrixNice(int[][] arr){
    int [] row = new int[arr.length];
    int [] column = new int[arr[0].length];
    int dia1=0,dia2=0;
    

    if (arr.length == arr[0].length){
        for(int i=0; i < arr.length;i++){
            for(int j=0; j < arr[i].length;j++){
                row[i] = arr[i][j] + row[i];
                column[i] = arr[j][i] + column[i];
            }       
        }
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == i) {
                        dia1 = arr[i][j] + dia1;
                    }
                if ((i+j) == (arr.length-1)) {
                        dia2 = arr[i][j] + dia2;
                    }
                }
            }
        
        if (dia1 != dia2){   //If diagonals are not equal returms false
            return false; 
        }
        else{
         for(int i=0; i < row.length;i++){
            if (row[i] != dia1 || column[i] != dia1){  // since it passed first check rows and columns are equal so checks if any sum is different than the diagonal
                return false;
            } 
        }
            System.out.println("sum:" + row[0]);  //outputs equal sum 
         return true;                             //returns false, since the matrix is nice
        }
        
    }
    
    return false;  //matrix doesnt meet nice specifications so returns false
}

    public static void main(String[] args){
        int y=reverseFactorial(119);
        System.out.println(y);
        int mat[][] = {{2, 7, 6},{9, 5, 1},{4, 3, 8}};
        System.out.println(isMatrixNice(mat));
    }
}
