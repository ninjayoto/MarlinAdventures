package net.androidbootcamp.marlinadventures;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;


public class Main extends Activity {

    private int currentYear;
    private int currentMonth;
    private int currentDay;
    static final int DATE_DIALOG_ID = 0;
    private Button btDate;
    //
    private TextView reservation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btDate = (Button) findViewById (R.id.btnDate);
        reservation = (TextView) findViewById(R.id.txtReservation);
        btDate.setOnClickListener(new View.OnClickListener() {

               @Override
               public void onClick(View v) {
               showDialog(DATE_DIALOG_ID);
              }

    });

        final Calendar c = Calendar.getInstance();

        currentYear = c.get(Calendar.YEAR);
        currentMonth = c.get(Calendar.MONTH);
        currentDay = c.get(Calendar.DAY_OF_MONTH);


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;*/
    }
    protected Dialog onCreateDialog(int id){
        switch(id) {
            case DATE_DIALOG_ID :
                return new DatePickerDialog(this,reservationDate, currentYear, currentMonth,currentDay);
        }
    return null;

    }
    private DatePickerDialog.OnDateSetListener reservationDate = new DatePickerDialog.OnDateSetListener() {
    @Override
    public void onDateSet(DatePicker View, int year, int month, int day) {
        reservation.setText ("Your reservation is set for " + (month + 1)+("-") + day + ("-") + year);
    }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
