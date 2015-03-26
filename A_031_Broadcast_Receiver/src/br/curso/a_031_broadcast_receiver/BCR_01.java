package br.curso.a_031_broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BCR_01 extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "BroadCast 01 - Processado", Toast.LENGTH_LONG)
				.show();
	}
}
