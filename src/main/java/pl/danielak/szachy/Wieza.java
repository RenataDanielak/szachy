package pl.danielak.szachy;

import java.util.ArrayList;
import java.util.List;

public class Wieza extends Figura {

    public RodzajFigury getRodzajFigury() {
        return RodzajFigury.WIEZA;
    }

    public void sprawdzMozliwyRuch (Szachownica szachownica, int polozenieX, int polozenieY, List<ParametryPola> mozliwyRuch) {
        Kolor kolorFigury = getKolor();
        Kolor kolorFiguryNaPolu = kolorFiguryNaPolu(szachownica, polozenieX, polozenieY);
        if (polozenieX >= 0 && polozenieX < 8 && polozenieY >= 0 && polozenieY < 8) {
            if (kolorFiguryNaPolu == null) {
            }
            }
    }

    @Override
    public List<ParametryPola> podajMozliweRuchy(Szachownica szachownica) {
        List<ParametryPola> lista;
        lista = new ArrayList<>();
        int polozenieX = getPolozenieX();
        int polozenieY = getPolozenieY();
        Kolor kolorWiezy = getKolor();
        Kolor kolorFigury = kolorFiguryNaPolu(szachownica,polozenieX,polozenieY+1);
        while (kolorFigury == null && polozenieY<7){
            ParametryPola polozenieKoncowe = new ParametryPola(polozenieX, polozenieY + 1, false);
            lista.add(polozenieKoncowe);
            polozenieY = polozenieY+1;
            kolorFigury = kolorFiguryNaPolu(szachownica,polozenieX,polozenieY+1);
            }
        if(kolorWiezy != kolorFigury){
            ParametryPola polozenieKoncowe1 = new ParametryPola(polozenieX, polozenieY + 1, true);
            lista.add(polozenieKoncowe1);
            }
        return lista;
    }
}
