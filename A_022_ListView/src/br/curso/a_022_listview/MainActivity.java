package br.curso.a_022_listview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Context context;

	private ListView lv_nome;
	private ArrayList<String> nomes;
	private ArrayAdapter<String> nomesadapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		context = getBaseContext();
		//
		nomes = new ArrayList<String>();
		nomes.add("Hugo");
		nomes.add("Pedro");
		nomes.add("Maria");
		nomes.add("Josefá");
		nomes.add("Eduardo");
		//
		nomesadapter = new ArrayAdapter<String>(context,
				android.R.layout.simple_list_item_1, nomes);
		//
		lv_nome = (ListView) findViewById(R.id.lv_nomes);
		lv_nome.setAdapter(nomesadapter);
		lv_nome.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				
				String resultado = (String) parent.getItemAtPosition(position);
				
				Toast.makeText(context, resultado, Toast.LENGTH_SHORT).show();
				
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
