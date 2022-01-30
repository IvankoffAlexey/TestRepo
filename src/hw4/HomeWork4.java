package hw4;

import java.util.Scanner;

public class HomeWork4 {


    private static Scanner scanner = new Scanner(System.in); // сканер вынесли в отдельную функцию(метод)
    private static int count = 0;   // счетчик попыток начинает с 0

    public static void main(String[] args) {

        System.out.println("Ваша задача угадать число.");

        int range = 100; // максимальное значение промежутка для загаданных чисел
        int number = (int)(Math.random() * range);  // есть класс Math в котором есть метод random
        // - он генерирует случайные числа от 0 до 1 ВКЛЮЧИТЕЛЬНО.
        // Если мы умножаем на range (10), то будут
        // генерироваться случайные числа от 0 до 10 до range (10),
        // меняя значение переменной range, мы меняем пределы в котором будет генерироваться число
        // команда Math.random() генерирует дробные числа, а нам нужно целое число
        // и как раз конструкцией (int) перед (Math.random() * range) мы отрезаем дробное число

        playNewLevel(range, number); //вызов функции(метода) в которой, прописана исполняемая логика

        scanner.close(); //сканер при создании выделяет ресурсы то необходимо после использования их освободить
    }

    private static void playNewLevel(int range, int number) { //вынесли логику в отдельную функцию(метод)
        while(true) {    // Создаем бесконечный цикл с помощью оператора While
            System.out.println("Угадайте число от 0 до " + range);
            int input_number = scanner.nextInt();
            if(input_number == number) {
                System.out.println(" * * * Вы угадали! * * * ");
                count++;
                break;   // Прерывание цикла после совпадения числа
            } else if (input_number > number) {
                System.out.println("Загаданное число меньше, попробуйте еще раз!");
            } else {
                System.out.println("Загаданное число больше, попробуйте еще раз!");
            }
            count++;
        }
        System.out.println("Вы угадали с "+count+" попытки.");
    }
}
