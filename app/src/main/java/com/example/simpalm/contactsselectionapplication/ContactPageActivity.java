package com.example.simpalm.contactsselectionapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ContactPageActivity extends AppCompatActivity implements View.OnClickListener {

    private final int PHONE = 0;
    private final int WEBSITE = 1;
    private TextView contactName1;
    private TextView contactPhone1;
    private TextView contactWebsite1;
    private ContactObject contactObject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_page);

        contactName1 = (TextView) findViewById(R.id.contactName);
        contactPhone1 = (TextView) findViewById(R.id.contactPhone);
        contactWebsite1 = (TextView) findViewById(R.id.contactWebsite);

        Bundle extras = getIntent().getExtras();
        if (extras == null)
            return;
        contactObject = (ContactObject) getIntent().getSerializableExtra("Object");

        contactName1.setText(contactObject.getName());
        contactPhone1.setText("Phone: " + contactObject.getPhone());
        contactWebsite1.setText("Website:" + contactObject.getWebsite());

        contactPhone1.setOnClickListener(this);
        contactWebsite1.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.contactPhone:
                Intent i = new Intent();
                i.putExtra("value", contactObject.getPhone());
                setResult(PHONE, i);
                finish();
                break;

            case R.id.contactWebsite:

                i = new Intent();
                i.putExtra("value", contactObject.getWebsite());
                setResult(WEBSITE, i);
                finish();
                break;
        }

    }
}
