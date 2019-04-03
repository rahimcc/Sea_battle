import java.util.Arrays;

public class Map {
    String name;
    int nShip=0;
    Ship[] ships=new Ship[10];
    char[][] grid= new char[10][10] ;
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();



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


    public  void printGrid(){
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

    public void addship (Ship ship,char[] opt ){
        int X=convert(opt[0]);
        int Y=opt[1]-'0';

        for (int i=0; i<ship.nSize ; i++){
            if (opt[2] =='H') grid[Y][X+i]=ship.nShip[i];
            else grid[Y+i][X]=ship.nShip[i];

        }
    }

}
