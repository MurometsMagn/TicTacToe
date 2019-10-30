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

/**
 * while (нет победителя) {
 * вывести поле
 * получить координаты клетки хода пользователя
 * сделать ход
 * переключить ход на другого игрока
 * }
 * <p>
 * Здесь «получить координаты клетки хода пользователя» это тоже тривиально:
 * <p>
 * System.out.print(«X: »);
 * x = scanner.nextInt();
 * System.out.print(«Y: »);
 * y = scanner.nextInt();
 * <p>
 * И на случай ввода некорректных значений, гонять это в цикле, пока функция validPosition() не выдаст true.
 */

public class Main {
    public static void main(String[] args) {

        String xo = "X";
        int inputNumber = 1;
        Scanner input = new Scanner(System.in);
        boolean continueInput = true;
        boolean i = true; //не смог засунуть в шапку цикла
        for (int j = 0; j < 9; j++) {
            //TicTacToe.printArray(TicTacToe.arrayTicTac);
            if (i) {
                System.out.println("Ход первого игрока (X): ");
                xo = "X";
            } else {
                System.out.println("Ход второго игрока (0): ");
                xo = "0";
            }
            do {
                try {
                    System.out.println("Введите номер поля вида: ");
                    TicTacToe.printArray(TicTacToe.arrayTicTacPos);
                    inputNumber = input.nextInt();
                    continueInput = !TicTacToe.arrayTicTac[(inputNumber - 1) / 3][(inputNumber - 1) % 3].equals(" ");
                    if (continueInput = !TicTacToe.arrayTicTac[(inputNumber - 1) / 3][(inputNumber - 1) % 3].equals(" ")) {
                        System.out.println("Некорректный ввод: поле занято, попробуйте еще раз");
                    } //else continueInput = false;
                } catch (InputMismatchException ex) {
                    System.out.println("Try again. (" + "Incorrect input: an integer is required)");
                    input.nextLine(); //при некорректном вводе -> для перевода курсора с ошибочной позиции
                //} catch (IndexOutOfBoundsException ex) {
                } catch (ArrayIndexOutOfBoundsException ex) { //не обрабатывает цифры от нуля и ниже (отрицательные)
                    System.out.println("Ошибка ввода: = " + ex);
                }
            } while (continueInput);

            //игровое действие:
            TicTacToe.arrayTicTac[(inputNumber - 1) / 3][(inputNumber - 1) % 3] = xo;
            TicTacToe.arrayTicTacPos[(inputNumber - 1) / 3][(inputNumber - 1) % 3] = xo;
            if (TicTacToe.winner(((inputNumber - 1) / 3), ((inputNumber - 1) % 3), xo)) {
                System.out.println("Выиграл игрок " + xo);
                TicTacToe.printArray(TicTacToe.arrayTicTac);
                System.exit(0);
            }

            i = !i;
        }
        System.out.println("ничья..");
    }
}
