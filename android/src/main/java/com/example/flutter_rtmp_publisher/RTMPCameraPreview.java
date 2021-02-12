package com.example.flutter_rtmp_publisher;

import android.view.TextureView;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.View;
import android.util.Log;

import com.pedro.rtplibrary.view.OpenGlView;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.platform.PlatformView;

public class RTMPCameraPreview implements PlatformView {
    OpenGlView openGlView;

    RTMPCameraPreview(Context context, BinaryMessenger messenger, int id, Object o) {
        Integer cameraId = Integer.valueOf(o.toString());
        Log.i("RTMPCameraPreview", "Create preview from camera " + cameraId.toString());
        this.openGlView = new OpenGlView(context);
        FlutterRtmpPublisherPlugin.cameraList.get(cameraId).setView(this.openGlView);
        Log.i("RTMPCameraPreview", "TextureView created.");
    }

    @Override
    public void dispose() {
    }

    @Override
    public View getView() {
        return this.openGlView;
    }
}