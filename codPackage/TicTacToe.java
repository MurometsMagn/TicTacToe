package codPackage;

/**
 * Created by Smolentsev Il'ya on 26.10.2019.
 */
public class TicTacToe {

    public static String[][] arrayTicTac = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};

    static boolean testWinner(int x, int y, String xo) {
        return (arrayTicTac[0][y].equals(xo) && arrayTicTac[1][y].equals(xo) && arrayTicTac[2][y].equals(xo));  //горизонталь
    }

    static boolean winner(int x, int y, String xo) {
        return
                ((arrayTicTac[0][y].equals(xo) && arrayTicTac[1][y].equals(xo) && arrayTicTac[2][y].equals(xo))  //вертикаль
                        || (arrayTicTac[x][0].equals(xo) && arrayTicTac[x][1].equals(xo) && arrayTicTac[x][2].equals(xo)) //горизонталь
                        || (((x == 0 && y == 0) || (x == 1 && y == 1) || (x == 2 && y == 2)) // лев диагональ
                        && (arrayTicTac[0][0].equals(xo) && arrayTicTac[1][1].equals(xo) && arrayTicTac[2][2].equals(xo)))
                        || (((x == 2 && y == 0) || (x == 1 && y == 1) || (x == 0 && y == 2)) //пр диагональ
                        && (arrayTicTac[2][0].equals(xo) && arrayTicTac[1][1].equals(xo) && arrayTicTac[0][2].equals(xo))));
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
        return (!arrayTicTac[x][y].equals("X") || !arrayTicTac[x][y].equals("0"));
    }
}
