package com.bartoszwalter.students.wejscie;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CzytnikDanych {

    private double podstawa;
    private char umowa;

    public void czytaj()
    {
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
    }

    public double getPodstawa() {
        return podstawa;
    }

    public char getUmowa() {
        return umowa;
    }
}
