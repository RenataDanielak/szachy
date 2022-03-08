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
        int pozycjaPoczatkowaX = pozycjaPoczatkowa.getPozycjaX();
        int pozycjaPoczatkowaY = pozycjaPoczatkowa.getPozycjaY();
        for (int i = 0; i < szachownica.getFigury().size(); i = i + 1 ){
            Figura figura = szachownica.getFigury().get(i);
            ParametryPolaDto pozycjaPionkaNaSzachownicy = new ParametryPolaDto(figura.getPolozenieX(), figura.getPolozenieY());
            int pozycjaPionkaNaSzachownicyX = pozycjaPionkaNaSzachownicy.getPozycjaX();
            int pozycjaPionkaNaSzachownicyY = pozycjaPionkaNaSzachownicy.getPozycjaY();
            if (pozycjaPoczatkowaX == pozycjaPionkaNaSzachownicyX && pozycjaPoczatkowaY == pozycjaPionkaNaSzachownicyY){
                List<ParametryPolaDto> listaWynikowa = new ArrayList<>();
                List <ParametryPola> lista = figura.podajMozliweRuchy();
                for (int j = 0; j < lista.size(); j = j + 1 ){
                    ParametryPola parametryPola = lista.get(i);
                    ParametryPolaDto parametryPolaDto = new ParametryPolaDto( parametryPola.getPolozenieX(), parametryPola.getPolozenieY());
                    listaWynikowa.add(parametryPolaDto);
                }
                return listaWynikowa;
            }
        }

        return null;
    }

    @Override
    public boolean wykonajRuch(ParametryPolaDto pozycjaPoczatkowa, ParametryPolaDto pozycjaKoncowa) {
        int pozycjaPoczatkowaX = pozycjaPoczatkowa.getPozycjaX();
        int pozycjaPoczatkowaY = pozycjaPoczatkowa.getPozycjaY();
        for (int i = 0; i < szachownica.getFigury().size(); i = i + 1 ){
            Figura figura = szachownica.getFigury().get(i);
            if (pozycjaPoczatkowaX == figura.getPolozenieX() && pozycjaPoczatkowaY == figura.getPolozenieY()){
                 List<ParametryPola> mozliweRuchy = figura.podajMozliweRuchy();
                 int pozycjaKoncowaX = pozycjaKoncowa.getPozycjaX();
                 int pozycjaKoncowaY = pozycjaKoncowa.getPozycjaY();
                for (int j = 0; j < mozliweRuchy.size(); j = j + 1 ){
                   if(pozycjaKoncowaX == mozliweRuchy.get(j).getPolozenieX() && pozycjaKoncowaY == mozliweRuchy.get(j).getPolozenieY()) {
                      figura.setPolozenieX(pozycjaKoncowaX);
                      figura.setPolozenieY(pozycjaKoncowaY);
                       return true;
                   }
                }
            }

        }

        return false;
    }
}
