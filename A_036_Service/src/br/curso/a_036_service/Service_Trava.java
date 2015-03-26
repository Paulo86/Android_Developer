package br.curso.a_036_service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class Service_Trava extends Service {

	private int iIndex;

	//

	@Override
	public void onCreate() {
		super.onCreate();
		//
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		//
		iIndex = 0;

		while (iIndex < 25) {
			try {
				Thread.sleep(200);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//
			iIndex++;
		}
		//
		return 1;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

}
