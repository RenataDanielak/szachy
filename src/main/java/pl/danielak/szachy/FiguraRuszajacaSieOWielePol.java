package pl.danielak.szachy;

import java.util.List;

public abstract class FiguraRuszajacaSieOWielePol extends Figura{

    protected void sprawdzMozliwyRuch(int polozenieX, int polozenieY, List<ParametryPola> mozliwyRuch, int a, int b) {
        Kolor kolor = getKolor();
        Kolor kolorFigury = kolorFiguryNaPolu(polozenieX + a, polozenieY + b);
        polozenieX = polozenieX + a;
        polozenieY = polozenieY + b;
        while (kolorFigury == null && polozenieX >= 0 && polozenieX < 8 && polozenieY >= 0 && polozenieY < 8) {
            ParametryPola polozenieKoncowe = new ParametryPola(polozenieX, polozenieY, false);
            mozliwyRuch.add(polozenieKoncowe);
            polozenieX = polozenieX + a;
            polozenieY = polozenieY + b;
            kolorFigury = kolorFiguryNaPolu(polozenieX, polozenieY);
        }
        if (kolor != kolorFigury && kolorFigury != null) {
            ParametryPola polozenieKoncowe1 = new ParametryPola(polozenieX, polozenieY, true);
            mozliwyRuch.add(polozenieKoncowe1);
        }
    }

}
