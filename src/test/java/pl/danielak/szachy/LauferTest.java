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

}
