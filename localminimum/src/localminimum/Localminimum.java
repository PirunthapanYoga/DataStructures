package localminimum;
import java.util.Scanner;
/**
 *
 * @author 2017e082
 */
public class Localminimum {

    public static void MatrixData(Scanner Read,int[][] Matrix,int N )
    {
        System.out.println("! Enter the number of array in row order one by one!");
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                Matrix[i][j] = Read.nextInt();
            }
        }
    }
    
    public static void PrintMatrix(int[][] Matrix,int N )
    {
         System.out.println("2D Array is : ");
         for(int i=0;i<N;i++)
         {
             for(int j=0;j<N;j++)
             {
                 System.out.print(Matrix[i][j]+"\t");
             }
             
             System.out.println();
         }
     }
     
    public static void LocalMin(int[][] A, int N)
    {
        for(int i=0;i<N;i++)
        {
            for(int j=0; j<N;j++)
            {
                if(i>0 && j>0 && i<N-1 && j<N-1)
                {
                    if(A[i][j]<A[i+1][j]  &&  A[i][j]<A[i][j+1] &&  A[i][j]<A[i-1][j]   &&  A[i][j]<A[i][j-1])
                    {
                    System.out.println("Row Number - " + i + "\nColumn Number - " + j + "\nLocal Minimum = " + A[i][j]);
                    }
                }
                
                if(i==0 || i== N-1)
                {
                    if(i==0 && j==0)
                    {
                        if(A[i][j]<A[i+1][j] && A[i][j]<A[i][j+1])
                        {
                            System.out.println("Row Number - " + i + "\nColumn Number - " + j + "\nLocal Minimum = " + A[i][j]);
                        }     
                    }
                    if(i==0 && j==N-1)
                    {
                        if(A[i][j]<A[i][j-1] && A[i][j]<A[i+1][j])
                        {
                            System.out.println("Row Number - " + i + "\nColumn Number - " + j + "\nLocal Minimum = " + A[i][j]);
                        }
                    }
                    if(i==N-1 && j==0)
                    {
                        if(A[i][j]<A[i-1][j] && A[i][j]<A[i][j+1])
                        {
                            System.out.println("Row Number - " + i + "\nColumn Number - " + j + "\nLocal Minimum = " + A[i][j]);
                        }
                    }
                    if(i==N-1 && j==N-1)
                    {
                        if(A[i][j]<A[i-1][j] && A[i][j]<A[i][j-1])
                        {
                            System.out.println("Row Number - " + i + "\nColumn Number - " + j + "\nLocal Minimum = " + A[i][j]);
                        }
                    }
                }
                
                if((i==0 && j>0) || (i==N-1 && j>0) || (j==0 && i>0) || (j==N-1 && i>0))
                {
                    if(i==0 && j>0 && j<N-1)
                    {
                        if(A[i][j]<A[i][j-1] && A[i][j]<A[i][j+1] && A[i][j]<A[i+1][j])
                        {
                            System.out.println("Row Number - " + i + "\nColumn Number - " + j + "\nLocal Minimum = " + A[i][j]);
                        }
                    }
                    if(i==N-1 && j>0 && j<N-1)
                    {
                        if(A[i][j]<A[i][j-1] && A[i][j]<A[i][j+1] && A[i][j]<A[i-1][j])
                        {
                            System.out.println("Row Number - " + i + "\nColumn Number - " + j + "\nLocal Minimum = " + A[i][j]);
                        }
                    }
                    if(j==0 && i>0 && i<N-1)
                    {
                        if(A[i][j]<A[i+1][j] && A[i][j]<A[i-1][j] && A[i][j]<A[i][j+1])
                        {
                            System.out.println("Row Number - " + i + "\nColumn Number - " + j + "\nLocal Minimum = " + A[i][j]);
                        }
                    }
                    if(j==N-1 && i>0 && i<N-1)
                    {
                        if(A[i][j]<A[i+1][j] && A[i][j]<A[i-1][j] && A[i][j]<A[i][j-1])
                        {
                            System.out.println("Row Number - " + i + "\nColumn Number - " + j + "\nLocal Minimum = " + A[i][j]);
                        }
                    }
                }
                
                
                
            }
        }
        
    }
    
    public static void main(String[] args)
    {
        
       Scanner Read = new Scanner(System.in);
       System.out.println("Enter the value for the Row (square 2D array) :- ");
       int N=Read.nextInt();
       int[][] Matrix = new int[N][N];
       
       MatrixData(Read,Matrix,N);
       
       PrintMatrix(Matrix,N);
       
       LocalMin(Matrix,N);
    }
    
}
