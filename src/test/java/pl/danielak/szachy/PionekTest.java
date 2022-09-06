package pl.danielak.szachy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PionekTest {

    Pionek pionek;
    Pionek pionekObcy;

    @Test
    void getRodzajFigury() {
        Given:
            pionek = new Pionek();
            RodzajFigury result;
        When:
            result = pionek.getRodzajFigury();
        Then:
            assertEquals(result, RodzajFigury.PIONEK);
    }

    @Test
    void podajMozliweRuchyPionekStoiNaSrodkuPrzyPustejSzachownicy() {
        Given:
            pionek = new Pionek();
            int x = 4;
            int y = 4;
            pionek.setPolozenieX(x);
            pionek.setPolozenieY(y);
            pionek.setKolor(Kolor.BIALY);
            Szachownica szachownica;
            szachownica = new Szachownica();
            szachownica.getFigury().add(pionek);
            pionek.setSzachownica(szachownica);
            List<ParametryPola> result;
        When:
            result = pionek.podajMozliweRuchy();
        Then:
            assertEquals(1, result.size());
            assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+1, false));
    }

    private boolean sprawdzCzyListaZawieraElement (List<ParametryPola> lista, int polozenieX, int polozenieY, boolean zajetePole) {
        for (int i = 0; i < lista.size(); i = i + 1) {
            int x = lista.get(i).getPolozenieX();
            int y = lista.get(i).getPolozenieY();
            boolean zajete = lista.get(i).isZajete();
            if(polozenieX==x && polozenieY==y && zajetePole==zajete){
                return true;
            }
        }
        return false;
    }
    @Test
    void podajMozliweRuchyPionekStoiWDrugimRzedziePrzyPustejSzachownicy() {
        Given:
        pionek = new Pionek();
        int x = 4;
        int y = 1;
        pionek.setPolozenieX(x);
        pionek.setPolozenieY(y);
        pionek.setKolor(Kolor.BIALY);
        Szachownica szachownica;
        szachownica = new Szachownica();
        szachownica.getFigury().add(pionek);
        pionek.setSzachownica(szachownica);
        List<ParametryPola> result;
        When:
        result = pionek.podajMozliweRuchy();
        Then:
        assertEquals(2, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+2, false));
    }

    @Test
    void podajMozliweRuchyPionekStoiWOstatnimRzedzieNaPustejSzachownicy() {
        Given:
        pionek = new Pionek();
        int x = 4;
        int y = 7;
        pionek.setPolozenieX(x);
        pionek.setPolozenieY(y);
        pionek.setKolor(Kolor.BIALY);
        Szachownica szachownica;
        szachownica = new Szachownica();
        szachownica.getFigury().add(pionek);
        pionek.setSzachownica(szachownica);
        List<ParametryPola> result;
        When:
        result = pionek.podajMozliweRuchy();
        Then:
        assertEquals(0, result.size());
    }

    @Test
    void podajMozliweRuchyPionekStoiNaSrodkuInnaFiguraTegoSamegoKoloruPrzedNim() {
        Given:
        pionek = new Pionek();
        int x = 4;
        int y = 3;
        pionek.setPolozenieX(x);
        pionek.setPolozenieY(y);
        pionek.setKolor(Kolor.BIALY);
        pionekObcy = new Pionek();
        pionekObcy.setPolozenieX(x);
        pionekObcy.setPolozenieY(y+1);
        pionekObcy.setKolor(Kolor.BIALY);
        Szachownica szachownica;
        szachownica = new Szachownica();
        pionek.setSzachownica(szachownica);
        pionekObcy.setSzachownica(szachownica);
        szachownica.getFigury().add(pionek);
        szachownica.getFigury().add(pionekObcy);
        List<ParametryPola> result;
        When:
        result = pionek.podajMozliweRuchy();
        Then:
        assertEquals(0, result.size());
    }

    @Test
    void podajMozliweRuchyPionekStoiNaSrodkuInnaFiguraInnegoKoloruPrzedNim() {
        Given:
        pionek = new Pionek();
        int x = 4;
        int y = 3;
        pionek.setPolozenieX(x);
        pionek.setPolozenieY(y);
        pionek.setKolor(Kolor.BIALY);
        pionekObcy = new Pionek();
        pionekObcy.setPolozenieX(x);
        pionekObcy.setPolozenieY(y+1);
        pionekObcy.setKolor(Kolor.CZARNY);
        Szachownica szachownica;
        szachownica = new Szachownica();
        pionek.setSzachownica(szachownica);
        pionekObcy.setSzachownica(szachownica);
        szachownica.getFigury().add(pionek);
        szachownica.getFigury().add(pionekObcy);
        List<ParametryPola> result;
        When:
        result = pionek.podajMozliweRuchy();
        Then:
        assertEquals(0, result.size());
    }

    @Test
    void podajMozliweRuchyPionekStoiWDrugimRzedzieInnaFiguraTegoSamegoKoloruPrzedNim() {
        Given:
        pionek = new Pionek();
        int x = 4;
        int y = 1;
        pionek.setPolozenieX(x);
        pionek.setPolozenieY(y);
        pionek.setKolor(Kolor.BIALY);
        pionekObcy = new Pionek();
        pionekObcy.setPolozenieX(x);
        pionekObcy.setPolozenieY(y+1);
        pionekObcy.setKolor(Kolor.BIALY);
        Szachownica szachownica;
        szachownica = new Szachownica();
        pionek.setSzachownica(szachownica);
        pionekObcy.setSzachownica(szachownica);
        szachownica.getFigury().add(pionek);
        szachownica.getFigury().add(pionekObcy);
        List<ParametryPola> result;
        When:
        result = pionek.podajMozliweRuchy();
        Then:
        assertEquals(0, result.size());
    }

    @Test
    void podajMozliweRuchyPionekStoiWDrugimRzedzieInnaFiguraInnegoKoloruPrzedNim() {
        Given:
        pionek = new Pionek();
        int x = 4;
        int y = 1;
        pionek.setPolozenieX(x);
        pionek.setPolozenieY(y);
        pionek.setKolor(Kolor.BIALY);
        pionekObcy = new Pionek();
        pionekObcy.setPolozenieX(x);
        pionekObcy.setPolozenieY(y+1);
        pionekObcy.setKolor(Kolor.CZARNY);
        Szachownica szachownica;
        szachownica = new Szachownica();
        pionek.setSzachownica(szachownica);
        pionekObcy.setSzachownica(szachownica);
        szachownica.getFigury().add(pionek);
        szachownica.getFigury().add(pionekObcy);
        List<ParametryPola> result;
        When:
        result = pionek.podajMozliweRuchy();
        Then:
        assertEquals(0, result.size());
    }

    @Test
    void podajMozliweRuchyPionekStoiNaSrodkuInnaFiguraInnegoKoloruNaUkosPrzedNim() {
        Given:
        pionek = new Pionek();
        int x = 4;
        int y = 3;
        pionek.setPolozenieX(x);
        pionek.setPolozenieY(y);
        pionek.setKolor(Kolor.BIALY);
        pionekObcy = new Pionek();
        pionekObcy.setPolozenieX(x+1);
        pionekObcy.setPolozenieY(y+1);
        pionekObcy.setKolor(Kolor.CZARNY);
        Szachownica szachownica;
        szachownica = new Szachownica();
        pionek.setSzachownica(szachownica);
        pionekObcy.setSzachownica(szachownica);
        szachownica.getFigury().add(pionek);
        szachownica.getFigury().add(pionekObcy);
        List<ParametryPola> result;
        When:
        result = pionek.podajMozliweRuchy();
        Then:
        assertEquals(2, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y+1, true));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+1, false));
    }

    @Test
    void podajMozliweRuchyPionekStoiNaSrodkuInnaFiguraTegoSamegoKoloruNaUkosPrzedNim() {
        Given:
        pionek = new Pionek();
        int x = 4;
        int y = 3;
        pionek.setPolozenieX(x);
        pionek.setPolozenieY(y);
        pionek.setKolor(Kolor.BIALY);
        pionekObcy = new Pionek();
        pionekObcy.setPolozenieX(x+1);
        pionekObcy.setPolozenieY(y+1);
        pionekObcy.setKolor(Kolor.BIALY);
        Szachownica szachownica;
        szachownica = new Szachownica();
        pionek.setSzachownica(szachownica);
        pionekObcy.setSzachownica(szachownica);
        szachownica.getFigury().add(pionek);
        szachownica.getFigury().add(pionekObcy);
        List<ParametryPola> result;
        When:
        result = pionek.podajMozliweRuchy();
        Then:
        assertEquals(1, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+1, false));
    }

    @Test
    void czarnyPionekPodajMozliweRuchyPionekStoiNaSrodkuPustejSzachownicy (){
        Given:
        pionek = new Pionek();
        int x = 3;
        int y = 3;
        pionek.setKolor(Kolor.CZARNY);
        pionek.setPolozenieY(y);
        pionek.setPolozenieX(x);
        Szachownica szachownica;
        szachownica = new Szachownica();
        pionek.setSzachownica(szachownica);
        szachownica.getFigury().add(pionek);
        List<ParametryPola> result;
        When:
        result = pionek.podajMozliweRuchy();
        Then:
        assertEquals(1, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-1, false));
    }
    @Test
    void czarnyPionekPodajMozliweRuchyPionekStoiWPrzedOstatnimRzedziePrzyPustejSzachownicy() {
        Given:
        pionek = new Pionek();
        int x = 4;
        int y = 6;
        pionek.setPolozenieX(x);
        pionek.setPolozenieY(y);
        pionek.setKolor(Kolor.CZARNY);
        Szachownica szachownica;
        szachownica = new Szachownica();
        pionek.setSzachownica(szachownica);
        szachownica.getFigury().add(pionek);
        List<ParametryPola> result;
        When:
        result = pionek.podajMozliweRuchy();
        Then:
        assertEquals(2, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-2, false));
    }

    @Test
    void czarnyPionekPodajMozliweRuchyPionekStoiWPierwszymRzedzieNaPustejSzachownicy() {
        Given:
        pionek = new Pionek();
        int x = 4;
        int y = 0;
        pionek.setPolozenieX(x);
        pionek.setPolozenieY(y);
        pionek.setKolor(Kolor.CZARNY);
        Szachownica szachownica;
        szachownica = new Szachownica();
        pionek.setSzachownica(szachownica);
        szachownica.getFigury().add(pionek);
        List<ParametryPola> result;
        When:
        result = pionek.podajMozliweRuchy();
        Then:
        assertEquals(0, result.size());
    }
    @Test
    void czarnyPionekPodajMozliweRuchyPionekStoiNaSrodkuInnaFiguraTegoSamegoKoloruZaNim() {
        Given:
        pionek = new Pionek();
        int x = 4;
        int y = 3;
        pionek.setPolozenieX(x);
        pionek.setPolozenieY(y);
        pionek.setKolor(Kolor.CZARNY);
        pionekObcy = new Pionek();
        pionekObcy.setPolozenieX(x);
        pionekObcy.setPolozenieY(y-1);
        pionekObcy.setKolor(Kolor.CZARNY);
        Szachownica szachownica;
        szachownica = new Szachownica();
        pionek.setSzachownica(szachownica);
        pionekObcy.setSzachownica(szachownica);
        szachownica.getFigury().add(pionek);
        szachownica.getFigury().add(pionekObcy);
        List<ParametryPola> result;
        When:
        result = pionek.podajMozliweRuchy();
        Then:
        assertEquals(0, result.size());
    }

    @Test
    void czarnyPionekPodajMozliweRuchyPionekStoiNaSrodkuInnaFiguraInnegoKoloruZaNim() {
        Given:
        pionek = new Pionek();
        int x = 4;
        int y = 3;
        pionek.setPolozenieX(x);
        pionek.setPolozenieY(y);
        pionek.setKolor(Kolor.CZARNY);
        pionekObcy = new Pionek();
        pionekObcy.setPolozenieX(x);
        pionekObcy.setPolozenieY(y-1);
        pionekObcy.setKolor(Kolor.BIALY);
        Szachownica szachownica;
        szachownica = new Szachownica();
        pionek.setSzachownica(szachownica);
        pionekObcy.setSzachownica(szachownica);
        szachownica.getFigury().add(pionek);
        szachownica.getFigury().add(pionekObcy);
        List<ParametryPola> result;
        When:
        result = pionek.podajMozliweRuchy();
        Then:
        assertEquals(0, result.size());
    }
    @Test
    void czarnyPionekPodajMozliweRuchyPionekStoiWPrzedOststnimRzedzieInnaFiguraTegoSamegoKoloruZaNim() {
        Given:
        pionek = new Pionek();
        int x = 4;
        int y = 6;
        pionek.setPolozenieX(x);
        pionek.setPolozenieY(y);
        pionek.setKolor(Kolor.CZARNY);
        pionekObcy = new Pionek();
        pionekObcy.setPolozenieX(x);
        pionekObcy.setPolozenieY(y-1);
        pionekObcy.setKolor(Kolor.CZARNY);
        Szachownica szachownica;
        szachownica = new Szachownica();
        pionek.setSzachownica(szachownica);
        pionekObcy.setSzachownica(szachownica);
        szachownica.getFigury().add(pionek);
        szachownica.getFigury().add(pionekObcy);
        List<ParametryPola> result;
        When:
        result = pionek.podajMozliweRuchy();
        Then:
        assertEquals(0, result.size());
    }

    @Test
    void czarnyPionekPodajMozliweRuchyPionekStoiWPrzedOstatnimRzedzieInnaFiguraInnegoKoloruZaNim() {
        Given:
        pionek = new Pionek();
        int x = 4;
        int y = 6;
        pionek.setPolozenieX(x);
        pionek.setPolozenieY(y);
        pionek.setKolor(Kolor.CZARNY);
        pionekObcy = new Pionek();
        pionekObcy.setPolozenieX(x);
        pionekObcy.setPolozenieY(y-1);
        pionekObcy.setKolor(Kolor.BIALY);
        Szachownica szachownica;
        szachownica = new Szachownica();
        pionek.setSzachownica(szachownica);
        pionekObcy.setSzachownica(szachownica);
        szachownica.getFigury().add(pionek);
        szachownica.getFigury().add(pionekObcy);
        List<ParametryPola> result;
        When:
        result = pionek.podajMozliweRuchy();
        Then:
        assertEquals(0, result.size());
    }
    @Test
    void czarnyPionekPodajMozliweRuchyPionekStoiNaSrodkuInnaFiguraInnegoKoloruNaUkosZaNim() {
        Given:
        pionek = new Pionek();
        int x = 4;
        int y = 3;
        pionek.setPolozenieX(x);
        pionek.setPolozenieY(y);
        pionek.setKolor(Kolor.CZARNY);
        pionekObcy = new Pionek();
        pionekObcy.setPolozenieX(x-1);
        pionekObcy.setPolozenieY(y-1);
        pionekObcy.setKolor(Kolor.BIALY);
        Szachownica szachownica;
        szachownica = new Szachownica();
        pionek.setSzachownica(szachownica);
        pionekObcy.setSzachownica(szachownica);
        szachownica.getFigury().add(pionek);
        szachownica.getFigury().add(pionekObcy);
        List<ParametryPola> result;
        When:
        result = pionek.podajMozliweRuchy();
        Then:
        assertEquals(2, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y-1, true));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-1, false));
    }

    @Test
    void czarnyPionekPodajMozliweRuchyPionekStoiNaSrodkuInnaFiguraTegoSamegoKoloruNaUkosZaNim() {
        Given:
        pionek = new Pionek();
        int x = 4;
        int y = 3;
        pionek.setPolozenieX(x);
        pionek.setPolozenieY(y);
        pionek.setKolor(Kolor.CZARNY);
        pionekObcy = new Pionek();
        pionekObcy.setPolozenieX(x-1);
        pionekObcy.setPolozenieY(y-1);
        pionekObcy.setKolor(Kolor.CZARNY);
        Szachownica szachownica;
        szachownica = new Szachownica();
        pionek.setSzachownica(szachownica);
        pionekObcy.setSzachownica(szachownica);
        szachownica.getFigury().add(pionek);
        szachownica.getFigury().add(pionekObcy);
        List<ParametryPola> result;
        When:
        result = pionek.podajMozliweRuchy();
        Then:
        assertEquals(1, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-1, false));
    }







}