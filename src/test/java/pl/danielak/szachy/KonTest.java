package pl.danielak.szachy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KonTest {

    Kon kon;
    Kon konObcy;

    @Test
    void getRodzajFigury() {
        Given:
        kon = new Kon();
        RodzajFigury result;
        When:
        result = kon.getRodzajFigury();
        Then:
        assertEquals(result, RodzajFigury.KON);
    }

    @Test
    void podajMozliweRuchyKonStoiNaSrodkuPrzyPustejSzachownicy() {
        Given:
        kon = new Kon();
        int x = 4;
        int y = 4;
        kon.setPolozenieX(x);
        kon.setPolozenieY(y);
        kon.setKolor(Kolor.BIALY);
        Szachownica szachownica;
        szachownica = new Szachownica();
        szachownica.getFigury().add(kon);
        List<ParametryPola> result;
        When:
        result = kon.podajMozliweRuchy(szachownica);
        Then:
        assertEquals(8, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x + 1, y + 2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x - 1, y + 2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x + 2, y + 1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x - 2, y + 1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x - 1, y - 2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x + 1, y - 2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x + 2, y - 1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x - 2, y - 1, false));
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
    void podajMozliweRuchyKonStoiWPierwszymRzedziePrzyPustejSzachownicy() {
        Given:
        kon = new Kon();
        int x = 4;
        int y = 0;
        kon.setPolozenieX(x);
        kon.setPolozenieY(y);
        kon.setKolor(Kolor.BIALY);
        Szachownica szachownica;
        szachownica = new Szachownica();
        szachownica.getFigury().add(kon);
        List<ParametryPola> result;
        When:
        result = kon.podajMozliweRuchy(szachownica);
        Then:
        assertEquals(4, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y+1, false));
    }
    @Test
    void podajMozliweRuchyKonStoiNaSrodkuInnaFiguraTegoSamegoKoloruNaLiniBicia() {
        Given:
        kon = new Kon();
        int x = 4;
        int y = 4;
        kon.setPolozenieX(x);
        kon.setPolozenieY(y);
        kon.setKolor(Kolor.BIALY);
        konObcy = new Kon();
        konObcy.setPolozenieX(x+2);
        konObcy.setPolozenieY(y+1);
        konObcy.setKolor(Kolor.BIALY);
        Szachownica szachownica;
        szachownica = new Szachownica();
        szachownica.getFigury().add(kon);
        szachownica.getFigury().add(konObcy);
        List<ParametryPola> result;
        When:
        result = kon.podajMozliweRuchy(szachownica);
        Then:
        assertEquals(7, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x + 1, y + 2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x - 1, y + 2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x - 2, y + 1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x - 1, y - 2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x + 1, y - 2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x + 2, y - 1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x - 2, y - 1, false));
    }

    @Test
    void podajMozliweRuchyKonStoiNaSrodkuInnaFiguraInnegoKoloruNaLiniBicia() {
        Given:
        kon = new Kon();
        int x = 4;
        int y = 4;
        kon.setPolozenieX(x);
        kon.setPolozenieY(y);
        kon.setKolor(Kolor.BIALY);
        konObcy = new Kon();
        konObcy.setPolozenieX(x+2);
        konObcy.setPolozenieY(y+1);
        konObcy.setKolor(Kolor.CZARNY);
        Szachownica szachownica;
        szachownica = new Szachownica();
        szachownica.getFigury().add(kon);
        szachownica.getFigury().add(konObcy);
        List<ParametryPola> result;
        When:
        result = kon.podajMozliweRuchy(szachownica);
        Then:
        assertEquals(8, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x + 1, y + 2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x - 1, y + 2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x - 2, y + 1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x - 1, y - 2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x + 1, y - 2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x + 2, y - 1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x - 2, y - 1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x + 2, y + 1, true));

    }

}
