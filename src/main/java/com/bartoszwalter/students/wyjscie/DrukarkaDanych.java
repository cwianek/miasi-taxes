package com.bartoszwalter.students.wyjscie;

import com.bartoszwalter.students.umowa.IDrukowalny;

public class DrukarkaDanych {

    public static void wyswietl(IDrukowalny drukowalny)
    {
       drukowalny.zwrocParametry().forEach( (k,v)-> {System.out.print(k + "\t"); System.out.println(v);} );
    }
}
