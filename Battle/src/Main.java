import java.net.UnknownServiceException;
import java.util.Scanner;

public class Main {

    public static void main (String[] args){
        Map UserMap = new Map("User");
        Map CompMap = new Map("Computer");
        UserMap.printGrid();
       // CompMap.printGrid();

       Scanner input= new Scanner(System.in);
       System.out.println("*********Initializing User's map************\n");

       int nS;
       String s;
       char[] opt= new char[3];



       while(UserMap.nShip<10) {

           nS = (UserMap.nShip < 4) ? 1 : ((UserMap.nShip < 7) ? 2 : ((UserMap.nShip) < 9 ? 3 : ((UserMap.nShip < 10) ? 4 : -1)));

           UserMap.ships[UserMap.nShip]= new Ship("Ship1",nS);

           System.out.println("Configuring ship of " + nS);

        /*  System.out.print("Coloumn: ");
            X=input.next().charAt(0);

            System.out.print("Row: ");
            Y=input.nextInt();

            System.out.print("[H/V]: ");
            ch=input.next().charAt(0);
         */
          System.out.println("Position: ");
          s=input.nextLine();
          opt=s.toCharArray();


          UserMap.addship(UserMap.ships[UserMap.nShip],opt);
          UserMap.printGrid();

           UserMap.nShip++;
       }

    }

}
