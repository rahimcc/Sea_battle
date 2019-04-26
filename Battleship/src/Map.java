import java.util.Arrays;
import java.util.Random;

public class Map {
    String name;
    int nShip = 0;

    Ship[] ships = new Ship[10];
    char[][] grid = new char[10][10];
    char[][] grid1 = new char[10][10];
    char[] alphabet = "abcdefghij".toCharArray();

    public Map(String name) {
        this.name = name;

        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(grid[i], '*');
            Arrays.fill(grid1[i], '*');
        }
    }

    public int convert(char choice) {
        switch (choice) {
            case 'A':case 'a':  return 0;
            case 'B':case 'b':  return 1;
            case 'C':case 'c':  return 2;
            case 'D':case 'd':  return 3;
            case 'E': case 'e': return 4;
            case 'F': case 'f': return 5;
            case 'G': case 'g': return 6;
            case 'H': case 'h': return 7;
            case 'I': case 'i': return 8;
            case 'J': case 'j': return 9;
            case 'K': case 'k': return 10;
            default: return -1;
        }
    }


    public void printGrid() {
        System.out.print("\n");
        System.out.print("\t\tMap of " + name + "\n");

        System.out.print("\t");
        for (int i = 0; i < grid[0].length; i++) {
            System.out.print(Character.toUpperCase(alphabet[i]) + "  ");
        }

        System.out.println();
        for (int i = 0; i < grid.length; i++) {
            System.out.print(" ");
            System.out.print(i);
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print("  " + grid[i][j]); // hgkjhgjkhg
            }
            System.out.println();
        }
    }

<<<<<<< HEAD
<<<<<<< HEAD
    public void printGrid1(){
        for (int i=0; i<10;i++){
            for (int j=0; j<10; j++){
                grid1[i][j]=grid[i][j];
            }
        }
    }



