package pl.danielak.szachy.dto;

import java.util.Objects;

public class ParametryPolaDto {
    private int pozycjaX;
    private int pozycjaY;

    public ParametryPolaDto(int pozycjaX, int pozycjaY) {
        this.pozycjaX = pozycjaX;
        this.pozycjaY = pozycjaY;
    }

    public int getPozycjaX() {
        return pozycjaX;
    }

    public void setPozycjaX(int pozycjaX) {
        this.pozycjaX = pozycjaX;
    }

    public int getPozycjaY() {
        return pozycjaY;
    }

    public void setPozycjaY(int pozycjaY) {
        this.pozycjaY = pozycjaY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParametryPolaDto that = (ParametryPolaDto) o;
        return pozycjaX == that.pozycjaX && pozycjaY == that.pozycjaY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pozycjaX, pozycjaY);
    }
}
