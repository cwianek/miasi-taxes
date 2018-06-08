package com.bartoszwalter.students.umowa;

public class UmowaZlecenie extends Umowa {

    @Override
    public void calculate() {
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
    }
}
