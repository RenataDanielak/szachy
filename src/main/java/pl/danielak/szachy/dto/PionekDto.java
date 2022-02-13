package pl.danielak.szachy.dto;

public class PionekDto {
    private int pozycjaX;
    private int pozyjcjaY;
    private boolean kolor;
    private String figura;

    public PionekDto(int pozycjaX, int pozyjcjaY, boolean kolor, String figura) {
        this.pozycjaX = pozycjaX;
        this.pozyjcjaY = pozyjcjaY;
        this.kolor = kolor;
        this.figura = figura;
    }

    public int getPozycjaX() {
        return pozycjaX;
    }

    public void setPozycjaX(int pozycjaX) {
        this.pozycjaX = pozycjaX;
    }

    public int getPozyjcjaY() {
        return pozyjcjaY;
    }

    public void setPozyjcjaY(int pozyjcjaY) {
        this.pozyjcjaY = pozyjcjaY;
    }

    public boolean isKolor() {
        return kolor;
    }

    public void setKolor(boolean kolor) {
        this.kolor = kolor;
    }

    public String getFigura() {
        return figura;
    }

    public void setFigura(String figura) {
        this.figura = figura;
    }
}
