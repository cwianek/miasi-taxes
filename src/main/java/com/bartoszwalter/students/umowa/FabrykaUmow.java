package com.bartoszwalter.students.umowa;

import com.bartoszwalter.students.wejscie.ICzytnik;

public class FabrykaUmow {

    public static Umowa create(ICzytnik czytnik){
        Umowa umowa = null;
        char symbol = czytnik.getUmowa();
        double podstawa = czytnik.getPodstawa();

        switch (symbol){
            case 'P':
                umowa = new UmowaStala(podstawa);
                break;
            case 'Z':
                umowa = new UmowaZlecenie(podstawa);
                break;
        }
        return umowa;
    }

}
