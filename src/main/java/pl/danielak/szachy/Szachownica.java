package pl.danielak.szachy;

import java.util.ArrayList;
import java.util.List;

public class Szachownica {
    private List<Figura> figury;

    private int numerRuchu = 0;

    public int getNumerRuchu() {
        return numerRuchu;
    }

    public void setNumerRuchu(int numerRuchu) {
        this.numerRuchu = numerRuchu;
    }

    public Szachownica (){
        figury = new ArrayList<>();
    }

    public List<Figura> getFigury() {
        return figury;
    }

    public void setFigury(List<Figura> figury) {
        this.figury = figury;
    }
}
