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

    public Interval(Double pocetnaTacka, Double krajnjaTacka, boolean pripadaLiPrva, boolean pripadaLiDruga){
        if(pocetnaTacka > krajnjaTacka) throw new IllegalArgumentException();
        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;
        this.pripadaLiPrva = pripadaLiPrva;
        this.pripadaLiDruga = pripadaLiDruga;
    }

    public Interval(){
        this.pocetnaTacka = 0.;
        this.krajnjaTacka = 0.;
        this.pripadaLiPrva = false;
        this.pripadaLiDruga = false;
    }

    public boolean isNull(){
        return  pocetnaTacka == 0 && krajnjaTacka == 0 && !pripadaLiPrva && !pripadaLiDruga;
    }

    public boolean isIn(Double tacka){
        if(pripadaLiPrva && pripadaLiDruga){
            return tacka >= pocetnaTacka && tacka<= krajnjaTacka;
        }else if(pripadaLiPrva) return tacka >= pocetnaTacka && tacka< krajnjaTacka;
        else if(pripadaLiDruga) return tacka > pocetnaTacka && tacka <= krajnjaTacka;
        return tacka > pocetnaTacka && tacka< krajnjaTacka;
    }

    public Interval intersect(Interval interval){
        if(krajnjaTacka < interval.pocetnaTacka || interval.krajnjaTacka < pocetnaTacka) return new Interval();
        Double prvaTacka = Math.max(interval.pocetnaTacka,pocetnaTacka),
                drugaTacka = Math.min(interval.krajnjaTacka,krajnjaTacka);
        boolean prvaU = (prvaTacka.equals(pocetnaTacka) ? pripadaLiPrva : interval.pripadaLiPrva),
                drugaU = (drugaTacka.equals(krajnjaTacka) ? pripadaLiDruga : interval.pripadaLiDruga);
        return new Interval(prvaTacka,drugaTacka,prvaU,drugaU);
    }

    public static Interval intersect(Interval int_1, Interval int_2){
        return int_1.intersect(int_2);
    }

    @Override
    public String toString() {
        if(pocetnaTacka.equals(0.) && krajnjaTacka.equals(0.) && !pripadaLiPrva && !pripadaLiDruga) return "()";
        return "" + (pripadaLiPrva ? "[" : "(") + pocetnaTacka +  "," + krajnjaTacka + (pripadaLiDruga ? "]" : ")");
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Interval){
            return ((Interval) o).pocetnaTacka.equals(pocetnaTacka) && ((Interval) o).krajnjaTacka.equals(krajnjaTacka)
                    && ((Interval) o).pripadaLiPrva == pripadaLiPrva && ((Interval) o).pripadaLiDruga == pripadaLiDruga;
        }else return false;
    }
}
