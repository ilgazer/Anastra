package com.ilgazzi.anastra.cards;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ilgaz on 09.08.2015.
 */
public class CardSet extends ArrayList<Card> {
    public CardSet() {
        super();
    }

    public CardSet(Card[] cards) {
        super(Arrays.asList(cards));
    }

    public CardSet(ArrayList<Card> cards) {
        super(cards);
    }

}
