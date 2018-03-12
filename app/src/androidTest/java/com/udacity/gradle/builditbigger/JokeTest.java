package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;
import android.util.Pair;

import com.example.myjokejava.MyJokeJava;
import com.udacity.gradle.builditbigger.task.GetJokeAsyncTask;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Rodrigo on 11/03/2018.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class JokeTest {

    public Context mContext = InstrumentationRegistry.getTargetContext();

    @Test
    public void test() throws Throwable {
        try {
            Assert.assertNotNull(new GetJokeAsyncTask().execute(new Pair<Context, String>(mContext, MyJokeJava.myJoke())));
        } catch (Exception e) {
            Assert.fail("is null");
        }
    }
}
