package pl.danielak.szachy;

import java.util.ArrayList;
import java.util.List;

public class Szachownica {
    private List<Figura> figury;

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
