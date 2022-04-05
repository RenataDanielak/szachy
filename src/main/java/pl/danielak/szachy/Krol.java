package pl.danielak.szachy;

import java.util.ArrayList;
import java.util.List;

public class Krol extends Figura{
    public List<ParametryPola> podajMozliweRuchy(Szachownica szachownica) {
        List<ParametryPola> lista;
        lista = new ArrayList<>();
        Kolor kolorKrola = getKolor();
        int polozenieX = getPolozenieX();
        int polozenieY = getPolozenieY();
        Kolor kolorFiguryNaPolu = kolorFiguryNaPolu(szachownica,polozenieX,polozenieY+1);
        if( polozenieY<=6){
            if(kolorFiguryNaPolu == null){
                ParametryPola polozenieKoncoweYplus1 = new ParametryPola(getPolozenieX(), getPolozenieY() + 1, false);
                lista.add(polozenieKoncoweYplus1);
            }
            if(kolorFiguryNaPolu != kolorKrola) {
            ParametryPola polozenieKoncoweYplus1 = new ParametryPola(getPolozenieX(), getPolozenieY() + 1, true);
            lista.add(polozenieKoncoweYplus1);
            }
        }
        if (polozenieX<=6 && polozenieY<=6) {
            kolorFiguryNaPolu = kolorFiguryNaPolu(szachownica, polozenieX + 1, polozenieY + 1);
            if (kolorFiguryNaPolu == null) {
                ParametryPola polozenieKoncoweYplus1Xplus1 = new ParametryPola(getPolozenieX() + 1, getPolozenieY() + 1, false);
                lista.add(polozenieKoncoweYplus1Xplus1);
            }
            if(kolorFiguryNaPolu != kolorKrola){
                ParametryPola polozenieKoncoweYplus1Xplus1 = new ParametryPola(getPolozenieX() + 1, getPolozenieY() + 1, true);
                lista.add(polozenieKoncoweYplus1Xplus1);
            }
        }
        kolorFiguryNaPolu = kolorFiguryNaPolu(szachownica, polozenieX + 1, polozenieY);
        if (polozenieX<=6) {
            if (kolorFiguryNaPolu == null) {
                ParametryPola polozenieKoncoweXplus1 = new ParametryPola(getPolozenieX() + 1, getPolozenieY(), false);
                lista.add(polozenieKoncoweXplus1);
            }
             if(kolorFiguryNaPolu != kolorKrola){
                 ParametryPola polozenieKoncoweXplus1 = new ParametryPola(getPolozenieX() + 1, getPolozenieY(), true);
                 lista.add(polozenieKoncoweXplus1);
             }
        }
        if (polozenieX<7 && polozenieY>0) {
            kolorFiguryNaPolu = kolorFiguryNaPolu(szachownica, polozenieX + 1, polozenieY - 1);
            if (kolorFiguryNaPolu == null) {
                ParametryPola polozenieKoncoweYminus1Xplus1 = new ParametryPola(getPolozenieX() + 1, getPolozenieY() - 1, false);
                lista.add(polozenieKoncoweYminus1Xplus1);
            }
            if(kolorFiguryNaPolu != kolorKrola){
                ParametryPola polozenieKoncoweYminus1Xplus1 = new ParametryPola(getPolozenieX() + 1, getPolozenieY() - 1, true);
                lista.add(polozenieKoncoweYminus1Xplus1);
            }
        }
        kolorFiguryNaPolu = kolorFiguryNaPolu(szachownica,polozenieX,polozenieY-1);
        if( polozenieY>0) {
            if (kolorFiguryNaPolu == null) {
                ParametryPola polozenieKoncoweYminus1 = new ParametryPola(getPolozenieX(), getPolozenieY() - 1, false);
                lista.add(polozenieKoncoweYminus1);
            }
            if(kolorFiguryNaPolu != kolorKrola){
                ParametryPola polozenieKoncoweYminus1 = new ParametryPola(getPolozenieX(), getPolozenieY() - 1, true);
                lista.add(polozenieKoncoweYminus1);
            }
        }
        if (polozenieX >=1 && polozenieY > 0) {
            kolorFiguryNaPolu = kolorFiguryNaPolu(szachownica, polozenieX - 1, polozenieY - 1);
            if (kolorFiguryNaPolu == null) {
                ParametryPola polozenieKoncoweYminus1Xminus1 = new ParametryPola(getPolozenieX() - 1, getPolozenieY() - 1, false);
                lista.add(polozenieKoncoweYminus1Xminus1);
            }
            if(kolorFiguryNaPolu != kolorKrola){
                ParametryPola polozenieKoncoweYminus1Xminus1 = new ParametryPola(getPolozenieX() - 1, getPolozenieY() - 1, true);
                lista.add(polozenieKoncoweYminus1Xminus1);
            }
        }
        kolorFiguryNaPolu = kolorFiguryNaPolu(szachownica, polozenieX - 1, polozenieY);
        if (polozenieX >=1) {
            if (kolorFiguryNaPolu == null) {
                ParametryPola polozenieKoncoweXminus1 = new ParametryPola(getPolozenieX() - 1, getPolozenieY(), false);
                lista.add(polozenieKoncoweXminus1);
            }
            if (kolorFiguryNaPolu != kolorKrola){
                ParametryPola polozenieKoncoweXminus1 = new ParametryPola(getPolozenieX() - 1, getPolozenieY(), true);
                lista.add(polozenieKoncoweXminus1);
            }
        }
        if (polozenieX >0 && polozenieY<7) {
            kolorFiguryNaPolu = kolorFiguryNaPolu(szachownica, polozenieX - 1, polozenieY + 1);
            if (kolorFiguryNaPolu == null) {
                ParametryPola polozenieKoncoweYplus1Xminus1 = new ParametryPola(getPolozenieX() - 1, getPolozenieY() + 1, false);
                lista.add(polozenieKoncoweYplus1Xminus1);
            }
            if(kolorFiguryNaPolu != kolorKrola){
                ParametryPola polozenieKoncoweYplus1Xminus1 = new ParametryPola(getPolozenieX() - 1, getPolozenieY() + 1, true);
                lista.add(polozenieKoncoweYplus1Xminus1);
            }
        }
        return lista;
    }
}


