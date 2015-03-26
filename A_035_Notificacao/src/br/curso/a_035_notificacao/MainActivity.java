package br.curso.a_035_notificacao;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Context context;
	//
	private Button btn_criar_notificacao;
	private Button btn_cancelar_notificacao;
	//
	private int idNotificacao = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		context = getBaseContext();
		//
		btn_criar_notificacao = (Button) findViewById(R.id.btn_criar_notificacao);
		btn_criar_notificacao.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				criarNotificacao();
			}
		});
		//
		btn_cancelar_notificacao = (Button) findViewById(R.id.btn_cancelar_notificacao);
		btn_cancelar_notificacao.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				cancelarNotificacao();
			}
		});
	}

	@SuppressLint("NewApi")
	protected void criarNotificacao() {
		Intent mIntent = new Intent(context, MainActivity.class);
		//
		PendingIntent pi = PendingIntent.getActivity(context, 0, mIntent, 0);
		//
		NotificationManager nm = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		//
		Notification.Builder builder = new Notification.Builder(context);
		builder.setContentIntent(pi)
				.setSmallIcon(R.drawable.ic_launcher)
				.setAutoCancel(true)
				.setContentTitle("Mensagem")
				.setContentText("Atualização Completa")
				.setDefaults(
						Notification.DEFAULT_SOUND
								| Notification.DEFAULT_VIBRATE);
		//
		int version = android.os.Build.VERSION.SDK_INT;
		
		if (version >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR1){
			nm.notify(idNotificacao, builder.build()); // 4.2 superior
		} else {
			nm.notify(idNotificacao, builder.getNotification());
		}
	}

	protected void cancelarNotificacao() {
		NotificationManager nm = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		//
		nm.cancel(idNotificacao);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
