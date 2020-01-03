package workingwithabstraction.HotelReservation;

public enum Discount {
    VIP(20),
    SecondVisit(10),
    None(0);

    private final int percent;
    Discount(int percent) {
        this.percent = percent;
    }
    public double getPercent() {
        return (100 - this.percent) / 100.0;
    }
}
