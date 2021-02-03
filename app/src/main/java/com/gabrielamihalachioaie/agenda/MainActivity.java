package com.gabrielamihalachioaie.agenda;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class MainActivity extends AppCompatActivity {
    private GregorianCalendar calendar = new GregorianCalendar();

    private EditText fullName;
    private EditText birthDate;
    private EditText phoneNumber;
    private EditText email;
    private EditText description;

    private Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fullName = findViewById(R.id.fullName);
        birthDate = findViewById(R.id.birthDate);
        phoneNumber = findViewById(R.id.phoneNumber);
        email = findViewById(R.id.email);
        description = findViewById(R.id.description);

        continueButton = findViewById(R.id.continueButton);
    }

    public void showDatePickerDialog(View v) {
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setListenerOfDateSelection(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);

                birthDate.setText(String.format("%d/%d/%d",
                        calendar.get(Calendar.DAY_OF_MONTH),
                        calendar.get(Calendar.MONTH) + 1,
                        calendar.get(Calendar.YEAR)));
            }
        });

        fragment.show(getSupportFragmentManager(), "birthDatePicker");
    }

    public void switchToConfirmationActivity(View v) {
        AgendaEntry entry = new AgendaEntry(fullName.getText().toString(), calendar,
                phoneNumber.getText().toString(), email.getText().toString(), description.getText().toString());

        Intent intent = new Intent(this, EntryConfirmationActivity.class);
        intent.putExtra(EntryConfirmationActivity.ENTRY_DETAILS, entry);

        startActivity(intent);
    }
}