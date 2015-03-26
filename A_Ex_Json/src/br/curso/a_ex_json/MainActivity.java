package br.curso.a_ex_json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;

import com.google.gson.Gson;

public class MainActivity extends Activity {

	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//
		context = getBaseContext();
		//
		Gson gson = new Gson();
		//
		Enviar_Dados env = new Enviar_Dados();
		ArrayList<Servico> servivos = new ArrayList<Servico>();
		Servico os_01 = new Servico();
		//
		env.setOs_servicos(servivos);
		//
		gson.toJson(env).toString();
		
		Recebe_Dados rec = gson.fromJson(readLog(R.raw.os_lista),
				Recebe_Dados.class);
		
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private String readLog(int iID) {
		StringBuilder contents = new StringBuilder();

		try {

			InputStream inputStream = context.getResources().openRawResource(
					iID);

			InputStreamReader inputreader = new InputStreamReader(inputStream);
			BufferedReader input = new BufferedReader(inputreader);

			try {
				String line = null;

				while ((line = input.readLine()) != null) {
					contents.append(line);
				}
			} finally {
				input.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return contents.toString();
	}

}
