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
        String activity_title = "Test Title";


        double distance = 1.0;
        DayEvent a = new DayEvent(activity_title,null, null, null, distance, null);

        String result = a.getActivitytitle();
        String expected = "Test Title";
        assertEquals(expected, result);
    }//Passing Test


    @SmallTest
    public void test2() throws IOException {
        String activity_title = "Test Title";


        double distance = 1.0;
       // DayEvent a = new DayEvent(activity_title,null, null, null, distance, null);

       // String result = a.getActivitytitle();
        String expected = "Not Title";
        assertEquals(expected, result);
    }//Failing Test

    @SmallTest
    public void test3() throws IOException{
        String activity_criteria = "Test Criteria";


        double distance = 1.0;
        //DayEvent a = new DayEvent(null,null, null, activity_criteria, distance, null);

        //String result = a.getCriteria();
        String expected = "Test Criteria";
        //assertEquals(expected, result);
    }//Passing Test

    @SmallTest
    public void test4() throws IOException
    {
        String activity_criteria = "Test Criteria";


        double distance = 1.0;
        //DayEvent a = new DayEvent(null,null, null, activity_criteria, distance, null);

       // String result = a.getCriteria();
        String expected = "NOT Criteria";
       // assertEquals(expected, result);
    }//Failling Test


    @SmallTest
    public void test5() throws IOException{
        SingleEvent e = new SingleEvent();

        double result = e.meters_to_miles(1);
        double expected = 6.2137E-4;
        assertEquals(expected,result);
    }//Passing Test

    @SmallTest
    public void test6() throws IOException{
        SingleEvent e = new SingleEvent();

        double result = e.meters_to_miles(15002.0);
        double expected = 6.132E-4;
        assertEquals(expected,result);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

}