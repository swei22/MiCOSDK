package com.mxchip.easylink;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.mxchip.wifiman.EasyLinkWifiManager;

/**
 * 
 * @author Rocke
 * 
 */
public class MainActivity extends Activity {
	private Button startsearch;
	private Button stopsearch;
	private EditText wifissid;
	private EditText wifipsw;
	public EasyLinkAPI elapi;
	private Context ctx = null;
	private EasyLinkWifiManager mWifiManager = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		wifissid = (EditText) findViewById(R.id.wifissid);
		wifipsw = (EditText) findViewById(R.id.wifipsw);
		startsearch = (Button) findViewById(R.id.startsearch);
		stopsearch = (Button) findViewById(R.id.stopsearch);

		ctx = MainActivity.this;
		elapi = new EasyLinkAPI(ctx);

		mWifiManager = new EasyLinkWifiManager(ctx);
		wifissid.setText(mWifiManager.getCurrentSSID());

		startsearch.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				elapi.startEasyLink(ctx, wifissid.getText().toString()
						.trim(), wifipsw.getText().toString());
				// elapi.startEasyLink_FTC(ctx,
				// wifissid.getText().toString().trim(),
				// wifipsw.getText().toString(), new FTCListener() {
				// @Override
				// public void onFTCfinished(String ip,
				// String jsonString) {
				// Log.d("FTCEnd", ip + " " + jsonString);
				// elapi.stopEasyLink();
				// }
				//
				// @Override
				// public void isSmallMTU(int MTU) {
				// }
				// });
			}
		});

		stopsearch.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// elapi.stopFTC();
				elapi.stopEasyLink();
			}
		});
	}
}
