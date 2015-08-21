package com.ilgazzi.anastra.cards;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Ilgaz on 08.08.2015.
 */
public class Deck extends CardSet {
    public Deck() {
        super();
        for (int i = 0; i < 104; i++) {
            int j = i % 52;
            int suit = j / 13;
            int rank = j % 13;
            this.add(new Card(Card.ranks[rank], Card.suits[suit]));
        }
        Collections.shuffle(this);
    }

    public Card deal() {
        if (this.size() != 0) {
            Card ret = this.get(0);
            this.remove(0);
            return ret;
        }
        System.out.println("The game blew up!");
        return null;
    }

    public Card[] deal(int i) {
        ArrayList<Card> ret = new ArrayList<Card>();
        for (int j = 0; j < i; j++) {
            ret.add(this.get(0));
            this.remove(0);
        }
        return ret.toArray(new Card[ret.size()]);
    }
}
