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


    @Override
    public boolean equals(Object o) {
        if ( this== o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParametryPola that = (ParametryPola) o;

        if (polozenieX != that.polozenieX) return false;
        if (polozenieY != that.polozenieY) return false;
        return zajete == that.zajete;
    }

}
