package com.webviewtest;

import android.widget.Toast;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNToastModule extends ReactContextBaseJavaModule {

    public RNToastModule(final ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "RNToastAndroid";
    }
    @ReactMethod
    public void show(String msg, Callback callback){
        Toast.makeText(getReactApplicationContext(),"Js调用显示原生传递的参数是:"+msg,Toast.LENGTH_LONG).show();
        callback.invoke("RNToastModule 调用JS方法");
    }
}
