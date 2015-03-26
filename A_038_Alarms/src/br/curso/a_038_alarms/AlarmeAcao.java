package br.curso.a_038_alarms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmeAcao extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		
		Toast.makeText(context, "Ação do Alarme", Toast.LENGTH_LONG).show();
		
	}
	
	

}
