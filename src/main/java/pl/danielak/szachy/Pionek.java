package pl.danielak.szachy;

import pl.danielak.szachy.dto.ParametryPolaDto;

import java.util.ArrayList;
import java.util.List;

public class Pionek extends Figura {


    @Override
    public List<ParametryPola> podajMozliweRuchy(Szachownica szachownica) {
        List<ParametryPola> lista;
        lista = new ArrayList<>();
        int polozenieX = getPolozenieX();
        int polozenieY = getPolozenieY();
        boolean wolnePole = true;
        boolean wolnePole1 = true;
        if (isKolor() == true){
            if (getPolozenieY() == 7){
                return null;
            }
            for (int i = 0; i < szachownica.getFigury().size(); i = i + 1 ) {
                int polozenieInnejFiguryX = szachownica.getFigury().get(i).getPolozenieX();
                int polozenieInnejFiguryY = szachownica.getFigury().get(i).getPolozenieY();
                if (polozenieInnejFiguryY == polozenieY + 1 && polozenieInnejFiguryX == polozenieX) {
                    wolnePole = false;
                }
            }
            if (wolnePole == true){
                ParametryPola polozenieKoncowe = new ParametryPola(getPolozenieX(),getPolozenieY()+1, false);
                lista.add(polozenieKoncowe);
                if (polozenieY == 1){
                    for (int i = 0; i < szachownica.getFigury().size(); i = i + 1 ) {
                        int polozenieInnejFiguryX = szachownica.getFigury().get(i).getPolozenieX();
                        int polozenieInnejFiguryY = szachownica.getFigury().get(i).getPolozenieY();
                        if (polozenieInnejFiguryY == polozenieY + 2 && polozenieInnejFiguryX == polozenieX) {
                           wolnePole1 = false;
                        }
                    }
                    if (wolnePole1 == true ) {
                        ParametryPola polozenieKoncowe1 = new ParametryPola(getPolozenieX(), getPolozenieY() + 2, false);
                        lista.add(polozenieKoncowe1);
                    }
                }
            }
            for (int i = 0; i < szachownica.getFigury().size(); i = i + 1 ) {
                int polozenieInnejFiguryX = szachownica.getFigury().get(i).getPolozenieX();
                int polozenieInnejFiguryY = szachownica.getFigury().get(i).getPolozenieY();
                boolean kolor = szachownica.getFigury().get(i).isKolor();
                if (polozenieInnejFiguryY == polozenieY + 1 && polozenieInnejFiguryX == polozenieX + 1 && kolor == false) {
                    ParametryPola bicie = new ParametryPola(getPolozenieX()+1, getPolozenieY() + 1, true);
                    lista.add(bicie);
                }
            }
            for (int i = 0; i < szachownica.getFigury().size(); i = i + 1 ) {
                int polozenieInnejFiguryX = szachownica.getFigury().get(i).getPolozenieX();
                int polozenieInnejFiguryY = szachownica.getFigury().get(i).getPolozenieY();
                boolean kolor = szachownica.getFigury().get(i).isKolor();
                if (polozenieInnejFiguryY == polozenieY + 1 && polozenieInnejFiguryX == polozenieX - 1 && kolor == false) {
                    ParametryPola bicie1 = new ParametryPola(getPolozenieX()-1, getPolozenieY() + 1, true);
                    lista.add(bicie1);
                }
            }
        }

        if (isKolor() == false){
            if(getPolozenieY() == 0){
                return null;
            }
            for (int i = 0; i < szachownica.getFigury().size(); i = i + 1 ) {
                int polozenieInnejFiguryX = szachownica.getFigury().get(i).getPolozenieX();
                int polozenieInnejFiguryY = szachownica.getFigury().get(i).getPolozenieY();
                if (polozenieInnejFiguryY == polozenieY - 1 && polozenieInnejFiguryX == polozenieX) {
                    wolnePole = false;
                }
            }
            if (wolnePole == true){
                ParametryPola polozenieKoncowe = new ParametryPola(getPolozenieX(),getPolozenieY()-1, false);
                lista.add(polozenieKoncowe);
                if (polozenieY == 6){
                    for (int i = 0; i < szachownica.getFigury().size(); i = i + 1 ) {
                        int polozenieInnejFiguryX = szachownica.getFigury().get(i).getPolozenieX();
                        int polozenieInnejFiguryY = szachownica.getFigury().get(i).getPolozenieY();
                        if (polozenieInnejFiguryY == polozenieY - 2 && polozenieInnejFiguryX == polozenieX) {
                            wolnePole1 = false;
                        }
                    }
                    if (wolnePole1 == true ) {
                        ParametryPola polozenieKoncowe1 = new ParametryPola(getPolozenieX(), getPolozenieY() - 2, false);
                        lista.add(polozenieKoncowe1);
                    }
                }
            }
            for (int i = 0; i < szachownica.getFigury().size(); i = i + 1 ) {
                int polozenieInnejFiguryX = szachownica.getFigury().get(i).getPolozenieX();
                int polozenieInnejFiguryY = szachownica.getFigury().get(i).getPolozenieY();
                boolean kolor = szachownica.getFigury().get(i).isKolor();
                if (polozenieInnejFiguryY == polozenieY - 1 && polozenieInnejFiguryX == polozenieX - 1 && kolor == true) {
                    ParametryPola bicie = new ParametryPola(getPolozenieX()-1, getPolozenieY() - 1, true);
                    lista.add(bicie);
                }
            }
            for (int i = 0; i < szachownica.getFigury().size(); i = i + 1 ) {
                int polozenieInnejFiguryX = szachownica.getFigury().get(i).getPolozenieX();
                int polozenieInnejFiguryY = szachownica.getFigury().get(i).getPolozenieY();
                boolean kolor = szachownica.getFigury().get(i).isKolor();
                if (polozenieInnejFiguryY == polozenieY - 1 && polozenieInnejFiguryX == polozenieX + 1 && kolor == true) {
                    ParametryPola bicie1 = new ParametryPola(getPolozenieX()+1, getPolozenieY() - 1, true);
                    lista.add(bicie1);
                }
            }

        }
        return lista;
    }

}
