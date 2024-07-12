package com.jesus.conversor;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        ConsultarMoneda consultarMoneda = new ConsultarMoneda();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("**********************************");
            System.out.println("Bienvenido al conversor de monedas:");
            System.out.println("1) Dólar -> Peso argentino");
            System.out.println("2) Peso argentino -> Dólar");
            System.out.println("3) Dólar -> Real brasileño");
            System.out.println("4) Real brasileño -> Dólar");
            System.out.println("5) Dólar -> Peso colombiano");
            System.out.println("6) Peso colombiano -> Dólar");
            System.out.println("7) Salir");
            System.out.print("Elija una opción: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Ingrese la cantidad en USD: ");
                    double amountInUsd = scanner.nextDouble();
                    double amountInArs = consultarMoneda.getUsdToArs().convertirDesdeUsd(amountInUsd);
                    System.out.println(String.format("%.2f USD = %.2f ARS", amountInUsd, amountInArs));
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad en ARS: ");
                    double amountInArsToConvert = scanner.nextDouble();
                    double amountInUsdFromArs = consultarMoneda.getUsdToArs().convertirAUsd(amountInArsToConvert);
                    System.out.println(String.format("%.2f ARS = %.2f USD", amountInArsToConvert, amountInUsdFromArs));
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad en USD: ");
                    double amountInUsdToBrl = scanner.nextDouble();
                    double amountInBrl = consultarMoneda.getUsdToBrl().convertirDesdeUsd(amountInUsdToBrl);
                    System.out.println(String.format("%.2f USD = %.2f BRL", amountInUsdToBrl, amountInBrl));
                    break;
                case 4:
                    System.out.print("Ingrese la cantidad en BRL: ");
                    double amountInBrlToConvert = scanner.nextDouble();
                    double amountInUsdFromBrl = consultarMoneda.getUsdToBrl().convertirAUsd(amountInBrlToConvert);
                    System.out.println(String.format("%.2f BRL = %.2f USD", amountInBrlToConvert, amountInUsdFromBrl));
                    break;
                case 5:
                    System.out.print("Ingrese la cantidad en USD: ");
                    double amountInUsdToCop = scanner.nextDouble();
                    double amountInCop = consultarMoneda.getUsdToCop().convertirDesdeUsd(amountInUsdToCop);
                    System.out.println(String.format("%.2f USD = %.2f COP", amountInUsdToCop, amountInCop));
                    break;
                case 6:
                    System.out.print("Ingrese la cantidad en COP: ");
                    double amountInCopToConvert = scanner.nextDouble();
                    double amountInUsdFromCop = consultarMoneda.getUsdToCop().convertirAUsd(amountInCopToConvert);
                    System.out.println(String.format("%.2f COP = %.2f USD", amountInCopToConvert, amountInUsdFromCop));
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        }

        scanner.close();
    }
}