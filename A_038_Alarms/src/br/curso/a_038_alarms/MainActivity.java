package br.curso.a_038_alarms;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
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
	private PendingIntent pi;
	//
	private Button btn_au;
	private Button btn_ar;
	private Button btn_cancelar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		context = getBaseContext();
		//
		btn_au = (Button) findViewById(R.id.btn_alarme);
		btn_ar = (Button) findViewById(R.id.btn_alarme_repetitivo);
		btn_cancelar = (Button) findViewById(R.id.btn_cancelar);
		//
		btn_au.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Calendar calendar = Calendar.getInstance();
				//
				calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 2);
				//
				Intent mIntent = new Intent(context, AlarmeAcao.class);
				pi = PendingIntent.getBroadcast(context, 0, mIntent, 0);
				//
				AlarmManager al = (AlarmManager) context
						.getSystemService(ALARM_SERVICE);
				//
				al.set(AlarmManager.RTC, calendar.getTimeInMillis(), pi);
			}
		});
		//
		btn_ar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent mIntent = new Intent(context, AlarmeAcao.class);
				pi = PendingIntent.getBroadcast(context, 0, mIntent, 0);
				//
				AlarmManager al = (AlarmManager) context
						.getSystemService(ALARM_SERVICE);
				//
				al.setRepeating(AlarmManager.RTC_WAKEUP,
						System.currentTimeMillis(), 5 * 1000, pi);
			}
		});
		//
		btn_cancelar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				AlarmManager al = (AlarmManager) context
						.getSystemService(ALARM_SERVICE);
				al.cancel(pi);
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
