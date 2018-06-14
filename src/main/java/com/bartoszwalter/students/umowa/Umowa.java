package com.bartoszwalter.students.umowa;

import java.util.Map;

abstract public class Umowa implements IDrukowalny {

    double podstawa;
    double sEmerytalna;
    double sRentowa;
    double uChorobowe;
    double kosztyUzyskania;
    double sZdrow1;
    double sZdrow2;
    double zaliczkaUS;

    double oPodstawa;
    double podstawaOpodat;
    double podstawaOpodatZaokr;
    double zaliczkaNaPodatek;

    double podatekPotracony;
    double zaliczkaUSZaokr;
    double wynagrodzenie;

    public abstract double calculate();

    public Umowa(double podstawa) {
        this.podstawa = podstawa;
    }

    void obliczZaliczke(double zaliczkaNaPodatek, double kwotaZmiejsz) {
        zaliczkaUS =  zaliczkaNaPodatek - sZdrow2 - kwotaZmiejsz;
        zaliczkaUSZaokr = Math.round(zaliczkaUS);
    }

    double obliczPodatek(double podstawa) {
        return (podstawa * 18) / 100;
    }

    void obliczPodstawe(double podstawa) {
        sEmerytalna = (podstawa * 9.76) / 100;
        sRentowa = (podstawa * 1.5) / 100;
        uChorobowe = (podstawa * 2.45) / 100;
        oPodstawa = podstawa - sEmerytalna - sRentowa - uChorobowe;
    }

    void obliczUbezpieczenia(double podstawa) {
        sZdrow1 = (podstawa * 9) / 100;
        sZdrow2 = (podstawa * 7.75) / 100;
    }

    void obliczZaliczkeNaPodatek(){
        podstawaOpodat = oPodstawa - kosztyUzyskania;
        podstawaOpodatZaokr = Math.round(podstawaOpodat);
        zaliczkaNaPodatek = obliczPodatek(podstawaOpodatZaokr);
    }

    void obliczWynagrodzenie(){
        wynagrodzenie = podstawa - ((sEmerytalna + sRentowa + uChorobowe) + sZdrow1 + zaliczkaUSZaokr);
    }

    void obliczPodatekPotracony(){
        podatekPotracony = zaliczkaNaPodatek;
    }
}
