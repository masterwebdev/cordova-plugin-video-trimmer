/**
*/
package com.autovitalsinc;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import java.util.Date;

import life.knowledge4.videotrimmer.K4LVideoTrimmer;

public class VideoTrimmer extends CordovaPlugin {
	private static final String TAG = "VideoTrimmer";
	
	private CallbackContext cbContext;

	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);

		Log.d(TAG, "Initializing VideoTrimmer");
	}

	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		
		this.cbContext=callbackContext;
		
		String path = args.getString(0);
		
		if(action.equals("trim")) {
			
			K4LVideoTrimmer videoTrimmer = ((K4LVideoTrimmer) cordova.getActivity().getWindow().getDecorView().findViewById(getResId("timeLine", "id")));
            if (videoTrimmer != null) {
                videoTrimmer.setVideoURI(Uri.parse(path));
            }
            
            Intent intent = new Intent("life.knowledge4.videotrimmer.K4LVideoTrimmer");

            this.cordova.startActivityForResult((CordovaPlugin) this, intent, 0);

			
		}
		return true;
	}

	public boolean getResult(){
		final PluginResult result = new PluginResult(PluginResult.Status.OK, (new Date()).toString());
		this.cbContext.sendPluginResult(result);
		
		return true;
	}
	
    private int getResId(String name, String type) {
        return cordova.getActivity().getResources().getIdentifier(name, type, cordova.getActivity().getPackageName());
    }

}