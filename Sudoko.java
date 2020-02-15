import java.util.Scanner;
import java.lang.*;


public class Sudoko{

     public static int checkRow(int arr[][],int n,int i,int j,int val){
          for(int k=0;k<n;k++){
               if(arr[i][k]==val)
               return 0;
          }
          return 1;
     }


     public static int checkCol(int arr[][],int n,int i,int j,int val){
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
          int x=i-(i%root);
          int y=j-(j%root);
          int block=checkBlock(arr, x, y, k);
          if(col==0||row==0||block==0)
          return 0;
          return 1;

     }

     public static int slotFinderx(int arr[][],int n){
          for(int i=0;i<n;i++){
               for(int j=0;j<n;j++){
                    if(arr[i][j]==0)
                    return((i*10)+j);
               }
          }
          return -1;

     }

     public static int solverCode(int arr[][],int n,int i,int j){
          int check=0;
          int temp,x,y;
          if(arr[i][j]==0){
               System.out.println(i+" val of i "+j+" val of j");
               int k=1;
               int test=0;

               for(;k<10;k++){
                    if(test!=k){
                    if(isSafe(arr,n,i,j,k)==1){
                         displayMatx(arr, n);
                         System.out.println("this iterated");
                         arr[i][j]=k;
                         temp=slotFinderx(arr, n);
                         x=(int)temp/10;
                         y=(int)temp%10;
                         check=solverCode(arr, n, x, y);
                         if(check==0)
                         {
                         arr[i][j]=0;
                         k=1;
                         test=k;
                         }





                    }}

               }
               if(k==10)
               return 0;



          }

          {
               temp=slotFinderx(arr, n);
               if(temp!=-1)

               {
                    x=(int)temp/10;
                    y=(int)temp%10;

                    check=solverCode(arr, n,x,y);
                    return (check);
               }
               return 1;
          }


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
