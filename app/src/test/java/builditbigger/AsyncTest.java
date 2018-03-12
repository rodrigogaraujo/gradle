package builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.util.Pair;

import com.example.myjokejava.MyJokeJava;
import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.task.GetJokeAsyncTask;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Rodrigo on 11/03/2018.
 */

@RunWith(AndroidJUnit4.class)
public class AsyncTest {

    public AsyncTest(){}

    private Context mContext = InstrumentationRegistry.getTargetContext();

    @Test
    public void test() throws Throwable {
        try {
            Assert.assertNotNull(new GetJokeAsyncTask().execute(new Pair<Context, String>(mContext, MyJokeJava.myJoke())));
        } catch (Exception e) {
            Assert.fail("is null");
        }
    }
}
