package pl.danielak.szachy.wirtualnyPrzeciwnik;

import pl.danielak.szachy.TypRuchu;
import pl.danielak.szachy.dto.ParametryPolaDto;

public class ParametryRuchuWirtualnegoPrzeciwnika {

    private ParametryPolaDto polozeniePoczatkowe;
    private ParametryPolaDto polozenieKoncowe;
    private int minimalnaWartoscRuchu;
    private int maksymalnaWartoscRuchu;

    public ParametryRuchuWirtualnegoPrzeciwnika(ParametryPolaDto polozeniePoczatkowe, ParametryPolaDto polozenieKoncowe, int minimalnaWartoscRuchu, int maksymalnaWartoscRuchu) {
        this.polozeniePoczatkowe = polozeniePoczatkowe;
        this.polozenieKoncowe = polozenieKoncowe;
        this.minimalnaWartoscRuchu = minimalnaWartoscRuchu;
        this.maksymalnaWartoscRuchu = maksymalnaWartoscRuchu;
    }

    public ParametryPolaDto getPolozeniePoczatkowe() {
        return polozeniePoczatkowe;
    }

    public void setPolozeniePoczatkowe(ParametryPolaDto polozeniePoczatkowe) {
        this.polozeniePoczatkowe = polozeniePoczatkowe;
    }

    public ParametryPolaDto getPolozenieKoncowe() {
        return polozenieKoncowe;
    }

    public void setPolozenieKoncowe(ParametryPolaDto polozenieKoncowe) {
        this.polozenieKoncowe = polozenieKoncowe;
    }

    public int getMinimalnaWartoscRuchu() {
        return minimalnaWartoscRuchu;
    }

    public void setMinimalnaWartoscRuchu(int minimalnaWartoscRuchu) {
        this.minimalnaWartoscRuchu = minimalnaWartoscRuchu;
    }

    public int getMaksymalnaWartoscRuchu() {
        return maksymalnaWartoscRuchu;
    }

    public void setMaksymalnaWartoscRuchu(int maksymalnaWartoscRuchu) {
        this.maksymalnaWartoscRuchu = maksymalnaWartoscRuchu;
    }

}
