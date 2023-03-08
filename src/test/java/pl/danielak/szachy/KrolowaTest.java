package pl.danielak.szachy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KrolowaTest {

    Krolowa krolowaBiala;

    @Test
    void getRodzajFigury(){
        Given:
        krolowaBiala = new Krolowa();
        RodzajFigury result;
        When:
        result  = krolowaBiala.getRodzajFigury();
        Then:
        assertEquals(result, RodzajFigury.KROLOWA);
    }

    @Test
    void podajMozliweRuchyKrolowaStoiNaSrodkuPustejSzachownicy(){
        Given:
        krolowaBiala = new Krolowa();
        int x = 4;
        int y = 4;
        krolowaBiala.setKolor(Kolor.BIALY);
        krolowaBiala.setPolozenieY(y);
        krolowaBiala.setPolozenieX(x);
        Szachownica szachownica = new Szachownica();
        krolowaBiala.setSzachownica(szachownica);
        szachownica.getFigury().add(krolowaBiala);
        List<ParametryPola> result;
        When:
        result = krolowaBiala.podajMozliweRuchy();
        Then:
        assertEquals(27, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y+3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y-1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y-2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-3, y-3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-4, y-4, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y-1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y-2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y-3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-3, y+3, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-3, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-4, y, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+3, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-4, false));
    }

    private boolean sprawdzCzyListaZawieraElement (List<ParametryPola> lista, int polozenieX, int polozenieY, boolean zajetePole){
        for(int i = 0; i < lista.size(); i++){
            int x = lista.get(i).getPolozenieX();
            int y = lista.get(i).getPolozenieY();
            boolean zajete = lista.get(i).isZajete();
            if ( x == polozenieX && y == polozenieY && zajete == zajetePole){
                return true;
            }
        }
        return false;
    }

    @Test
    void podajMozliweRuchyKrolowaStoiNaPoczatkuPustejSzachownicy(){
        Given:
        krolowaBiala = new Krolowa();
        int x = 4;
        int y = 0;
        krolowaBiala.setKolor(Kolor.BIALY);
        krolowaBiala.setPolozenieY(y);
        krolowaBiala.setPolozenieX(x);
        Szachownica szachownica = new Szachownica();
        krolowaBiala.setSzachownica(szachownica);
        szachownica.getFigury().add(krolowaBiala);
        List<ParametryPola> result;
        When:
        result = krolowaBiala.podajMozliweRuchy();
        Then:
        assertEquals(21, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y+3, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-3, y+3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-4, y+4, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-3, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-4, y, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+4, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+5, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+6, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+7, false));
    }

    @Test
    void podajMozliweRuchyKrolowaStoiNaSrodkuSzachownicyInnaFiguraTegoSamegoKoloruPrzedNia(){
        Given:
        krolowaBiala = new Krolowa();
        Szachownica szachownica = new Szachownica();
        int x = 4;
        int y = 4;
        krolowaBiala.setKolor(Kolor.BIALY);
        krolowaBiala.setPolozenieY(y);
        krolowaBiala.setPolozenieX(x);
        krolowaBiala.setSzachownica(szachownica);
        Pionek pionekBialy = new Pionek();
        pionekBialy.setKolor(Kolor.BIALY);
        pionekBialy.setPolozenieY(5);
        pionekBialy.setPolozenieX(4);
        pionekBialy.setSzachownica(szachownica);
        szachownica.getFigury().add(krolowaBiala);
        szachownica.getFigury().add(pionekBialy);
        List<ParametryPola> result;
        When:
        result = krolowaBiala.podajMozliweRuchy();
        Then:
        assertEquals(24, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y+3, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y-1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y-2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-3, y-3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-4, y-4, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y-1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y-2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y-3, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-3, y+3, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-3, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-4, y, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-4, false));
    }

    @Test
    void podajMozliweRuchyKrolowaStoiNaSrodkuSzachownicyInnaFiguraInnegoKoloruPrzedNia(){
        Given:
        krolowaBiala = new Krolowa();
        Szachownica szachownica = new Szachownica();
        int x = 4;
        int y = 4;
        krolowaBiala.setKolor(Kolor.BIALY);
        krolowaBiala.setPolozenieY(y);
        krolowaBiala.setPolozenieX(x);
        krolowaBiala.setSzachownica(szachownica);
        Pionek pionekCzarny = new Pionek();
        pionekCzarny.setKolor(Kolor.CZARNY);
        pionekCzarny.setPolozenieY(5);
        pionekCzarny.setPolozenieX(4);
        pionekCzarny.setSzachownica(szachownica);
        szachownica.getFigury().add(krolowaBiala);
        szachownica.getFigury().add(pionekCzarny);
        List<ParametryPola> result;
        When:
        result = krolowaBiala.podajMozliweRuchy();
        Then:
        assertEquals(25, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y+3, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y-1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y-2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-3, y-3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-4, y-4, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y-1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y-2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y-3, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-3, y+3, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-3, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-4, y, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-4, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+1, true));

    }

    @Test
    void podajMozliweRuchyKrolowaStoiNaSrodkuSzachownicyInnaFiguraTegoSamegoKoloruNaLiniRuchu(){
        Given:
        krolowaBiala = new Krolowa();
        Szachownica szachownica = new Szachownica();
        int x = 4;
        int y = 4;
        krolowaBiala.setKolor(Kolor.BIALY);
        krolowaBiala.setPolozenieY(y);
        krolowaBiala.setPolozenieX(x);
        krolowaBiala.setSzachownica(szachownica);
        Pionek pionekBialy = new Pionek();
        pionekBialy.setKolor(Kolor.BIALY);
        pionekBialy.setPolozenieY(1);
        pionekBialy.setPolozenieX(1);
        pionekBialy.setSzachownica(szachownica);
        szachownica.getFigury().add(krolowaBiala);
        szachownica.getFigury().add(pionekBialy);
        List<ParametryPola> result;
        When:
        result = krolowaBiala.podajMozliweRuchy();
        Then:
        assertEquals(25, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y+3, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y-1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y-2, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y-1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y-2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y-3, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-3, y+3, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-3, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-4, y, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-4, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+3, false));
    }

    @Test
    void podajMozliweRuchyKrolowaStoiNaSrodkuSzachownicyInnaFiguraInnegoKoloruNaLiniRuchu(){
        Given:
        krolowaBiala = new Krolowa();
        Szachownica szachownica = new Szachownica();
        int x = 4;
        int y = 4;
        krolowaBiala.setKolor(Kolor.BIALY);
        krolowaBiala.setPolozenieY(y);
        krolowaBiala.setPolozenieX(x);
        krolowaBiala.setSzachownica(szachownica);
        Pionek pionekCzarny = new Pionek();
        pionekCzarny.setKolor(Kolor.CZARNY);
        pionekCzarny.setPolozenieY(1);
        pionekCzarny.setPolozenieX(1);
        pionekCzarny.setSzachownica(szachownica);
        szachownica.getFigury().add(krolowaBiala);
        szachownica.getFigury().add(pionekCzarny);
        List<ParametryPola> result;
        When:
        result = krolowaBiala.podajMozliweRuchy();
        Then:
        assertEquals(26, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y+3, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y-1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y-2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-3, y-3, true));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y-1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y-2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y-3, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-3, y+3, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-3, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-4, y, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-4, false));

        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+3, false));
    }
}
