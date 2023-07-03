package pl.danielak.szachy.wirtualnyPrzeciwnik;

import org.junit.jupiter.api.Test;
import pl.danielak.szachy.*;
import pl.danielak.szachy.dto.ParametryPolaDto;
import pl.danielak.szachy.dto.ParametryRuchuDto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class WirtualnyPrzeciwnikIntegracyjnyTest {

    WirtualnyPrzeciwnik wirtualnyPrzeciwnik;

    Szachy szachy;
    Szachownica szachownica;

    @Test
    void T01_WirtualnyPrzeciwnikPowinienZbicNieobstawionaFigure(){
        //src/test/resources/wirtualnyPrzeciwnikIntegracyjnyTest/T01.png
        Given:
        szachownica = new Szachownica();
        Krol krolBialy = new Krol(3, 0 , Kolor.BIALY, szachownica);
        Krol krolCzarny = new Krol(3, 7, Kolor.CZARNY, szachownica);
        Krolowa krolowaBiala = new Krolowa(5, 1, Kolor.BIALY, szachownica);
        Krolowa krolowaCzarna = new Krolowa(5, 5, Kolor.CZARNY, szachownica);

        szachownica.getFigury().add(krolBialy);
        szachownica.getFigury().add(krolCzarny);
        szachownica.getFigury().add(krolowaBiala);
        szachownica.getFigury().add(krolowaCzarna);

        szachy = new Szachy(szachownica);
        wirtualnyPrzeciwnik = new WirtualnyPrzeciwnik(szachy);

        RuchWirtualnegoPrzeciwnika ruch;

        When:
        ruch = wirtualnyPrzeciwnik.wykonajRuchWirtualnymPrzeciwnikiem();

        Then:
        assertEquals(ruch.getParametryRuchuDto(), new ParametryRuchuDto(new ParametryPolaDto(5, 1), new ParametryPolaDto(5, 5)));
        assertEquals(ruch.getParametryRuchuDto().getStart().getPozycjaX(), 5);
        assertEquals(ruch.getParametryRuchuDto().getStart().getPozycjaY(), 1);
        assertEquals(ruch.getParametryRuchuDto().getKoniec().getPozycjaX(), 5);
        assertEquals(ruch.getParametryRuchuDto().getKoniec().getPozycjaY(), 5);

    }

    @Test
    void T02_WirtualnyPrzeciwnikPowinienZbicBardziejWartosciowaFigure(){
        //src\test\resources\wirtualnyPrzeciwnikIntegracyjnyTest\T02.png
        Given:
        szachownica = new Szachownica();
        Krol krolBialy = new Krol(5, 0 , Kolor.BIALY, szachownica);
        Krol krolCzarny = new Krol(6, 7, Kolor.CZARNY, szachownica);
        Wieza wiezaBiala = new Wieza(4, 2, Kolor.BIALY, szachownica);
        Wieza wiezaCzarna = new Wieza(1, 2, Kolor.CZARNY, szachownica);
        Pionek pionekCzarny = new Pionek(4, 6, Kolor.CZARNY, szachownica);

        szachownica.getFigury().add(krolBialy);
        szachownica.getFigury().add(krolCzarny);
        szachownica.getFigury().add(wiezaBiala);
        szachownica.getFigury().add(wiezaCzarna);
        szachownica.getFigury().add(pionekCzarny);

        szachy = new Szachy(szachownica);
        wirtualnyPrzeciwnik = new WirtualnyPrzeciwnik(szachy);

        RuchWirtualnegoPrzeciwnika ruch;

        When:
        ruch = wirtualnyPrzeciwnik.wykonajRuchWirtualnymPrzeciwnikiem();

        Then:
        assertEquals(ruch.getParametryRuchuDto(), new ParametryRuchuDto(new ParametryPolaDto(4, 2), new ParametryPolaDto(1, 2)));
        assertEquals(ruch.getParametryRuchuDto().getStart().getPozycjaX(), 4);
        assertEquals(ruch.getParametryRuchuDto().getStart().getPozycjaY(), 2);
        assertEquals(ruch.getParametryRuchuDto().getKoniec().getPozycjaX(), 1);
        assertEquals(ruch.getParametryRuchuDto().getKoniec().getPozycjaY(), 2);
    }

    @Test
    void T03_WirtualnyPrzeciwnikNieBijeFiguryPrzeciwnikaKiedyOdslaniaBardziejWartosciowaFigureSwojegoKoloru(){
        //src\test\resources\wirtualnyPrzeciwnikIntegracyjnyTest\T03.png
        Given:
        szachownica = new Szachownica();
        Krol krolBialy = new Krol(0, 0 , Kolor.BIALY, szachownica);
        Krol krolCzarny = new Krol(1, 7, Kolor.CZARNY, szachownica);
        Krolowa krolowaBiala = new Krolowa(3, 0, Kolor.BIALY, szachownica);
        Wieza wiezaBiala = new Wieza(4, 1, Kolor.BIALY, szachownica);
        Krolowa krolowaCzarna = new Krolowa(6, 3, Kolor.CZARNY, szachownica);
        Kon konCzarny = new Kon(4, 4, Kolor.CZARNY, szachownica);

        szachownica.getFigury().add(krolBialy);
        szachownica.getFigury().add(krolCzarny);
        szachownica.getFigury().add(krolowaBiala);
        szachownica.getFigury().add(wiezaBiala);
        szachownica.getFigury().add(krolowaCzarna);
        szachownica.getFigury().add(konCzarny);

        szachy = new Szachy(szachownica);
        wirtualnyPrzeciwnik = new WirtualnyPrzeciwnik(szachy);

        RuchWirtualnegoPrzeciwnika ruch;

        When:
        ruch = wirtualnyPrzeciwnik.wykonajRuchWirtualnymPrzeciwnikiem();

        Then:
        assertNotEquals(ruch.getParametryRuchuDto(), new ParametryRuchuDto(new ParametryPolaDto(4 ,1), new ParametryPolaDto(4, 4)));
    }

    @Test
    void T04_WirtualnyPrzeciwnikNieBijePionkaPrzeciwnikaKiedyPoTymRuchuStanalbyNaLinniBiciaCenniejszaFigura(){
        //src\test\resources\wirtualnyPrzeciwnikIntegracyjnyTest\T04.png
        Given:
        szachownica = new Szachownica();
        Krol krolBialy = new Krol(0, 0 , Kolor.BIALY, szachownica);
        Krol krolCzarny = new Krol(1, 7, Kolor.CZARNY, szachownica);
        Wieza wiezaBiala = new Wieza(4, 0, Kolor.BIALY, szachownica);
        Krolowa krolowaCzarna = new Krolowa(7, 4, Kolor.CZARNY, szachownica);
        Pionek pionekCzarny = new Pionek(4, 4, Kolor.CZARNY, szachownica);

        szachownica.getFigury().add(krolBialy);
        szachownica.getFigury().add(krolCzarny);
        szachownica.getFigury().add(wiezaBiala);
        szachownica.getFigury().add(krolowaCzarna);
        szachownica.getFigury().add(pionekCzarny);

        szachy = new Szachy(szachownica);
        wirtualnyPrzeciwnik = new WirtualnyPrzeciwnik(szachy);

        RuchWirtualnegoPrzeciwnika ruch;

        When:
        ruch = wirtualnyPrzeciwnik.wykonajRuchWirtualnymPrzeciwnikiem();

        Then:
        assertNotEquals(ruch.getParametryRuchuDto(), new ParametryRuchuDto(new ParametryPolaDto(4 ,0), new ParametryPolaDto(4, 4)));

    }

    @Test
    void T05_WirtualnyPrzeciwnikUciekaFiguraJesliMozeJaStracic(){
        //src\test\resources\wirtualnyPrzeciwnikIntegracyjnyTest\T05.png
        Given:
        szachownica = new Szachownica();
        Krol krolBialy = new Krol(0, 1 , Kolor.BIALY, szachownica);
        Wieza wiezaBiala = new Wieza(1, 1, Kolor.BIALY, szachownica);
        Kon konBialy = new Kon(3, 2, Kolor.BIALY, szachownica);
        Wieza wiezaCzarna = new Wieza(7, 2, Kolor.CZARNY, szachownica);
        Pionek pionekCzarny = new Pionek(4, 7, Kolor.CZARNY, szachownica);

        szachownica.getFigury().add(krolBialy);
        szachownica.getFigury().add(wiezaBiala);
        szachownica.getFigury().add(konBialy);
        szachownica.getFigury().add(wiezaCzarna);
        szachownica.getFigury().add(pionekCzarny);

        szachy = new Szachy(szachownica);
        wirtualnyPrzeciwnik = new WirtualnyPrzeciwnik(szachy);

        RuchWirtualnegoPrzeciwnika ruch;

        When:
        ruch = wirtualnyPrzeciwnik.wykonajRuchWirtualnymPrzeciwnikiem();

        Then:
        assertEquals(ruch.getParametryRuchuDto().getStart().getPozycjaX(), 3);
        assertEquals(ruch.getParametryRuchuDto().getStart().getPozycjaY(), 2);
    }

    @Test
    void T06_PionWirtualnegoPrzeciwnikaWPrzedOstatnimRzedzie(){
        //src\test\resources\wirtualnyPrzeciwnikIntegracyjnyTest\T06.png
        Given:
        szachownica = new Szachownica();
        Krol krolBialy = new Krol(3, 0 , Kolor.BIALY, szachownica);
        Krol krolCzarny = new Krol(6, 7, Kolor.CZARNY, szachownica);
        Wieza wiezaBiala = new Wieza(0, 1, Kolor.BIALY, szachownica);
        Pionek pionekBialy = new Pionek(1, 6, Kolor.BIALY, szachownica);
        Kon konCzarny = new Kon(5, 4, Kolor.CZARNY, szachownica);

        szachownica.getFigury().add(krolBialy);
        szachownica.getFigury().add(krolCzarny);
        szachownica.getFigury().add(wiezaBiala);
        szachownica.getFigury().add(pionekBialy);
        szachownica.getFigury().add(konCzarny);

        szachy = new Szachy(szachownica);
        wirtualnyPrzeciwnik = new WirtualnyPrzeciwnik(szachy);

        RuchWirtualnegoPrzeciwnika ruch;

        When:
        ruch = wirtualnyPrzeciwnik.wykonajRuchWirtualnymPrzeciwnikiem();

        Then:
        assertEquals(ruch.getParametryRuchuDto(), new ParametryRuchuDto(new ParametryPolaDto(1 ,6), new ParametryPolaDto(1, 7)));
        assertEquals(ruch.getParametryRuchuDto().getStart().getPozycjaX(), 1);
        assertEquals(ruch.getParametryRuchuDto().getStart().getPozycjaY(), 6);
        assertEquals(ruch.getParametryRuchuDto().getKoniec().getPozycjaX(), 1);
        assertEquals(ruch.getParametryRuchuDto().getKoniec().getPozycjaY(), 7);
    }

    @Test
    void T07_PionWirtualnegoPrzeciwnikaWPrzedOstatnimRzedzieAleJesliZamieniSieWKrolowaToJaStraci(){
        //src\test\resources\wirtualnyPrzeciwnikIntegracyjnyTest\T07.png
        Given:
        szachownica = new Szachownica();
        Krol krolBialy = new Krol(3, 0 , Kolor.BIALY, szachownica);
        Krol krolCzarny = new Krol(6, 7, Kolor.CZARNY, szachownica);
        Wieza wiezaBiala = new Wieza(0, 1, Kolor.BIALY, szachownica);
        Pionek pionekBialy = new Pionek(1, 6, Kolor.BIALY, szachownica);
        Kon konCzarny = new Kon(5, 4, Kolor.CZARNY, szachownica);
        Krolowa krolowaCzarna = new Krolowa(4, 7, Kolor.CZARNY, szachownica);

        szachownica.getFigury().add(krolBialy);
        szachownica.getFigury().add(krolCzarny);
        szachownica.getFigury().add(wiezaBiala);
        szachownica.getFigury().add(pionekBialy);
        szachownica.getFigury().add(konCzarny);
        szachownica.getFigury().add(krolowaCzarna);

        szachy = new Szachy(szachownica);
        wirtualnyPrzeciwnik = new WirtualnyPrzeciwnik(szachy);

        RuchWirtualnegoPrzeciwnika ruch;

        When:
        ruch = wirtualnyPrzeciwnik.wykonajRuchWirtualnymPrzeciwnikiem();

        Then:
        assertNotEquals(ruch.getParametryRuchuDto(), new ParametryRuchuDto(new ParametryPolaDto(1 ,6), new ParametryPolaDto(1, 7)));
    }

    @Test
    void T08_WirtualnyPrzeciwnikJesliMozeZrobicSzachMatAlboZbicInnaFigureWybierzeSzachMat(){
        //src\test\resources\wirtualnyPrzeciwnikIntegracyjnyTest\T08.png
        Given:
        szachownica = new Szachownica();
        Krol krolBialy = new Krol(4, 7 , Kolor.BIALY, szachownica);
        Krol krolCzarny = new Krol(1, 0, Kolor.CZARNY, szachownica);
        Wieza wiezaBiala = new Wieza(6, 1, Kolor.BIALY, szachownica);
        Wieza wiezaBiala2 = new Wieza(5, 5, Kolor.BIALY, szachownica);
        Krolowa krolowaCzarna = new Krolowa(1, 5, Kolor.CZARNY, szachownica);

        szachownica.getFigury().add(krolBialy);
        szachownica.getFigury().add(krolCzarny);
        szachownica.getFigury().add(wiezaBiala);
        szachownica.getFigury().add(wiezaBiala2);
        szachownica.getFigury().add(krolowaCzarna);

        szachy = new Szachy(szachownica);
        wirtualnyPrzeciwnik = new WirtualnyPrzeciwnik(szachy);

        RuchWirtualnegoPrzeciwnika ruch;

        When:
        ruch = wirtualnyPrzeciwnik.wykonajRuchWirtualnymPrzeciwnikiem();

        Then:
        assertEquals(ruch.getParametryRuchuDto(), new ParametryRuchuDto(new ParametryPolaDto(5, 5), new ParametryPolaDto(5, 0)));
        assertEquals(ruch.getParametryRuchuDto().getStart().getPozycjaX(), 5);
        assertEquals(ruch.getParametryRuchuDto().getStart().getPozycjaY(), 5);
        assertEquals(ruch.getParametryRuchuDto().getKoniec().getPozycjaX(), 5);
        assertEquals(ruch.getParametryRuchuDto().getKoniec().getPozycjaY(), 0);
    }

    @Test
    void T09_WirtualnyPrzeciwnikBroniSiePrzedSzewkimMatem(){
        //src\test\resources\wirtualnyPrzeciwnikIntegracyjnyTest\T09.png
        Given:
        szachownica = new Szachownica();

        Pionek pionekBialy1 = new Pionek(0, 1, Kolor.BIALY, szachownica);
        Pionek pionekBialy2 = new Pionek(1, 3, Kolor.BIALY, szachownica);
        Pionek pionekBialy3 = new Pionek(2, 1, Kolor.BIALY, szachownica);
        Pionek pionekBialy4 = new Pionek(3, 1, Kolor.BIALY, szachownica);
        Pionek pionekBialy5 = new Pionek(4, 1, Kolor.BIALY, szachownica);
        Pionek pionekBialy6 = new Pionek(5, 1, Kolor.BIALY, szachownica);
        Pionek pionekBialy7 = new Pionek(6, 2, Kolor.BIALY, szachownica);
        Pionek pionekBialy8 = new Pionek(7, 1, Kolor.BIALY, szachownica);

        Wieza wiezaBiala1 = new Wieza(0, 0, Kolor.BIALY, szachownica);
        Wieza wiezaBiala2 = new Wieza(7, 0, Kolor.BIALY, szachownica);

        Kon konBialy1 = new Kon(1, 0, Kolor.BIALY, szachownica);
        Kon konBialy2 = new Kon(6, 0, Kolor.BIALY, szachownica);

        Laufer lauferBialy1 = new Laufer(2, 0, Kolor.BIALY, szachownica);
        Laufer lauferBialy2 = new Laufer(5, 0, Kolor.BIALY, szachownica);

        Krol krolBialy = new Krol(3, 0, Kolor.BIALY, szachownica);

        Krolowa krolowaBiala = new Krolowa(4, 0, Kolor.BIALY, szachownica);

        Pionek pionekCzarny1 = new Pionek(0, 6, Kolor.CZARNY, szachownica);
        Pionek pionekCzarny2 = new Pionek(1, 6, Kolor.CZARNY, szachownica);
        Pionek pionekCzarny3 = new Pionek(2, 6, Kolor.CZARNY, szachownica);
        Pionek pionekCzarny4 = new Pionek(3, 4, Kolor.CZARNY, szachownica);
        Pionek pionekCzarny5 = new Pionek(4, 6, Kolor.CZARNY, szachownica);
        Pionek pionekCzarny6 = new Pionek(5, 6, Kolor.CZARNY, szachownica);
        Pionek pionekCzarny7 = new Pionek(6, 6, Kolor.CZARNY, szachownica);
        Pionek pionekCzarny8 = new Pionek(7, 6, Kolor.CZARNY, szachownica);

        Wieza wiezaCzarna1 = new Wieza(0, 7, Kolor.CZARNY, szachownica);
        Wieza wiezaCzarna2 = new Wieza(7, 7, Kolor.CZARNY, szachownica);

        Kon konCzarny1 = new Kon(1, 7, Kolor.CZARNY, szachownica);
        Kon konCzarny2 = new Kon(6, 7, Kolor.CZARNY, szachownica);

        Laufer lauferCzarny1 = new Laufer(5, 4, Kolor.CZARNY, szachownica);
        Laufer lauferCzarny2 = new Laufer(5, 7, Kolor.CZARNY, szachownica);

        Krol krolCzarny = new Krol(3, 7, Kolor.CZARNY, szachownica);

        Krolowa krolowaCzarna = new Krolowa(2, 5, Kolor.CZARNY, szachownica);

        szachownica.getFigury().add(pionekBialy1);
        szachownica.getFigury().add(pionekBialy2);
        szachownica.getFigury().add(pionekBialy3);
        szachownica.getFigury().add(pionekBialy4);
        szachownica.getFigury().add(pionekBialy5);
        szachownica.getFigury().add(pionekBialy6);
        szachownica.getFigury().add(pionekBialy7);
        szachownica.getFigury().add(pionekBialy8);
        szachownica.getFigury().add(wiezaBiala1);
        szachownica.getFigury().add(wiezaBiala2);
        szachownica.getFigury().add(konBialy1);
        szachownica.getFigury().add(konBialy2);
        szachownica.getFigury().add(lauferBialy1);
        szachownica.getFigury().add(lauferBialy2);
        szachownica.getFigury().add(krolBialy);
        szachownica.getFigury().add(krolowaBiala);

        szachownica.getFigury().add(pionekCzarny1);
        szachownica.getFigury().add(pionekCzarny2);
        szachownica.getFigury().add(pionekCzarny3);
        szachownica.getFigury().add(pionekCzarny4);
        szachownica.getFigury().add(pionekCzarny5);
        szachownica.getFigury().add(pionekCzarny6);
        szachownica.getFigury().add(pionekCzarny7);
        szachownica.getFigury().add(pionekCzarny8);
        szachownica.getFigury().add(wiezaCzarna1);
        szachownica.getFigury().add(wiezaCzarna2);
        szachownica.getFigury().add(konCzarny1);
        szachownica.getFigury().add(konCzarny2);
        szachownica.getFigury().add(lauferCzarny1);
        szachownica.getFigury().add(lauferCzarny2);
        szachownica.getFigury().add(krolCzarny);
        szachownica.getFigury().add(krolowaCzarna);

        szachy = new Szachy(szachownica);
        wirtualnyPrzeciwnik = new WirtualnyPrzeciwnik(szachy);

        RuchWirtualnegoPrzeciwnika ruch;

        List<ParametryRuchuDto> optymalneRuchy = new ArrayList<>();
        optymalneRuchy.add(new ParametryRuchuDto(new ParametryPolaDto(2, 1), new ParametryPolaDto(2, 2)));
        optymalneRuchy.add(new ParametryRuchuDto(new ParametryPolaDto(2, 1), new ParametryPolaDto(2, 3)));
        optymalneRuchy.add(new ParametryRuchuDto(new ParametryPolaDto(3, 1), new ParametryPolaDto(3, 2)));
        optymalneRuchy.add(new ParametryRuchuDto(new ParametryPolaDto(1, 0), new ParametryPolaDto(0, 2)));
        optymalneRuchy.add(new ParametryRuchuDto(new ParametryPolaDto(1, 0), new ParametryPolaDto(2, 2)));
        optymalneRuchy.add(new ParametryRuchuDto(new ParametryPolaDto(4, 1), new ParametryPolaDto(4, 2)));
        optymalneRuchy.add(new ParametryRuchuDto(new ParametryPolaDto(4, 1), new ParametryPolaDto(4, 3)));


        When:
        ruch = wirtualnyPrzeciwnik.wykonajRuchWirtualnymPrzeciwnikiem();
        boolean wynik = optymalneRuchy.contains(ruch.getParametryRuchuDto());

        Then:
        assertEquals(true, wynik);

    }



    //jak ma dwa pionki do wyboru zeby zbic, to niech wybiera tego wazniejszego
    //jak moze zbic pionek ale pozniej straci cenniejsza figure to zeby tego ruchu nie wykonywal -uzywamy assertNotEquals();
    //sprawdzic czy nie bije pionka gdy odslania inna figure ktora jest cenniejsza
    //sprawdzic czy wirtualnyPrzeciwnik ucieknie figura jesli moze ja stracic
    //jak pionek wirtualnego przeciwnika dojdzie do ostatniego rzedu, to czy zamienia sie w krolowa
    //jak pionek moze  dojsc do ostatniego rzedu i zamieni sie w krolowa ale moze byc zbity od razu przy tym to tego nie zrobi
    //Popraw zamiane pionka w krolowa - w typ ruchu
    //Poprawa testow zeby nadpisac equals
    //T03 zeby wieza nie byla na lini bicia
    // jak moze zrobic szachmat albo zbic inna figure to wybierze szachmat - zdjecie
    //sprawdzic czy broni sie przed szewskim matem- zdjecie

    //sprawdzic blad wczorajszy



}
