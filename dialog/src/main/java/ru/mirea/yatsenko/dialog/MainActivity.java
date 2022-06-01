package ru.mirea.yatsenko.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickShowDialog(View view) {
        AlertDialogFragment dialogFragment = new AlertDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "mirea");
    }
    public void onOkClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Иду дальше\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onCancelClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Нет\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onNeutralClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"На паузе\"!",
                Toast.LENGTH_LONG).show();
    }
    Calendar CurrentTime = Calendar.getInstance();
    TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            CurrentTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            CurrentTime.set(Calendar.MINUTE, minute);
        }
    };
    public void onClickProgressDialog(View view) {
        MyProgressDialogFragment myProgressDialogFragment = new MyProgressDialogFragment(MainActivity.this);
        myProgressDialogFragment.show();
    }
    public void onClickTimeDialog(View view) {
        MyTimeDialogFragment myTimeDialogFragment = new MyTimeDialogFragment(MainActivity.this, t,
                CurrentTime.get(Calendar.HOUR_OF_DAY),
                CurrentTime.get(Calendar.MINUTE), true);
        myTimeDialogFragment.show();
    }

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
            CurrentTime.set(Calendar.YEAR, year);
            CurrentTime.set(Calendar.MONTH, monthOfYear);
            CurrentTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        }
    };

    public void onClickDateDialog(View view) {
        MyDateDialogFragment myDateDialogFragment = new MyDateDialogFragment(MainActivity.this, d,
                CurrentTime.get(Calendar.YEAR),
                CurrentTime.get(Calendar.MONTH),
                CurrentTime.get(Calendar.DAY_OF_MONTH));
        myDateDialogFragment.show();
    }
}