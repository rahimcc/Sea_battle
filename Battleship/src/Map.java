import java.util.Arrays;

public class Map {
    String name;
    int nShip=0;

    Ship[] ships=new Ship[10];
    char[][] grid= new char[10][10] ;
    char[][] grid1= new char[10][10];
    char[] alphabet = "abcdefghij".toCharArray();

    public Map (String name){
        this.name=name;

        for (int i=0; i<grid.length;i++) {
            Arrays.fill(grid[i],'*');
        }
    }

    public int convert (char choice){
        switch (choice){
            case 'A': case 'a' : return 0;
            case 'B': case 'b' : return 1;
            case 'C': case 'c' : return 2;
            case 'D': case 'd' : return 3;
            case 'E': case 'e' : return 4;
            case 'F': case 'f' : return 5;
            case 'G': case 'g' : return 6;
            case 'H': case 'h' : return 7;
            case 'I': case 'i' : return 8;
            case 'J': case 'j' : return 9;
            case 'K': case 'k' : return 10;
            default: return -1;
        }
    }


    public void printGrid(){
        System.out.print("\n");
        System.out.print("\t\tMap of "+ name+ "\n");

        System.out.print("\t");
        for (int i=0;i<grid[0].length;i++){
            System.out.print(Character.toUpperCase(alphabet[i])+"  ");
        }

        System.out.println();
        for (int i=0;i<grid.length;i++){
            System.out.print(" ");
            System.out.print(i);
            for (int j=0;j<grid[0].length;j++){
                System.out.print("  "+ grid[i][j]);
            }
            System.out.println();
        }
    }

    public boolean addship (Ship ship, char[] opt ){

        if (opt.length!=3) {
            System.out.println("Wrong format");
            return false;
        }

        int X=convert(opt[0]);
        int Y=opt[1]-'0';

        if (X<0 || Y<0 || X>9 || Y>9){
            System.out.println("Out of range");
            return false;
        }

        int i = (X - 1 < 0) ? 0 : X - 1;
        int j = (Y - 1 < 0) ? 0 : Y - 1;
        int endX = (X + 1 > 9) ? 10 : X + 1;
        int endY = (Y + 1 > 9) ? 10 : Y + 1;

            for (; i < endX; i++) {
                for (; j < endY; j++) {
                    if (grid[j][i]=='0'){
                        System.out.println("Cannot be assigned");
                        return false;
                    }
                }
            }


        for (int k=0; k<ship.nSize ; k++){
            if (opt[2] =='H' || opt[2]=='h') grid[Y][X+k]=ship.nShip[k];
            else if (opt[2]=='V' || opt[2]=='v') grid[Y+k][X]=ship.nShip[k];
             else {
                 System.out.println("Mistake in orientation of the ship ");
                 return false;
             }
        }
        printGrid();
        nShip++;
        return true;
    }

    public boolean check (char posX,char posY , char c ){
        int X=convert(posX);
        int Y=posY-'0';

        int i= (X-1<0) ? 0 : X-1;
        int j= (Y-1<0) ? 0 : Y-1;
        int endX=(X+1>9) ? 10 : X+1;
        int endY=(X+1>9) ? 10 : X+1;

        for (;i<endX;i++){
            for (;j<endY;j++){
                if (i==X && j== Y) continue;
                if (grid[i][j]==c) return true ;

            }
        }
        return false;
    }

    public boolean shoot (char posX, char posY) {
        int X = convert(posX);
        int Y = posY - '0';



        if (grid[X][Y]=='*') {
            grid[X][Y]='-';
            System.out.println("MISS");
            return true;
        }

        if (grid[X][Y]=='0') {

            if (check(posX, posY, '0')) {
                grid[X][Y]='/';
                return true;
            }


            if (check(posX, posY, '0') == true && check(posX, posY, '/') == true) nShip--;


        }
        printGrid();
        return true;
    }




    public void replace() {
        for (int i = 0; i < nShip; i++) {
            int nS = (nShip < 4) ? 1 : ((nShip < 7) ? 2 : ((nShip) < 9 ? 3 : ((nShip < 10) ? 4 : -1)));

            ships[nShip] =new Ship("Ship",nS);
        }
    }
}
