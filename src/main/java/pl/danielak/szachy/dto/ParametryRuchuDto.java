package pl.danielak.szachy.dto;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParametryRuchuDto that = (ParametryRuchuDto) o;
        return Objects.equals(start, that.start) && Objects.equals(koniec, that.koniec);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, koniec);
    }

    @Override
    public String toString() {
        return "ParametryRuchuDto{" +
                "start=" + start +
                ", koniec=" + koniec +
                '}';
    }
}
