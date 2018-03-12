package com.udacity.gradle.builditbigger.task;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;

import com.example.myjokeandroid.MyJokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.Constants;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by Rodrigo on 11/03/2018.
 */
public class GetJokeAsyncTask extends AsyncTask<Pair<Context, String> , Void, String> {
    private static MyApi mMyApiService = null;
    private Context mContext;
    private String mJoke;

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(mMyApiService == null){
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl(Constants.URL_SERVER)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            mMyApiService = builder.build();
        }
        mJoke = params[0].second;
        mContext = params[0].first;
        try {
            return mMyApiService.getJoke(mJoke).execute().getData();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        Intent i = new Intent(mContext, MyJokeActivity.class);
        i.putExtra(Constants.SEND_JOKE, mJoke);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(i);
    }
}
