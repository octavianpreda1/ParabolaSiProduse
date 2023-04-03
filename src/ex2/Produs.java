package ex2;

import java.time.LocalDate;

public class Produs {

    private String denumire;
    private float pret;
    private int cantitate;
    private LocalDate data_expirarii;
    static float incasari=0;

    public Produs(String denumire, float pret, int cantitate, LocalDate data_expirarii) {
        this.denumire = denumire;
        this.pret = pret;
        this.cantitate = cantitate;
        this.data_expirarii = data_expirarii;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public LocalDate getData_expirarii() {
        return data_expirarii;
    }

    public void setData_expirarii(LocalDate data_expirarii) {
        this.data_expirarii = data_expirarii;
    }

    @Override
    public String toString() {
        return "denumire: '" + denumire + '\'' +
                ", pret: " + pret +
                ", cantitate: " + cantitate +
                ", data expirarii: " + data_expirarii;
    }
}


