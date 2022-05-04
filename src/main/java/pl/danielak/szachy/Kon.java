package pl.danielak.szachy;

import java.util.ArrayList;
import java.util.List;

public class Kon extends FiguraWielokierunkowa {

    public RodzajFigury getRodzajFigury() {
        return RodzajFigury.KON;
    }

    public List<ParametryPola> podajMozliweRuchy(Szachownica szachownica) {
        List<ParametryPola> lista;
        lista = new ArrayList<>();
        int polozenieX = getPolozenieX();
        int polozenieY = getPolozenieY();
        sprawdzMozliwyRuch(szachownica, polozenieX-1, polozenieY + 2, lista);
        sprawdzMozliwyRuch(szachownica, polozenieX + 1, polozenieY + 2, lista);
        sprawdzMozliwyRuch(szachownica, polozenieX - 1, polozenieY - 2, lista);
        sprawdzMozliwyRuch(szachownica, polozenieX + 1, polozenieY - 2, lista);
        sprawdzMozliwyRuch(szachownica, polozenieX-2, polozenieY + 1, lista);
        sprawdzMozliwyRuch(szachownica, polozenieX + 2, polozenieY + 1, lista);
        sprawdzMozliwyRuch(szachownica, polozenieX + 2, polozenieY - 1, lista);
        sprawdzMozliwyRuch(szachownica, polozenieX - 2, polozenieY - 1, lista);

        return lista;
    }

}
