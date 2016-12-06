package com.dxytech.oden.annotations.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.dxytech.oden.annotations.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class QHBActivity extends AppCompatActivity {

	private static final String SERVICE_NAME = "com.dxytech.oden.annotations/com.dxytech.oden.annotations.app.service.HongbaoService_";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_qhb);

		String cmd1 = "settings put secure enabled_accessibility_services com.dxytech.oden.annotations/com.dxytech.oden.annotations.app.service.HongbaoService_";
		String cmd2 = "settings put secure accessibility_enabled 1";

		// execShell(cmd1);
		// execShell(cmd2);

		try {
			Settings.Secure.putInt(getContentResolver(),
					Settings.Secure.ACCESSIBILITY_ENABLED, 1);
		} catch (Exception e) {
			Log.d("wutl", " open accesibility service exception = " + e.toString());
		}

		Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
		startActivity(intent);
	}

	private static void execShell(String cmd) {
		try {
			Process p = Runtime.getRuntime().exec(cmd);
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String readLine = br.readLine();
			while (readLine != null) {
				System.out.println(readLine);
				readLine = br.readLine();
			}
			if (br != null) {
				br.close();
			}
			p.destroy();
			p = null;
		} catch (IOException e) {
			Log.d("wutl", " exec command  exception = " + e.toString());
		}
	}

}
