package pl.danielak.szachy;

import java.util.ArrayList;
import java.util.List;


public class Krol extends FiguraWielokierunkowa {

    private int numerRuchuKrola = 0;

    @Override
    public RodzajFigury getRodzajFigury() {
        return RodzajFigury.KROL;
    }

    @Override
    public void wykonajRuch(int polozenieKoncoweY, int polozenieKoncoweX) {
        Szachownica szachownica = getSzachownica();
        int polozeniePoczatkoweX = getPolozenieX();
        super.wykonajRuch(polozenieKoncoweY, polozenieKoncoweX);
        numerRuchuKrola = numerRuchuKrola + 1;
        if (polozenieKoncoweX == polozeniePoczatkoweX + 2) {
            int polozenieY = 0;
            Kolor kolorWiezy = getKolor();
            if (kolorWiezy == Kolor.BIALY) {
                polozenieY = 0;
            }
            if (kolorWiezy == Kolor.CZARNY) {
                polozenieY = 7;
            }
            for (int i = 0; i < szachownica.getFigury().size(); i = i + 1) {
                Figura figura = szachownica.getFigury().get(i);
                int polozenieWiezyX = figura.getPolozenieX();
                int polozenieWiezyY = figura.getPolozenieY();
                RodzajFigury rodzajFigury = szachownica.getFigury().get(i).getRodzajFigury();
                if (polozenieWiezyX == 7 && polozenieWiezyY == polozenieY && rodzajFigury == RodzajFigury.WIEZA) {
                    figura.setPolozenieX(polozenieWiezyX - 2);
                    figura.setPolozenieY(polozenieWiezyY);
                }
            }
        }
    }

    protected boolean sprawdzWieze(int polozenieX, int polozenieY) {
        Szachownica szachownica = getSzachownica();
        for (int i = 0; i < szachownica.getFigury().size(); i = i + 1) {
            int polozenieFiguryX = szachownica.getFigury().get(i).getPolozenieX();
            int polozenieFiguryY = szachownica.getFigury().get(i).getPolozenieY();
            RodzajFigury rodzajFigury = szachownica.getFigury().get(i).getRodzajFigury();
            if (polozenieFiguryX == polozenieX && polozenieFiguryY == polozenieY && rodzajFigury == RodzajFigury.WIEZA) {
                Wieza wieza = (Wieza) szachownica.getFigury().get(i);
                int numerRuchuWiezy = wieza.getNumerRuchuWiezy();
                if (numerRuchuWiezy == 0){
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean sprawdzCzyMoznaWykonacRoszade() {

        Kolor kolor = getKolor();
        int polozenieY = 0;
        if (kolor == Kolor.BIALY) {
            polozenieY = 0;
        }
        if (kolor == Kolor.CZARNY) {
            polozenieY = 7;
        }
        Kolor kolorFiguryNaPoluX1 = kolorFiguryNaPolu(5, polozenieY);
        Kolor kolorFiguryNaPoluX2 = kolorFiguryNaPolu(6, polozenieY);
        if (numerRuchuKrola == 0 && (kolorFiguryNaPoluX1 == null && kolorFiguryNaPoluX2 == null) && (sprawdzWieze(7, polozenieY))) {
            return true;
        }
        return false;
    }

    protected void roszada(int polozenieX, int polozenieY, List<ParametryPola> mozliwyRuch) {
        if (sprawdzCzyMoznaWykonacRoszade() == true) {
            ParametryPola polozenieKoncoweKrola = new ParametryPola(polozenieX, polozenieY, false);
            mozliwyRuch.add(polozenieKoncoweKrola);
        }
    }


    public List<ParametryPola> podajMozliweRuchy() {
        List<ParametryPola> lista;
        lista = new ArrayList<>();
        int polozenieX = getPolozenieX();
        int polozenieY = getPolozenieY();
        sprawdzMozliwyRuch(polozenieX, polozenieY + 1, lista);
        sprawdzMozliwyRuch(polozenieX + 1, polozenieY + 1, lista);
        sprawdzMozliwyRuch(polozenieX + 1, polozenieY, lista);
        sprawdzMozliwyRuch(polozenieX + 1, polozenieY - 1, lista);
        sprawdzMozliwyRuch( polozenieX, polozenieY - 1, lista);
        sprawdzMozliwyRuch(polozenieX - 1, polozenieY - 1, lista);
        sprawdzMozliwyRuch(polozenieX - 1, polozenieY, lista);
        sprawdzMozliwyRuch( polozenieX - 1, polozenieY + 1, lista);
        roszada(polozenieX + 2, polozenieY, lista);

        return lista;
    }

}

