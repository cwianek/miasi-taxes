package com.bartoszwalter.students.taxes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class TaxCalculator {

    private static char umowa = ' ';

    private static double podstawa = 0;
    private static double sEmerytalna = 0; // 9,76% podstawyy
    private static double sRentowa = 0; // 1,5% podstawy
    private static double uChorobowe = 0; // 2,45% podstawy
    private static double kosztyUzyskania = 111.25;
    private static double sZdrow1 = 0; // od podstawy wymiaru 9%
    private static double sZdrow2 = 0; // od podstawy wymiaru 7,75 %
    private static double kwotaZmiejsz = 46.33; // kwota zmienjszająca podatek 46,33 PLN
    private static double zaliczkaUS = 0;

    private static DecimalFormat df00 = new DecimalFormat("#.00");
    private static DecimalFormat df = new DecimalFormat("#");

    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            System.out.print("Podaj kwotę dochodu: ");
            podstawa = Double.parseDouble(br.readLine());

            System.out.print("Typ umowy: (P)raca, (Z)lecenie: ");
            umowa = br.readLine().charAt(0);

        } catch (Exception ex) {
            System.out.println("Błędna kwota");
            System.err.println(ex);
            return;
        }


        if (umowa == 'P') {
            double oPodstawa = obliczonaPodstawa(podstawa);
            obliczUbezpieczenia(oPodstawa);

            double podstawaOpodat = oPodstawa - kosztyUzyskania;
            double podstawaOpodatZaokr = Math.round(podstawaOpodat);
            double zaliczkaNaPodatek = obliczPodatek(podstawaOpodatZaokr);

            double podatekPotracony = zaliczkaNaPodatek - kwotaZmiejsz;
            double zaliczkaUS = obliczZaliczke(zaliczkaNaPodatek, kwotaZmiejsz);
            double zaliczkaUSZaokr = Math.round(zaliczkaUS);
            double wynagrodzenie = podstawa - ((sEmerytalna + sRentowa + uChorobowe) + sZdrow1 + zaliczkaUSZaokr);

            wyswietlUmoweOprace(oPodstawa, podstawaOpodat, podstawaOpodatZaokr, podatekPotracony, wynagrodzenie, zaliczkaNaPodatek, zaliczkaUSZaokr);

        } else if (umowa == 'Z') {
            double oPodstawa = obliczonaPodstawa(podstawa);
            obliczUbezpieczenia(oPodstawa);

            kosztyUzyskania = (oPodstawa * 20) / 100;

            double podstawaOpodat = oPodstawa - kosztyUzyskania;
            double podstawaOpodatZaokr = Math.round(podstawaOpodat);
            double zaliczkaNaPodatek = obliczPodatek(podstawaOpodatZaokr);
            double podatekPotracony = zaliczkaNaPodatek;
            double zaliczkaUS = obliczZaliczke(zaliczkaNaPodatek, 0);
            double zaliczkaUSZaokr = Math.round(zaliczkaUS);
            double wynagrodzenie = podstawa - ((sEmerytalna + sRentowa + uChorobowe) + sZdrow1 + zaliczkaUSZaokr);
            wyswietlUmoweZlecenie(podstawaOpodat, podstawaOpodatZaokr, oPodstawa, podatekPotracony, wynagrodzenie,zaliczkaNaPodatek, zaliczkaUSZaokr);
        } else {
            System.out.println("Nieznany typ umowy!");
        }
    }

    public static void wyswietlUmoweOprace(double oPodstawa, double podstawaOpodat, double podstawaOpodatZaokr, double podatekPotracony, double wynagrodzenie, double zaliczkaNaPodatek, double zaliczkaUSZaokr) {
        System.out.println("UMOWA O PRACĘ");
        System.out.println("Podstawa wymiaru składek " + podstawa);
        System.out.println("Składka na ubezpieczenie emerytalne " + df00.format(sEmerytalna));
        System.out.println("Składka na ubezpieczenie rentowe    " + df00.format(sRentowa));
        System.out.println("Składka na ubezpieczenie chorobowe  " + df00.format(uChorobowe));
        System.out.println("Podstawa wymiaru składki na ubezpieczenie zdrowotne: " + oPodstawa);
        System.out.println("Składka na ubezpieczenie zdrowotne: 9% = " + df00.format(sZdrow1) + " 7,75% = " + df00.format(sZdrow2));
        System.out.println("Koszty uzyskania przychodu w stałej wysokości " + kosztyUzyskania);
        System.out.println("Podstawa opodatkowania " + podstawaOpodat + " zaokrąglona " + df.format(podstawaOpodatZaokr));
        System.out.println("Zaliczka na podatek dochodowy 18 % = " + zaliczkaNaPodatek);
        System.out.println("Kwota wolna od podatku = " + kwotaZmiejsz);
        System.out.println("Podatek potrącony = " + df00.format(podatekPotracony));
        System.out.println("Zaliczka do urzędu skarbowego = " + df00.format(zaliczkaUS) + " po zaokrągleniu = " + df.format(zaliczkaUSZaokr));
        System.out.println();
        System.out.println("Pracownik otrzyma wynagrodzenie netto w wysokości = " + df00.format(wynagrodzenie));
    }

    private static void wyswietlUmoweZlecenie(double podstawaOpodat, double podstawaOpodatZaokr, double oPodstawa, double podatekPotracony, double wynagrodzenie, double zaliczkaNaPodatek, double zaliczkaUSZaokr) {
        System.out.println("UMOWA-ZLECENIE");
        System.out.println("Podstawa wymiaru składek " + podstawa);
        System.out.println("Składka na ubezpieczenie emerytalne " + df00.format(sEmerytalna));
        System.out.println("Składka na ubezpieczenie rentowe    " + df00.format(sRentowa));
        System.out.println("Składka na ubezpieczenie chorobowe  " + df00.format(uChorobowe));
        System.out.println("Podstawa wymiaru składki na ubezpieczenie zdrowotne: " + oPodstawa);
        System.out.println("Składka na ubezpieczenie zdrowotne: 9% = " + df00.format(sZdrow1) + " 7,75% = " + df00.format(sZdrow2));
        System.out.println("Zaliczka do urzędu skarbowego = " + df00.format(zaliczkaUS) + " po zaokrągleniu = " + df.format(zaliczkaUSZaokr));
        System.out.println("Koszty uzyskania przychodu (stałe) " + kosztyUzyskania);
        System.out.println("Podstawa opodatkowania " + podstawaOpodat + " zaokrąglona " + df.format(podstawaOpodatZaokr));
        System.out.println("Zaliczka na podatek dochodowy 18 % = " + zaliczkaNaPodatek);
        System.out.println("Podatek potrącony = " + df00.format(podatekPotracony));
        System.out.println("Zaliczka do urzędu skarbowego = " + df00.format(zaliczkaUS) + " po zaokrągleniu = " + df.format(zaliczkaUSZaokr));
        System.out.println();
        System.out.println("Pracownik otrzyma wynagrodzenie netto w wysokości = " + df00.format(wynagrodzenie));
    }

    public static double obliczZaliczke(double zaliczkaNaPodatek, double kwotaZmiejsz) {
        return zaliczkaNaPodatek - sZdrow2 - kwotaZmiejsz;
    }

    public static double obliczPodatek(double podstawa) {
        return (podstawa * 18) / 100;
    }

    public static double obliczonaPodstawa(double podstawa) {
        sEmerytalna = (podstawa * 9.76) / 100;
        sRentowa = (podstawa * 1.5) / 100;
        uChorobowe = (podstawa * 2.45) / 100;
        return (podstawa - sEmerytalna - sRentowa - uChorobowe);
    }

    public static void obliczUbezpieczenia(double podstawa) {
        sZdrow1 = (podstawa * 9) / 100;
        sZdrow2 = (podstawa * 7.75) / 100;
    }
}
