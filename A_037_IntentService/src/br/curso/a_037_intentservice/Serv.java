package br.curso.a_037_intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class Serv extends IntentService {

	private int iIndex;

	public Serv() {
		super("Servico");
	}

	@Override
	protected void onHandleIntent(Intent intent) {

		try {

			iIndex = 0;
			//
			while (iIndex < 25) {
				iIndex++;
				//
				Log.d("ISERV", String.valueOf(iIndex));
				//
				Thread.sleep(200);
			}

		} catch (Exception e) {
		}

	}

}
