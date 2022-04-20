package pl.danielak.szachy.dto;

import pl.danielak.szachy.Kolor;
import pl.danielak.szachy.RodzajFigury;

public class PionekDto {
    private int pozycjaX;
    private int pozyjcjaY;
    private Kolor kolor;
    private RodzajFigury figura;

    public PionekDto(int pozycjaX, int pozyjcjaY, Kolor kolor, RodzajFigury figura) {
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

    public Kolor getKolor() {
        return kolor;
    }

    public void setKolor(Kolor kolor) {
        this.kolor = kolor;
    }

    public RodzajFigury getFigura() {
        return figura;
    }

    public void setFigura(RodzajFigury figura) {
        this.figura = figura;
    }
}
