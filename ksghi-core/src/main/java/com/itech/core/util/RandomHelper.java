package com.itech.core.util;

import java.util.Random;

public class RandomHelper {
    /**
     * 生成大于100000 小于 999999的随机数
     *
     * @return
     */
    public static int getRandomNum6() {
        Random r = new Random();
        int number = r.nextInt(899999);
        return number + 100000;
    }
}
