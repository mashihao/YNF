package com.yunifang.ynf;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        int []a = {1,2,3,4,5,6};
        int [] b = {1,2};
        a = b;
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}