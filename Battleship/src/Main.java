import java.util.Scanner;

public class Main {

    public static void printMaps(Map User, Map Comp){
        System.out.print("\t========="+ User.name+ "========");
        System.out.println("\t\t\t\t \t======="+ Comp.name+ "=======");
        System.out.print("  ");
        for (int i=0;i<User.alphabet.length;i++){
            System.out.print(User.alphabet[i]+"  ");
        }
        System.out.print("\t\t  ");
        for (int i=0;i<Comp.alphabet.length;i++){
            System.out.print(Comp.alphabet[i]+"  ");
        }

        System.out.print("\n");
        for (int i=0; i<10; i++){
            System.out.print(i+" ");
            for (int j=0; j<10; j++ ){
                System.out.print(User.grid_back[i][j]+"  " );
            }
            System.out.print("\t\t");
            System.out.print(i+" ");
            for (int k=0;k<10;k++ ) {
                System.out.print(Comp.grid_front[i][k]+"  ");
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


        while(UserMap.nShip<9) {
            nS = (UserMap.nShip < 1) ? 5 : ((UserMap.nShip < 3) ? 4 : ((UserMap.nShip) < 5 ? 3 : ((UserMap.nShip < 9) ? 2 : -1)));
            System.out.print("Configuring ship of the size "+ nS +": ");
//            System.out.print("Position");
            s=input.nextLine();
            s=s.replaceAll("\\s+","");

            opt=s.toCharArray();

          /*  UserMap.ships[UserMap.nShip]= new Ship(nS);
            if (UserMap.addship(UserMap.ships[UserMap.nShip],opt)==false ) continue;
*/
            UserMap.ships[UserMap.nShip]= new Ship(nS);
            if ( UserMap.addship(UserMap.ships[UserMap.nShip],opt)==false ) continue;
            printMaps(UserMap,CompMap);
        }

        CompMap.autofill();
        /*
        define comps map
         */

        printMaps(UserMap,CompMap);
        int check=0;
        while (CompMap.nShip>0  && UserMap.nShip>0) {
           if (check==0) {
               System.out.print("Shot position: ");
               s = input.nextLine();
               s = s.replaceAll("\\s+", "");
               opt = s.toCharArray();
              if (CompMap.shootchar(opt)) {
                  CompMap.copygrid();
                  printMaps(UserMap, CompMap);
                  continue;
              }
               CompMap.copygrid();
           }
           check=1;
           if (check==1){
                if (UserMap.autoshoot()){

                    printMaps(UserMap,CompMap);
                    continue;
                }
           }
           check=0;
            printMaps(UserMap,CompMap);
        }


    }
}
