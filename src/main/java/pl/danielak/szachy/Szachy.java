package pl.danielak.szachy;

import pl.danielak.szachy.dto.ParametryPolaDto;
import pl.danielak.szachy.dto.PionekDto;

import java.util.ArrayList;
import java.util.List;

public class Szachy implements Gra {
    private Szachownica szachownica;

    public Szachy (){
        szachownica = new Szachownica();
        Pionek pionek = new Pionek();
        pionek.setKolor(true);
        pionek.setPolozenieX(0);
        pionek.setPolozenieY(1);
        szachownica.getFigury().add(pionek);
    }

    @Override
    public List<PionekDto> listaPionkow() {
        List<PionekDto> lista = new ArrayList<>();
        for (int i = 0; i < szachownica.getFigury().size(); i = i + 1 ){
            Figura figura = szachownica.getFigury().get(i);
            PionekDto pionekDto = new PionekDto( figura.getPolozenieX(), figura.getPolozenieY(), figura.isKolor(), "pionek");
            lista.add(pionekDto);
        }
        return lista;
    }

    @Override
    public List<ParametryPolaDto> podajMozliweRuchy(ParametryPolaDto pozycjaPoczatkowa) {
        return null;
    }

    @Override
    public boolean wykonajRuch(ParametryPolaDto pozycjaPoczatkowa, ParametryPolaDto pozycjaKoncowa) {
        return false;
    }
}
