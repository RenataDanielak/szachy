package pl.danielak.szachy;

import pl.danielak.szachy.dto.ParametryPolaDto;

import java.util.ArrayList;
import java.util.List;

public class Figura {
    private int polozenieX;
    private int polozenieY;
    private Kolor kolor;
    private Szachownica szachownica;

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

    public RodzajFigury getRodzajFigury() {
        return null;
    }

    public Szachownica getSzachownica() {
        return szachownica;
    }

    public void setSzachownica(Szachownica szachownica) {
        this.szachownica = szachownica;
    }

    public List<ParametryPola> podajMozliweRuchy(){
        List<ParametryPola> lista;
        lista = new ArrayList<>();
        return lista;
    }

    public void wykonajRuch (int polozenieKoncoweY, int polozenieKoncoweX){
        setPolozenieX(polozenieKoncoweX);
        setPolozenieY(polozenieKoncoweY);
    }
    protected Kolor kolorFiguryNaPolu (int polozenieX, int polozenieY){
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
