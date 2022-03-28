package pl.danielak.szachy;

import java.util.ArrayList;
import java.util.List;

public class Figura {
    private int polozenieX;
    private int polozenieY;
    private boolean kolor;

    public int getPolozenieX() {
        return polozenieX;
    }

    public void setPolozenieX(int polozenieX) {
        this.polozenieX = polozenieX;
    }

    public int getPolozenieY() {
        return polozenieY;
    }

    public void setPolozenieY(int polozenieY) {
        this.polozenieY = polozenieY;
    }

    public boolean isKolor() {
        return kolor;
    }

    public void setKolor(boolean kolor) {
        this.kolor = kolor;
    }

    public List<ParametryPola> podajMozliweRuchy(Szachownica szachownica){
        List<ParametryPola> lista;
        lista = new ArrayList<>();
        return lista;
    }

}
