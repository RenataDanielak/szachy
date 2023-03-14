package pl.danielak.szachy;

import java.util.ArrayList;
import java.util.List;

public class Wieza extends FiguraRuszajacaSieOWielePol {

    public RodzajFigury getRodzajFigury() {
        return RodzajFigury.WIEZA;
    }

    private int numerRuchuWiezy;

    public Wieza() {

    }

    public Wieza(int polozenieX, int polozenieY, Kolor kolor, Szachownica szachownica) {
        setPolozenieX(polozenieX);
        setPolozenieY(polozenieY);
        setKolor(kolor);
        setSzachownica(szachownica);
    }

    public int getNumerRuchuWiezy() {
        return numerRuchuWiezy;
    }

    public void setNumerRuchuWiezy(int numerRuchuWiezy) {
        this.numerRuchuWiezy = numerRuchuWiezy;
    }

    @Override
    public void wykonajRuch(int polozenieKoncoweY, int polozenieKoncoweX) {
        super.wykonajRuch(polozenieKoncoweY, polozenieKoncoweX);
        numerRuchuWiezy = numerRuchuWiezy + 1;
    }

    @Override
    public List<ParametryPola> podajMozliweRuchy() {
        List<ParametryPola> lista;
        lista = new ArrayList<>();
        int polozenieX = getPolozenieX();
        int polozenieY = getPolozenieY();
        sprawdzMozliwyRuch(polozenieX, polozenieY, lista, 0, 1);
        sprawdzMozliwyRuch( polozenieX, polozenieY, lista, 0, -1);
        sprawdzMozliwyRuch( polozenieX, polozenieY, lista, 1, 0);
        sprawdzMozliwyRuch( polozenieX, polozenieY, lista, -1, 0);
        return lista;
    }
}
