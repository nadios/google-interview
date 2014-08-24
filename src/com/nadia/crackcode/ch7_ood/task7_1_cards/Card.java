package com.nadia.crackcode.ch7_ood.task7_1_cards;

/**
 * Created with IntelliJ IDEA.
 * User: Nadios
 * Date: 23.08.14
 * Time: 19:35
 * To change this template use File | Settings | File Templates.
 */
public class Card {

    public enum Suit {
       Pika, Chirva, Bubna, Kresti;
    }

    Suit mast;
    Integer value;
    String name;

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
