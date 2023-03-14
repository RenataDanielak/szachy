package pl.danielak.szachy;

import java.util.ArrayList;
import java.util.List;

public class Kon extends FiguraWielokierunkowa {

    public Kon() {
    }

    public Kon(int polozenieX, int polozenieY, Kolor kolor, Szachownica szachownica) {
        setPolozenieX(polozenieX);
        setPolozenieY(polozenieY);
        setKolor(kolor);
        setSzachownica(szachownica);
    }

    public RodzajFigury getRodzajFigury() {
        return RodzajFigury.KON;
    }

    public List<ParametryPola> podajMozliweRuchy() {
        List<ParametryPola> lista;
        lista = new ArrayList<>();
        int polozenieX = getPolozenieX();
        int polozenieY = getPolozenieY();
        sprawdzMozliwyRuch(polozenieX-1, polozenieY + 2, lista);
        sprawdzMozliwyRuch(polozenieX + 1, polozenieY + 2, lista);
        sprawdzMozliwyRuch( polozenieX - 1, polozenieY - 2, lista);
        sprawdzMozliwyRuch(polozenieX + 1, polozenieY - 2, lista);
        sprawdzMozliwyRuch(polozenieX-2, polozenieY + 1, lista);
        sprawdzMozliwyRuch(polozenieX + 2, polozenieY + 1, lista);
        sprawdzMozliwyRuch(polozenieX + 2, polozenieY - 1, lista);
        sprawdzMozliwyRuch(polozenieX - 2, polozenieY - 1, lista);

        return lista;
    }

}
