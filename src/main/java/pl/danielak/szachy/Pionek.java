package pl.danielak.szachy;

import pl.danielak.szachy.dto.ParametryPolaDto;

import java.util.ArrayList;
import java.util.List;

public class Pionek extends Figura {

    @Override
    public RodzajFigury getRodzajFigury() {
        return RodzajFigury.PIONEK;
    }

    @Override
    public List<ParametryPola> podajMozliweRuchy() {
        List<ParametryPola> lista;
        lista = new ArrayList<>();
        int polozenieX = getPolozenieX();
        int polozenieY = getPolozenieY();
        if (getKolor() == Kolor.BIALY){
            if (getPolozenieY() == 7){
                return lista;
            }
           Kolor kolorInnejFigury = kolorFiguryNaPolu(polozenieX,polozenieY+1);
            if( kolorInnejFigury == null) {
                ParametryPola polozenieKoncowe = new ParametryPola(getPolozenieX(), getPolozenieY() + 1, false);
                lista.add(polozenieKoncowe);
                if (polozenieY == 1) {
                    Kolor kolorInnejFigury1 = kolorFiguryNaPolu(polozenieX, polozenieY + 2);
                    if (kolorInnejFigury1 == null) {
                        ParametryPola polozenieKoncowe1 = new ParametryPola(getPolozenieX(), getPolozenieY() + 2, false);
                        lista.add(polozenieKoncowe1);
                    }
                }
            }
            Kolor kolorPrzyBiciu = kolorFiguryNaPolu(polozenieX+1,polozenieY+1);
            if (kolorPrzyBiciu == Kolor.CZARNY){
                ParametryPola bicie = new ParametryPola(getPolozenieX()+1, getPolozenieY() + 1, true);
                lista.add(bicie);
            }
            Kolor kolorPrzyBiciu1 = kolorFiguryNaPolu(polozenieX-1,polozenieY+1);
            if (kolorPrzyBiciu1 == Kolor.CZARNY){
                ParametryPola bicie1 = new ParametryPola(getPolozenieX()-1, getPolozenieY() + 1, true);
                lista.add(bicie1);
            }
        }

        if (getKolor() == Kolor.CZARNY) {
            if (getPolozenieY() == 0) {
                return lista;
            }
            Kolor kolorInnejFigury = kolorFiguryNaPolu(polozenieX, polozenieY - 1);
            if (kolorInnejFigury == null) {
                ParametryPola polozenieKoncowe = new ParametryPola(getPolozenieX(), getPolozenieY() - 1, false);
                lista.add(polozenieKoncowe);
                if (polozenieY == 6) {
                    Kolor kolorInnejFigury1 = kolorFiguryNaPolu(polozenieX, polozenieY - 2);
                    if (kolorInnejFigury1 == null) {
                        ParametryPola polozenieKoncowe1 = new ParametryPola(getPolozenieX(), getPolozenieY() - 2, false);
                        lista.add(polozenieKoncowe1);
                    }
                }
            }
            Kolor kolorPrzyBiciu = kolorFiguryNaPolu(polozenieX - 1, polozenieY - 1);
            if (kolorPrzyBiciu == Kolor.BIALY) {
                ParametryPola bicie = new ParametryPola(getPolozenieX() - 1, getPolozenieY() - 1, true);
                lista.add(bicie);
            }
            Kolor kolorPrzyBiciu1 = kolorFiguryNaPolu(polozenieX + 1, polozenieY - 1);
            if (kolorPrzyBiciu1 == Kolor.BIALY) {
                ParametryPola bicie1 = new ParametryPola(getPolozenieX() + 1, getPolozenieY() - 1, true);
                lista.add(bicie1);
            }
        }
        return lista;
    }


}
