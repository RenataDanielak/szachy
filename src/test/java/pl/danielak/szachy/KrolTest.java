package pl.danielak.szachy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KrolTest {
    Krol krol;
    Wieza wieza;
    Pionek pionek;
    Pionek pionekPrzeciwnegoKoloru;

    @Test
    void getRodzajFigury() {
        Given:
        krol = new Krol();
        RodzajFigury result;
        When:
        result = krol.getRodzajFigury();
        Then:
        assertEquals(result, RodzajFigury.KROL);
    }
    private boolean sprawdzCzyListaZawieraElement(List<ParametryPola> lista, int polozenieX, int polozenieY, boolean zajetePole) {
        for (int i = 0; i < lista.size(); i = i + 1) {
            int x = lista.get(i).getPolozenieX();
            int y = lista.get(i).getPolozenieY();
            boolean zajete = lista.get(i).isZajete();
            if (polozenieX == x && polozenieY == y && zajetePole == zajete) {
                return true;
            }
        }
        return false;
    }
    @Test
    void podajMozliweRuchyKonStoiNaSrodkuPrzyPustejSzachownicy() {
        Given:
        krol = new Krol();
        int x = 4;
        int y = 4;
        krol.setPolozenieX(x);
        krol.setPolozenieY(y);
        krol.setKolor(Kolor.BIALY);
        Szachownica szachownica;
        szachownica = new Szachownica();
        szachownica.getFigury().add(krol);
        krol.setSzachownica(szachownica);
        List<ParametryPola> result;
        When:
        result = krol.podajMozliweRuchy();
        Then:
        assertEquals(8, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x + 1, y + 1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x - 1, y + 1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x , y + 1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x - 1, y , false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x + 1, y , false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x + 1, y - 1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x - 1, y - 1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x , y - 1, false));
        assertEquals(true, result.contains(new ParametryPola(x+1, y+1, false)) );
    }

    @Test
    void podajMozliweRuchyKrolStoiWPierwszymRzedziePrzyPustejSzachownicy() {
        Given:
        krol = new Krol();
        int x = 4;
        int y = 0;
        krol.setPolozenieX(x);
        krol.setPolozenieY(y);
        krol.setKolor(Kolor.BIALY);
        Szachownica szachownica;
        szachownica = new Szachownica();
        szachownica.getFigury().add(krol);
        krol.setSzachownica(szachownica);
        List<ParametryPola> result;
        When:
        result = krol.podajMozliweRuchy();
        Then:
        assertEquals(5, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+1, false));
    }

    @Test
    void podajMozliweRuchyKrolStoiNaSrodkuInnaFiguraTegoSamegoKoloruNaLiniBicia() {
        Given:
        krol = new Krol();
        wieza = new Wieza();
        int y = 4;
        int x = 4;
        Szachownica szachownica;
        szachownica = new Szachownica();
        krol.setSzachownica(szachownica);
        wieza.setSzachownica(szachownica);
        szachownica.getFigury().add(krol);
        szachownica.getFigury().add(wieza);
        krol.setPolozenieX(x);
        krol.setPolozenieY(y);
        krol.setKolor(Kolor.BIALY);
        wieza.setPolozenieX(x);
        wieza.setPolozenieY(y-1);
        wieza.setKolor(Kolor.BIALY);
        List <ParametryPola> result;
        When:
        result = krol.podajMozliweRuchy();
        Then:
        assertEquals(7, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x + 1, y + 1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x - 1, y + 1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x , y + 1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x - 1, y , false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x + 1, y , false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x + 1, y - 1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x - 1, y - 1, false));
        assertEquals(true, result.contains(new ParametryPola(x+1, y+1, false)) );
    }

    @Test
    void podajMozliweRuchyKrolStoiNaSrodkuInnaFiguraInnegoKoloruNaLiniBicia() {
        Given:
        krol = new Krol();
        pionekPrzeciwnegoKoloru = new Pionek();
        int y = 4;
        int x = 4;
        Szachownica szachownica;
        szachownica = new Szachownica();
        krol.setSzachownica(szachownica);
        pionekPrzeciwnegoKoloru.setSzachownica(szachownica);
        szachownica.getFigury().add(krol);
        szachownica.getFigury().add(pionekPrzeciwnegoKoloru);
        krol.setPolozenieX(x);
        krol.setPolozenieY(y);
        krol.setKolor(Kolor.BIALY);
        pionekPrzeciwnegoKoloru.setPolozenieX(x);
        pionekPrzeciwnegoKoloru.setPolozenieY(y-1);
        pionekPrzeciwnegoKoloru.setKolor(Kolor.CZARNY);
        List <ParametryPola> result;
        When:
        result = krol.podajMozliweRuchy();
        Then:
        assertEquals(8, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x + 1, y + 1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x + 1, y - 1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x - 1, y + 1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x , y + 1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x - 1, y , false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x + 1, y , false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x + 1, y - 1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x - 1, y - 1, false));
        assertEquals(true, result.contains(new ParametryPola(x+1, y+1, false)) );
    }

    @Test
    void podajMozliweRuchyZUwzglednieniemRoszadyWszystkieWarunkiSpelnione() {
        Given:
        krol = new Krol();
        wieza = new Wieza();
        int y = 0;
        int x = 4;
        Szachownica szachownica;
        szachownica = new Szachownica();
        krol.setSzachownica(szachownica);
        wieza.setSzachownica(szachownica);
        szachownica.getFigury().add(krol);
        szachownica.getFigury().add(wieza);
        krol.setPolozenieX(x);
        krol.setPolozenieY(y);
        krol.setKolor(Kolor.BIALY);
        krol.setNumerRuchuKrola(0);
        wieza.setPolozenieX(x+3);
        wieza.setPolozenieY(y);
        wieza.setKolor(Kolor.BIALY);
        wieza.setNumerRuchuWiezy(0);
        List <ParametryPola> result;
        When:
        result = krol.podajMozliweRuchy();
        Then:
        assertEquals(6, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y, false));
    }

    @Test
    void podajMozliweRuchyZUwzglednieniemRoszadyZamiastWiezyStoiPionek() {
        Given:
        krol = new Krol();
        pionek = new Pionek();
        int y = 0;
        int x = 4;
        Szachownica szachownica;
        szachownica = new Szachownica();
        krol.setSzachownica(szachownica);
        pionek.setSzachownica(szachownica);
        szachownica.getFigury().add(krol);
        szachownica.getFigury().add(pionek);
        krol.setPolozenieX(x);
        krol.setPolozenieY(y);
        krol.setKolor(Kolor.BIALY);
        krol.setNumerRuchuKrola(0);
        pionek.setPolozenieX(x+3);
        pionek.setPolozenieY(y);
        pionek.setKolor(Kolor.BIALY);
        List <ParametryPola> result;
        When:
        result = krol.podajMozliweRuchy();
        Then:
        assertEquals(5, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+1, false));
    }



    @Test
    void podajMozliweRuchyZUwzglednieniemRoszadyWiezaWykonalaJuzRuch() {
        Given:
        krol = new Krol();
        wieza = new Wieza();
        int y = 0;
        int x = 4;
        Szachownica szachownica;
        szachownica = new Szachownica();
        krol.setSzachownica(szachownica);
        wieza.setSzachownica(szachownica);
        szachownica.getFigury().add(krol);
        szachownica.getFigury().add(wieza);
        krol.setPolozenieX(x);
        krol.setPolozenieY(y);
        krol.setKolor(Kolor.BIALY);
        krol.setNumerRuchuKrola(0);
        wieza.setPolozenieX(x+3);
        wieza.setPolozenieY(y);
        wieza.setKolor(Kolor.BIALY);
        wieza.setNumerRuchuWiezy(1);
        List <ParametryPola> result;
        When:
        result = krol.podajMozliweRuchy();
        Then:
        assertEquals(5, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+1, false));
    }

    @Test
    void podajMozliweRuchyZUwzglednieniemRoszadyKrolWykonalJuzRuch() {
        Given:
        krol = new Krol();
        wieza = new Wieza();
        int y = 0;
        int x = 4;
        Szachownica szachownica;
        szachownica = new Szachownica();
        krol.setSzachownica(szachownica);
        wieza.setSzachownica(szachownica);
        szachownica.getFigury().add(krol);
        szachownica.getFigury().add(wieza);
        krol.setPolozenieX(x);
        krol.setPolozenieY(y);
        krol.setKolor(Kolor.BIALY);
        krol.setNumerRuchuKrola(1);
        wieza.setPolozenieX(x+3);
        wieza.setPolozenieY(y);
        wieza.setKolor(Kolor.BIALY);
        wieza.setNumerRuchuWiezy(0);
        List <ParametryPola> result;
        When:
        result = krol.podajMozliweRuchy();
        Then:
        assertEquals(5, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+1, false));
    }

    @Test
    void podajMozliweRuchyZUwzglednieniemRoszadyPomiedzyKrolemAWiezaStoiInnaFigura() {
        Given:
        krol = new Krol();
        wieza = new Wieza();
        pionek = new Pionek();
        int y = 0;
        int x = 4;
        Szachownica szachownica;
        szachownica = new Szachownica();
        krol.setSzachownica(szachownica);
        wieza.setSzachownica(szachownica);
        pionek.setSzachownica(szachownica);
        szachownica.getFigury().add(krol);
        szachownica.getFigury().add(wieza);
        szachownica.getFigury().add(pionek);
        krol.setPolozenieX(x);
        krol.setPolozenieY(y);
        krol.setKolor(Kolor.BIALY);
        krol.setNumerRuchuKrola(0);
        wieza.setPolozenieX(x+3);
        wieza.setPolozenieY(y);
        wieza.setKolor(Kolor.BIALY);
        wieza.setNumerRuchuWiezy(0);
        pionek.setPolozenieX(x+1);
        pionek.setPolozenieY(y);
        pionek.setKolor(Kolor.BIALY);
        List <ParametryPola> result;
        When:
        result = krol.podajMozliweRuchy();
        Then:
        assertEquals(4, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+1, false));
    }
}
