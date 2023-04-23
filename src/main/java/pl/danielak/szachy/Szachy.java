package pl.danielak.szachy;

import org.springframework.stereotype.Component;
import pl.danielak.szachy.dto.ParametryPolaDto;
import pl.danielak.szachy.dto.PionekDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class Szachy implements Gra {
    private Szachownica szachownica;
    private int numerRuchu = 0;

    public Szachy () {
        szachownica = new Szachownica();
        ustawieniePionkowNaSzachownicy(Kolor.BIALY);
        ustawieniePionkowNaSzachownicy(Kolor.CZARNY);
    }

    public Szachy(Szachownica szachownica){
        this.szachownica = szachownica;
    }

    public Szachownica getSzachownica() {
        return szachownica;
    }

    public void setSzachownica(Szachownica szachownica) {
        this.szachownica = szachownica;
    }

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

        Kon kon2 = new Kon();
        kon2.setKolor(kolor);
        kon2.setPolozenieX(6);
        kon2.setPolozenieY(polozenieY);
        kon2.setSzachownica(szachownica);
        szachownica.getFigury().add(kon2);

        Laufer laufer1 = new Laufer();
        laufer1.setKolor(kolor);
        laufer1.setPolozenieX(2);
        laufer1.setPolozenieY(polozenieY);
        laufer1.setSzachownica(szachownica);
        szachownica.getFigury().add(laufer1);

        Laufer laufer2 = new Laufer();
        laufer2.setKolor(kolor);
        laufer2.setPolozenieX(5);
        laufer2.setPolozenieY(polozenieY);
        laufer2.setSzachownica(szachownica);
        szachownica.getFigury().add(laufer2);

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

    @Override
    public List<PionekDto> listaPionkow() {
        List<PionekDto> lista = szachownica.getFigury().stream()
                .map(figura -> new PionekDto(figura.getPolozenieX(), figura.getPolozenieY(), figura.getKolor(), figura.getRodzajFigury()))
                .collect(Collectors.toList());
        return lista;
    }


    public Szachownica stworzSzachowniceTestowa(){
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

        Optional<Figura> optionalFigura = szachownica.getFigury().stream()
                .filter(figura -> figura.getKolor() == kolor && figura.getPolozenieX() == pozycjaPoczatkowaX && figura.getPolozenieY() == pozycjaPoczatkowaY)
                .findFirst();

        if(!optionalFigura.isPresent()){
            return null;
        }
        Figura figura = optionalFigura.get();
        ParametryPola pozycjaPoczatkowa = new ParametryPola(pozycjaPoczatkowaX, pozycjaPoczatkowaY, true);
        List<ParametryPolaDto> listaWynikowa = new ArrayList<>();
        List <ParametryPola> lista = figura.podajMozliweRuchy();
        List <ParametryPola> listaMozliwychRuchowZUwglednieniemKrola = mozliweRuchyZUwglednieniemPozycjiKrola(pozycjaPoczatkowa, lista);
        for (int j = 0; j < listaMozliwychRuchowZUwglednieniemKrola.size(); j = j + 1 ){
            ParametryPolaDto parametryPolaDto = new ParametryPolaDto( listaMozliwychRuchowZUwglednieniemKrola.get(j).getPolozenieX(), listaMozliwychRuchowZUwglednieniemKrola.get(j).getPolozenieY());
            listaWynikowa.add(parametryPolaDto);
        }
        return listaWynikowa;

    }

    public boolean sprawdzMozliwyRuchUwzgledniajacPozycjeKrola (ParametryPola pozycjaPoczatkowa, ParametryPola pozycjaKoncowa, Szachownica szachownicaTestowa){
        Optional<Figura> optionalFigura = szachownicaTestowa.getFigury().stream()
                .filter(figura -> figura.getPolozenieX() == pozycjaPoczatkowa.getPolozenieX() && figura.getPolozenieY() == pozycjaPoczatkowa.getPolozenieY())
                .findFirst();
        if(!optionalFigura.isPresent()){
            return true;
        }
        Figura figuraNaSzachownicyTestowej = optionalFigura.get();
        boolean zajetePole = pozycjaKoncowa.isZajete();
        if(zajetePole){
            Optional<Figura> optionalFiguraNaZajetymPolu = szachownicaTestowa.getFigury().stream()
                    .filter(figura -> figura.getPolozenieX() == pozycjaKoncowa.getPolozenieX() && figura.getPolozenieY() == pozycjaKoncowa.getPolozenieY())
                    .findFirst();
            if(optionalFiguraNaZajetymPolu.isPresent()){
                szachownicaTestowa.getFigury().remove(optionalFiguraNaZajetymPolu.get());
            }
        }
        figuraNaSzachownicyTestowej.wykonajRuch(pozycjaKoncowa.getPolozenieY(), pozycjaKoncowa.getPolozenieX());

        Optional<Figura> opcionalKrol = szachownicaTestowa.getFigury().stream()
                .filter(figura -> figura.getRodzajFigury() == RodzajFigury.KROL)
                .filter(figura -> figura.getKolor() == figuraNaSzachownicyTestowej.getKolor())
                .findFirst();

        if(!opcionalKrol.isPresent()) {
            return true;
        }

        final int polozenieKrolaX = opcionalKrol.get().getPolozenieX();
        final int polozenieKrolaY = opcionalKrol.get().getPolozenieY();

        boolean czyBijeKrola = szachownicaTestowa.getFigury().stream()
                .anyMatch(figura -> figura.podajMozliweRuchy()
                        .stream()
                        .filter(mozliwyRuch -> mozliwyRuch.isZajete())
                        .anyMatch(mozliwyRuch -> mozliwyRuch.getPolozenieX() == polozenieKrolaX && mozliwyRuch.getPolozenieY() == polozenieKrolaY));

        return !czyBijeKrola;
    }

    public List<ParametryPola> mozliweRuchyZUwglednieniemPozycjiKrola(ParametryPola pozycjaPoczatkowa, List<ParametryPola> mozliweRuchy){
        List<ParametryPola> lista = mozliweRuchy.stream()
                .filter(mozliwyRuch -> sprawdzMozliwyRuchUwzgledniajacPozycjeKrola(pozycjaPoczatkowa, mozliwyRuch, stworzSzachowniceTestowa()))
                .collect(Collectors.toList());
        return lista;
    }

    public boolean sprawdzCzyBijeKrola (Kolor kolor){
        Optional<Figura> krol = szachownica.getFigury().stream()
                .filter(figura -> figura.getRodzajFigury() == RodzajFigury.KROL && figura.getKolor() != kolor)
                .findFirst();
        if(!krol.isPresent()){
            return false;
        }
        int polozenieKrolaX = krol.get().getPolozenieX();
        int polozenieKrolaY = krol.get().getPolozenieY();
        return szachownica.getFigury().stream()
                .anyMatch(figura -> figura.podajMozliweRuchy().stream()
                        .anyMatch(mozliwyRuch -> mozliwyRuch.getPolozenieX() == polozenieKrolaX && mozliwyRuch.getPolozenieY() == polozenieKrolaY));
    }

    public boolean sprawdzCzyPrzeciwnikMozeWykonacRuch (Kolor kolor){
        for (int i = 0; i < szachownica.getFigury().size(); i = i + 1 ) {
            if(szachownica.getFigury().get(i).getKolor() != kolor){
                ParametryPola pozycjaPoczatkowa = new ParametryPola(szachownica.getFigury().get(i).getPolozenieX(), szachownica.getFigury().get(i).getPolozenieY(), true);
                List<ParametryPola> mozliweRuchyZUwzglednieniemPozycjiKrola = mozliweRuchyZUwglednieniemPozycjiKrola(pozycjaPoczatkowa, szachownica.getFigury().get(i).podajMozliweRuchy());
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
        Optional<Figura> figuraOptional = szachownica.getFigury().stream()
                .filter(figura -> figura.getPolozenieX() == pozycjaPoczatkowa.getPozycjaX() && figura.getPolozenieY() == pozycjaPoczatkowa.getPozycjaY())
                .findFirst();
        if(!figuraOptional.isPresent()){
            throw new IllegalArgumentException();
        }
        List<ParametryPolaDto> mozliweRuchy = podajMozliweRuchy(pozycjaPoczatkowa);
        Optional<ParametryPolaDto> parametryPolaDtoOptional = mozliweRuchy.stream()
                .filter(parametryPola -> parametryPola.getPozycjaX() == pozycjaKoncowa.getPozycjaX() && parametryPola.getPozycjaY() == pozycjaKoncowa.getPozycjaY())
                .findFirst();
        if(!parametryPolaDtoOptional.isPresent()) {
            throw new IllegalArgumentException();
        }
        Optional<Figura> optionalFiguraDoBicia = szachownica.getFigury().stream()
                .filter(figura -> figura.getPolozenieX() == pozycjaKoncowa.getPozycjaX() && figura.getPolozenieY() == pozycjaKoncowa.getPozycjaY())
                .findFirst();
        if(optionalFiguraDoBicia.isPresent()) {
            szachownica.getFigury().remove(optionalFiguraDoBicia.get());
        }
        figuraOptional.get().wykonajRuch(pozycjaKoncowa.getPozycjaY(), pozycjaKoncowa.getPozycjaX());
        zamianaPionkaWKrolowa(figuraOptional.get());
        numerRuchu = numerRuchu +1;
        return typRuchu(figuraOptional.get().getKolor());
    }

    public void zamianaPionkaWKrolowa(Figura figura){
        if(figura.getRodzajFigury() == RodzajFigury.PIONEK){
            int polozenieX = figura.getPolozenieX();
            int polozenieY = figura.getPolozenieY();
            if(figura.getKolor() == Kolor.BIALY && polozenieY == 7){
                szachownica.getFigury().remove(figura);
                Krolowa krolowa = new Krolowa();
                krolowa.setKolor(Kolor.BIALY);
                krolowa.setPolozenieX(polozenieX);
                krolowa.setPolozenieY(polozenieY);
                krolowa.setSzachownica(szachownica);
                szachownica.getFigury().add(krolowa);
            }
            if(figura.getKolor() == Kolor.CZARNY && polozenieY == 0){
                szachownica.getFigury().remove(figura);
                Krolowa krolowa = new Krolowa();
                krolowa.setKolor(Kolor.CZARNY);
                krolowa.setPolozenieX(polozenieX);
                krolowa.setPolozenieY(polozenieY);
                krolowa.setSzachownica(szachownica);
                szachownica.getFigury().add(krolowa);
            }
        }
    }

    @Override
    public void rozpocznijGreOdNowa (){
        List<Figura> listaFigur = new ArrayList<>();
        szachownica.setFigury(listaFigur);
        ustawieniePionkowNaSzachownicy(Kolor.BIALY);
        ustawieniePionkowNaSzachownicy(Kolor.CZARNY);
        numerRuchu = 0;
    }
}
