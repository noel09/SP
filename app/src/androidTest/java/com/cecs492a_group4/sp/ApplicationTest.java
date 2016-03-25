package com.cecs492a_group4.sp;

import android.test.suitebuilder.annotation.SmallTest;

import junit.framework.TestCase;

import java.io.IOException;
import java.net.URL;

import static com.cecs492a_group4.sp.DayEvent.*;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends TestCase{

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    public void test() throws IOException {
        String activity_title = "Testtitle";
        String activity_criteria = "criteria";

        double distance = 1.0;
        DayEvent a = new DayEvent(activity_title,null, null, activity_criteria, distance);

        String result = a.getActivitytitle();
        String expected = "Testtitle";
        assertEquals(expected, result);

    }


    @SmallTest
    public void test2() throws IOException {
        String activity_title = "Testtitle";
        String activity_criteria = "criteria";

        double distance = 1.0;
        DayEvent a = new DayEvent(activity_title,null, null, activity_criteria, distance);

        String result = a.getActivitytitle();
        String expected = "Nothin";
        assertEquals(expected, result);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

}