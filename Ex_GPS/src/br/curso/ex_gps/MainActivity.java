package br.curso.ex_gps;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Context context;

	private TextView tv_tipo;
	private TextView tv_latitude;
	private TextView tv_longitude;
	//
	private Button btn_gps;
	private Button btn_nw;
	private Button btn_stop;

	private double latitude;
	private double longitude;

	private String tipo;

	private LocationManager lm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		context = getBaseContext();
		//
		tv_tipo = (TextView) findViewById(R.id.tv_tipo);
		tv_latitude = (TextView) findViewById(R.id.tv_Latitude);
		tv_longitude = (TextView) findViewById(R.id.tv_longitude);
		//
		btn_gps = (Button) findViewById(R.id.btn_gps);
		btn_gps.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				limparCampos();
				//
				btn_gps.setEnabled(false);
				btn_nw.setEnabled(false);
				//
				tv_tipo.setText("GPS");
				//
				lm = (LocationManager) context
						.getSystemService(LOCATION_SERVICE);
				lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,
						gpsListener);
			}
		});

		btn_nw = (Button) findViewById(R.id.btn_nw);
		btn_nw.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				limparCampos();
				//
				btn_gps.setEnabled(false);
				btn_nw.setEnabled(false);
				//
				tv_tipo.setText("Nw");

				//
				lm = (LocationManager) context
						.getSystemService(LOCATION_SERVICE);
				lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0,
						0, gpsListener);
			}
		});

		btn_stop = (Button) findViewById(R.id.btn_stop);
		btn_stop.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				btn_gps.setEnabled(true);
				btn_nw.setEnabled(true);
				//
				if (lm != null) {
					lm.removeUpdates(gpsListener);
					lm = null;
				}

			}
		});
	}

	protected void limparCampos() {
		tv_tipo.setText("");
		tv_latitude.setText("0");
		tv_longitude.setText("0");
	}

	private LocationListener gpsListener = new LocationListener() {

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onLocationChanged(Location location) {
			latitude = location.getLatitude();
			longitude = location.getLongitude();
			//
			tv_latitude.setText(String.valueOf(latitude));
			tv_longitude.setText(String.valueOf(longitude));

		}
	};

}
