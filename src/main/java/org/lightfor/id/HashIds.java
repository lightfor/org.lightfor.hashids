package org.lightfor.id;

import org.hashids.Hashids;

/**
 * HashIds
 * Created by Light on 2017/1/3.
 */
public class HashIds {

    public static void main(String[] args) {
        Hashids hashids = new Hashids("lightFor");
        for(int i = 0 ; i< 1000 ; i++){
            String encode = hashids.encode(i);
            System.out.println(encode);
            long[] decode = hashids.decode(encode);
            System.out.println(decode[0]);
        }
    }
}
