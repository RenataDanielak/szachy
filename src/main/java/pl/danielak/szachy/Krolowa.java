package pl.danielak.szachy;

import java.util.ArrayList;
import java.util.List;

public class Krolowa extends FiguraRuszajacaSieOWielePol {

    public Krolowa() {

    }

    public Krolowa(int polozenieX, int polozenieY, Kolor kolor, Szachownica szachownica) {
        setPolozenieX(polozenieX);
        setPolozenieY(polozenieY);
        setKolor(kolor);
        setSzachownica(szachownica);
    }

    public RodzajFigury getRodzajFigury() {
        return RodzajFigury.KROLOWA;
    }

    @Override
    public List<ParametryPola> podajMozliweRuchy() {
        List<ParametryPola> lista;
        lista = new ArrayList<>();
        int polozenieX = getPolozenieX();
        int polozenieY = getPolozenieY();
        sprawdzMozliwyRuch( polozenieX, polozenieY, lista, 1, 1);
        sprawdzMozliwyRuch( polozenieX, polozenieY, lista, 1, -1);
        sprawdzMozliwyRuch(polozenieX, polozenieY, lista, -1, -1);
        sprawdzMozliwyRuch(polozenieX, polozenieY, lista, -1, 1);
        sprawdzMozliwyRuch( polozenieX, polozenieY, lista, 0, 1);
        sprawdzMozliwyRuch( polozenieX, polozenieY, lista, 0, -1);
        sprawdzMozliwyRuch(polozenieX, polozenieY, lista, 1, 0);
        sprawdzMozliwyRuch(polozenieX, polozenieY, lista, -1, 0);
        return lista;
    }
}
