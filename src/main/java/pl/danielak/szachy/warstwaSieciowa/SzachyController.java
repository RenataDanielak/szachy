package pl.danielak.szachy.warstwaSieciowa;

import org.springframework.web.bind.annotation.*;
import pl.danielak.szachy.Gra;
import pl.danielak.szachy.Szachy;
import pl.danielak.szachy.TypRuchu;
import pl.danielak.szachy.dto.ParametryPolaDto;
import pl.danielak.szachy.dto.ParametryRuchuDto;
import pl.danielak.szachy.dto.PionekDto;
import pl.danielak.szachy.wirtualnyPrzeciwnik.WirtualnyPrzeciwnik;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/szachy")
public class SzachyController {

    Gra gra;
    WirtualnyPrzeciwnik witrualnyPrzeciwnik;

    public SzachyController() {
        gra = new Szachy();
        witrualnyPrzeciwnik = new WirtualnyPrzeciwnik((Szachy)gra);
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

    @PostMapping("/ruch")
    public TypRuchu ruch(@RequestBody ParametryRuchuDto parametryRuchu) {
        ParametryPolaDto start = parametryRuchu.getStart();
        ParametryPolaDto koniec = parametryRuchu.getKoniec();
        return gra.wykonajRuch(start, koniec);
    }

    @PostMapping("/rozpocznijGreOdNowa")
    public void rozpocznijGreOdNowa(){
        gra.rozpocznijGreOdNowa();
    }

//    @PostMapping("/ruchGlupiegoWirtualnegoPrzeciwnika")
//    public ParametryRuchuDto wykonajRuchGlupimWirtualnymPrzeciwnikiem() {
//        witrualnyPrzeciwnik.glupiWirtualnyPrzeciwnik();
//        return new ParametryRuchuDto();
//    }

    @PostMapping("/ruchWirtualnegoPrzeciwnika")
    public ParametryRuchuDto wykonajRuch() {
        return witrualnyPrzeciwnik.wykonajRuchWirtualnymPrzeciwnikiem();
    }
}
