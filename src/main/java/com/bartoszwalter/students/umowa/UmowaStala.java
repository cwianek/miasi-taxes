package com.bartoszwalter.students.umowa;

import java.util.Map;
import java.util.TreeMap;

public class UmowaStala extends Umowa {

    protected double kwotaZmiejsz = 46.33;

    public UmowaStala(double podstawa) {
        super(podstawa);
        kosztyUzyskania = 111.25;
    }

    @Override
    public double calculate(){
        obliczPodstawe(podstawa);
        obliczUbezpieczenia(oPodstawa);
        obliczZaliczkeNaPodatek();
        obliczPodatekPotracony();
        obliczZaliczke(zaliczkaNaPodatek, kwotaZmiejsz);
        obliczWynagrodzenie();
        return wynagrodzenie;
    }

    @Override
    public void obliczPodatekPotracony() {
        podatekPotracony = zaliczkaNaPodatek - kwotaZmiejsz;
    }

    @Override
    public Map<String, Double> zwrocParametry() {

        Map<String, Double> parametry = new TreeMap<>();
        parametry.put("Umowa o prace", null);
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
        parametry.put("Kwota wolna od podatku = ", kwotaZmiejsz);
        parametry.put("Podatek potrącony = ", podatekPotracony);
        parametry.put("Zaliczka do urzędu skarbowego = ", zaliczkaUS);
        parametry.put("Zaliczka do urzędu skarbowego po zaokrągleniu = ", zaliczkaUSZaokr);
        parametry.put("Pracownik otrzyma wynagrodzenie netto w wysokości = ", wynagrodzenie);

        return parametry;
    }
}
