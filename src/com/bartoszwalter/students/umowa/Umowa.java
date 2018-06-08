package com.bartoszwalter.students.umowa;

import com.bartoszwalter.students.wyjscie.DrukarkaDanych;

import java.util.Map;

abstract public class Umowa {

    protected double podstawa = 0;
    protected double sEmerytalna = 0; // 9,76% podstawyy
    protected double sRentowa = 0; // 1,5% podstawy
    protected double uChorobowe = 0; // 2,45% podstawy
    protected double kosztyUzyskania = 111.25;
    protected double sZdrow1 = 0; // od podstawy wymiaru 9%
    protected double sZdrow2 = 0; // od podstawy wymiaru 7,75 %
    protected double kwotaZmiejsz = 46.33; // kwota zmienjszająca podatek 46,33 PLN
    protected double zaliczkaUS = 0;

    public void calculate(){

    }

    public Map<String,Double> zwrocParametry() {
        return null;
    }

    public double obliczZaliczke(double zaliczkaNaPodatek, double kwotaZmiejsz) {
        return zaliczkaNaPodatek - sZdrow2 - kwotaZmiejsz;
    }

    public double obliczPodatek(double podstawa) {
        return (podstawa * 18) / 100;
    }

    public double obliczonaPodstawa(double podstawa) {
        sEmerytalna = (podstawa * 9.76) / 100;
        sRentowa = (podstawa * 1.5) / 100;
        uChorobowe = (podstawa * 2.45) / 100;
        return (podstawa - sEmerytalna - sRentowa - uChorobowe);
    }

    public void obliczUbezpieczenia(double podstawa) {
        sZdrow1 = (podstawa * 9) / 100;
        sZdrow2 = (podstawa * 7.75) / 100;
    }

}
