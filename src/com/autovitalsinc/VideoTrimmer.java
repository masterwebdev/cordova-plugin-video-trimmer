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

import android.util.Log;

import java.util.Date;

public class VideoTrimmer extends CordovaPlugin {
	private static final String TAG = "VideoTrimmer";

	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);

		Log.d(TAG, "Initializing VideoTrimmer");
	}

	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		if(action.equals("trim")) {

			
		}
		return true;
	}

	public boolean getResult(){
		final PluginResult result = new PluginResult(PluginResult.Status.OK, (new Date()).toString());
		callbackContext.sendPluginResult(result);
	}

}