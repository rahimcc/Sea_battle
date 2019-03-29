

public class Main {

    public static void printGrid (char[] letters, int[][] grid ){
        System.out.print("\t");

        for (int i=0;i<grid[0].length;i++){
            System.out.print(Character.toUpperCase(letters[i])+"  ");
        }
        System.out.println();

        
        for (int i=0;i<grid.length;i++){
            System.out.print(" ");
            System.out.print(i);
            for (int j=0;j<grid[0].length;j++){
                    System.out.print("*  ");
                }
                System.out.println();
            }
        }



    public static void main (String[] args){

        int[][] multi= new int[8][8];
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();


        printGrid(alphabet,multi);
    }
}
