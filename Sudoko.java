import java.util.Scanner;



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

          int y=j-(j/root);

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

     static public int  solveCoder(int arr[][],int n){
          int store=slotFinderx(arr, n);
          if(store==-1)
          //if array doesnot contain 0 then it is filled completely with proper values
          return 1;
          int x,y;
          x=(int) store/10;
          y=store%10;
          for(int i=1;i<=9;i++){
               if(isSafe(arr, n, x, y, i)==1){
                    arr[x][y]=i;
                    if(solveCoder(arr, n)==1)
                    //this denotes that no problem has been recorded during recursion
                    //if problem is seen 0 will be returned as no other value can fit in that place
                    return 1;
                    arr[x][y]=0;
               }
          }
          return 0;

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
          int n=9;
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


          int temp=solveCoder(arr,n);
          if(temp==1){
               displayMatx(arr,n);
               System.out.println("Nice it got solved");
          }
          else
          System.out.println("Cannot be solved by me!");
     }

}
