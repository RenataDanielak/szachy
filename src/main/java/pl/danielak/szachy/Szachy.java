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
        pionek.setKolor(Kolor.BIALY);
        pionek.setPolozenieX(4);
        pionek.setPolozenieY(4);
        szachownica.getFigury().add(pionek);

        Pionek pionek1 = new Pionek();
        pionek1.setKolor(Kolor.CZARNY);
        pionek1.setPolozenieX(3);
        pionek1.setPolozenieY(5);
        szachownica.getFigury().add(pionek1);

        Krol krolBialy = new Krol();
        krolBialy.setKolor(Kolor.BIALY);
        krolBialy.setPolozenieX(3);
        krolBialy.setPolozenieY(1);
        szachownica.getFigury().add(krolBialy);

        Kon konBialy1 = new Kon();
        konBialy1.setKolor(Kolor.BIALY);
        konBialy1.setPolozenieX(3);
        konBialy1.setPolozenieY(2);
        szachownica.getFigury().add(konBialy1);

        Wieza wiezaBiala1 = new Wieza();
        wiezaBiala1.setKolor(Kolor.BIALY);
        wiezaBiala1.setPolozenieX(5);
        wiezaBiala1.setPolozenieY(5);
        szachownica.getFigury().add(wiezaBiala1);

        Laufer lauferCzarny1 = new Laufer();
        lauferCzarny1.setKolor(Kolor.CZARNY);
        lauferCzarny1.setPolozenieX(1);
        lauferCzarny1.setPolozenieY(1);
        szachownica.getFigury().add(lauferCzarny1);
    }

    @Override
    public List<PionekDto> listaPionkow() {
        List<PionekDto> lista = new ArrayList<>();
        for (int i = 0; i < szachownica.getFigury().size(); i = i + 1 ){
            Figura figura = szachownica.getFigury().get(i);
            PionekDto pionekDto = new PionekDto( figura.getPolozenieX(), figura.getPolozenieY(), figura.getKolor(), figura.getRodzajFigury());
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
                List <ParametryPola> lista = figura.podajMozliweRuchy(szachownica);
                for (int j = 0; j < lista.size(); j = j + 1 ){
                    ParametryPola parametryPola = lista.get(j);
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
                 List<ParametryPola> mozliweRuchy = figura.podajMozliweRuchy(szachownica);
                 int pozycjaKoncowaX = pozycjaKoncowa.getPozycjaX();
                 int pozycjaKoncowaY = pozycjaKoncowa.getPozycjaY();
                for (int j = 0; j < mozliweRuchy.size(); j = j + 1 ){
                   if(pozycjaKoncowaX == mozliweRuchy.get(j).getPolozenieX() && pozycjaKoncowaY == mozliweRuchy.get(j).getPolozenieY()) {
                      boolean zajete = mozliweRuchy.get(j).isZajete();
                      if (zajete == true){
                          for (int k = 0; k < szachownica.getFigury().size(); k = k + 1 ){
                              int polozenieX = szachownica.getFigury().get(k).getPolozenieX();
                              int polozenieY = szachownica.getFigury().get(k).getPolozenieY();
                              if (polozenieX == pozycjaKoncowaX && polozenieY == pozycjaKoncowaY){
                                  Figura removedStr = szachownica.getFigury().remove(k);
                              }
                          }
                      }
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
