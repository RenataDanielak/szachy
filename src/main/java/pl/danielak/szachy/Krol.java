package pl.danielak.szachy;

import java.util.ArrayList;
import java.util.List;


public class Krol extends Figura {

    public Krol() {
        setRodzajFigury(RodzajFigury.KROL);
    }

    public void sprawdzMozliwyRuch(Szachownica szachownica, int polozenieX, int polozenieY, List<ParametryPola> mozliwyRuch) {
        Kolor kolorKrola = getKolor();
        Kolor kolorFiguryNaPolu = kolorFiguryNaPolu(szachownica, polozenieX, polozenieY);
        if (polozenieX >= 0 && polozenieX < 8 && polozenieY >= 0 && polozenieY < 8) {
            if (kolorFiguryNaPolu == null) {
                ParametryPola polozenieKoncowe = new ParametryPola(polozenieX, polozenieY, false);
                mozliwyRuch.add(polozenieKoncowe);
            }
            if (kolorFiguryNaPolu != kolorKrola) {
                ParametryPola polozenieKoncowe1 = new ParametryPola(polozenieX, polozenieY,true);
                mozliwyRuch.add(polozenieKoncowe1);
            }
        }
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
