package pl.danielak.szachy;

import pl.danielak.szachy.dto.ParametryPolaDto;
import pl.danielak.szachy.dto.PionekDto;
import java.util.List;


public interface Gra {

    List<PionekDto> listaPionkow();

    List<ParametryPolaDto> podajMozliweRuchy(ParametryPolaDto pozycjaPoczatkowa);

    boolean wykonajRuch(ParametryPolaDto pozycjaPoczatkowa, ParametryPolaDto pozycjaKoncowa);

}
