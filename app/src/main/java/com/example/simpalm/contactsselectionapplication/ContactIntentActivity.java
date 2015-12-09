package com.example.simpalm.contactsselectionapplication;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class ContactIntentActivity extends AppCompatActivity {

    private final int PHONE = 0;
    private final int WEBSITE = 1;
    private ListView intentListView;
    private ArrayAdapter<String> adapter;
    private List<ContactObject> contactsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_intent);

        intentListView = (ListView) findViewById(R.id.listview1);


        // initialize the list and add item

        contactsList = new ArrayList<ContactObject>();
        contactsList.add(new ContactObject("Android One", "111-111-1111", "www.androidATC.com"));
        contactsList.add(new ContactObject("Android Two", "222-222-2222", "www.androidATC.com"));
        contactsList.add(new ContactObject("Android Three", "333-333-3333", "www.androidATC.com"));
        contactsList.add(new ContactObject("Android Four", "444-444-4444", "www.androidATC.com"));

        List<String> listName = new ArrayList<String>();
        for (int i = 0; i < contactsList.size(); i++) {
            listName.add(contactsList.get(i).getName());
        }

        // initialize the arrayadapter object

        adapter = new ArrayAdapter<String>(ContactIntentActivity.this, android.R.layout.simple_list_item_1, listName);

        // set the adapter of the listview

        intentListView.setAdapter(adapter);

        intentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(ContactIntentActivity.this, ContactPageActivity.class);
                i.putExtra("Object", contactsList.get(position));
                startActivityForResult(i, 0);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {


        }


        String value = data.getStringExtra("value");
        switch (resultCode) {
            case PHONE:
                // implicit intent to make a call

                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + value)));
                break;

            case WEBSITE:

                // implicit intent to visit website

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + value)));
                break;

        }
    }
}


