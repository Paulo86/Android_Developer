package br.curso.a_022_listview_adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	private Context context;
	
	private ListView lv_herois;
	private ArrayList<Heroi> herois;
	private AdapterNew adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		context = getBaseContext();
		//
		lv_herois = (ListView) findViewById(R.id.telainicial_lv_herois);
		//
		herois = new ArrayList<Heroi>();
		herois.add(new Heroi("Cyclopes", R.drawable.man, "Ser traido"));
		herois.add(new Heroi("Jean Gray", R.drawable.woman, "Ttraidora"));
		//
		adapter = new AdapterNew(context, herois);
		//
		lv_herois.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
