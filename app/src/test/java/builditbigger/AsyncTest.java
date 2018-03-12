package builditbigger;

import android.content.Context;
import android.util.Pair;

import com.example.myjokejava.MyJokeJava;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Rodrigo on 11/03/2018.
 */

public class AsyncTest {

    private GetJokeAsyncTask mGetJokeAsyncTask = new GetJokeAsyncTask();
    private MainActivity mMainActivity = new MainActivity();

    @Test
    public void test() throws Throwable {
        try {
            Assert.assertNotNull(new GetJokeAsyncTask().execute(new Pair<Context, String>(mMainActivity.getApplicationContext(), MyJokeJava.myJoke())));
        } catch (Exception e) {
            Assert.fail("is null");
        }
    }
}
