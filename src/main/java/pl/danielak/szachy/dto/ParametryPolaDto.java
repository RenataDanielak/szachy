package pl.danielak.szachy.dto;

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
}
