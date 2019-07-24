import React, { Component } from 'react';
import { View } from 'react-native';
import { WebView } from 'react-native-webview';

export default class Test extends Component {
    render() {
        const html = `
      <html>
      <head></head>
      <body>
        <script>
          setTimeout(function () {
            window.ReactNativeWebView.postMessage("Hello!")
          }, 2000)
        </script>
      </body>
      </html>
    `;

        return (
            <View style={{ flex: 1 }}>
                <WebView
                    source={{ html }}
                    onMessage={event => {
                        alert(event.nativeEvent.data);
                    }}
                />
            </View>
        );
    }
}
