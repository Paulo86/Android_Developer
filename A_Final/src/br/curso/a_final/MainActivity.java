package br.curso.a_final;

import java.util.HashMap;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import br.curso.a_final.dao.PacienteDao;
import br.curso.a_final.service.DB_Service;

public class MainActivity extends Activity {

	private Context context;
	//
	private ListView lv_pacientes;
	//
	private ResponseReceiver receiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		context = getBaseContext();
		//
		lv_pacientes = (ListView) findViewById(R.id.telainicial_lv_vista);
		//
		IntentFilter filter = new IntentFilter("DADOS_OK");
		filter.addCategory(Intent.CATEGORY_DEFAULT);
		receiver = new ResponseReceiver();
		//
		registerReceiver(receiver, filter);
		//
		Intent mIntent = new Intent(getBaseContext(), DB_Service.class);
		startService(mIntent);
		//
		mostrarDados();
	}

	@Override
	protected void onDestroy() {
		unregisterReceiver(receiver);
		//
		super.onDestroy();
	}

	private class ResponseReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context arg0, Intent arg1) {
			mostrarDados();
		}

	}

	private void mostrarDados() {
		PacienteDao pacienteDao = new PacienteDao(context);
		//
		String[] from = { "nome" };
		int[] to = { R.id.celula_tv_nome };
		SimpleAdapter adapter = new SimpleAdapter(context,
				pacienteDao.getAllPaciente(), R.layout.celula, from, to);

		lv_pacientes.setAdapter(adapter);
	}

}
