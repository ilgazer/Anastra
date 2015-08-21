package com.ilgazzi.anastra.cards;

import java.util.ArrayList;

/**
 * Created by Ilgaz on 08.08.2015.
 */
public class Hand extends CardSet {
    private boolean isTurn = false;
    private CardSet chosen=new CardSet();
    public Hand() {
        super();
    }

    public Hand(Card[] cards) {
        super(cards);
    }

    public Hand(ArrayList<Card> cards) {
        super(cards);
    }

    public Card play(Card c) {
        remove(indexOf(c));
        return c;
    }

    public Card play(int i) {
        Card c = get(i);
        remove(i);
        return c;
    }

    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean isTurn) {
        this.isTurn = isTurn;
    }

    public void draw(Deck deck) {
        setTurn(true);
        add(deck.deal());
    }

    //public int isSet

    public int getPoints(CardSet cards){

        //if(cards.get(0))
        return 0;
    }
}
