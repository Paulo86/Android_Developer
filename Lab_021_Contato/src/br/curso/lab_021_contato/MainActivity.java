package br.curso.lab_021_contato;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Context context;
	//
	private Spinner sp_contatos;
	private ArrayList<Contato> contatos;
	private ArrayAdapter<Contato> contatosadapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		context = getBaseContext();
		//
		contatos = new ArrayList<Contato>();
		contatos.add(new Contato(10, "Hugo", "4444-44444"));
		contatos.add(new Contato(20, "Android", "5555-55555"));
		contatos.add(new Contato(30, "Corina", "5555-44444"));
		contatos.add(new Contato(40, "Paulo", "4444-55555"));
		contatos.add(new Contato(50, "José", "8888-88888"));
		//
		contatosadapter = new ArrayAdapter<Contato>(context,
				android.R.layout.simple_spinner_item, contatos);
		contatosadapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//
		sp_contatos = (Spinner) findViewById(R.id.sp_contatos);
		sp_contatos.setAdapter(contatosadapter);
		//
		sp_contatos.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {

				Contato cAux = (Contato) parent.getItemAtPosition(position);

				Toast.makeText(context, String.valueOf(cAux.getIdcontato()),
						Toast.LENGTH_SHORT).show();

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
