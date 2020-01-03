package workingwithabstraction.HotelReservation;

enum Season {
    Autumn(1),
    Spring(2),
    Winter(3),
    Summer(4);

    private int priceMultiplier;
    Season(int index) {
        this.priceMultiplier = index;
    }

    public int getPriceMultiplier() {
        return this.priceMultiplier;
    }
}