=======
    boolean copyGrid (int X, int Y ){
        grid1[Y][X]=grid[Y][X];
=======
    boolean copyGrid(int X, int Y) {
        grid1[Y][X] = grid[Y][X];
>>>>>>> 45217a3364e1f60e030287d0b9f3c9888d5e526a
        printGrid();
        return true;
    }

<<<<<<< HEAD
>>>>>>> 58cccbae86552a0805ba1f0725cda2fb9e246011
    public boolean addship (Ship ship, char[] opt ){
=======
    public boolean checkship(int X,int Y,char c, Ship s ){
>>>>>>> 45217a3364e1f60e030287d0b9f3c9888d5e526a

        for

    }

    public boolean addship(Ship ship, char[] opt) {

        if (opt.length != 3) {
            System.out.println("Wrong format");
            return false;
        }

        int X = convert(opt[0]);
        int Y = opt[1] - '0';
        if (X < 0 || Y < 0 || X > 9 || Y > 9) {
            System.out.println("Out of range");
            return false;
        }

        int i = (X - 1 < 0) ? 0 : X - 1;
        int j = (Y - 1 < 0) ? 0 : Y - 1;
        int endX = (X + 1 > 9) ? 10 : X + 1;
        int endY = (Y + 1 > 9) ? 10 : Y + 1;

         /*   for (; i < endX; i++) {
                for (; j < endY; j++) {
                    if (grid[j][i]=='0'){
                        System.out.println("Cannot be assigned");
                        return false;
                    }
                }
            }

        */
        if (opt[2] == 'H' || opt[2] == 'h') {
            //grid[Y][X+k]=ship.nShip[k];
            for (int k = 0; k < ship.nSize; k++) {
                if (check(X, (Y + k), '0')) {
                    System.out.println("not be assigned");
                    //printGrid();
                    return false;
                }
            }
        } else if (opt[2] == 'V' || opt[2] == 'v') {
            for (int k = 0; k < ship.nSize; k++) {
                if (check((X + k), Y, '0')) {
                    System.out.println("not be assigned");
                    // printGrid();
                    return false;
                }
            }
        }
        //grid[Y+k][X]=ship.nShip[k];
        else {
            System.out.println("Mistake in orientation of the ship ");
            return false;
        }
        for (int k = 0; k < ship.nSize; k++) {
            if (opt[2] == 'H' || opt[2] == 'h') grid[Y][X + k] = ship.nShip[k];
            else if (opt[2] == 'V' || opt[2] == 'v') grid[Y + k][X] = ship.nShip[k];
        }

        //printGrid();
        nShip++;
        return true;
    }

    public boolean checkship(int posX, int posY, Ship s, char c){
        if (s.nSize==0) return true;

        if (check(posX,posY,'0')) return false;
       else {
            if (c=='h' || c=='H') posX=posX+1;
            else if (c=='v' || c=='V') posY=posY+1;
            checkship(posX, posY, s, c);
            s.nSize--;
        }
    }


    public boolean check(int posX, int posY, char c) {
        //        int X=convert(posX);
        //        int Y=posY-'0

        int endX = (posX + 1 > 9) ? 10 : posX + 2;
        int endY = (posY + 1 > 9) ? 10 : posY + 2;


        for (int i = (posX - 1 < 0) ? 0 : posX - 1; i < endX; i++) {
            for (int k = (posY - 1 < 0) ? 0 : posY - 1; k < endY; k++) {
                if (i == posX && k == posY) continue;
                if (grid[k][i] == c) {
                    return true;
                    }
            }
        }
        return false;
    }

    public boolean shoot(char posX, char posY) {
        int X = convert(posX);
        int Y = posY - '0';

        if (X < 0 || Y < 0 || X > 9 || Y > 9) {
            System.out.println("Out of range");
            return false;
        }

<<<<<<< HEAD
        System.out.println(X+" "+ Y);
        if (grid[Y][X]=='*') {
            grid[Y][X]='-';
        }
        if (grid[Y][X]=='0') {
            if (check(X , Y,'0')) {
                grid[Y][X]='/';
=======
        System.out.println(X + " " + Y);
        if (grid[Y][X] == '*') {
            grid[Y][X] = '-';
            System.out.println("MISS");
        }

        if (grid[Y][X] == '0') {
            if (check(X, Y, '0')) {
                grid[Y][X] = '/';
>>>>>>> 45217a3364e1f60e030287d0b9f3c9888d5e526a
            } else {
                grid[Y][X] = 'X';
                destructship(X, Y);
                nShip--;
            }
        }
        // printGrid();
        return true;
    }


    public void destructship(int posX, int posY) {

        int endX = (posX + 1 > 9) ? 10 : posX + 2;
        int endY = (posY + 1 > 9) ? 10 : posY + 2;
        int check = 0;
        int buffX = posX;
        int buffY = posY;


        for (int i = (posX - 1 < 0) ? 0 : posX - 1; i < endX; i++) {
            for (int k = (posY - 1 < 0) ? 0 : posY - 1; k < endY; k++) {
                if (i == posX && k == posY) continue;

                if (grid[k][i] == '*') grid[k][i] = '-';
                if (grid[k][i] == '/') {
                    grid[k][i] = 'X';
                    buffX = i;
                    buffY = k;
                    check = 1;
                }
            }
        }
        if (check == 1) destructship(buffX, buffY);
    }

    /* public void autofill() {
         char[] opt=new char[3];
         Random rand= new Random();

         opt[0]=alphabet[rand.nextInt(9)];
         opt[1] =(char)(rand.nextInt(9)+'0');
         opt[2]='H';
         int nS;
         while (nShip < 10) {
             nS = (nShip < 4) ? 1 : ((nShip < 7) ? 2 : ((nShip) < 9 ? 3 : ((nShip < 10) ? 4 : -1)));

             ships[nShip]= new Ship("ship",nS);
             if ( addship(ships[nShip],opt)==false ) continue;

         }

     }
 }   */
    public void fill() {
        char[] opt = new char[3];

        ships[0] = new Ship("ship", 1);
        opt[0] = 'a';
        opt[1] = '0';
        opt[2] = 'h';
        addship(ships[0], opt);
        ships[1] = new Ship("ship", 1);
        opt[0] = 'a';
        opt[1] = '3';
        opt[2] = 'h';
        addship(ships[1], opt);
        ships[2] = new Ship("ship", 1);
        opt[0] = 'a';
        opt[1] = '5';
        opt[2] = 'h';
        addship(ships[2], opt);
        ships[3] = new Ship("ship", 1);
        opt[0] = 'a';
        opt[1] = '3';
        opt[2] = 'h';
        addship(ships[3], opt);
        ships[4] = new Ship("ship", 2);

        opt[0] = 'c';
        opt[1] = '0';
        opt[2] = 'h';
        addship(ships[4], opt);

        ships[5] = new Ship("ship", 2);
        opt[0] = 'c';
        opt[1] = '3';
        opt[2] = 'h';
        addship(ships[5], opt);


        ships[6] = new Ship("ship", 2);
        opt[0] = 'c';
        opt[1] = '5';
        opt[2] = 'h';
        addship(ships[6], opt);
        ships[7] = new Ship("ship", 3);
        opt[0] = 'g';
        opt[1] = '0';
        opt[2] = 'v';
        addship(ships[7], opt);

        ships[8] = new Ship("ship", 3);
        opt[0] = 'c';
        opt[1] = '8';
        opt[2] = 'h';
        addship(ships[8], opt);


        ships[9] = new Ship("ship", 4);
        opt[0] = 'j';
        opt[1] = '0';
        opt[2] = 'v';  // this is comment  
        addship(ships[9], opt);

    }



    public void copygrid(){
        for (int i=0;i<10;i++){
            for (int j=0;j<10; j++){
                if (grid[i][j]!='0')
                grid1[i][j]=grid[i][j];
            }
        }
    }
}

