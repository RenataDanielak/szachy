package pl.danielak.szachy;

import pl.danielak.szachy.dto.ParametryPolaDto;

import java.util.ArrayList;
import java.util.List;

public class Pionek extends Figura {

    public Pionek() {
        setRodzajFigury(RodzajFigury.PIONEK);
    }

    @Override
    public List<ParametryPola> podajMozliweRuchy(Szachownica szachownica) {
        List<ParametryPola> lista;
        lista = new ArrayList<>();
        int polozenieX = getPolozenieX();
        int polozenieY = getPolozenieY();
        if (getKolor() == Kolor.BIALY){
            if (getPolozenieY() == 7){
                return null;
            }
           Kolor pytany = kolorFiguryNaPolu(szachownica,polozenieX,polozenieY+1);
            if( pytany == null) {
                ParametryPola polozenieKoncowe = new ParametryPola(getPolozenieX(), getPolozenieY() + 1, false);
                lista.add(polozenieKoncowe);
                if (polozenieY == 1) {
                    Kolor pytany1 = kolorFiguryNaPolu(szachownica, polozenieX, polozenieY + 2);
                    if (pytany1 == null) {
                        ParametryPola polozenieKoncowe1 = new ParametryPola(getPolozenieX(), getPolozenieY() + 2, false);
                        lista.add(polozenieKoncowe1);
                    }
                }
            }
            Kolor bicia = kolorFiguryNaPolu(szachownica,polozenieX+1,polozenieY+1);
            if (bicia == Kolor.CZARNY){
                ParametryPola bicie = new ParametryPola(getPolozenieX()+1, getPolozenieY() + 1, true);
                lista.add(bicie);
            }
            Kolor bicia1 = kolorFiguryNaPolu(szachownica,polozenieX-1,polozenieY+1);
            if (bicia1 == Kolor.CZARNY){
                ParametryPola bicie1 = new ParametryPola(getPolozenieX()-1, getPolozenieY() + 1, true);
                lista.add(bicie1);
            }
        }

        if (getKolor() == Kolor.CZARNY) {
            if (getPolozenieY() == 0) {
                return null;
            }
            Kolor pytany = kolorFiguryNaPolu(szachownica, polozenieX, polozenieY - 1);
            if (pytany == null) {
                ParametryPola polozenieKoncowe = new ParametryPola(getPolozenieX(), getPolozenieY() - 1, false);
                lista.add(polozenieKoncowe);
                if (polozenieY == 6) {
                    Kolor pytany1 = kolorFiguryNaPolu(szachownica, polozenieX, polozenieY - 2);
                    if (pytany1 == null) {
                        ParametryPola polozenieKoncowe1 = new ParametryPola(getPolozenieX(), getPolozenieY() - 2, false);
                        lista.add(polozenieKoncowe1);
                    }
                }
            }
            Kolor bicia = kolorFiguryNaPolu(szachownica, polozenieX - 1, polozenieY - 1);
            if (bicia == Kolor.BIALY) {
                ParametryPola bicie = new ParametryPola(getPolozenieX() - 1, getPolozenieY() - 1, true);
                lista.add(bicie);
            }
            Kolor bicia1 = kolorFiguryNaPolu(szachownica, polozenieX + 1, polozenieY - 1);
            if (bicia1 == Kolor.BIALY) {
                ParametryPola bicie1 = new ParametryPola(getPolozenieX() + 1, getPolozenieY() - 1, true);
                lista.add(bicie1);
            }
        }
        return lista;
    }


}
