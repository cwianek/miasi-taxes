package com.bartoszwalter.students.wyjscie;

import java.text.DecimalFormat;
import java.util.Map;

public class DrukarkaDanych {

    private char umowa;
    public void wyswietl(Map<String, Double> parametry)
    {

        parametry.forEach( (k,v)-> {System.out.print(k + "\t"); System.out.println(v);} );
        DecimalFormat df00 = new DecimalFormat("#.00");
        DecimalFormat df = new DecimalFormat("#");

//        switch (umowa){
//            case 'P':
//
//                System.out.println("UMOWA O PRACĘ");
//                System.out.println("Podstawa wymiaru składek " + podstawa);
//                System.out.println("Składka na ubezpieczenie emerytalne " + df00.format(sEmerytalna));
//                System.out.println("Składka na ubezpieczenie rentowe    " + df00.format(sRentowa));
//                System.out.println("Składka na ubezpieczenie chorobowe  " + df00.format(uChorobowe));
//                System.out.println("Podstawa wymiaru składki na ubezpieczenie zdrowotne: " + oPodstawa);
//                System.out.println("Składka na ubezpieczenie zdrowotne: 9% = " + df00.format(sZdrow1) + " 7,75% = " + df00.format(sZdrow2));
//                System.out.println("Koszty uzyskania przychodu w stałej wysokości " + kosztyUzyskania);
//                System.out.println("Podstawa opodatkowania " + podstawaOpodat + " zaokrąglona " + df.format(podstawaOpodatZaokr));
//                System.out.println("Zaliczka na podatek dochodowy 18 % = " + zaliczkaNaPodatek);
//                System.out.println("Kwota wolna od podatku = " + kwotaZmiejsz);
//                System.out.println("Podatek potrącony = " + df00.format(podatekPotracony));
//                System.out.println("Zaliczka do urzędu skarbowego = " + df00.format(zaliczkaUS) + " po zaokrągleniu = " + df.format(zaliczkaUSZaokr));
//                System.out.println();
//                System.out.println("Pracownik otrzyma wynagrodzenie netto w wysokości = " + df00.format(wynagrodzenie));
//
//                break;
//
//            case 'Z':
//
//                System.out.println("UMOWA-ZLECENIE");
//                System.out.println("Podstawa wymiaru składek " + podstawa);
//                System.out.println("Składka na ubezpieczenie emerytalne " + df00.format(sEmerytalna));
//                System.out.println("Składka na ubezpieczenie rentowe    " + df00.format(sRentowa));
//                System.out.println("Składka na ubezpieczenie chorobowe  " + df00.format(uChorobowe));
//                System.out.println("Podstawa wymiaru składki na ubezpieczenie zdrowotne: " + oPodstawa);
//                System.out.println("Składka na ubezpieczenie zdrowotne: 9% = " + df00.format(sZdrow1) + " 7,75% = " + df00.format(sZdrow2));
//                System.out.println("Zaliczka do urzędu skarbowego = " + df00.format(zaliczkaUS) + " po zaokrągleniu = " + df.format(zaliczkaUSZaokr));
//                System.out.println("Koszty uzyskania przychodu (stałe) " + kosztyUzyskania);
//                System.out.println("Podstawa opodatkowania " + podstawaOpodat + " zaokrąglona " + df.format(podstawaOpodatZaokr));
//                System.out.println("Zaliczka na podatek dochodowy 18 % = " + zaliczkaNaPodatek);
//                System.out.println("Podatek potrącony = " + df00.format(podatekPotracony));
//                System.out.println("Zaliczka do urzędu skarbowego = " + df00.format(zaliczkaUS) + " po zaokrągleniu = " + df.format(zaliczkaUSZaokr));
//                System.out.println();
//                System.out.println("Pracownik otrzyma wynagrodzenie netto w wysokości = " + df00.format(wynagrodzenie));
//
//                break;
//        }

    }
}
