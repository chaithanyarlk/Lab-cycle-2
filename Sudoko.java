import java.util.Scanner;
import java.lang.*;


public class Sudoko{

     public static int checkRow(int arr[][],int n,int i,int j,int val){

          //this will check the row for safe insertion
          for(int k=0;k<n;k++){
               if(arr[i][k]==val)
               return 0;
          }
          return 1;
     }


     public static int checkCol(int arr[][],int n,int i,int j,int val){

          //this will check the column whether it contains the number anywhere
          for(int k=0;k<n;k++){
               if(arr[k][j]==val)
               return 0;
          }
          return 1;
     }

     public static int  checkBlock(int arr[][],int i,int j,int val){
          //this has to check the block contains the given values
          System.out.println("at block we got i "+i+" the value of j "+j);
          for(int k=i;k<i+3;k++){
               for(int c=j;c<j+3;c++){
                    if(arr[k][c]==val)
                    return 0;
               }
          }
          return 1;
     }

     public static  int isSafe(int arr[][],int n,int i,int j,int k){
          //thsi must solve the problem
          int col=checkCol(arr, n, i, j,k);
          int row=checkRow(arr, n, i, j,k);
          int root=(int)Math.sqrt(n);
          System.out.println(root);
          int x=i-(i/root);
          int y=j-(j/root);
          System.out.println("x "+x+" y "+y);
          //the values of x and y will point to the blocks first indices
          int block=checkBlock(arr, x, y, k);
          //if any one of them is true then it is unsafe to insert the values
          if(col==0||row==0||block==0)
          return 0;
          return 1;

     }

     public static int slotFinderx(int arr[][],int n){
          //finds the slot which is empty
          for(int i=0;i<n;i++){
               for(int j=0;j<n;j++){
                    if(arr[i][j]==0)
                    return((i*10)+j);
                    //encoded form
               }
          }
          return -1;

     }

     public static int solverCode(int arr[][],int n,int i,int j){
          int check=0;
          int temp,x,y;
          if(arr[i][j]==0){
               //this will check wheteher the slotFinder has returned the right slot or not
               System.out.println(i+" val of i "+j+" val of j");
               //checking the values
               int k=1;
               int test=0;
               //test is a variable that will check that the value that is got rejected will not be again inserted for current iteration
               for(;k<10;k++){
                    if(test!=k && check==0){
                         System.out.println("we are trying k "+k+" also the value of except is "+test);
                         //checking that the value of k is not  equal to that which got rejected
                    if(isSafe(arr,n,i,j,k)==1){
                         //we checck if that is safe then we have to proceed
                         System.out.println("this iterated");
                         arr[i][j]=k;
                         displayMatx(arr, n);
                         //now we will insert and find the next element in the list
                         temp=slotFinderx(arr, n);
                         if(temp!=-1){
                         //if temp ==-1 then no value or slot which is empty is present
                         x=(int)temp/10;
                         y=(int)temp%10;
                         //System.out.println()
                         check=solverCode(arr, n, x, y);
                         System.out.println(check+" this the val of check");
                         //recursive backtracking is applied if the value returned by this set is 0 then prev
                         //call has to be executed
                    }
                         if(check==0)
                         {
                         arr[i][j]=0;
                         //initialize the element to 0 and again serach for the next possible value in the loop
                         k=0;
                         test=k;
                         }

                    }}

               }
               if(k==10)
               return 0;

          }//end of if condition of slot filler of codeSolver

               temp=slotFinderx(arr, n);
               if(temp!=-1)

               {
                    System.out.println("enetred else");
                    x=(int)temp/10;
                    y=(int)temp%10;

                    check=solverCode(arr, n,x,y);
                    return (check);
               }

               System.out.println("1 return part");
               return 1;



     }
     static public void displayMatx(int arr[][],int n){
          //displays the arr

          for(int i=0;i<n;i++){
               for(int j=0;j<n;j++){
                    System.out.print(arr[i][j]+"\t");

               }
               System.out.println(" " );
          }

     }

     static public void main(String []args){
          int n=3;
          Scanner s=new Scanner(System.in);
          int arr[][]= new int[n][n];
          for(int i=0;i<n;i++){
               for(int j=0;j<n;j++){
                    System.out.println("bro if you want to leave empty space press 0");
                    arr[i][j]=s.nextInt();
               }

          }
          displayMatx(arr,n);
          System.out.println("this is enetered");


          int temp=solverCode(arr,n,0,0);
          if(temp==1){
               System.out.println("Nice it got solved");
          }
          else
          System.out.println("Cannot be solved by me!");
     }

}
