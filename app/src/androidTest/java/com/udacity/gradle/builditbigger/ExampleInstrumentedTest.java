package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Test
    public void checkAsyncTask_nonEmptyStringResult() throws InterruptedException {
        assertTrue(true);
        final CountDownLatch latch = new CountDownLatch(1);
        Context context = InstrumentationRegistry.getContext();
        EndpointsAsyncTask testTask = new EndpointsAsyncTask(new ProgressChangeListener() {
            @Override
            public void onProgressChanged(boolean complete) {

            }
        }) {
            @Override
            protected void onPostExecute(String result) {
                assertNotNull(result);
                latch.countDown();
            }
        };
        testTask.execute(context);
        latch.await();
    }
}
