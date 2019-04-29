import java.awt.*;
import java.awt.geom.Point2D;
import java.io.PipedOutputStream;
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

    public static class Point extends Point2D{
        int x,y;

        public Point(int x, int y) {
            this.x=x;
            this.y=y;
        }

        @Override
        public double getX() {
            return x;
        }

        @Override
        public double getY() {
            return y;
        }

        @Override
        public void setLocation(double x, double y) {
            this.x=(int) x;
            this.y= (int) y;
        }

        public void setLocation(int x, int y) {
            this.x= x;
            this.y= y;

        }
    }

    public Point check(Point p , char c) {
            Point pos = new Point(p.x,p.y);
        int endX = (pos.x + 1 > 9) ? 10 : pos.x + 2;
        int endY = (pos.y + 1 > 9) ? 10 : pos.y + 2;
         for (int i = (pos.x - 1 < 0) ? 0 : pos.x - 1; i < endX; i++) {
            for (int k = (pos.y - 1 < 0) ? 0 : pos.y - 1; k < endY; k++) {
                if (i == pos.x && k == pos.y) continue;
                if (grid_back[k][i] == c) {
                    pos.setLocation(i,k);
                    pos.x=i;
                    pos.y=k;
                    return pos;
                }
            }
        }
        return pos;
    }



    public boolean checkImmersed ( Point pos, int count ){
        Point p=new Point(pos.x,pos.y);
        System.out.println(count);
        System.out.println("Asdfasd");

        if (count==5) return true;
        if (!ifEqual(check(p,'0'),p))  return false;

         p=check(p, '/');
            count++;
            checkImmersed(p, count);

        System.out.println("pos: " +  pos.x+ " " + pos.y);

        return  true;
    }

    public boolean ifEqual(Point p1, Point p2){
        if (p1.x==p2.x && p1.y==p2.y ) return true;
        return false;
    }

    public boolean checkship(Point pos, int size , char c){
        if (size==0) return true ;
//        Point p = new Point(posX,posY);
        if (pos.x>9 || pos.y>9 ) return false;
         Point p= check(pos,'0');
        if ( !ifEqual(pos,p) ) return false;
        else {
            if (c == 'h' || c == 'H') pos.x = pos.x + 1;
            else if (c == 'v' || c == 'V') pos.y = pos.y + 1;
            else return false;
        }

         size--;
         return  checkship(pos, size, c);
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
        Point p= new Point(X,Y);


        if (checkship( p, ship.nSize,opt[2])==false) {
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

    public boolean shootint (int X, int Y){

        Point p = new Point(X,Y);
        System.out.println(X+" "+ Y);
        if (grid_back[Y][X]=='*') {
            grid_back[Y][X]='-';
            return false;
        }

        if (grid_back[Y][X] == '0') {
            if (!checkImmersed(p,0)) {
                grid_back[Y][X] = '/';
                return true;
            } else {
                grid_back[Y][X] = 'X';
                destructship(X, Y);
                nShip--;
            }
        }
        return true;
    }

    public boolean shootchar(char[] pos) {

        if (pos.length!=2) {
            System.out.println("Wrong format    ");
        return  false;
        }
        int X = convert(pos[0]);
        int Y = pos[1] - '0';
        if (X < 0 || Y < 0 || X > 9 || Y > 9) {
            System.out.println("Out of range");
            return false;
        }
         if (shootint(X,Y)) return true;
       return false;
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
            Point p= new Point(x,y);
            c = choice[rand.nextInt(choice.length)];
            nS = (nShip < 1) ? 5 : ((nShip < 3) ? 4 : ((nShip) < 5 ? 3 : ((nShip < 9) ? 2 : -1)));

            ships[nShip] = new Ship(nS);
            System.out.println(nShip +  "  "+  nS);

            if (checkship(p, ships[nShip].nSize, c) == false) {
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

    public boolean autoshoot (){
       int x,y ;
        Random rand = new Random();
        x=rand.nextInt(10);
        y=rand.nextInt(10);
        if (grid_back[y][x]=='-' || grid_back[y][x]=='/' || grid_back[y][x]=='X') autoshoot();
        if (shootint(x,y)) return true;
        return false;
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

