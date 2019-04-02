import java.util.Arrays;

public class Ship {
    String sName;
    int nSize;
    char nShip[];



    public Ship(String sName , int nSize ){
        this.sName=sName;
        this.nSize=nSize;
        nShip=new char[nSize];
        Arrays.fill(nShip,'-');
    }




}