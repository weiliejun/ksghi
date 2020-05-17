package com.itech.core.util;

import java.util.Random;

/**
 * Created by dengjianping on 2015/8/24.
 */
public class RandomUtil {
    private static RandomProbability rp1 = new RandomProbability();
    private static RandomProbability rp2 = new RandomProbability();
    private static RandomProbability rp3 = new RandomProbability();
    private static RandomProbability rp4 = new RandomProbability();

    public static RandomProbability getPool_1_5_Instence() {
        return rp1;
    }

    public static RandomProbability getPool_10_120_Instence() {
        return rp2;
    }

    public static RandomProbability getPool_10_188_Instence() {
        return rp3;
    }

    public static RandomProbability getPool_10_30_Instence() {
        return rp4;
    }

    /**
     * 获取指定位数的随机数字串
     *
     * @param digit 随机数的长度
     * @return
     */
    public static String getRandomString(int digit) {
        Random random = new Random();
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < digit; i++) {
            randomString.append(random.nextInt(10));
        }
        return randomString.toString();
    }

    /**
     * 获取6位数字验证码
     *
     * @return
     */
    public static int getRandomVerifyCode() {
        Random random = new Random();
        int x = random.nextInt(899999);
        x = x + 100000;
        return x;
    }
}
