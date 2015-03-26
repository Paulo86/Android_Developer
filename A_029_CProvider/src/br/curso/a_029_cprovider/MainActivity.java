package br.curso.a_029_cprovider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle.Control;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Context context;
	//
	private ListView lv_contatos;
	private ArrayList<HashMap<String, String>> contatos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		iniciallizarVariavel();
		inicializarAcao();
		criarListaContatos();
	}

	private void iniciallizarVariavel() {
		context = getBaseContext();
		//
		lv_contatos = (ListView) findViewById(R.id.telainicial_lv_contatos);
	}

	private void inicializarAcao() {
		// lv_contatos.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		//
		// HashMap<String, String> item = (HashMap<String, String>);
		//
		//
		// }
		// });
		//
		lv_contatos.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				HashMap<String, String> item = (HashMap<String, String>) parent
						.getItemAtPosition(position);

				if (item.get("temtelefone").equals("1")) {

					Uri PhoneContent_Uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

					String Phone_ID = ContactsContract.CommonDataKinds.Phone.CONTACT_ID;
					String Phone_name = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME;
					String Number = ContactsContract.CommonDataKinds.Phone.NUMBER;

					String[] campos = { Phone_name, Number };

					String Telefones = item.get("nome") + "\n";

					try {

						Cursor cursor = getContentResolver().query(
								PhoneContent_Uri, campos, Phone_ID + " = ?", new String [] { item.get("codigo")},
								null);
						
						while(cursor.moveToNext()){
							Telefones += "\n" + cursor.getString(cursor.getColumnIndex(Number));
						}
						
						cursor.close();
						cursor = null;

					} catch (Exception e) {
						e.toString();
					}
					
					Toast.makeText(context, Telefones,
							Toast.LENGTH_SHORT).show();


				} else {
					Toast.makeText(context, "Não tem telefone",
							Toast.LENGTH_SHORT).show();
				}
			}
		});

	}

	private void criarListaContatos() {
		contatos = new ArrayList<HashMap<String, String>>();
		//
		// Endereco do Servico
		Uri uri = ContactsContract.Contacts.CONTENT_URI;
		String order = ContactsContract.Contacts.DISPLAY_NAME;

		Cursor cursor = getContentResolver()
				.query(uri, null, null, null, order);

		while (cursor.moveToNext()) {

			HashMap<String, String> item = new HashMap<String, String>();
			item.put("codigo", cursor.getString(cursor
					.getColumnIndex(ContactsContract.Contacts._ID)));
			item.put("nome", cursor.getString(cursor
					.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
			item.put(
					"temtelefone",
					cursor.getString(cursor
							.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));

			contatos.add(item);
		}
		//
		cursor.close();

		String[] from = { "codigo", "nome" };
		int[] to = { R.id.celula_tv_idcontato, R.id.celula_tv_nome };
		lv_contatos.setAdapter(new SimpleAdapter(context, contatos,
				R.layout.celula, from, to));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
