package codPackage;

/**
 * Created by Smolentsev Il'ya on 26.10.2019.
 */
public class TicTacToe {

    public static String[][] arrayTicTacPos = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
    public static String[][] arrayTicTac = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};

    static boolean winner(int x, int y, String xo) {
        return
                ((arrayTicTac[0][y] == xo && arrayTicTac[1][y] == xo && arrayTicTac[2][y] == xo)  //горизонталь
                        || (arrayTicTac[x][0] == xo && arrayTicTac[x][1] == xo && arrayTicTac[x][2] == xo) //вертикаль
                        || (((x == 0 && y == 0) || (x == 1 && y == 1) || (x == 2 && y == 2)) // лев диагональ
                        && (arrayTicTac[0][0] == xo && arrayTicTac[1][1] == xo && arrayTicTac[2][2] == xo))
                        || (((x == 2 && y == 0) || (x == 1 && y == 1) || (x == 0 && y == 2)) //пр диагональ
                        && (arrayTicTac[2][0] == xo && arrayTicTac[1][1] == xo && arrayTicTac[0][2] == xo)));
    }

    static void printArray(String[][] arr) {
        System.out.println("+ - + - + - +");
        System.out.println("| " + arr[0][0] + " | " + arr[0][1] + " | " + arr[0][2] + " |");
        System.out.println("+ - + - + - +");
        System.out.println("| " + arr[1][0] + " | " + arr[1][1] + " | " + arr[1][2] + " |");
        System.out.println("+ - + - + - +");
        System.out.println("| " + arr[2][0] + " | " + arr[2][1] + " | " + arr[2][2] + " |");
        System.out.println("+ - + - + - +");
    }

    static boolean validPosition(int x, int y) {
        //return  (!arrayTicTac[x][y].equals("X") || !arrayTicTac[x][y].equals("0"));
        return  (arrayTicTac[x][y].equals(" "));
    }
}
