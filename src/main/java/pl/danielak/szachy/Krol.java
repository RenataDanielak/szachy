package pl.danielak.szachy;

import java.util.ArrayList;
import java.util.List;


public class Krol extends FiguraWielokierunkowa {

    @Override
    public RodzajFigury getRodzajFigury() {
        return RodzajFigury.KROL;
    }


    public List<ParametryPola> podajMozliweRuchy(Szachownica szachownica) {
        List<ParametryPola> lista;
        lista = new ArrayList<>();
        int polozenieX = getPolozenieX();
        int polozenieY = getPolozenieY();
        sprawdzMozliwyRuch(szachownica, polozenieX, polozenieY + 1, lista);
        sprawdzMozliwyRuch(szachownica, polozenieX + 1, polozenieY + 1, lista);
        sprawdzMozliwyRuch(szachownica, polozenieX + 1, polozenieY, lista);
        sprawdzMozliwyRuch(szachownica, polozenieX + 1, polozenieY - 1, lista);
        sprawdzMozliwyRuch(szachownica, polozenieX, polozenieY - 1, lista);
        sprawdzMozliwyRuch(szachownica, polozenieX - 1, polozenieY - 1, lista);
        sprawdzMozliwyRuch(szachownica, polozenieX - 1, polozenieY, lista);
        sprawdzMozliwyRuch(szachownica, polozenieX - 1, polozenieY + 1, lista);

        return lista;
    }
}
