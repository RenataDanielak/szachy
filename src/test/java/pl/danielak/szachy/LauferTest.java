package pl.danielak.szachy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LauferTest {

    Laufer lauferBialy;

    @Test
    void getRodzajFigury(){
        Given:
        lauferBialy = new Laufer();
        RodzajFigury result;
        When:
        result  = lauferBialy.getRodzajFigury();
        Then:
        assertEquals(result, RodzajFigury.LAUFER);
    }

    @Test
    void podajMozliweRuchyLauferStoiNaSrodkuPustejSzachownicy(){
        Given:
        lauferBialy = new Laufer();
        int x = 4;
        int y = 4;
        lauferBialy.setKolor(Kolor.BIALY);
        lauferBialy.setPolozenieY(y);
        lauferBialy.setPolozenieX(x);
        Szachownica szachownica = new Szachownica();
        lauferBialy.setSzachownica(szachownica);
        szachownica.getFigury().add(lauferBialy);
        List<ParametryPola> result;
        When:
        result = lauferBialy.podajMozliweRuchy();
        Then:
        assertEquals(13, result.size());
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
    void podajMozliweRuchyLauferStoiNaPoczatkuPustejSzachownicy(){
        Given:
        lauferBialy = new Laufer();
        int x = 3;
        int y = 0;
        lauferBialy.setKolor(Kolor.BIALY);
        lauferBialy.setPolozenieY(y);
        lauferBialy.setPolozenieX(x);
        Szachownica szachownica = new Szachownica();
        lauferBialy.setSzachownica(szachownica);
        szachownica.getFigury().add(lauferBialy);
        List<ParametryPola> result;
        When:
        result = lauferBialy.podajMozliweRuchy();
        Then:
        assertEquals(7, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y+3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+4, y+4, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-3, y+3, false));
    }

    @Test
    void podajMozliweRuchyLauferStoiNaSzachownicyInnaFiguraTegoSamegoKoloruNaLiniRuchuObokLaufra(){
        Given:
        lauferBialy = new Laufer();
        Szachownica szachownica = new Szachownica();
        int x = 4;
        int y = 4;
        lauferBialy.setKolor(Kolor.BIALY);
        lauferBialy.setPolozenieY(y);
        lauferBialy.setPolozenieX(x);
        lauferBialy.setSzachownica(szachownica);
        Pionek pionekBialy = new Pionek();
        pionekBialy.setKolor(Kolor.BIALY);
        pionekBialy.setPolozenieX(3);
        pionekBialy.setPolozenieY(3);
        pionekBialy.setSzachownica(szachownica);
        szachownica.getFigury().add(lauferBialy);
        szachownica.getFigury().add(pionekBialy);
        List<ParametryPola> result;
        When:
        result = lauferBialy.podajMozliweRuchy();
        Then:
        assertEquals(9, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y+3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y-1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y-2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y-3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-3, y+3, false));
    }

    @Test
    void podajMozliweRuchyLauferStoiNaSzachownicyInnaFiguraInnegoKoloruNaLiniRuchuObokLaufra(){
        Given:
        lauferBialy = new Laufer();
        Szachownica szachownica = new Szachownica();
        int x = 4;
        int y = 4;
        lauferBialy.setKolor(Kolor.BIALY);
        lauferBialy.setPolozenieY(y);
        lauferBialy.setPolozenieX(x);
        lauferBialy.setSzachownica(szachownica);
        Pionek pionekCzarny = new Pionek();
        pionekCzarny.setKolor(Kolor.CZARNY);
        pionekCzarny.setPolozenieX(3);
        pionekCzarny.setPolozenieY(3);
        pionekCzarny.setSzachownica(szachownica);
        szachownica.getFigury().add(lauferBialy);
        szachownica.getFigury().add(pionekCzarny);
        List<ParametryPola> result;
        When:
        result = lauferBialy.podajMozliweRuchy();
        Then:
        assertEquals(10, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y+3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y-1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y-2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y-3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-3, y+3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y-1, true));

    }

    @Test
    void podajMozliweRuchyLauferStoiNaSzachownicyInnaFiguraTegoSamegoKoloruNaLiniRuchuParePolOdLaufra(){
        Given:
        lauferBialy = new Laufer();
        Szachownica szachownica = new Szachownica();
        int x = 4;
        int y = 4;
        lauferBialy.setKolor(Kolor.BIALY);
        lauferBialy.setPolozenieY(y);
        lauferBialy.setPolozenieX(x);
        lauferBialy.setSzachownica(szachownica);
        Pionek pionekBialy = new Pionek();
        pionekBialy.setKolor(Kolor.BIALY);
        pionekBialy.setPolozenieX(1);
        pionekBialy.setPolozenieY(1);
        pionekBialy.setSzachownica(szachownica);
        szachownica.getFigury().add(lauferBialy);
        szachownica.getFigury().add(pionekBialy);
        List<ParametryPola> result;
        When:
        result = lauferBialy.podajMozliweRuchy();
        Then:
        assertEquals(11, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y+3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y-1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y-2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y-3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-3, y+3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y-1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y-2, false));
    }

    @Test
    void podajMozliweRuchyLauferStoiNaSzachownicyInnaFiguraInnegoKoloruNaLiniRuchuParePolOdLaufra(){
        Given:
        lauferBialy = new Laufer();
        Szachownica szachownica = new Szachownica();
        int x = 4;
        int y = 4;
        lauferBialy.setKolor(Kolor.BIALY);
        lauferBialy.setPolozenieY(y);
        lauferBialy.setPolozenieX(x);
        lauferBialy.setSzachownica(szachownica);
        Pionek pionekCzarny = new Pionek();
        pionekCzarny.setKolor(Kolor.CZARNY);
        pionekCzarny.setPolozenieX(1);
        pionekCzarny.setPolozenieY(1);
        pionekCzarny.setSzachownica(szachownica);
        szachownica.getFigury().add(lauferBialy);
        szachownica.getFigury().add(pionekCzarny);
        List<ParametryPola> result;
        When:
        result = lauferBialy.podajMozliweRuchy();
        Then:
        assertEquals(12, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y+3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y-1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y-2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y-3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-3, y+3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y-1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y-2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-3, y-3, true));

    }


}
