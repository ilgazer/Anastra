package com.ilgazzi.anastra;

import com.ilgazzi.anastra.cards.Card;
import com.ilgazzi.anastra.cards.Deck;
import com.ilgazzi.anastra.cards.Hand;
import com.ilgazzi.anastra.cards.Pile;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;

/**
 * Created by Ilgaz on 08.08.2015.
 */
public class Game extends JFrame {
    public Game() throws Exception {
        JPanel p = new JPanel();
        Hand[] h = new Hand[4];
        this.getContentPane().add(p, BorderLayout.CENTER);
        Pile pile = new Pile();
        Deck deck = new Deck();
        for (int i = 0; i < 4; i++) {
            h[i] = new Hand(deck.deal(13));
            Collections.sort(h[i]);
        }
        update(h, p);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        while (true) {
            for (int i = 0; i < 4; i++) {
                h[i].draw(deck);
                Collections.sort(h[i]);
                pile.add(h[i].play(0));
                System.out.println(i + " done out of 4");
                update(h, p);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    void update(Hand[] h, JPanel p) {
        p.removeAll();
        for (int i = 0; i < 4; i++) {
            for (Card c : h[i].toArray(new Card[13])) {
                p.add(c);
                //System.out.println(c.getRank()+c.getSuit());
            }
            p.add(new Card("back", ""));
        }
        p.updateUI();
    }
}
