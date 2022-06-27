package pl.danielak.szachy;

import java.util.List;

public class FiguraWielokierunkowa extends Figura{

    protected void sprawdzMozliwyRuch(Szachownica szachownica, int polozenieX, int polozenieY, List<ParametryPola> mozliwyRuch) {
        Kolor kolorFigury = getKolor();
        Kolor kolorFiguryNaPolu = kolorFiguryNaPolu(szachownica, polozenieX, polozenieY);
        if (polozenieX >= 0 && polozenieX < 8 && polozenieY >= 0 && polozenieY < 8) {
            if (kolorFiguryNaPolu == null) {
                ParametryPola polozenieKoncowe = new ParametryPola(polozenieX, polozenieY, false);
                mozliwyRuch.add(polozenieKoncowe);
            }
            if (kolorFiguryNaPolu != kolorFigury && kolorFiguryNaPolu != null) {
                ParametryPola polozenieKoncowe1 = new ParametryPola(polozenieX, polozenieY,true);
                mozliwyRuch.add(polozenieKoncowe1);
            }
        }
    }
}
