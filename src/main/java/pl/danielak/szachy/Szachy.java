package pl.danielak.szachy;

import pl.danielak.szachy.dto.ParametryPolaDto;
import pl.danielak.szachy.dto.PionekDto;

import java.util.ArrayList;
import java.util.List;

public class Szachy implements Gra {
    private Szachownica szachownica;
    private int numerRuchu = 0;

    public int getNumerRuchu() {
        return numerRuchu;
    }

    public void setNumerRuchu(int numerRuchu) {
        this.numerRuchu = numerRuchu;
    }

    public void ustawieniePionkowNaSzachownicy(Kolor kolor){
        int polozenieY = 0;
        int polozeniePionkow = 0;
        if(kolor == Kolor.BIALY){
          polozenieY = 0;
          polozeniePionkow = 1;
        }
        if(kolor == Kolor.CZARNY){
          polozenieY = 7;
          polozeniePionkow = 6;
        }
        for (int i = 0; i < 8; i = i + 1) {
            Pionek pionek = new Pionek();
            pionek.setKolor(kolor);
            pionek.setPolozenieX(i);
            pionek.setPolozenieY(polozeniePionkow);
            pionek.setSzachownica(szachownica);
            szachownica.getFigury().add(pionek);
        }

        Wieza wieza1 = new Wieza();
        wieza1.setKolor(kolor);
        wieza1.setPolozenieX(0);
        wieza1.setPolozenieY(polozenieY);
        wieza1.setSzachownica(szachownica);
        szachownica.getFigury().add(wieza1);

        Wieza wieza2 = new Wieza();
        wieza2.setKolor(kolor);
        wieza2.setPolozenieX(7);
        wieza2.setPolozenieY(polozenieY);
        wieza2.setSzachownica(szachownica);
        szachownica.getFigury().add(wieza2);

        Kon kon1 = new Kon();
        kon1.setKolor(kolor);
        kon1.setPolozenieX(1);
        kon1.setPolozenieY(polozenieY);
        kon1.setSzachownica(szachownica);
        szachownica.getFigury().add(kon1);

        //Kon kon2 = new Kon();
        //kon2.setKolor(kolor);
        //kon2.setPolozenieX(6);
        //kon2.setPolozenieY(polozenieY);
        //kon2.setSzachownica(szachownica);
        //szachownica.getFigury().add(kon2);

        Laufer laufer1 = new Laufer();
        laufer1.setKolor(kolor);
        laufer1.setPolozenieX(2);
        laufer1.setPolozenieY(polozenieY);
        laufer1.setSzachownica(szachownica);
        szachownica.getFigury().add(laufer1);

        //Laufer laufer2 = new Laufer();
        //laufer2.setKolor(kolor);
        //laufer2.setPolozenieX(5);
        //laufer2.setPolozenieY(polozenieY);
        //laufer2.setSzachownica(szachownica);
        //szachownica.getFigury().add(laufer2);

        Krolowa krolowa = new Krolowa();
        krolowa.setKolor(kolor);
        krolowa.setPolozenieX(3);
        krolowa.setPolozenieY(polozenieY);
        krolowa.setSzachownica(szachownica);
        szachownica.getFigury().add(krolowa);

        Krol krol = new Krol();
        krol.setKolor(kolor);
        krol.setPolozenieX(4);
        krol.setPolozenieY(polozenieY);
        krol.setSzachownica(szachownica);
        szachownica.getFigury().add(krol);
    }
    public Szachy () {
        szachownica = new Szachownica();
        ustawieniePionkowNaSzachownicy(Kolor.BIALY);
        ustawieniePionkowNaSzachownicy(Kolor.CZARNY);
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
        Kolor kolor = kolejnoscRuchuFigurPodWzgledemKoloru(numerRuchu);
        for (int i = 0; i < szachownica.getFigury().size(); i = i + 1 ){
            Figura figura = szachownica.getFigury().get(i);
            ParametryPolaDto pozycjaPionkaNaSzachownicy = new ParametryPolaDto(figura.getPolozenieX(), figura.getPolozenieY());
            int pozycjaPionkaNaSzachownicyX = pozycjaPionkaNaSzachownicy.getPozycjaX();
            int pozycjaPionkaNaSzachownicyY = pozycjaPionkaNaSzachownicy.getPozycjaY();
            if (kolor == figura.getKolor() && pozycjaPoczatkowaX == pozycjaPionkaNaSzachownicyX && pozycjaPoczatkowaY == pozycjaPionkaNaSzachownicyY){
                List<ParametryPolaDto> listaWynikowa = new ArrayList<>();
                List <ParametryPola> lista = figura.podajMozliweRuchy();
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
    public Kolor kolejnoscRuchuFigurPodWzgledemKoloru (int numerRuchu){
        Kolor kolorRuchuFigury;
        if(numerRuchu % 2 == 0){
            return kolorRuchuFigury = Kolor.BIALY;
        }
        return kolorRuchuFigury = Kolor.CZARNY;
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
                      figura.wykonajRuch(pozycjaKoncowaY, pozycjaKoncowaX);
                       numerRuchu = numerRuchu +1;
                       return true;
                   }
                }
            }
        }
        return false;
    }

}
