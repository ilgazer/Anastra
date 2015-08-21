package com.ilgazzi.anastra.cards;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Ilgaz on 08.08.2015.
 */
public class Card extends JLabel implements Comparable {
    public static final String[] suits = {"club", "diamond", "heart", "spade"};
    public static final ArrayList<String> suitList = new ArrayList<String>(Arrays.asList(suits));
    public final static String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k", "a"};
    public static final ArrayList<String> rankList = new ArrayList<String>(Arrays.asList(ranks));
    private final String rank;
    private final String suit;
    private ImageIcon cardIcon;

    public Card() {
        this.rank = Card.ranks[new Random().nextInt(13)];
        this.suit = Card.suits[new Random().nextInt(4)];
        InputStream is = this.getClass().getResourceAsStream("/com/ilgazzi/anastra/assets/cards/" + this.suit + "/" + this.rank + ".png");
        try {
            cardIcon = new ImageIcon(ImageIO.read(is));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("You must have deleted my resource files. If you didn't, please send a bug report.");
        }
        this.setIcon(cardIcon);
    }

    public Card(String rank, String suit) {
        super();
        this.rank = rank;
        this.suit = suit;
        InputStream is;
        is = this.getClass().getResourceAsStream("/com/ilgazzi/anastra/assets/cards/" + this.suit + "/" + this.rank + ".png");
        try {
            cardIcon = new ImageIcon(ImageIO.read(is));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("You must have deleted my resource files. If you didn't, please send a bug report.");
        }
        this.setIcon(cardIcon);
    }

    public Card(String rank) {
        super();
        this.rank = rank;
        this.suit = "";
        InputStream is;
        is = this.getClass().getResourceAsStream("/com/ilgazzi/anastra/assets/cards/" + this.rank + ".png");
        try {
            cardIcon = new ImageIcon(ImageIO.read(is));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("You must have deleted my resource files. If you didn't, please send a bug report.");
        }
        this.setIcon(cardIcon);
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Object o) {
        if (o.getClass() == this.getClass()) {
            Card c = (Card) o;
            int i = Integer.valueOf(rankList.indexOf(this.getRank()))
                    .compareTo(rankList.indexOf(c.getRank()));
            if (i == 0) {
                Integer suit1 = suitList.indexOf(this.getSuit());
                Integer suit2 = suitList.indexOf(c.getSuit());
                return suit1.compareTo(suit2);
            } else
                return i;
        } else {
            return -1;
        }
    }
}
