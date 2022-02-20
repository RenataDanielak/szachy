package pl.danielak.szachy;

import pl.danielak.szachy.dto.ParametryPolaDto;

import java.util.ArrayList;
import java.util.List;

public class Pionek extends Figura {

    @Override
    public List<ParametryPola> podajMozliweRuchy() {
        List<ParametryPola> lista;
        lista = new ArrayList<>();
        ParametryPola polozenieKoncowe = new ParametryPola(getPolozenieX(),getPolozenieY()+1);
        lista.add(polozenieKoncowe);
        return lista;
    }

}
