import java.util.Scanner;




public class Tictac{
     public static int winCase(int arr[][],int n){
          for( int i=0;i<n;i++){
         if((arr[i][0]==0&&arr[i][1]==0&&arr[i][2]==0)||(arr[i][0]==1&&arr[i][1]==1&&arr[i][2]==1))
              return arr[i][0];}
           for( int i=0;i<n;i++){
           if((arr[0][i]==0&&arr[1][i]==0&&arr[2][i]==0)||(arr[0][i]==1&&arr[1][i]==1&&arr[2][i]==1))
           return arr[0][i];}

          if((arr[0][0]==0&&arr[1][1]==0&&arr[2][2]==0)||(arr[0][0]==1&&arr[1][1]==1&&arr[2][2]==1))
          return (arr[0][0]);
          if((arr[2][0]==0&&arr[1][1]==0&&arr[0][2]==0)||(arr[2][0]==1&&arr[1][1]==1&&arr[0][2]==1))
          return arr[1][1];
     return -1; }  
          
     public static int check(int arr[][],int i,int j){
          if(arr[i][j]!=-1)
          return 0;//if place is not empty
          return 1;//if place is empty
     }

     public static void display(int arr[][]){
          for(int i=0;i<3;i++){
               for(int j=0;j<3;j++){
                    if(arr[i][j]==0){
                         System.out.print("0"+"\t");
                    }
                    if(arr[i][j]==1){
                         System.out.print("X"+"\t");
                    }
               }
               System.out.println(" ");
          }
     }

     static public void main(String []args){
          int i=1;
          int win=-1;
          int row,col;
          int arr[][] =new int[3][3];
          for(int k=0;k<3;k++){
               for(int g=0;g<3;g++){
                    arr[k][g]=-1;
               }
          }
          Scanner s=new Scanner(System.in);
          while(i<10&&win==-1){
               if(i%2!=0){
                    System.out.println("Player1 chance ");

               }
               else{
                    System.out.println("Player2 chance ");

               }
               System.out.println("eneter row");
               row=s.nextInt();
               System.out.println("eneter col");
               col=s.nextInt();
               int temp=check(arr,row-1,col-1);
               if(temp==0){
                    display(arr);
                    continue;
               }
               else{
               if(i%2==0)
               arr[row-1][col-1]=1;
               else
               arr[row-1][col-1]=0;
               display(arr);
               i++;
          }
          win=winCase(arr,3);


          }
          if(win==0){
               System.out.println("PLayer1 won");
          }
          else {
               System.out.println("PLayer2 won");
          }

          if(i==10)
          System.out.println("tie");
     }
          
          
     
     

}