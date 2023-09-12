package app;

import java.util.Scanner;
import java.util.Locale;
import java.util.Arrays;

public class Main {
    private static final int days = 7;
    private static double average;
    private final static String CURRENCY = "EUR";

    public static void main(String[] args) {

        Scanner priceScanner = new Scanner(System.in);
        priceScanner.useLocale(Locale.US);

        // Створюємо масив для цін за семиденний період.
        double[] price = new double[days];

        // Фіксуємо ціну товару за кожен з семи днів.
        System.out.println("Pricing your product in EUR for each of the 7 sales days:");
        for (int i = 0; i < days; ++i)
            price[i] = priceScanner.nextDouble();

        // За допомогою алгоритму Bubble sort
        // Сортуємо значення цін у зростаючому порядку.
        for (int i = 0; i < days; ++i) {
            for (int j = 0; j < (days - i - 1); ++j) {
                if (price[j] > price[j + 1]) {
                    double temp = price[j];
                    price[j] = price[j + 1];
                    price[j + 1] = temp;
                }
            }
        }
        System.out.println("Sorted prices for 7 days ascending:");
        for (int i = 0; i < days; ++i)
            System.out.println(CURRENCY + " " + price[i]);


        // Розраховуємо середню ціну за семиденний період.
        // Варіант 1
        for (double value : price)
            average += value;

        average /= price.length;

        //Варіант 2
        // Перетворюємо масив у відповідний потік
        // І викликаємо у ньому метод average().
        // Ця операція повертає опис середнього арифметичного
        // Елементів цього потоку або
        // Порожній параметр, якщо цей потік порожній.

        // average = Arrays.stream(price).average().orElse(0);

        System.out.printf(Locale.US,"-".repeat(35) +
                    "%nAverage price: %s %.2f", CURRENCY, average);

        priceScanner.close();
    }
}
