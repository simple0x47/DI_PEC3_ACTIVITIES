package com.gabrielamihalachioaie.agenda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class EntryConfirmationActivity extends AppCompatActivity {
    public static final String ENTRY_DETAILS = "entryDetails";

    private AgendaEntry entry;

    private TextView fullName;
    private TextView birthDate;
    private TextView phoneNumber;
    private TextView email;
    private TextView description;

    private Button editDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        fullName = findViewById(R.id.fullNameText);
        birthDate = findViewById(R.id.birthDateText);
        phoneNumber = findViewById(R.id.phoneNumberText);
        email = findViewById(R.id.emailText);
        description = findViewById(R.id.descriptionText);

        editDetails = findViewById(R.id.editDetails);
        editDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        entry = getIntent().getParcelableExtra(ENTRY_DETAILS);

        fullName.setText(entry.fullName);
        birthDate.setText(String.format("%s %d/%d/%d",
                getString(R.string.birth_date),
                entry.birthDate.get(Calendar.DAY_OF_MONTH),
                entry.birthDate.get(Calendar.MONTH) + 1,
                entry.birthDate.get(Calendar.YEAR)));
        phoneNumber.setText(String.format("%s %s",
                getString(R.string.phone_number_text),
                entry.phoneNumber));
        email.setText(String.format("%s %s",
                getString(R.string.email_text),
                entry.email));
        description.setText(String.format("%s %s",
                getString(R.string.description_text),
                entry.description));
    }
}
