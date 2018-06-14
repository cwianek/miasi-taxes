import com.bartoszwalter.students.umowa.FabrykaUmow;
import com.bartoszwalter.students.umowa.Umowa;
import com.bartoszwalter.students.wejscie.CzytnikDanych;
import com.bartoszwalter.students.wyjscie.DrukarkaDanych;

public class Main {

    public static void main(String[] args){
        CzytnikDanych czytnikDanych = new CzytnikDanych();

        Umowa umowa = FabrykaUmow.create(czytnikDanych);
        umowa.calculate();

        DrukarkaDanych.wyswietl(umowa);
    }

}
