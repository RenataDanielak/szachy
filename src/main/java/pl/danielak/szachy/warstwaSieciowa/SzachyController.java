package pl.danielak.szachy.warstwaSieciowa;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.web.bind.annotation.*;
import pl.danielak.szachy.GlupiaGra;
import pl.danielak.szachy.Gra;
import pl.danielak.szachy.Szachy;
import pl.danielak.szachy.dto.ParametryPolaDto;
import pl.danielak.szachy.dto.PionekDto;

import java.lang.reflect.Parameter;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/szachy")
public class SzachyController {

    Gra gra;

    public SzachyController() {
        gra = new Szachy();
    }

    @GetMapping("/plansza")
    public List<PionekDto> plansza() {
        return gra.listaPionkow();
    }

    @GetMapping("/dostepneRuchy")
    public List<ParametryPolaDto> dostepneRuchy(@RequestParam int startX, @RequestParam int startY) {
        ParametryPolaDto start = new ParametryPolaDto(startX, startY);
        return gra.podajMozliweRuchy(start);
    }

    @GetMapping("/ruch")
    public boolean ruch(@RequestParam int startX, @RequestParam int startY,
                                       @RequestParam int koniecX, @RequestParam int koniecY) {
        ParametryPolaDto start = new ParametryPolaDto(startX, startY);
        ParametryPolaDto koniec = new ParametryPolaDto(koniecX, koniecY);

        return gra.wykonajRuch(start, koniec);
    }
}
