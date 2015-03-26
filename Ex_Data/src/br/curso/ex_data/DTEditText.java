package br.curso.ex_data;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.EditText;

public class DTEditText extends EditText implements OnClickListener {

	private Context context;
	private SimpleDateFormat dateFormatter;
	private String titulo = "Select Date";

	public DTEditText(Context context) {
		super(context);
		//
		initialize(context);
	}

	public DTEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		//
		initialize(context);
	}

	public DTEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		//
		initialize(context);
	}

	private void initialize(Context context) {
		this.context = context;
		//
		this.dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		//
		setInputType(InputType.TYPE_NULL);
		setFocusable(false);
		//
		setOnClickListener(this);
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public void onClick(View v) {
		String mConteudo = getText().toString();
		//
		Calendar mDate = Calendar.getInstance();
		//
		try {
			mDate.setTime(dateFormatter.parse(mConteudo));
		} catch (Exception e) {
		}
		//
		int mYear = mDate.get(Calendar.YEAR);
		int mMonth = mDate.get(Calendar.MONTH);
		int mDay = mDate.get(Calendar.DAY_OF_MONTH);
		//
		DatePickerDialog mDatePicker = new DatePickerDialog(context,

		new OnDateSetListener() {

			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {

				Calendar newDate = Calendar.getInstance();
				//
				newDate.set(year, monthOfYear, dayOfMonth);
				//
				setText(dateFormatter.format(newDate.getTime()));
			}
		}

		, mYear, mMonth, mDay);
		//
		mDatePicker.setTitle(titulo);
		//
		mDatePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Ok", mDatePicker);
		mDatePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE, "Cancelar", mDatePicker);
		
		//
		mDatePicker.show();
		

	}

}
