package com.webviewtest.Javamodule;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseJsPackage implements ReactPackage {
    @Override
    public List<NativeModule> createNativeModules (ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        modules.add(new CourseJavaMoudle(reactContext));
        return modules;
    }

    @Override
    public List <ViewManager> createViewManagers (ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }
}
