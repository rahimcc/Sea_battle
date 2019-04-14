import java.net.UnknownServiceException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){


        Map UserMap = new Map("User");
        Map CompMap = new Map("Computer");

        UserMap.printGrid();
        //CompMap.printGrid();


        Scanner input= new Scanner(System.in);
        System.out.println("*********Initializing User's map*******\n");

        int nS;
        String s;
        char[] opt;



        while(UserMap.nShip<10) {
            nS = (UserMap.nShip < 4) ? 1 : ((UserMap.nShip < 7) ? 2 : ((UserMap.nShip) < 9 ? 3 : ((UserMap.nShip < 10) ? 4 : -1)));
            System.out.println("Configuring ship of the size "+nS+":");
            System.out.print("Position");
            UserMap.ships[UserMap.nShip]= new Ship("ship",nS);
            s=input.nextLine();
            s=s.replaceAll("\\s+","");

            opt=s.toCharArray();


            if ( UserMap.addship(UserMap.ships[UserMap.nShip],opt)==false) continue;


        }

        while (UserMap.nShip>0){
            System.out.print("shot position: ");
            s=input.nextLine();
            opt=s.toCharArray();
            UserMap.shoot(opt[0],opt[1]);
        }


        System.out.println("GAME OVER");
    }

}
