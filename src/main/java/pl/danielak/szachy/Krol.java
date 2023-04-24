package pl.danielak.szachy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Krol extends FiguraWielokierunkowa {

    public Krol() {

    }

    public Krol(int polozenieX, int polozenieY, Kolor kolor, Szachownica szachownica) {
        setPolozenieX(polozenieX);
        setPolozenieY(polozenieY);
        setKolor(kolor);
        setSzachownica(szachownica);
    }

    private int numerRuchuKrola = 0;

    public int getNumerRuchuKrola() {
        return numerRuchuKrola;
    }

    public void setNumerRuchuKrola(int numerRuchuKrola) {
        this.numerRuchuKrola = numerRuchuKrola;
    }

    @Override
    public RodzajFigury getRodzajFigury() {
        return RodzajFigury.KROL;
    }

    @Override
    public void wykonajRuch(int polozenieKoncoweY, int polozenieKoncoweX) {
        Szachownica szachownica = getSzachownica();
        super.wykonajRuch(polozenieKoncoweY, polozenieKoncoweX);
        numerRuchuKrola = numerRuchuKrola + 1;
        if (polozenieKoncoweX != getPolozenieX() + 2) {
            return;
        }
        int polozenieY = 0;
        if (getKolor() == Kolor.BIALY) {
            polozenieY = 0;
        }
        if (getKolor() == Kolor.CZARNY) {
            polozenieY = 7;
        }
        final int polozenieYFinal = polozenieY;

        Optional<Figura> figuraOptional = szachownica.getFigury().stream()
                .filter(figura -> figura.getPolozenieX() == 7 && figura.getPolozenieY() == polozenieYFinal && figura.getRodzajFigury() == RodzajFigury.WIEZA)
                .findFirst();
        if(figuraOptional.isPresent()){
            figuraOptional.get().setPolozenieX(figuraOptional.get().getPolozenieX() - 2);
            figuraOptional.get().setPolozenieY(figuraOptional.get().getPolozenieY());
        }

//            for (int i = 0; i < szachownica.getFigury().size(); i = i + 1) {
//                Figura figura = szachownica.getFigury().get(i);
//                int polozenieWiezyX = figura.getPolozenieX();
//                int polozenieWiezyY = figura.getPolozenieY();
//                RodzajFigury rodzajFigury = szachownica.getFigury().get(i).getRodzajFigury();
//                if (polozenieWiezyX == 7 && polozenieWiezyY == polozenieY && rodzajFigury == RodzajFigury.WIEZA) {
//                    figura.setPolozenieX(polozenieWiezyX - 2);
//                    figura.setPolozenieY(polozenieWiezyY);
//                }
//            }

    }

    protected boolean sprawdzWieze(int polozenieX, int polozenieY) {
        Szachownica szachownica = getSzachownica();
        Optional<Figura> figuraOptional = szachownica.getFigury().stream()
                .filter(figura -> figura.getRodzajFigury() == RodzajFigury.WIEZA && figura.getPolozenieX() == polozenieX && figura.getPolozenieY() == polozenieY)
                .findFirst();
        if(!figuraOptional.isPresent()){
            return false;
        }
        Wieza wieza = (Wieza) figuraOptional.get();
        if(wieza.getNumerRuchuWiezy() == 0){
            return true;
        }
        return false;

//        for (int i = 0; i < szachownica.getFigury().size(); i = i + 1) {
//            int polozenieFiguryX = szachownica.getFigury().get(i).getPolozenieX();
//            int polozenieFiguryY = szachownica.getFigury().get(i).getPolozenieY();
//            RodzajFigury rodzajFigury = szachownica.getFigury().get(i).getRodzajFigury();
//            if (polozenieFiguryX == polozenieX && polozenieFiguryY == polozenieY && rodzajFigury == RodzajFigury.WIEZA) {
//                Wieza wieza = (Wieza) szachownica.getFigury().get(i);
//                int numerRuchuWiezy = wieza.getNumerRuchuWiezy();
//                if (numerRuchuWiezy == 0){
//                    return true;
//                }
////            }
////        }
//        return false;
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

