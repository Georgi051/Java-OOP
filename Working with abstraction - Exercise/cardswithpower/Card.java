package workingwithabstraction.cardswithpower;

public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int cardTotalPower(){
        return this.rank.getValue() + this.suit.getValue();
    }
}
