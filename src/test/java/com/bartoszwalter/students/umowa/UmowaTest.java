package com.bartoszwalter.students.umowa;

import com.bartoszwalter.students.wejscie.CzytnikDanych;
import com.bartoszwalter.students.wejscie.ICzytnik;
import com.bartoszwalter.students.wyjscie.DrukarkaDanych;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UmowaTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void umowaOPrace() throws Exception {
        CzytnikDanych czytnikDanych = Mockito.mock(CzytnikDanych.class);
        when(czytnikDanych.getUmowa()).thenReturn('P');
        when(czytnikDanych.getPodstawa()).thenReturn(1000d);

        Umowa umowa = FabrykaUmow.create(czytnikDanych);

        verify(czytnikDanych,times(1)).getUmowa();
        verify(czytnikDanych,times(1)).getPodstawa();
        Assert.assertTrue(umowa.calculate()==763.239);
    }

    @Test
    public void umowaZlecenie() throws Exception {
        CzytnikDanych czytnikDanych = Mockito.mock(CzytnikDanych.class);
        when(czytnikDanych.getUmowa()).thenReturn('Z');
        when(czytnikDanych.getPodstawa()).thenReturn(1000d);

        Umowa umowa = FabrykaUmow.create(czytnikDanych);

        verify(czytnikDanych,times(1)).getUmowa();
        verify(czytnikDanych,times(1)).getPodstawa();
        Assert.assertTrue(umowa.calculate()==728.239);
    }

}