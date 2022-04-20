package pl.danielak.szachy;

import pl.danielak.szachy.dto.ParametryPolaDto;
import pl.danielak.szachy.dto.PionekDto;

import java.util.ArrayList;
import java.util.List;

// http://127.0.0.1:8080/szachy/plansza
// http://127.0.0.1:8080/szachy/dostepneRuchy?startX=3&startY=3
// http://127.0.0.1:8080/szachy/ruch?startX=3&startY=3&koniecX=4&koniecY=3

//http://localhost:8080/swagger-ui.html

//cd ..\FrontSzachy\szachy\
//npm run start
// http://localhost:3000/
public class GlupiaGra implements Gra{

    private int x;
    private int y;

    public GlupiaGra(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public List<PionekDto> listaPionkow() {
        List<PionekDto> lista = new ArrayList<>();
        PionekDto pionekDto = new PionekDto(x, y, Kolor.CZARNY, RodzajFigury.PIONEK);
        lista.add(pionekDto);
        return lista;
    }

    @Override
    public List<ParametryPolaDto> podajMozliweRuchy(ParametryPolaDto pozycjaPionka) {
        List<ParametryPolaDto> lista = new ArrayList<>();
        if (pozycjaPionka.getPozycjaX() == x && pozycjaPionka.getPozycjaY() == y) {
            if (x+1 < 8 ) {
                ParametryPolaDto ruch1 = new ParametryPolaDto(x + 1, y);
                lista.add(ruch1);
            }
            if (x-1 >= 0 ) {
                ParametryPolaDto ruch2 = new ParametryPolaDto(x - 1, y);
                lista.add(ruch2);
            }
            if (y+1 < 8 ) {
                ParametryPolaDto ruch3 = new ParametryPolaDto(x, y + 1);
                lista.add(ruch3);
            }
            if (y-1 >= 0 ) {
                ParametryPolaDto ruch4 = new ParametryPolaDto(x, y - 1);
                lista.add(ruch4);
            }
        }
        return lista;
    }

    @Override
    public boolean wykonajRuch(ParametryPolaDto pozycjaPoczatkowa, ParametryPolaDto pozycjaKoncowa) {
        if (pozycjaPoczatkowa.getPozycjaX() == x && pozycjaPoczatkowa.getPozycjaY() == y) {
            List<ParametryPolaDto> lista = podajMozliweRuchy(pozycjaPoczatkowa);
            for (int i = 0; i < lista.size(); i = i +1){
                int pozycjaProponowanaX = lista.get(i).getPozycjaX();
                int pozycjaProponowanaY = lista.get(i).getPozycjaY();
                int pozycjaKoncowaX = pozycjaKoncowa.getPozycjaX();
                int pozycjaKoncowaY = pozycjaKoncowa.getPozycjaY();
                if ((pozycjaProponowanaX == pozycjaKoncowaX) && (pozycjaProponowanaY == pozycjaKoncowaY)){
                    x = pozycjaKoncowa.getPozycjaX();
                    y = pozycjaKoncowa.getPozycjaY();
                    return true;
                }
            }
        }
        return false;
    }

}
