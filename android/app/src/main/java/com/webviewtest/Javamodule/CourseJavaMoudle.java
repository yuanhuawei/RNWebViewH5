package com.webviewtest.Javamodule;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.Date;

public class CourseJavaMoudle extends ReactContextBaseJavaModule {
    private static final String MODULE_NAME = "CourseJavaMoudle";
    private Context mContext = null;

    public CourseJavaMoudle (ReactApplicationContext reactContext) {
        super(reactContext);
        mContext = reactContext;
    }

    @Override
    public String getName ( ) {
        return MODULE_NAME;
    }

    @ReactMethod
    public void show(String msg, Callback callback){
        Toast.makeText(getReactApplicationContext(),"Js调用显示原生传递的参数是:"+msg, Toast.LENGTH_LONG).show();
        callback.invoke("RNToastModule 调用JS方法");
    }

}