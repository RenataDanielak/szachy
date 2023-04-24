package pl.danielak.szachy.wirtualnyPrzeciwnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.danielak.szachy.*;
import pl.danielak.szachy.dto.ParametryPolaDto;
import pl.danielak.szachy.dto.ParametryRuchuDto;
import pl.danielak.szachy.dto.PionekDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class WirtualnyPrzeciwnik {

    @Autowired
    private Szachy szachy;

    public WirtualnyPrzeciwnik(Szachy szachy) {
        this.szachy = szachy;
    }

    public Szachy getSzachy() {
        return szachy;
    }

    public void setSzachy(Szachy szachy) {
        this.szachy = szachy;
    }

    public RuchWirtualnegoPrzeciwnika wykonajRuchWirtualnymPrzeciwnikiem() {
        List<ParametryRuchuWirtualnegoPrzeciwnika> mozliweRuchy = mozliweRuchy();
        List<ParametryRuchuWirtualnegoPrzeciwnika> najlepszeMin = najlepszeMin(mozliweRuchy);
        ParametryPolaDto pozycjaPoczatkowa;
        ParametryPolaDto pozycjaKoncowa;
        if(najlepszeMin.size() > 1){
            List<ParametryRuchuWirtualnegoPrzeciwnika> najlepszeMax = najlepszeMax(najlepszeMin);
            if(najlepszeMax.size() > 1){
                Random randomGenerator = new Random();
                int index = randomGenerator.nextInt(najlepszeMax.size());
                pozycjaPoczatkowa = najlepszeMax.get(index).getPolozeniePoczatkowe();
                pozycjaKoncowa = najlepszeMax.get(index).getPolozenieKoncowe();

            }
            else{
                pozycjaPoczatkowa = najlepszeMax.get(0).getPolozeniePoczatkowe();
                pozycjaKoncowa = najlepszeMax.get(0).getPolozenieKoncowe();
            }
        }
        else {
            pozycjaPoczatkowa = najlepszeMin.get(0).getPolozeniePoczatkowe();
            pozycjaKoncowa = najlepszeMin.get(0).getPolozenieKoncowe();
        }
        TypRuchu typRuchu = szachy.wykonajRuch(pozycjaPoczatkowa, pozycjaKoncowa);
        ParametryRuchuDto parametryRuchuDto = new ParametryRuchuDto(pozycjaPoczatkowa, pozycjaKoncowa);
        return new RuchWirtualnegoPrzeciwnika(parametryRuchuDto, typRuchu);
    }

    public List<ParametryRuchuWirtualnegoPrzeciwnika> najlepszeMin(List<ParametryRuchuWirtualnegoPrzeciwnika> mozliweRuchy){
        List<ParametryRuchuWirtualnegoPrzeciwnika> lista = new ArrayList<>();
        int najlepszaMinimalnaWartoscRuchu = -1000;
        for (int i = 0; i < mozliweRuchy.size(); i = i + 1 ){
            int min = mozliweRuchy.get(i).getMinimalnaWartoscRuchu();
            if(min == najlepszaMinimalnaWartoscRuchu){
                lista.add(mozliweRuchy.get(i));
            }
            if(min > najlepszaMinimalnaWartoscRuchu){
                najlepszaMinimalnaWartoscRuchu = min;
                lista = new ArrayList<>();
                lista.add(mozliweRuchy.get(i));
            }
        }
        return lista;
    }

    public List<ParametryRuchuWirtualnegoPrzeciwnika> najlepszeMax(List<ParametryRuchuWirtualnegoPrzeciwnika> najlepszeMin){
        List<ParametryRuchuWirtualnegoPrzeciwnika> lista = new ArrayList<>();
        int najlepszeMax = -1000;
        for (int i = 0; i < najlepszeMin.size(); i = i + 1 ){
            int max = najlepszeMin.get(i).getMaksymalnaWartoscRuchu();
            if(max == najlepszeMax){
                lista.add(najlepszeMin.get(i));
            }
            if(max > najlepszeMax){
                najlepszeMax = max;
                lista = new ArrayList<>();
                lista.add(najlepszeMin.get(i));
            }
        }
        return lista;
    }

    public List<ParametryRuchuWirtualnegoPrzeciwnika> mozliweRuchy() {
        List<ParametryRuchuWirtualnegoPrzeciwnika> lista = new ArrayList<>();
        Kolor kolor = szachy.kolejnoscRuchuFigurPodWzgledemKoloru(szachy.getNumerRuchu());
        List<PionekDto> listaFigur = szachy.listaPionkow();
        List<ParametryPolaDto> pozycjePoczatkowe = listaFigur.stream()
                .filter(figura -> figura.getKolor() == kolor)
                .map(figura -> new ParametryPolaDto(figura.getPozycjaX(), figura.getPozyjcjaY()))
                .collect(Collectors.toList());
        for (int i = 0; i < pozycjePoczatkowe.size(); i = i + 1 ){
            List<ParametryPolaDto> mozliweRuchy = szachy.podajMozliweRuchy(pozycjePoczatkowe.get(i));
            for (int j = 0; j < mozliweRuchy.size(); j = j + 1 ){
                ParametryPolaDto pozycjaKoncowa = new ParametryPolaDto(mozliweRuchy.get(j).getPozycjaX(), mozliweRuchy.get(j).getPozycjaY());
                ParametryRuchuWirtualnegoPrzeciwnika parametryRuchu = generujParametryRuchuWirtualnegoPrzeciwnika(pozycjePoczatkowe.get(i), pozycjaKoncowa);
                lista.add(parametryRuchu);
            }
        }
        return lista;
    }

    public TypRuchu ruch (Figura figura, ParametryPolaDto pozycjaKoncowa, Szachy szachy) {
        Szachownica szachownica = szachy.getSzachownica();
        Optional<Figura> figuraOptional = szachownica.getFigury().stream()
                .filter(bierka -> bierka.getPolozenieX() == pozycjaKoncowa.getPozycjaX() && bierka.getPolozenieY() == pozycjaKoncowa.getPozycjaY())
                .findFirst();
        if(figuraOptional.isPresent()){
            szachownica.getFigury().remove(figuraOptional.get());
        }
        figura.wykonajRuch(pozycjaKoncowa.getPozycjaY(), pozycjaKoncowa.getPozycjaX());
        szachy.setNumerRuchu(szachy.getNumerRuchu()+1);
        szachy.zamianaPionkaWKrolowa(figura);
        return szachy.typRuchu(figura.getKolor());
    }



    public ParametryRuchuWirtualnegoPrzeciwnika generujParametryRuchuWirtualnegoPrzeciwnika (ParametryPolaDto pozycjaPoczatkowa, ParametryPolaDto pozycjaKoncowa){
        int minimalnaWartoscRuchu = 1000;
        int maksymalnaWartoscRuchu = -1000;
        Szachy szachyTestowe = zrobWirtualneSzachy(szachy);
        Szachownica szachownicaTestowa = szachyTestowe.getSzachownica();
        Optional<Figura> figuraOptional = szachownicaTestowa.getFigury().stream()
                .filter(figura -> figura.getPolozenieX() == pozycjaPoczatkowa.getPozycjaX() && figura.getPolozenieY() == pozycjaPoczatkowa.getPozycjaY())
                .findFirst();
        if(!figuraOptional.isPresent()){
            return null;
        }
        Kolor kolor = figuraOptional.get().getKolor();
        TypRuchu typRuchu = ruch(figuraOptional.get(), pozycjaKoncowa, szachyTestowe);
        if (typRuchu == TypRuchu.SZACHMAT) {
            return new ParametryRuchuWirtualnegoPrzeciwnika(pozycjaPoczatkowa, pozycjaKoncowa, 50, 50);
        } else if (typRuchu == TypRuchu.PAT) {
            return new ParametryRuchuWirtualnegoPrzeciwnika(pozycjaPoczatkowa, pozycjaKoncowa, 0, 0);
        } else {
            List<Figura> listaFigurPrzeciwnegoKoloru = szachownicaTestowa.getFigury().stream()
                    .filter(figura -> figura.getKolor() != kolor)
                    .collect(Collectors.toList());
            List<ParametryPolaDto> pozycjePoczatkowePrzeciwnegoKoloru = listaFigurPrzeciwnegoKoloru.stream()
                    .map(figura -> new ParametryPolaDto(figura.getPolozenieX(), figura.getPolozenieY()))
                    .collect(Collectors.toList());
            for (int i = 0; i < pozycjePoczatkowePrzeciwnegoKoloru.size(); i = i + 1) {
                List<ParametryPolaDto> mozliweRuchy = szachyTestowe.podajMozliweRuchy(pozycjePoczatkowePrzeciwnegoKoloru.get(i));
                for (int j = 0; j < mozliweRuchy.size(); j = j + 1) {
                    Szachy szachyTestoweNaOdpowiedzPrzeciwnika = zrobWirtualneSzachy(szachyTestowe);
                    ParametryPolaDto pozycjaKoncowaMozliwegoRuchu = new ParametryPolaDto(mozliweRuchy.get(j).getPozycjaX(), mozliweRuchy.get(j).getPozycjaY());
                    Optional<TypRuchu> typRuchuOptional = listaFigurPrzeciwnegoKoloru.stream()
                            .map(figura -> ruch(figura, pozycjaKoncowaMozliwegoRuchu, szachyTestoweNaOdpowiedzPrzeciwnika))
                            .findFirst();
                    if(!typRuchuOptional.isPresent()){
                        return null;
                    }
                    if(typRuchuOptional.get() == TypRuchu.SZACHMAT){
                        minimalnaWartoscRuchu = -50;
                    }
                    else {
                        List<PionekDto> listaPionkow = szachyTestoweNaOdpowiedzPrzeciwnika.listaPionkow();
                        int wartoscPionkowNaPlanszy = wartoscPionkowNaPlanszy(listaPionkow, kolor);
                        if(wartoscPionkowNaPlanszy < minimalnaWartoscRuchu){
                            minimalnaWartoscRuchu = wartoscPionkowNaPlanszy;
                        }
                        if(wartoscPionkowNaPlanszy > maksymalnaWartoscRuchu){
                            maksymalnaWartoscRuchu = wartoscPionkowNaPlanszy;
                        }
                    }
            }
        }
            return new ParametryRuchuWirtualnegoPrzeciwnika(pozycjaPoczatkowa, pozycjaKoncowa, minimalnaWartoscRuchu, maksymalnaWartoscRuchu);
        }
    }


    public int wartoscPionkowNaPlanszy (List<PionekDto> listaPionkow, Kolor kolor){
        int wartoscPionkowNaPlanszy = 0;
        int wartoscFigury = 0;
        for (int i = 0; i < listaPionkow.size(); i = i + 1 ){
            RodzajFigury rodzajFigury = listaPionkow.get(i).getFigura();
            if(rodzajFigury == RodzajFigury.KON || rodzajFigury == RodzajFigury.LAUFER){
                wartoscFigury = 3;
            }
            else if(rodzajFigury == RodzajFigury.PIONEK){
                wartoscFigury = 1;
            }
            else if(rodzajFigury == RodzajFigury.WIEZA){
                wartoscFigury = 5;
            }
            else if(rodzajFigury == RodzajFigury.KROL){
                wartoscFigury = 0;
            }
            else if(rodzajFigury == RodzajFigury.KROLOWA){
                wartoscFigury = 9;
            }
            if(listaPionkow.get(i).getKolor() == kolor){
                wartoscPionkowNaPlanszy = wartoscPionkowNaPlanszy + wartoscFigury;
            }
            if(listaPionkow.get(i).getKolor() != kolor){
               wartoscPionkowNaPlanszy = wartoscPionkowNaPlanszy - wartoscFigury;
            }

        }
        return wartoscPionkowNaPlanszy;
    }

    private Szachy zrobWirtualneSzachy (Szachy szachy){
        Szachy wirtualneSzachy = new Szachy(szachy.stworzSzachowniceTestowa());
        wirtualneSzachy.setNumerRuchu(szachy.getNumerRuchu());
        return wirtualneSzachy;
    }

}
