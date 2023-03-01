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

    public void ustawieniePionkowNaSzachownicy(){
        //PAMIETAC O DODANIU KOLORU DO PARAMETRU FUNKCJI I POZNIEJ PRZY WYWOLYWANIU TEJ FUNKCJI ROWNIEZ
//        int polozenieY = 0;
//        int polozeniePionkow = 0;
//        if(kolor == Kolor.BIALY){
//          polozenieY = 0;
//          polozeniePionkow = 1;
//        }
//        if(kolor == Kolor.CZARNY){
//          polozenieY = 7;
//          polozeniePionkow = 6;
//        }
//        for (int i = 0; i < 8; i = i + 1) {
//            Pionek pionek = new Pionek();
//            pionek.setKolor(kolor);
//            pionek.setPolozenieX(i);
//            pionek.setPolozenieY(polozeniePionkow);
//            pionek.setSzachownica(szachownica);
//            szachownica.getFigury().add(pionek);
//        }

//        Wieza wieza1 = new Wieza();
//        wieza1.setKolor(kolor);
//        wieza1.setPolozenieX(0);
//        wieza1.setPolozenieY(polozenieY);
//        wieza1.setSzachownica(szachownica);
//        szachownica.getFigury().add(wieza1);
//
//        Wieza wieza2 = new Wieza();
//        wieza2.setKolor(kolor);
//        wieza2.setPolozenieX(7);
//        wieza2.setPolozenieY(polozenieY);
//        wieza2.setSzachownica(szachownica);
//        szachownica.getFigury().add(wieza2);

//        Kon kon1 = new Kon();
//        kon1.setKolor(kolor);
//        kon1.setPolozenieX(1);
//        kon1.setPolozenieY(polozenieY);
//        kon1.setSzachownica(szachownica);
//        szachownica.getFigury().add(kon1);
//
//        Kon kon2 = new Kon();
//        kon2.setKolor(kolor);
//        kon2.setPolozenieX(6);
//        kon2.setPolozenieY(polozenieY);
//        kon2.setSzachownica(szachownica);
//        szachownica.getFigury().add(kon2);

//        Laufer laufer1 = new Laufer();
//        laufer1.setKolor(kolor);
//        laufer1.setPolozenieX(2);
//        laufer1.setPolozenieY(polozenieY);
//        laufer1.setSzachownica(szachownica);
//        szachownica.getFigury().add(laufer1);
//
//        Laufer laufer2 = new Laufer();
//        laufer2.setKolor(kolor);
//        laufer2.setPolozenieX(5);
//        laufer2.setPolozenieY(polozenieY);
//        laufer2.setSzachownica(szachownica);
//        szachownica.getFigury().add(laufer2);

//        Krolowa krolowa = new Krolowa();
//        krolowa.setKolor(kolor);
//        krolowa.setPolozenieX(3);
//        krolowa.setPolozenieY(polozenieY);
//        krolowa.setSzachownica(szachownica);
//        szachownica.getFigury().add(krolowa);
//
//        Krol krol = new Krol();
//        krol.setKolor(kolor);
//        krol.setPolozenieX(4);
//        krol.setPolozenieY(polozenieY);
//        krol.setSzachownica(szachownica);
//        szachownica.getFigury().add(krol);

        Krol krol = new Krol();
        krol.setKolor(Kolor.BIALY);
        krol.setPolozenieX(6);
        krol.setPolozenieY(0);
        krol.setSzachownica(szachownica);
        szachownica.getFigury().add(krol);

        Krolowa krolowa = new Krolowa();
        krolowa.setKolor(Kolor.CZARNY);
        krolowa.setPolozenieX(3);
        krolowa.setPolozenieY(6);
        krolowa.setSzachownica(szachownica);
        szachownica.getFigury().add(krolowa);

        Pionek pionek = new Pionek();
        pionek.setKolor(Kolor.BIALY);
        pionek.setPolozenieX(2);
        pionek.setPolozenieY(3);
        pionek.setSzachownica(szachownica);
        szachownica.getFigury().add(pionek);

//        Wieza wieza = new Wieza();
//        wieza.setKolor(Kolor.BIALY);
//        wieza.setPolozenieX(3);
//        wieza.setPolozenieY(1);
//        wieza.setSzachownica(szachownica);
//        szachownica.getFigury().add(wieza);

        Wieza wieza1 = new Wieza();
        wieza1.setKolor(Kolor.CZARNY);
        wieza1.setPolozenieX(2);
        wieza1.setPolozenieY(1);
        wieza1.setSzachownica(szachownica);
        szachownica.getFigury().add(wieza1);

        Krol krol1 = new Krol();
        krol1.setKolor(Kolor.CZARNY);
        krol1.setPolozenieX(4);
        krol1.setPolozenieY(7);
        krol1.setSzachownica(szachownica);
        szachownica.getFigury().add(krol1);
    }
    public Szachy () {
        szachownica = new Szachownica();
        ustawieniePionkowNaSzachownicy();
        //ustawieniePionkowNaSzachownicy(Kolor.CZARNY);
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

    public Szachownica szachownicaTestowa (){
        Szachownica szachownicaTestowa = new Szachownica();
        List<Figura> lista = new ArrayList<>();
        for (int j = 0; j < szachownica.getFigury().size(); j = j + 1 ){
            Figura figura = szachownica.getFigury().get(j);
            RodzajFigury rodzajFigury = figura.getRodzajFigury();
            int pozycjaX = figura.getPolozenieX();
            int pozycjaY = figura.getPolozenieY();
            Kolor kolor = figura.getKolor();
            Figura figuraNaSzachownicyTestowej;
            if(rodzajFigury == RodzajFigury.PIONEK){
                figuraNaSzachownicyTestowej = new Pionek();
            }
            else if(rodzajFigury == RodzajFigury.KON){
                figuraNaSzachownicyTestowej = new Kon();
            }
            else if(rodzajFigury == RodzajFigury.KROL){
                Krol krolNaSzachownicyTestowej = new Krol();
                Krol krol = (Krol) figura;
                int numerRuchu = krol.getNumerRuchuKrola();
                krolNaSzachownicyTestowej.setNumerRuchuKrola(numerRuchu);
                figuraNaSzachownicyTestowej = krolNaSzachownicyTestowej;
            }
            else if(rodzajFigury == RodzajFigury.KROLOWA){
                figuraNaSzachownicyTestowej = new Krolowa();
            }
            else if(rodzajFigury == RodzajFigury.LAUFER){
                figuraNaSzachownicyTestowej = new Laufer();
            }
            else {
                Wieza wiezaNaSzachownicyTestowej = new Wieza();
                Wieza wieza = (Wieza) figura;
                int numerRuchu = wieza.getNumerRuchuWiezy();
                wiezaNaSzachownicyTestowej.setNumerRuchuWiezy(numerRuchu);
                figuraNaSzachownicyTestowej = wiezaNaSzachownicyTestowej;
            }
            figuraNaSzachownicyTestowej.setPolozenieX(pozycjaX);
            figuraNaSzachownicyTestowej.setPolozenieY(pozycjaY);
            figuraNaSzachownicyTestowej.setKolor(kolor);
            figuraNaSzachownicyTestowej.setSzachownica(szachownicaTestowa);
            lista.add(figuraNaSzachownicyTestowej);
        }
        szachownicaTestowa.setFigury(lista);

    return szachownicaTestowa;
}


    @Override
    public List<ParametryPolaDto> podajMozliweRuchy(ParametryPolaDto pozycjaPoczatkowaDto) {
        int pozycjaPoczatkowaX = pozycjaPoczatkowaDto.getPozycjaX();
        int pozycjaPoczatkowaY = pozycjaPoczatkowaDto.getPozycjaY();
        Kolor kolor = kolejnoscRuchuFigurPodWzgledemKoloru(numerRuchu);
        for (int i = 0; i < szachownica.getFigury().size(); i = i + 1 ){
            Figura figura = szachownica.getFigury().get(i);
            ParametryPolaDto pozycjaPionkaNaSzachownicy = new ParametryPolaDto(figura.getPolozenieX(), figura.getPolozenieY());
            int pozycjaPionkaNaSzachownicyX = pozycjaPionkaNaSzachownicy.getPozycjaX();
            int pozycjaPionkaNaSzachownicyY = pozycjaPionkaNaSzachownicy.getPozycjaY();
            ParametryPola pozycjaPoczatkowa = new ParametryPola(pozycjaPionkaNaSzachownicyX, pozycjaPionkaNaSzachownicyY, true);
            if (kolor == figura.getKolor() && pozycjaPoczatkowaX == pozycjaPionkaNaSzachownicyX && pozycjaPoczatkowaY == pozycjaPionkaNaSzachownicyY){
                List<ParametryPolaDto> listaWynikowa = new ArrayList<>();
                List <ParametryPola> lista = figura.podajMozliweRuchy();
                List <ParametryPola> listaMozliwychRuchowZUwglednieniemKrola = mozliweRuchyZUwglednieniemPozycjiKrola(pozycjaPoczatkowa, lista);
                for (int j = 0; j < listaMozliwychRuchowZUwglednieniemKrola.size(); j = j + 1 ){
                    ParametryPola parametryPola = listaMozliwychRuchowZUwglednieniemKrola.get(j);
                    ParametryPolaDto parametryPolaDto = new ParametryPolaDto( parametryPola.getPolozenieX(), parametryPola.getPolozenieY());
                    listaWynikowa.add(parametryPolaDto);
                }
                return listaWynikowa;
            }
        }
        return null;
    }

    public boolean sprawdzMozliwyRuchUwzgledniajacPozycjeKrola (ParametryPola pozycjaPoczatkowa, ParametryPola pozycjaKoncowa, Szachownica szachownicaTestowa){
        int polozenieKrolaX = 0;
        int polozenieKrolaY = 0;
        for (int i = 0; i < szachownicaTestowa.getFigury().size(); i = i + 1 ) {
            Figura figuraNaSzachownicyTestowej = szachownicaTestowa.getFigury().get(i);
            if(figuraNaSzachownicyTestowej.getPolozenieX() == pozycjaPoczatkowa.getPolozenieX() && figuraNaSzachownicyTestowej.getPolozenieY() == pozycjaPoczatkowa.getPolozenieY()){
                boolean zajetePole = pozycjaKoncowa.isZajete();
                if(zajetePole){
                    for (int j = 0; j < szachownicaTestowa.getFigury().size(); j = j + 1 ) {
                        if(szachownicaTestowa.getFigury().get(j).getPolozenieX() == pozycjaKoncowa.getPolozenieX() && szachownicaTestowa.getFigury().get(j).getPolozenieY() == pozycjaKoncowa.getPolozenieY()){
                            szachownicaTestowa.getFigury().remove(j);
                        }
                    }
                }
                figuraNaSzachownicyTestowej.wykonajRuch(pozycjaKoncowa.getPolozenieY(), pozycjaKoncowa.getPolozenieX());
                for (int j = 0; j < szachownicaTestowa.getFigury().size(); j = j + 1 ) {
                    if (szachownicaTestowa.getFigury().get(j).getRodzajFigury() == RodzajFigury.KROL && figuraNaSzachownicyTestowej.getKolor() == szachownicaTestowa.getFigury().get(j).getKolor()) {
                        polozenieKrolaX = szachownicaTestowa.getFigury().get(j).getPolozenieX();
                        polozenieKrolaY = szachownicaTestowa.getFigury().get(j).getPolozenieY();
                    }
                    for (int k = 0; k < szachownicaTestowa.getFigury().size(); k = k + 1 ) {
                        List<ParametryPola> mozliweRuchyPrzeciwnegoKoloru = szachownicaTestowa.getFigury().get(k).podajMozliweRuchy();
                        for (int l = 0; l < mozliweRuchyPrzeciwnegoKoloru.size(); l = l + 1 ) {
                            boolean zajete = mozliweRuchyPrzeciwnegoKoloru.get(l).isZajete();
                            if(zajete){
                                if(polozenieKrolaX == mozliweRuchyPrzeciwnegoKoloru.get(l).getPolozenieX() && polozenieKrolaY == mozliweRuchyPrzeciwnegoKoloru.get(l).getPolozenieY()){
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public List<ParametryPola> mozliweRuchyZUwglednieniemPozycjiKrola(ParametryPola pozycjaPoczatkowa, List<ParametryPola> mozliweRuchy){
        List<ParametryPola> lista = new ArrayList<>();
        for (int i = 0; i < mozliweRuchy.size(); i = i + 1 ) {
            ParametryPola mozliwyRuch = mozliweRuchy.get(i);
            Szachownica szachownicaTestowa = szachownicaTestowa();
            boolean sprawdzMozliwyRuch = sprawdzMozliwyRuchUwzgledniajacPozycjeKrola(pozycjaPoczatkowa, mozliwyRuch, szachownicaTestowa);
            if(sprawdzMozliwyRuch){
                lista.add(mozliwyRuch);
            }
        }
        return lista;
    }

    public boolean sprawdzCzyBijeKrola (Kolor kolor){
        Szachownica szachownicaTestowa = szachownicaTestowa();
        for (int i = 0; i < szachownicaTestowa.getFigury().size(); i = i + 1 ) {
            if(szachownicaTestowa.getFigury().get(i).getRodzajFigury() == RodzajFigury.KROL && szachownicaTestowa.getFigury().get(i).getKolor() != kolor){
                int polozenieKrolaX = szachownicaTestowa.getFigury().get(i).getPolozenieX();
                int polozenieKrolaY = szachownicaTestowa.getFigury().get(i).getPolozenieY();
                for (int j = 0; j < szachownicaTestowa.getFigury().size(); j = j + 1 ) {
                    List<ParametryPola> mozliweRuchy = szachownicaTestowa.getFigury().get(j).podajMozliweRuchy();
                    for (int k = 0; k < mozliweRuchy.size(); k = k + 1 ) {
                        if(mozliweRuchy.get(k).isZajete()){
                            if(mozliweRuchy.get(k).getPolozenieX() == polozenieKrolaX && mozliweRuchy.get(k).getPolozenieY() == polozenieKrolaY){
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean sprawdzCzyPrzeciwnikMozeWykonacRuch (Kolor kolor){
        Szachownica szachownicaTestowa = szachownicaTestowa();
        for (int i = 0; i < szachownicaTestowa.getFigury().size(); i = i + 1 ) {
            if(szachownicaTestowa.getFigury().get(i).getKolor() != kolor){
                ParametryPola pozycjaPoczatkowa = new ParametryPola(szachownicaTestowa.getFigury().get(i).getPolozenieX(), szachownicaTestowa.getFigury().get(i).getPolozenieY(), true);
                List<ParametryPola> mozliweRuchyZUwzglednieniemPozycjiKrola = mozliweRuchyZUwglednieniemPozycjiKrola(pozycjaPoczatkowa, szachownicaTestowa.getFigury().get(i).podajMozliweRuchy());
                if(mozliweRuchyZUwzglednieniemPozycjiKrola.size()>0){
                    return true;
                }

            }
        }
        return false;
    }

    public TypRuchu typRuchu (Kolor kolor){
        boolean sprawdzCzyBijeKrola = sprawdzCzyBijeKrola(kolor);
        boolean sprawdzCzyPrzeciwnikMozeWykonacRuch = sprawdzCzyPrzeciwnikMozeWykonacRuch(kolor);
        if (sprawdzCzyBijeKrola == true && sprawdzCzyPrzeciwnikMozeWykonacRuch == true){
            return TypRuchu.SZACH;
        }
        else if (sprawdzCzyBijeKrola == true && sprawdzCzyPrzeciwnikMozeWykonacRuch == false){
            return TypRuchu.SZACHMAT;
        }
        else if(sprawdzCzyBijeKrola == false && sprawdzCzyPrzeciwnikMozeWykonacRuch == false){
            return TypRuchu.PAT;
        }
        else return TypRuchu.ZWYKLYRUCH;
    }


    public Kolor kolejnoscRuchuFigurPodWzgledemKoloru (int numerRuchu){
        Kolor kolorRuchuFigury;
        if(numerRuchu % 2 == 0){
            return kolorRuchuFigury = Kolor.BIALY;
        }
        return kolorRuchuFigury = Kolor.CZARNY;
    }

    @Override
    public TypRuchu wykonajRuch(ParametryPolaDto pozycjaPoczatkowa, ParametryPolaDto pozycjaKoncowa) {
        int pozycjaPoczatkowaX = pozycjaPoczatkowa.getPozycjaX();
        int pozycjaPoczatkowaY = pozycjaPoczatkowa.getPozycjaY();
        for (int i = 0; i < szachownica.getFigury().size(); i = i + 1 ){
            Figura figura = szachownica.getFigury().get(i);
            if (pozycjaPoczatkowaX == figura.getPolozenieX() && pozycjaPoczatkowaY == figura.getPolozenieY()){
                List<ParametryPola> mozliweRuchy = figura.podajMozliweRuchy();
                ParametryPola pozycja = new ParametryPola(pozycjaPoczatkowaX, pozycjaPoczatkowaY, true);
                int pozycjaKoncowaX = pozycjaKoncowa.getPozycjaX();
                int pozycjaKoncowaY = pozycjaKoncowa.getPozycjaY();
                List <ParametryPola> listaMozliwychRuchowZUwglednieniemKrola = mozliweRuchyZUwglednieniemPozycjiKrola(pozycja, mozliweRuchy);
                for (int j = 0; j < listaMozliwychRuchowZUwglednieniemKrola.size(); j = j + 1 ){
                   if(pozycjaKoncowaX == listaMozliwychRuchowZUwglednieniemKrola.get(j).getPolozenieX() && pozycjaKoncowaY == listaMozliwychRuchowZUwglednieniemKrola.get(j).getPolozenieY()) {
                      boolean zajete = listaMozliwychRuchowZUwglednieniemKrola.get(j).isZajete();
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
                       return typRuchu(figura.getKolor());
                   }
                }
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void rozpocznijGreOdNowa (){
        List<Figura> listaFigur = new ArrayList<>();
        szachownica.setFigury(listaFigur);
        ustawieniePionkowNaSzachownicy();
    }



    //3. Wykonaj ruch przez wirtualnego przeciwnika- ta fukcja zwraca pozycje poczatkowa i koncowa figury ktora wykonala ruch

}
