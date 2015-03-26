package br.curso.a_031_broadcast_receiver_oncode;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private TextView tv_mudar_valor;
	
	private ReceiverInterno receiver;
	
	private String res = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		tv_mudar_valor = (TextView) findViewById(R.id.telaincial_tv_mudar_varlo);
		//
		IntentFilter filter = new IntentFilter("EXECUTA_PROGRAMA");
		filter.addCategory(Intent.CATEGORY_DEFAULT);
		//
		receiver = new ReceiverInterno();
		//
		registerReceiver(receiver, filter);
		
	}
	
	@Override
	protected void onResume() {
		tv_mudar_valor.setText(res);
		// 
		super.onResume();
	}
	
	
	
	@Override
	protected void onDestroy() {
		unregisterReceiver(receiver);
		// 
		super.onDestroy();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private class ReceiverInterno extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			res = tv_mudar_valor.getText().toString() + " 0 ";
			//
			Log.d("RECEIVER", "OnCode");
			
		}
	}
}
