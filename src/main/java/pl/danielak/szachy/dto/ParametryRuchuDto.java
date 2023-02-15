package pl.danielak.szachy.dto;

public class ParametryRuchuDto {

    private ParametryPolaDto start;
    private ParametryPolaDto koniec;

    public ParametryRuchuDto() {

    }

    public ParametryRuchuDto(ParametryPolaDto start, ParametryPolaDto koniec) {
        this.start = start;
        this.koniec = koniec;
    }

    public ParametryPolaDto getStart() {
        return start;
    }

    public void setStart(ParametryPolaDto start) {
        this.start = start;
    }

    public ParametryPolaDto getKoniec() {
        return koniec;
    }

    public void setKoniec(ParametryPolaDto koniec) {
        this.koniec = koniec;
    }
}
