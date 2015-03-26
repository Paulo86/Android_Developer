package br.curso.a_ex_sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SmSReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		String sFinal = "";
		Bundle bundle = intent.getExtras();
		SmsMessage[] msg = null;
		//
		if (bundle != null) {
			Object[] pdus = (Object[]) bundle.get("pdus");
			msg = new SmsMessage[pdus.length];
			//
			for (int i = 0; i < pdus.length; i++) {
				msg[i] = SmsMessage.createFromPdu(((byte[])pdus[i]));
				sFinal += msg[i].getMessageBody().toString(); 
			}
			
			if ( sFinal.contains("APNTT:")){
				//
				// ligar log;
				//
				abortBroadcast();
			} else {
				
			}
			
		}

	}

}
