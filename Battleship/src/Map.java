import java.util.Arrays;
import java.util.Random;

public class Map {
    String name;
    int nShip = 0;

    Ship[] ships = new Ship[10];
    char[][] grid_back = new char[10][10];
    char[][] grid_front = new char[10][10];
    char[] alphabet = "abcdefghij".toCharArray();

    public Map(String name) {
        this.name = name;
        for (int i = 0; i < grid_back.length; i++) {
            Arrays.fill(grid_back[i], '*');
            Arrays.fill(grid_front[i], '*');
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


    public boolean check(int posX, int posY, char c) {

        int endX = (posX + 1 > 9) ? 10 : posX + 2;
        int endY = (posY + 1 > 9) ? 10 : posY + 2;
         for (int i = (posX - 1 < 0) ? 0 : posX - 1; i < endX; i++) {
            for (int k = (posY - 1 < 0) ? 0 : posY - 1; k < endY; k++) {
                if (i == posX && k == posY) continue;
                if (grid_back[k][i] == c) return true ;
            }
        }
        return false;
    }


    public boolean checkship(int posX, int posY, int size , char c){
        if (size==0) return true ;


        if (posX>9 || posY>9 ) return false;
        if (check(posX,posY,'0')) return false;



        else {
            if (c == 'h' || c == 'H') posX = posX + 1;
            else if (c == 'v' || c == 'V') posY = posY + 1;
            else return false;
        }
         size--;
         return  checkship(posX, posY, size, c);
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

        if (checkship(X,Y, ship.nSize,opt[2])==false) {
                System.out.println("Checkship failed");
                return false;
        }

        for (int k = 0; k < ship.nSize; k++) {
            if (opt[2] == 'H' || opt[2] == 'h') grid_back[Y][X + k] = ship.nShip[k];
            else if (opt[2] == 'V' || opt[2] == 'v') grid_back[Y + k][X] = ship.nShip[k];
        }

        nShip++;
        return true;
    }


    public boolean shoot(char posX, char posY) {
        int X = convert(posX);
        int Y = posY - '0';

        if (X < 0 || Y < 0 || X > 9 || Y > 9) {
            System.out.println("Out of range");
            return false;
        }


        System.out.println(X+" "+ Y);
        if (grid_back[Y][X]=='*') {
            grid_back[Y][X]='-';
        }
        if (grid_back[Y][X]=='0') {
            if (check(X, Y, '0'))
                grid_back[Y][X] = '/';
            System.out.println(X + " " + Y);
            if (grid_back[Y][X] == '*') {
                grid_back[Y][X] = '-';
                System.out.println("MISS");
            }
        }
        if (grid_back[Y][X] == '0') {
            if (check(X, Y, '0')) {
                grid_back[Y][X] = '/';

            } else {
                grid_back[Y][X] = 'X';
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

                if (grid_back[k][i] == '*') grid_back[k][i] = '-';
                if (grid_back[k][i] == '/') {
                    grid_back[k][i] = 'X';
                    buffX = i;
                    buffY = k;
                    check = 1;
                }
            }
        }
        if (check == 1) destructship(buffX, buffY);
    }

    public void autofill (){
        int x,y, nS=0;
        Random rand= new Random();
        char[] choice={'H','V'};
        char c;

        while (nShip<9) {
            x=rand.nextInt(10);
            y=rand.nextInt(10);
            c = choice[rand.nextInt(choice.length)];
            nS = (nShip < 1) ? 5 : ((nShip < 3) ? 4 : ((nShip) < 5 ? 3 : ((nShip < 9) ? 2 : -1)));

            ships[nShip] = new Ship(nS);
            System.out.println(nShip +  "  "+  nS);

            if (checkship(x, y, ships[nShip].nSize, c) == false) {
                System.out.println("Checkship failed");

                continue;
            }
                System.out.println("Succes" + nS );

            for (int k = 0; k < ships[nShip].nSize; k++) {
                if (c == 'H' || c == 'h') grid_back[y][x + k] = ships[nShip].nShip[k];
                //grid_back[y][x + k] = ships[nShip].nShip[k];
                else if (c == 'V' || c == 'v') grid_back[y + k][x] = ships[nShip].nShip[k];
            }
            nShip++;
        }


    }


    public void copygrid(){
        for (int i=0;i<10;i++){
            for (int j=0;j<10; j++){
                if (grid_back[i][j]!='0')
                grid_front[i][j]=grid_back[i][j];
            }
        }
    }
}

