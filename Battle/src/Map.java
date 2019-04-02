
public class Map {
    String name;
    int nShip=10;
    Ship[] ships=new Ship[10];
     char[][] grid= new char[10][10];
     char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public Map (String name){
        this.name=name;
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
}
