package pl.danielak.szachy.wirtualnyPrzeciwnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.danielak.szachy.*;
import pl.danielak.szachy.dto.ParametryPolaDto;
import pl.danielak.szachy.dto.ParametryRuchuDto;
import pl.danielak.szachy.dto.PionekDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public ParametryRuchuDto glupiWirtualnyPrzeciwnik() {
        int numerRuchu = szachy.getNumerRuchu();
        Kolor kolor = szachy.kolejnoscRuchuFigurPodWzgledemKoloru(numerRuchu);
        List<PionekDto> listaPionkow = szachy.listaPionkow();
        for (int i = 0; i < listaPionkow.size(); i = i + 1 ){
            if(listaPionkow.get(i).getKolor() == kolor){
                ParametryPolaDto pozycjaPoczatkowa = new ParametryPolaDto(listaPionkow.get(i).getPozycjaX(), listaPionkow.get(i).getPozyjcjaY());
                List<ParametryPolaDto> mozliweRuchy = szachy.podajMozliweRuchy(pozycjaPoczatkowa);
                if(mozliweRuchy.size() > 0){
                    ParametryPolaDto pozycjaKoncowa = new ParametryPolaDto(mozliweRuchy.get(0).getPozycjaX(), mozliweRuchy.get(0).getPozycjaY());
                    szachy.wykonajRuch(pozycjaPoczatkowa, pozycjaKoncowa);
                    return new ParametryRuchuDto(pozycjaPoczatkowa, pozycjaKoncowa);
                }
            }

        }
        return null;
    }


    public RuchWirtualnegoPrzeciwnika wykonajRuchWirtualnymPrzeciwnikiem() {
        List<ParametryRuchuWirtualnegoPrzeciwnika> mozliweRuchy = mozliweRuchy();
        List<ParametryRuchuWirtualnegoPrzeciwnika> najlepszeMin = najlepszeMin(mozliweRuchy);
        if(najlepszeMin.size() > 1){
            List<ParametryRuchuWirtualnegoPrzeciwnika> najlepszeMax = najlepszeMax(najlepszeMin);
            if(najlepszeMax.size() > 1){
                Random randomGenerator = new Random();
                int index = randomGenerator.nextInt(najlepszeMax.size());
                ParametryPolaDto pozycjaPoczatkowa = najlepszeMax.get(index).getPolozeniePoczatkowe();
                ParametryPolaDto pozycjaKoncowa = najlepszeMax.get(index).getPolozenieKoncowe();
                TypRuchu typRuchu = szachy.wykonajRuch(pozycjaPoczatkowa, pozycjaKoncowa);
                ParametryRuchuDto parametryRuchuDto = new ParametryRuchuDto(pozycjaPoczatkowa, pozycjaKoncowa);
                return new RuchWirtualnegoPrzeciwnika(parametryRuchuDto, typRuchu);
            }
            else{
                ParametryPolaDto pozycjaPoczatkowa = najlepszeMax.get(0).getPolozeniePoczatkowe();
                ParametryPolaDto pozycjaKoncowa = najlepszeMax.get(0).getPolozenieKoncowe();
                TypRuchu typRuchu = szachy.wykonajRuch(pozycjaPoczatkowa, pozycjaKoncowa);
                ParametryRuchuDto parametryRuchuDto = new ParametryRuchuDto(pozycjaPoczatkowa, pozycjaKoncowa);
                return new RuchWirtualnegoPrzeciwnika(parametryRuchuDto, typRuchu);
            }
        }
        else {
            ParametryPolaDto pozycjaPoczatkowa = najlepszeMin.get(0).getPolozeniePoczatkowe();
            ParametryPolaDto pozycjaKoncowa = najlepszeMin.get(0).getPolozenieKoncowe();
            TypRuchu typRuchu = szachy.wykonajRuch(pozycjaPoczatkowa, pozycjaKoncowa);
            ParametryRuchuDto parametryRuchuDto = new ParametryRuchuDto(pozycjaPoczatkowa, pozycjaKoncowa);
            return new RuchWirtualnegoPrzeciwnika(parametryRuchuDto, typRuchu);
        }
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
        int numerRuchu = szachy.getNumerRuchu();
        Kolor kolor = szachy.kolejnoscRuchuFigurPodWzgledemKoloru(numerRuchu);
        List<PionekDto> listaFigur = szachy.listaPionkow();
        for (int i = 0; i < listaFigur.size(); i = i + 1 ){
            if(listaFigur.get(i).getKolor() == kolor){
                ParametryPolaDto pozycjaPoczatkowa = new ParametryPolaDto(listaFigur.get(i).getPozycjaX(), listaFigur.get(i).getPozyjcjaY());
                List<ParametryPolaDto> mozliweRuchy = szachy.podajMozliweRuchy(pozycjaPoczatkowa);
                for (int j = 0; j < mozliweRuchy.size(); j = j + 1 ){
                    ParametryPolaDto pozycjaKoncowa = new ParametryPolaDto(mozliweRuchy.get(j).getPozycjaX(), mozliweRuchy.get(j).getPozycjaY());
                    ParametryRuchuWirtualnegoPrzeciwnika parametryRuchu = generujParametryRuchuWirtualnegoPrzeciwnika(pozycjaPoczatkowa, pozycjaKoncowa);
                    lista.add(parametryRuchu);
                }
            }
        }
        return lista;
    }

    public TypRuchu ruch (Figura figura, ParametryPolaDto pozycjaKoncowa, Szachy szachy) {
        Szachownica szachownica = szachy.getSzachownica();
        for (int j = 0; j < szachownica.getFigury().size(); j = j + 1) {
            if (szachownica.getFigury().get(j).getPolozenieX() == pozycjaKoncowa.getPozycjaX() && szachownica.getFigury().get(j).getPolozenieY() == pozycjaKoncowa.getPozycjaY()) {
                szachownica.getFigury().remove(j);
            }
        }
        figura.wykonajRuch(pozycjaKoncowa.getPozycjaY(), pozycjaKoncowa.getPozycjaX());
        szachy.setNumerRuchu(szachy.getNumerRuchu()+1);
        szachy.zamianaPionkaWKrolowa(figura);
        return szachy.typRuchu(figura.getKolor());
    }



    public ParametryRuchuWirtualnegoPrzeciwnika generujParametryRuchuWirtualnegoPrzeciwnika (ParametryPolaDto pozycjaPoczatkowa, ParametryPolaDto pozycjaKoncowa){
        int minimalnaWartoscRuchu = 1000;
        int maksymalnaWartoscRuchu = -1000;
        int numerRuchu = szachy.getNumerRuchu();
        TypRuchu typRuchu1 = null;
        Szachy szachyTestowe = zrobWirtualneSzachy(szachy);
        Szachownica szachownicaTestowa = szachyTestowe.getSzachownica();
        for (int i = 0; i < szachownicaTestowa.getFigury().size(); i = i + 1) {
            Figura figura = szachownicaTestowa.getFigury().get(i);
            Kolor kolor = figura.getKolor();
            if (figura.getPolozenieX() == pozycjaPoczatkowa.getPozycjaX() && figura.getPolozenieY() == pozycjaPoczatkowa.getPozycjaY()) {
                TypRuchu typRuchu = ruch(figura, pozycjaKoncowa, szachyTestowe);
                if (typRuchu == TypRuchu.SZACHMAT) {
                    return new ParametryRuchuWirtualnegoPrzeciwnika(pozycjaPoczatkowa, pozycjaKoncowa, 50, 50);
                } else if (typRuchu == TypRuchu.PAT) {
                    return new ParametryRuchuWirtualnegoPrzeciwnika(pozycjaPoczatkowa, pozycjaKoncowa, 0, 0);
                } else {
                    for (int j = 0; j < szachownicaTestowa.getFigury().size(); j = j + 1) {
                        if(szachownicaTestowa.getFigury().get(j).getKolor() != kolor){
                            ParametryPolaDto pozycjaPoczatkowaPrzeciwnegoKoloru = new ParametryPolaDto(szachownicaTestowa.getFigury().get(j).getPolozenieX(), szachownicaTestowa.getFigury().get(j).getPolozenieY());
                            List<ParametryPolaDto> mozliweRuchy = szachyTestowe.podajMozliweRuchy(pozycjaPoczatkowaPrzeciwnegoKoloru);
                            for (int k = 0; k < mozliweRuchy.size(); k = k + 1) {
                                Szachy szachyTestoweNaOdpowiedzPrzeciwnika = zrobWirtualneSzachy(szachyTestowe);
                                ParametryPolaDto pozycjaKoncowaMozliwegoRuchu = new ParametryPolaDto(mozliweRuchy.get(k).getPozycjaX(), mozliweRuchy.get(k).getPozycjaY());
                                typRuchu1 = ruch(szachownicaTestowa.getFigury().get(j), pozycjaKoncowaMozliwegoRuchu, szachyTestoweNaOdpowiedzPrzeciwnika);
                                if(typRuchu1 == TypRuchu.SZACHMAT){
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
                    }
                }
                return new ParametryRuchuWirtualnegoPrzeciwnika(pozycjaPoczatkowa, pozycjaKoncowa, minimalnaWartoscRuchu, maksymalnaWartoscRuchu);
            }
        }
        return null;
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
        Szachy wirtualneSzachy = new Szachy(szachy.szachownicaTestowa());
        wirtualneSzachy.setNumerRuchu(szachy.getNumerRuchu());
        return wirtualneSzachy;
    }


    //Skonczyc metode, wykonajRuch, kosmetyka, poprawa Conrollera, sprawdzic czy dziala postmanem
    //wykonaj kazdy mozliwy ruch, ocen ten ruch - ocena ruchu na podstawie, czy robi szach-mat, czy bije jakas figure
    // dla kazdego mozliwego ruchu wykonaj mozliwa odpowiedz przeciwnika, i ja ocen
    // docelowo dostajemy liste obiektow, ktore zawieraja informacje o: polozenie poczatkowe, polozenie koncowe, minimalna wartosc ruchu, maksymalna wartosc ruchu
    // docelowy ruch wykonuje figura z najwieksza wartoscia min, jesli kilka figur ma taka sama wartosc min to ruch wykonuje figura z majwieksza wartoscia max, jesli max jest kila takich samych to losowo
// pionek wartosc 1
    // ktolowa 9
    //wieza 5
    // laufer 3
    // kon 3
    // szach mat 50
    //

}
