import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Doğum gününüzü giriniz: ( 26.08.1994 )");
        String birthday = scanner.nextLine();

        int dayOfYear = Integer.parseInt(birthday.substring(0, 2));

        // Horoscope date ranges
        // Assigns the astrological sign based on the day of the year
        /*
         * 21 - 41 : Capricorn
         * 42 - 72 : Aquarius
         * 73 - 103 : Pisces
         * 104 - 133 : Aries
         * 134 - 174 : Taurus
         * 175 - 204 : Gemini
         * 205 - 235 : Cancer
         * 236 - 266 : Leo
         * 267 - 296 : Virgo
         * 297 - 326 : Libra
         * 327 - 355 : Scorpio
         * 356 - 365 : Sagittarius
         */

        // Determines the astrological sign based on the day of the year
        if (dayOfYear >= 21 && dayOfYear <= 41) {
            System.out.println("Burcunuz: Oğlak"); // Capricorn
        } else if (dayOfYear >= 42 && dayOfYear <= 72) {
            System.out.println("Burcunuz: Kova"); // Aquarius
        } else if (dayOfYear >= 73 && dayOfYear <= 103) {
            System.out.println("Burcunuz: Balık"); // Pisces
        } else if (dayOfYear >= 104 && dayOfYear <= 133) {
            System.out.println("Burcunuz: Koç"); // Aries
        } else if (dayOfYear >= 134 && dayOfYear <= 174) {
            System.out.println("Burcunuz: Boğa"); // Taurus
        } else if (dayOfYear >= 175 && dayOfYear <= 204) {
            System.out.println("Burcunuz: İkizler"); // Gemini
        } else if (dayOfYear >= 205 && dayOfYear <= 235) {
            System.out.println("Burcunuz: Yengeç"); // Cancer
        } else if (dayOfYear >= 236 && dayOfYear <= 266) {
            System.out.println("Burcunuz: Aslan"); // Leo
        } else if (dayOfYear >= 267 && dayOfYear <= 296) {
            System.out.println("Burcunuz: Başak"); // Virgo
        } else if (dayOfYear >= 297 && dayOfYear <= 326) {
            System.out.println("Burcunuz: Terazi"); // Libra
        } else if (dayOfYear >= 327 && dayOfYear <= 355) {
            System.out.println("Burcunuz: Akrep"); // Scorpio
        } else if (dayOfYear >= 356 && dayOfYear <= 365) {
            System.out.println("Burcunuz: Yay"); // Sagittarius
        } else {
            System.out.println("Hatalı giriş yaptınız."); // Invalid input
        }
    }
}
