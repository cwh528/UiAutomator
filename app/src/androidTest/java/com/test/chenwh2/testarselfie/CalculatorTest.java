package com.test.chenwh2.testarselfie;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by chenwh2 on 2017/9/6.
 */

public class CalculatorTest {
    private String LOG_TAG = "CalculatorTest";
    private UiDevice mDevice;
    private static final int LAUNCH_TIMEOUT = 5000;
    private final String BASIC_SAMPLE_PACKAGE = "com.google.android.calculator";

    @Before
    public void setUp() {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

    }
    @Test
    public void checkPreconditions() {
        assertThat(mDevice, notNullValue());
    }
    @Test
    public void openApp(){
        //open the app
        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE);
        //Clear out any previous instances
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

    }
    @Test
    public void functionTest() {

        UiObject2 button7 = mDevice.wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "digit_7")), 500);
        UiObject2 buttonX = mDevice.wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "op_mul")), 500);
        UiObject2 button6 = mDevice.wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "digit_6")), 500);
        UiObject2 buttonEqual = mDevice.wait(Until.findObject(By.res(BASIC_SAMPLE_PACKAGE, "eq")), 500);

        button7.click();
        buttonX.click();
        button6.click();
        buttonEqual.click();

    }
}
