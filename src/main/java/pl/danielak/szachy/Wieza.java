package pl.danielak.szachy;

import java.util.ArrayList;
import java.util.List;

public class Wieza extends Figura {

    public RodzajFigury getRodzajFigury() {
        return RodzajFigury.WIEZA;
    }

    public void sprawdzMozliwyRuch(Szachownica szachownica, int polozenieX, int polozenieY, List<ParametryPola> mozliwyRuch, int a, int b) {
        Kolor kolorWiezy = getKolor();
        Kolor kolorFigury = kolorFiguryNaPolu(szachownica, polozenieX + a, polozenieY + b);
        polozenieX = polozenieX + a;
        polozenieY = polozenieY + b;
        while (kolorFigury == null && polozenieX >= 0 && polozenieX < 8 && polozenieY >= 0 && polozenieY < 8) {
            ParametryPola polozenieKoncowe = new ParametryPola(polozenieX, polozenieY, false);
            mozliwyRuch.add(polozenieKoncowe);
            polozenieX = polozenieX + a;
            polozenieY = polozenieY + b;
            kolorFigury = kolorFiguryNaPolu(szachownica, polozenieX, polozenieY);
        }
        if (kolorWiezy != kolorFigury && kolorFigury != null) {
            ParametryPola polozenieKoncowe1 = new ParametryPola(polozenieX, polozenieY, true);
            mozliwyRuch.add(polozenieKoncowe1);
        }
    }


    @Override
    public List<ParametryPola> podajMozliweRuchy(Szachownica szachownica) {
        List<ParametryPola> lista;
        lista = new ArrayList<>();
        int polozenieX = getPolozenieX();
        int polozenieY = getPolozenieY();
        sprawdzMozliwyRuch(szachownica, polozenieX, polozenieY, lista, 0, 1);
        sprawdzMozliwyRuch(szachownica, polozenieX, polozenieY, lista, 0, -1);
        sprawdzMozliwyRuch(szachownica, polozenieX, polozenieY, lista, 1, 0);
        sprawdzMozliwyRuch(szachownica, polozenieX, polozenieY, lista, -1, 0);
        return lista;
    }
}
