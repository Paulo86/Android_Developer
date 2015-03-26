package br.curso.a_final.service;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import br.curso.a_final.R;
import br.curso.a_final.dao.PacienteDao;
import br.curso.a_final.vo.Paciente;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class DB_Service extends IntentService {

	private static final String NAMESPACE = "http://tempuri.org/";
	private static final String METHOD_NAME = "getPacientes";
	//
	private static final String SOAP_ACTION = NAMESPACE + METHOD_NAME;
	// private static final String URL_WEB =
	// "http://172.16.6.31/ws/WebService.asmx?WSDL";
	private static final String URL_WEB = "http://www.nmsystems.com.br/androidsoapws/WebService.asmx?WSDL";

	private String msg = "";

	public DB_Service() {
		super("DB_Service");
	}

	@Override
	protected void onHandleIntent(Intent intent) {

		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
		request.addProperty("quantidade", 80);
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
			SoapObject result = (SoapObject) envelope.getResponse();
			//
			if (result != null) {
				ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
				//
				for (int i = 0; i < result.getPropertyCount(); i++) {
					SoapObject pii = (SoapObject) result.getProperty(i);
					Paciente pAux = new Paciente();
					//
					pAux.setCodigo(Integer.parseInt(pii.getProperty("codigo")
							.toString()));
					pAux.setNome(pii.getProperty("nome").toString());
					pAux.setIdade(Integer.parseInt(pii.getProperty("idade")
							.toString()));
					pAux.setSexo(pii.getProperty("sexo").toString());
					pAux.setEndereco(pii.getProperty("endereco").toString());
					//
					pacientes.add(pAux);
				}
				//
				PacienteDao pacienteDao = new PacienteDao(getBaseContext());
				pacienteDao.insList(pacientes);
				//
				msg = "Sincronismo Realizado com Sucesso!!!";
				//
				enviarAviso();
				//
			}

		} catch (Exception e) {
			msg = "Erro de Sincronimo: " + e.toString();
		} finally {
			//
			enviarNotificacao();
			//
		}
	}

	private void enviarAviso() {
		Intent mIntent = new Intent();
		mIntent.setAction("DADOS_OK");
		mIntent.addCategory(Intent.CATEGORY_DEFAULT);
		sendBroadcast(mIntent);
	}

	@SuppressLint("NewApi")
	private void enviarNotificacao() {
		NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		Notification.Builder builder = new Notification.Builder(
				getBaseContext());
		//
		builder.setContentTitle("Sincronismo")
				.setSmallIcon(R.drawable.ic_launcher).setContentText(msg)
				.setAutoCancel(true);
		builder.setDefaults(Notification.DEFAULT_SOUND
				| Notification.DEFAULT_VIBRATE);
		//
		nm.notify(0, builder.build());
	}

}
