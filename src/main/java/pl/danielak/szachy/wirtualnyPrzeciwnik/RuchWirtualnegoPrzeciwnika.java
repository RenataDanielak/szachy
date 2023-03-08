package pl.danielak.szachy.wirtualnyPrzeciwnik;

import pl.danielak.szachy.TypRuchu;
import pl.danielak.szachy.dto.ParametryRuchuDto;

public class RuchWirtualnegoPrzeciwnika {

    private ParametryRuchuDto parametryRuchuDto;
    private TypRuchu typRuchu;

    public RuchWirtualnegoPrzeciwnika(ParametryRuchuDto parametryRuchuDto, TypRuchu typRuchu) {
        this.parametryRuchuDto = parametryRuchuDto;
        this.typRuchu = typRuchu;
    }

    public ParametryRuchuDto getParametryRuchuDto() {
        return parametryRuchuDto;
    }

    public void setParametryRuchuDto(ParametryRuchuDto parametryRuchuDto) {
        this.parametryRuchuDto = parametryRuchuDto;
    }

    public TypRuchu getTypRuchu() {
        return typRuchu;
    }

    public void setTypRuchu(TypRuchu typRuchu) {
        this.typRuchu = typRuchu;
    }
}
