package br.curso.a_040_soapcontatos;

import java.util.ArrayList;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {

	private static final String NAMESPACE = "http://tempuri.org/";
	private static final String METHOD_NAME = "getContatos";
	//
	private static final String SOAP_ACTION = NAMESPACE + METHOD_NAME;
	private static final String URL_WEB = "http://172.16.6.31/ws/WebService.asmx?WSDL";
	// private static final String URL_WEB =
	// "http://www.nmsystems.com.br/androidsoapws/WebService.asmx?WSDL";

	private Context context;

	private Button btn_ws;
	private ListView lv_contatos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		context = getBaseContext();
		//
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);
		//
		btn_ws = (Button) findViewById(R.id.btn_chamar_ws);
		btn_ws.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
				request.addProperty("quantidade", 20);
				//
				SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
						SoapEnvelope.VER12);
				//
				envelope.setOutputSoapObject(request);
				envelope.dotNet = true;
				//
				try {

					HttpTransportSE androidHttp = new HttpTransportSE(URL_WEB);
					androidHttp.call(SOAP_ACTION, envelope);
					//
					SoapObject results = (SoapObject) envelope.getResponse();
					//
					ArrayList<Contato> contatos = new ArrayList<Contato>();
					//
					if (results != null) {
						for (int i = 0; i < results.getPropertyCount(); i++) {
							SoapObject pii = (SoapObject) results
									.getProperty(i);
							//
							Contato cAux = new Contato();
							cAux.setCodigo(Long.parseLong(pii.getProperty(
									"codigo").toString()));
							cAux.setNome(pii.getProperty("nome").toString());
							cAux.setTelefone(pii.getProperty("telefone")
									.toString());
							//
							contatos.add(cAux);
						}
					}
					//
					lv_contatos.setAdapter(new ArrayAdapter<Contato>(context,
							android.R.layout.simple_list_item_1, contatos));

				} catch (Exception e) {
					e.toString();
				}

			}
		});

		lv_contatos = (ListView) findViewById(R.id.lv_contatos);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
