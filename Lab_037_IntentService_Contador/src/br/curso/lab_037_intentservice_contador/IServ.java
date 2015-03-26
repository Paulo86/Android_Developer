package br.curso.lab_037_intentservice_contador;

import android.app.IntentService;
import android.content.Intent;

public class IServ extends IntentService {

	private int iIndex;

	public IServ() {
		super("IServ");
	}

	@Override
	protected void onHandleIntent(Intent intent) {

		try {
			iIndex = 0;
			//
			while (iIndex < 25) {
				iIndex++;
				//
				Thread.sleep(200);
				//
				enviarBroadCast(iIndex, 0);
			}

		} catch (Exception e) {
		}
		//
		enviarBroadCast(0, 1);
	}

	private void enviarBroadCast(int valor, int tipo) {
		Intent mIntent = new Intent("NV");
		mIntent.putExtra(Constantes.NOVO_VALOR, String.valueOf(valor));
		mIntent.putExtra(Constantes.TIPO, tipo);
		//
		sendBroadcast(mIntent);
	}

}
