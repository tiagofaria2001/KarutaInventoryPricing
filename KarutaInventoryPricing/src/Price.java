public class Price {
    private Edition edition;
    private Print print;
    private double rate;

    public Price(Edition edition, Print print, double rate) {
        this.edition = edition;
        this.print = print;
        this.rate = rate;
    }
    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    public Print getPrint() {
        return print;
    }

    public void setPrint(Print print) {
        this.print = print;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
