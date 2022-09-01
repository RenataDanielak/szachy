package pl.danielak.szachy;

import java.util.ArrayList;
import java.util.List;

public class Laufer extends FiguraRuszajacaSieOWielePol {

    public RodzajFigury getRodzajFigury() {
        return RodzajFigury.LAUFER;
    }

    @Override
    public List<ParametryPola> podajMozliweRuchy() {
        List<ParametryPola> lista;
        lista = new ArrayList<>();
        int polozenieX = getPolozenieX();
        int polozenieY = getPolozenieY();
        sprawdzMozliwyRuch(polozenieX, polozenieY, lista, 1, 1);
        sprawdzMozliwyRuch(polozenieX, polozenieY, lista, 1, -1);
        sprawdzMozliwyRuch(polozenieX, polozenieY, lista, -1, -1);
        sprawdzMozliwyRuch(polozenieX, polozenieY, lista, -1, 1);
        return lista;
    }
}
