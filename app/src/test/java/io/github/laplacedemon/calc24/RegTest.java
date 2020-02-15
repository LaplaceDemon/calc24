package io.github.laplacedemon.calc24;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RegTest {
    @Test
    public void testSpint0() {
        String[] s = "1  2   3".split("\\s+");
        System.out.println(Arrays.toString(s));
        Assert.assertEquals(s.length, 3);
    }

    @Test
    public void testReplace() {
        String s = "10.0+100.0+1.0+2.0+3.0".replaceAll("(\\.0)", "");
        System.out.println(s);
    }
}
