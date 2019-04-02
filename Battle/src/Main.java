


public class Main {

    public static void main (String[] args){
        Map UserMap = new Map("User");
        Map CompMap = new Map("Computer");
        UserMap.printGrid();
       // CompMap.printGrid();

        Ship ship= new Ship("ship1", 5);
        UserMap.addship(ship,4,5,'V');
        UserMap.printGrid();


    }
}
