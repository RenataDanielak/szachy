package pl.danielak.szachy;

public class ParametryPola {

    private int polozenieX;
    private int polozenieY;
    private boolean zajete;

    public ParametryPola (int polozenieX, int polozenieY, boolean zajete){
        this.polozenieX = polozenieX;
        this.polozenieY = polozenieY;
        this.zajete = zajete;
    }

    public int getPolozenieX() {
        return polozenieX;
    }

    public void setPolozenieX(int polozenieX) {
        this.polozenieX = polozenieX;
    }

    public int getPolozenieY() {
        return polozenieY;
    }

    public void setPolozenieY(int polozenieY) {
        this.polozenieY = polozenieY;
    }

    public boolean isZajete() {
        return zajete;
    }

    public void setZajete(boolean zajete) {
        this.zajete = zajete;
    }
}
