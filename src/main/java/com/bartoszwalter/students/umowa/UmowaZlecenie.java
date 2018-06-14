package com.bartoszwalter.students.umowa;

import java.util.Map;
import java.util.TreeMap;

public class UmowaZlecenie extends Umowa {

    public UmowaZlecenie(double podstawa) {
        super(podstawa);
    }

    @Override
    public double calculate() {
        obliczPodstawe(podstawa);
        obliczUbezpieczenia(oPodstawa);
        obliczKosztyUzyskania();
        obliczZaliczkeNaPodatek();
        obliczPodatekPotracony();
        obliczZaliczke(zaliczkaNaPodatek, 0);
        obliczWynagrodzenie();
        return wynagrodzenie;
    }

    private void obliczKosztyUzyskania(){
        kosztyUzyskania = (oPodstawa * 20) / 100;
    }

    @Override
    public Map<String, Double> zwrocParametry() {

        Map<String, Double> parametry = new TreeMap<>();
        parametry.put("UMOWA-ZLECENIE", null);
        parametry.put("Podstawa wymiaru składek ", podstawa);
        parametry.put("Składka na ubezpieczenie emerytalne ", sEmerytalna);
        parametry.put("Składka na ubezpieczenie rentowe    ", sRentowa);
        parametry.put("Składka na ubezpieczenie chorobowe  ", uChorobowe);
        parametry.put("Podstawa wymiaru składki na ubezpieczenie zdrowotne: ", oPodstawa);
        parametry.put("Składka na ubezpieczenie zdrowotne: 9% = ", sZdrow1);
        parametry.put("Składka na ubezpieczenie zdrowotne: 7,75% = ", sZdrow2);
        parametry.put("Koszty uzyskania przychodu w stałej wysokości ", kosztyUzyskania);
        parametry.put("Podstawa opodatkowania ", podstawaOpodat);
        parametry.put("Podstawa opodatkowania zaokrąglona ", podstawaOpodatZaokr);
        parametry.put("Zaliczka na podatek dochodowy 18 % = ", zaliczkaNaPodatek);
        parametry.put("Podatek potrącony = ", podatekPotracony);
        parametry.put("Zaliczka do urzędu skarbowego = ", zaliczkaUS);
        parametry.put("Zaliczka do urzędu skarbowego po zaokrągleniu = ", zaliczkaUSZaokr);
        parametry.put("Pracownik otrzyma wynagrodzenie netto w wysokości = ", wynagrodzenie);

        return parametry;

    }
}