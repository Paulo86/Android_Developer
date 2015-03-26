package br.curso.lab_022_lista_contatos;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Context context;

	private ListView lv_contatos;
	private ArrayList<HashMap<String, String>> contatos;
	private AdapterContato adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		context = getBaseContext();
		//
		lv_contatos = (ListView) findViewById(R.id.telainicial_lv_contatos);
		//
		gerarContatos(1000);
		//
		//adapter = new AdapterContato(context, contatos);
		adapter = new AdapterContato(context, R.layout.celula_2, contatos);
		//
		lv_contatos.setAdapter(adapter);
		//
		lv_contatos.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// Toast nome
				// HashMap<String, String> item = (HashMap<String, String>)
				// parent.getItemAtPosition(position);

				Toast.makeText(context,
						String.valueOf(position) + " - " + String.valueOf(id),
						Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void gerarContatos(int quantidade) {
		contatos = new ArrayList<HashMap<String, String>>();
		//
		for (int i = 0; i < quantidade; i++) {
			HashMap<String, String> item = new HashMap<String, String>();
			//
			item.put(Constantes.ID, String.valueOf(i + 1));
			item.put(Constantes.NOME, "Nome - " + String.valueOf(i + 1));
			item.put(Constantes.TELEFONE, "Telefone - " + String.valueOf(i + 1));
			//
			contatos.add(item);
		}
	}

}
