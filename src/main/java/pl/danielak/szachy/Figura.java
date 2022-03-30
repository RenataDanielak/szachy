package pl.danielak.szachy;

import java.util.ArrayList;
import java.util.List;

public class Figura {
    private int polozenieX;
    private int polozenieY;
    private Kolor kolor;

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

    public Kolor getKolor() {
        return kolor;
    }

    public void setKolor(Kolor kolor) {
        this.kolor = kolor;
    }

    public List<ParametryPola> podajMozliweRuchy(Szachownica szachownica){
        List<ParametryPola> lista;
        lista = new ArrayList<>();
        return lista;
    }
    protected Kolor kolorFiguryNaPolu (Szachownica szachownica, int polozenieX, int polozenieY){
        for (int i = 0; i < szachownica.getFigury().size(); i = i + 1 ) {
            int polozenieFiguryX = szachownica.getFigury().get(i).getPolozenieX();
            int polozenieFiguryY = szachownica.getFigury().get(i).getPolozenieY();
            if (polozenieX == polozenieFiguryX && polozenieY == polozenieFiguryY){
                return szachownica.getFigury().get(i).getKolor();
            }
        }
        return null;
   }

}
