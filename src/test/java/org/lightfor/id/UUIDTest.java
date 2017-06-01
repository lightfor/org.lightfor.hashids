package org.lightfor.id;

import org.junit.Test;

import java.util.UUID;

/**
 * 
 * Created by Light on 2017/5/31.
 */
public class UUIDTest {

    public void test1() {
        //3912
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            UUID uuid = UUID.randomUUID();
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public void test2() {
        //12979
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            String uuidStr = UUID.randomUUID().toString().replaceAll("-", "");
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public void test3() {
        //8750
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder(32);
        for (int i = 0; i < 10000000; i++) {
            String uuidStr = UUID.randomUUID().toString();
            String result = sb.delete(0, sb.length()).append(uuidStr.substring(0, 8)).append(uuidStr.substring(9, 13)).append(uuidStr.substring(14, 18)).append(uuidStr.substring(19, 23)).append(uuidStr.substring(24)).toString();
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public void test4() {
        //9163
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            String uuidStr = UUID.randomUUID().toString();
            String result = uuidStr.substring(0, 8) + uuidStr.substring(9, 13) + uuidStr.substring(14, 18) + uuidStr.substring(19, 23) + uuidStr.substring(24);
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public void test5() {
        //8147
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            String uuidStr = UUID.randomUUID().toString();
            int p = 0;
            int j = 0;
            char[] buf = new char[32];
            while (p < uuidStr.length()) {
                char c = uuidStr.charAt(p);
                p += 1;
                if (c == '-') continue;
                buf[j] = c;
                j += 1;
            }
            String result = new String(buf);
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
