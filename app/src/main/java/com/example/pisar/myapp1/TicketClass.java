package com.example.pisar.myapp1;
import java.lang.String;

/**
 * Created by pisar on 26.12.2017.
 */

public class TicketClass {
    int num;
    String ill;
    String quest;
    String rigth;
    String other1;
    String other2;
    String other3;
    String clar;

    public TicketClass(String[] str) {
        num = Integer.parseInt(str[0]);
        ill = str[1];
        quest = str[2];
        rigth = str[3];
        other1 = str[4];
        other2 = str[5];
        other3 = str[6];
        clar = str[7];
    }

    public answerset getansset() {
        String[] str2 = new String[4];
        str2[0] = rigth;
        str2[1] = other1;
        str2[2] = other2;
        str2[3] = other3;
        return new answerset(str2);
    }
}
