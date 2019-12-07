package codPackage;

/**
 * Created by Smolentsev Il'ya on 16.10.2019.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Реализовать игру в крестики-нолики. В игру играют два игрока (человека). Перед началом игры программа печатает пустое
 * поле.После печати поля, программа предлагает первому игроку ввести координаты x и y для постановки крестика.
 * В случае, если
 * пользователь ввел некорректные координаты клетки или клетка занята, программа должна выдать соответствующее сообщение.
 * Если пользователь сделал ход, программа печатает поле с учетом хода игрока и ход передается следующему игроку.
 * Игра прекращается когда выиграл один из игроков, или наступила ничья (ничьей считать полностью заполненное поле,
 * на котором ни один из игроков не выиграл). Программа должна выдать номер игрока победителя (или его символ —
 * крестик или нолик), либо сообщение, что наступила ничья.
 */

public class Main {
    public static void main(String[] args) {

        String xo = "0";
        int inputNumber = 1;
        Scanner input = new Scanner(System.in);
        boolean tieFlag = false; //ничья: tie, draw, dead heat, standoff

        for (int j = 0; j < 9; j++) { //outerLoop
            xo = (xo.equals("X")) ? "0" : "X";
            int x = 0, y = 0;
            boolean continueInput = true; //во избежание лишних итераций j

            do { // innerLoop
                try {
                    System.out.println("j = " + j);
                    String toPrint = (xo.equals("X")) ? "Ход первого игрока (X)" : "Ход второго игрока (0)";
                    System.out.println(toPrint);

                    System.out.println("Введите номер поля вида: ");
                    TicTacToe.printArray(TicTacToe.arrayTicTac);
                    inputNumber = input.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Try again. (" + "Incorrect input: an integer is required)");
                    input.nextLine(); //при некорректном вводе -> для перевода курсора с ошибочной позиции
                    continue;
                }

                if (inputNumber < 1 || inputNumber > 9) {
                    System.out.println("некорректный ввод: введите число от 0 до 9");
                    continue;
                }
                x = (inputNumber - 1) / 3;
                y = (inputNumber - 1) % 3;
                if (continueInput = !TicTacToe.validPosition(x, y)) { //как прокомментировать присваивание?
                    System.out.println("Некорректный ввод: поле занято, попробуйте еще раз");
                    continue;
                }
            } while (continueInput);

            //игровое действие:
            TicTacToe.arrayTicTac[x][y] = xo;
            if (TicTacToe.winner(x, y, xo)) {
                System.out.println("Выиграл игрок " + xo);
                TicTacToe.printArray(TicTacToe.arrayTicTac);
                System.exit(0);

            }
            if (j == 8) tieFlag = true; //добавлено
        }
        if (tieFlag) System.out.println("ничья..");
    }
}
