package pl.danielak.szachy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

public class WiezaTest {

    Wieza wiezaBiala;

    @Test
    void getRodzajFigury(){
        Given:
        wiezaBiala = new Wieza();
        RodzajFigury result;
        When:
        result = wiezaBiala.getRodzajFigury();
        Then:
        assertEquals(result, RodzajFigury.WIEZA);
    }

    @Test
    void podajMozliweRuchyWiezaStoiNaSrodkuPustejSzachownicy(){
        Given:
        wiezaBiala = new Wieza();
        int x = 4;
        int y = 4;
        wiezaBiala.setKolor(Kolor.BIALY);
        wiezaBiala.setPolozenieY(y);
        wiezaBiala.setPolozenieX(x);
        wiezaBiala.setNumerRuchuWiezy(0);
        Szachownica szachownica = new Szachownica();
        wiezaBiala.setSzachownica(szachownica);
        szachownica.getFigury().add(wiezaBiala);
        List<ParametryPola>result;
        When:
        result = wiezaBiala.podajMozliweRuchy();
        Then:
        assertEquals(14, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-4, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-3, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-4, y, false));

    }

    private boolean sprawdzCzyListaZawieraElement (List<ParametryPola> lista, int polozenieX, int polozenieY, boolean zajetePole){
        for(int i = 0; i < lista.size(); i++){
            int x = lista.get(i).getPolozenieX();
            int y = lista.get(i).getPolozenieY();
            boolean zajete = lista.get(i).isZajete();
            if (x == polozenieX && y == polozenieY && zajete == zajetePole){
                return true;
            }
        }
        return false;
    }

    @Test
    void podajMozliweRuchyWiezaStoiNaPoczatkuPustejSzachownicy(){
        Given:
        wiezaBiala = new Wieza();
        int x = 4;
        int y = 0;
        wiezaBiala.setKolor(Kolor.BIALY);
        wiezaBiala.setPolozenieY(y);
        wiezaBiala.setPolozenieX(x);
        wiezaBiala.setNumerRuchuWiezy(0);
        Szachownica szachownica = new Szachownica();
        wiezaBiala.setSzachownica(szachownica);
        szachownica.getFigury().add(wiezaBiala);
        List<ParametryPola>result;
        When:
        result = wiezaBiala.podajMozliweRuchy();
        Then:
        assertEquals(14, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+4, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+5, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+6, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+7, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-3, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-4, y, false));

    }

    @Test
    void podajMozliweRuchyWiezaStoiNaSrodkuSzachownicyInnaFiguraTegoSamegoKoloruPrzedNia(){
        Given:
        wiezaBiala = new Wieza();
        Pionek pionekBialy = new Pionek();
        int x = 4;
        int y = 4;
        wiezaBiala.setKolor(Kolor.BIALY);
        wiezaBiala.setPolozenieY(y);
        wiezaBiala.setPolozenieX(x);
        wiezaBiala.setNumerRuchuWiezy(0);
        Szachownica szachownica = new Szachownica();
        wiezaBiala.setSzachownica(szachownica);
        pionekBialy.setSzachownica(szachownica);
        pionekBialy.setKolor(Kolor.BIALY);
        pionekBialy.setPolozenieY(y+1);
        pionekBialy.setPolozenieX(x);
        szachownica.getFigury().add(wiezaBiala);
        szachownica.getFigury().add(pionekBialy);
        List<ParametryPola>result;
        When:
        result = wiezaBiala.podajMozliweRuchy();
        Then:
        assertEquals(11, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-4, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-3, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-4, y, false));

    }

    @Test
    void podajMozliweRuchyWiezaStoiNaSrodkuSzachownicyInnaFiguraInnegoKoloruPrzedNia(){
        Given:
        wiezaBiala = new Wieza();
        Pionek pionekCzarny = new Pionek();
        int x = 4;
        int y = 4;
        wiezaBiala.setKolor(Kolor.BIALY);
        wiezaBiala.setPolozenieY(y);
        wiezaBiala.setPolozenieX(x);
        wiezaBiala.setNumerRuchuWiezy(0);
        Szachownica szachownica = new Szachownica();
        wiezaBiala.setSzachownica(szachownica);
        pionekCzarny.setSzachownica(szachownica);
        pionekCzarny.setKolor(Kolor.CZARNY);
        pionekCzarny.setPolozenieY(y+1);
        pionekCzarny.setPolozenieX(x);
        szachownica.getFigury().add(wiezaBiala);
        szachownica.getFigury().add(pionekCzarny);
        List<ParametryPola>result;
        When:
        result = wiezaBiala.podajMozliweRuchy();
        Then:
        assertEquals(12, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+1, true));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-4, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-3, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-4, y, false));

    }
    @Test
    void podajMozliweRuchyWiezaStoiNaSrodkuSzachownicyInnaFiguraInnegoKoloruDwaPolaWLewo(){
        Given:
        wiezaBiala = new Wieza();
        Pionek pionekCzarny = new Pionek();
        int x = 4;
        int y = 4;
        wiezaBiala.setKolor(Kolor.BIALY);
        wiezaBiala.setPolozenieY(y);
        wiezaBiala.setPolozenieX(x);
        wiezaBiala.setNumerRuchuWiezy(0);
        Szachownica szachownica = new Szachownica();
        wiezaBiala.setSzachownica(szachownica);
        pionekCzarny.setSzachownica(szachownica);
        pionekCzarny.setKolor(Kolor.CZARNY);
        pionekCzarny.setPolozenieY(y);
        pionekCzarny.setPolozenieX(x-2);
        szachownica.getFigury().add(wiezaBiala);
        szachownica.getFigury().add(pionekCzarny);
        List<ParametryPola>result;
        When:
        result = wiezaBiala.podajMozliweRuchy();
        Then:
        assertEquals(12, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-4, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-2, y, true));

    }

    @Test
    void podajMozliweRuchyWiezaStoiNaSrodkuSzachownicyInnaFiguraTegoSamegoKoloruDwaPolaWLewo(){
        Given:
        wiezaBiala = new Wieza();
        Pionek pionekBialy = new Pionek();
        int x = 4;
        int y = 4;
        wiezaBiala.setKolor(Kolor.BIALY);
        wiezaBiala.setPolozenieY(y);
        wiezaBiala.setPolozenieX(x);
        wiezaBiala.setNumerRuchuWiezy(0);
        Szachownica szachownica = new Szachownica();
        wiezaBiala.setSzachownica(szachownica);
        pionekBialy.setSzachownica(szachownica);
        pionekBialy.setKolor(Kolor.BIALY);
        pionekBialy.setPolozenieY(y);
        pionekBialy.setPolozenieX(x-2);
        szachownica.getFigury().add(wiezaBiala);
        szachownica.getFigury().add(pionekBialy);
        List<ParametryPola>result;
        When:
        result = wiezaBiala.podajMozliweRuchy();
        Then:
        assertEquals(11, result.size());
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y+3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-1, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-2, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-3, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x, y-4, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+1, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+2, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x+3, y, false));
        assertEquals(true, sprawdzCzyListaZawieraElement(result, x-1, y, false));
    }

}
