import java.util.Scanner;

public class Main {

    public static void printMaps(Map User, Map Comp){
        System.out.print("========="+ User.name+ "========");
        System.out.println("\t\t ======="+ Comp.name+ "=======");
        System.out.print("  ");
        for (int i=0;i<User.alphabet.length;i++){
            System.out.print(User.alphabet[i]+" ");
        }
        System.out.print("\t\t  ");
        for (int i=0;i<Comp.alphabet.length;i++){
            System.out.print(Comp.alphabet[i]+" ");
        }

        System.out.print("\n");
        for (int i=0; i<10; i++){
            System.out.print(i+" ");
            for (int j=0; j<10; j++ ){
                System.out.print(User.grid[i][j]+" " );
            }
            System.out.print("\t\t");
            System.out.print(i+" ");
            for (int k=0;k<10;k++ ) {
                System.out.print(Comp.grid1[i][k]+" ");
            }
            System.out.print("\n");
        }
    }





    public static void main (String[] args){
        Map UserMap = new Map("User");// merveillous
        Map CompMap = new Map("Computer");// this is magnefique

        printMaps(UserMap,CompMap);

        Scanner input= new Scanner(System.in);
        System.out.println("*********Initializing User's map*******\n"); //i like this comment

        int nS;
        String s;
        char[] opt;



        while(UserMap.nShip<10) {
            nS = (UserMap.nShip < 4) ? 1 : ((UserMap.nShip < 7) ? 2 : ((UserMap.nShip) < 9 ? 3 : ((UserMap.nShip < 10) ? 4 : -1)));
            System.out.println("Configuring ship of the size "+ nS +":");
            System.out.print("Position");
            s=input.nextLine();
            s=s.replaceAll("\\s+","");

            opt=s.toCharArray();


            UserMap.ships[UserMap.nShip]= new Ship("ship",nS);
            if ( UserMap.addship(UserMap.ships[UserMap.nShip],opt)==false ) continue;
            printMaps(UserMap,CompMap);
        }

        CompMap.fill();
        /*
        define comps map
         */

        printMaps(UserMap,CompMap);
        while (CompMap.nShip>0) {
            System.out.print("shot position: ");
            s = input.nextLine();
            s = s.replaceAll("\\s+", "");
            opt = s.toCharArray();
            CompMap.shoot(opt[0], opt[1]);
            CompMap.copygrid();
            printMaps(UserMap,CompMap);
        }


    }
}
