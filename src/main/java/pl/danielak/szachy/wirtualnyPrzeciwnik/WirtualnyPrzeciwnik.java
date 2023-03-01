package pl.danielak.szachy.wirtualnyPrzeciwnik;
import pl.danielak.szachy.Kolor;
import pl.danielak.szachy.ParametryPola;
import pl.danielak.szachy.Szachy;
import pl.danielak.szachy.TypRuchu;
import pl.danielak.szachy.dto.ParametryPolaDto;
import pl.danielak.szachy.dto.ParametryRuchuDto;
import pl.danielak.szachy.dto.PionekDto;

import java.util.List;

public class WirtualnyPrzeciwnik {

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

    public ParametryRuchuDto wykonajRuch() {
        int numerRuchu = szachy.getNumerRuchu();
        Kolor kolor = szachy.kolejnoscRuchuFigurPodWzgledemKoloru(numerRuchu);
        List<PionekDto> listaPionkow = szachy.listaPionkow();
        for (int i = 0; i < listaPionkow.size(); i = i + 1 ){
            if(listaPionkow.get(i).getKolor() == kolor){
                ParametryPolaDto pozycjaPoczatkowaDto = new ParametryPolaDto(listaPionkow.get(i).getPozycjaX(), listaPionkow.get(i).getPozyjcjaY());
                List<ParametryPolaDto> mozliweRuchy = szachy.podajMozliweRuchy(pozycjaPoczatkowaDto);
                if(mozliweRuchy.size() > 0){
                    szachy.wykonajRuch(new ParametryPolaDto(listaPionkow.get(i).getPozycjaX(), listaPionkow.get(i).getPozyjcjaY()), new ParametryPolaDto(mozliweRuchy.get(0).getPozycjaX(), mozliweRuchy.get(0).getPozycjaY()));
                    ParametryPolaDto pozycjaKoncowa = new ParametryPolaDto(mozliweRuchy.get(0).getPozycjaX(), mozliweRuchy.get(0).getPozycjaY());
                    return new ParametryRuchuDto(pozycjaPoczatkowaDto, pozycjaKoncowa);
                }
            }

        }
        return null;

    }

//    public int wartoscRuchu (TypRuchu typRuchu, ParametryPola pozycjaKoncowa){
//        if()
//        return 0;
//    }

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
