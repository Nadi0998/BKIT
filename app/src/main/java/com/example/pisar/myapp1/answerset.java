package com.example.pisar.myapp1;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by pisar on 27.12.2017.
 */

public class answerset {
    String[] str = new String[4];
    int id;
    public answerset(String[] str1){
        ArrayList<Integer> LST = new ArrayList<Integer>(4);
        Random rnd = new Random(System.currentTimeMillis());
        id = rnd.nextInt(3);
        str[id] = str1[0];
        for (int i=0;i<4; i++) {
            if(i==0) continue;
            LST.add(i);
        }
        int i=0;
        for (;i<3;i++){
            if(i==id){
                continue;
                }
            int tmp = rnd.nextInt(LST.size()-1);
            str[i] = str1[LST.get(tmp)];
            LST.remove(tmp);
        }
       if(id!=3) str[3]= str1[LST.get(0)];
        LST.clear();
    }
}
