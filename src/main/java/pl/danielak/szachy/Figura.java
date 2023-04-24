package pl.danielak.szachy;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Figura {
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

    public abstract List<ParametryPola> podajMozliweRuchy();

    public void wykonajRuch (int polozenieKoncoweY, int polozenieKoncoweX){
        setPolozenieX(polozenieKoncoweX);
        setPolozenieY(polozenieKoncoweY);
    }
    protected Kolor kolorFiguryNaPolu (int polozenieX, int polozenieY){
        Optional<Figura> figuraOptional = szachownica.getFigury().stream()
                .filter(figura -> figura.getPolozenieX() == polozenieX && figura.getPolozenieY() == polozenieY)
                .findFirst();
        if(figuraOptional.isPresent()){
            return figuraOptional.get().getKolor();
        }
        return null;
   }


}
