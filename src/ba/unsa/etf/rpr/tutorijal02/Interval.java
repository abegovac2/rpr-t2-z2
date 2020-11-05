package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private Double pocetnaTacka;
    private Double krajnjaTacka;
    private boolean pripadaLiPrva;
    private boolean pripadaLiDruga;

    public Double getPocetnaTacka() {
        return pocetnaTacka;
    }

    public void setPocetnaTacka(Double pocetnaTacka) {
        this.pocetnaTacka = pocetnaTacka;
    }

    public Double getKrajnjaTacka() {
        return krajnjaTacka;
    }

    public void setKrajnjaTacka(Double krajnjaTacka) {
        this.krajnjaTacka = krajnjaTacka;
    }

    public boolean isPripadaLiPrva() {
        return pripadaLiPrva;
    }

    public void setPripadaLiPrva(boolean pripadaLiPrva) {
        this.pripadaLiPrva = pripadaLiPrva;
    }

    public boolean isPripadaLiDruga() {
        return pripadaLiDruga;
    }

    public void setPripadaLiDruga(boolean pripadaLiDruga) {
        this.pripadaLiDruga = pripadaLiDruga;
    }

    Interval(Double pocetnaTacka, Double krajnjaTacka, boolean pripadaLiPrva, boolean pripadaLiDruga){
        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;
        this.pripadaLiPrva = pripadaLiPrva;
        this.pripadaLiDruga = pripadaLiDruga;
    }
}
