import React, {Component} from 'react';
import {View, Button, NativeModules} from 'react-native';
import {WebView} from 'react-native-webview';

export default class Test extends Component {
    render() {
        const html = `
      <html>
      <head></head>
      <body>
      <h1>React Native WebView</h1>
        <script>
          setTimeout(function () {
            window.ReactNativeWebView.postMessage("Hello React Native!")
          }, 2000)
        </script>
      </body>
      </html>
    `;

        const run = `
      document.body.style.backgroundColor = 'blue';
      true;
    `;

        setTimeout(() => {
            this.webref.injectJavaScript(run);
        }, 3000);

        return (
            <View style={{flex: 1}}>
                <WebView
                    originWhitelist={['*']}
                    ref={r => (this.webref = r)}
                    source={{uri: 'http://192.168.60.83/manifest/1.html'}}
                    onMessage={event => {
                        alert(event.nativeEvent.data);
                    }}
                />
                <Button
                    onPress={() => {
                        // alert("你点击了按钮！");
                        this.webref.injectJavaScript(`alert(1)`);
                    }}
                    title="RN调用JS！"
                />
                <Button
                    onPress={() => {
                        // alert("你点击了按钮！");
                        NativeModules.CourseJavaMoudle.show('我的万能JS', function (args) {
                            alert(args);
                        });
                    }}
                    title="RN调用Java！"
                />
            </View>
        );
    }
}
