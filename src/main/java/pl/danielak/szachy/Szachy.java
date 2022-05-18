package pl.danielak.szachy;

import pl.danielak.szachy.dto.ParametryPolaDto;
import pl.danielak.szachy.dto.PionekDto;

import java.util.ArrayList;
import java.util.List;

public class Szachy implements Gra {
    private Szachownica szachownica;

    public Szachy (){
        szachownica = new Szachownica();
        for (int i = 0; i < 8; i = i + 1) {
            Pionek pionek = new Pionek();
            pionek.setKolor(Kolor.BIALY);
            pionek.setPolozenieX(i);
            pionek.setPolozenieY(1);
            szachownica.getFigury().add(pionek);
        }
        Wieza wiezaBiala1 = new Wieza();
        wiezaBiala1.setKolor(Kolor.BIALY);
        wiezaBiala1.setPolozenieX(0);
        wiezaBiala1.setPolozenieY(0);
        szachownica.getFigury().add(wiezaBiala1);

        Wieza wiezaBiala2 = new Wieza();
        wiezaBiala2.setKolor(Kolor.BIALY);
        wiezaBiala2.setPolozenieX(7);
        wiezaBiala2.setPolozenieY(0);
        szachownica.getFigury().add(wiezaBiala2);

        Kon konBialy1 = new Kon();
        konBialy1.setKolor(Kolor.BIALY);
        konBialy1.setPolozenieX(1);
        konBialy1.setPolozenieY(0);
        szachownica.getFigury().add(konBialy1);

        Kon konBialy2 = new Kon();
        konBialy2.setKolor(Kolor.BIALY);
        konBialy2.setPolozenieX(6);
        konBialy2.setPolozenieY(0);
        szachownica.getFigury().add(konBialy2);

        Laufer lauferBialy1 = new Laufer();
        lauferBialy1.setKolor(Kolor.BIALY);
        lauferBialy1.setPolozenieX(2);
        lauferBialy1.setPolozenieY(0);
        szachownica.getFigury().add(lauferBialy1);

        Laufer lauferBialy2 = new Laufer();
        lauferBialy2.setKolor(Kolor.BIALY);
        lauferBialy2.setPolozenieX(5);
        lauferBialy2.setPolozenieY(0);
        szachownica.getFigury().add(lauferBialy2);

        Krolowa krolowaBiala = new Krolowa();
        krolowaBiala.setKolor(Kolor.BIALY);
        krolowaBiala.setPolozenieX(3);
        krolowaBiala.setPolozenieY(0);
        szachownica.getFigury().add(krolowaBiala);

        Krol krolBialy = new Krol();
        krolBialy.setKolor(Kolor.BIALY);
        krolBialy.setPolozenieX(4);
        krolBialy.setPolozenieY(0);
        szachownica.getFigury().add(krolBialy);

        Pionek pionek1 = new Pionek();
        pionek1.setKolor(Kolor.CZARNY);
        pionek1.setPolozenieX(3);
        pionek1.setPolozenieY(5);
        szachownica.getFigury().add(pionek1);

        Laufer lauferCzarny1 = new Laufer();
        lauferCzarny1.setKolor(Kolor.CZARNY);
        lauferCzarny1.setPolozenieX(1);
        lauferCzarny1.setPolozenieY(6);
        szachownica.getFigury().add(lauferCzarny1);

        Krolowa krolowaCzarna = new Krolowa();
        krolowaCzarna.setKolor(Kolor.CZARNY);
        krolowaCzarna.setPolozenieX(6);
        krolowaCzarna.setPolozenieY(6);
        szachownica.getFigury().add(krolowaCzarna);
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
