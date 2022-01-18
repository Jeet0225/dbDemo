package com.example.dbdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.dbdemo.adapter.RecyclerViewAdapter;
import com.example.dbdemo.data.MydbHandler;
import com.example.dbdemo.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<Contact> contactArrayList;
    private ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MydbHandler db = new MydbHandler(MainActivity.this);

        Contact jeet = new Contact();
        jeet.setPhoneNumber("9090909090");
        jeet.setName("Jeet");

        db.clearDB();
        db.addContact(jeet);
        db.addContact(jeet);
        db.addContact(jeet);
        db.addContact(jeet);
        db.addContact(jeet);
        db.addContact(jeet);
        db.addContact(jeet);
        db.addContact(jeet);
        db.addContact(jeet);
        db.addContact(jeet);
        db.addContact(jeet);
        db.addContact(jeet);
        db.addContact(jeet);
        db.addContact(jeet);
        db.addContact(jeet);
        db.addContact(jeet);
        db.addContact(jeet);
        db.addContact(jeet);
        db.addContact(jeet);
        db.addContact(jeet);
        db.addContact(jeet);
        db.addContact(jeet);
        db.addContact(jeet);
        db.addContact(jeet);
        db.addContact(jeet);


        contactArrayList = new ArrayList<>();

        List<Contact> contactList = db.getAllContacts();


        for(Contact contact: contactList){

            Log.d("dbjeet", "\nId: " + contact.getId() + "\n" +
                    "Phone Number: " + contact.getPhoneNumber() + "\n" +
                    "Name: " + contact.getName() + "\n" );

            contactArrayList.add(contact);
        }

        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, contactArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);

        Log.d("dbjeet","Bro you have" + db.getCount()+ " contact in your database");
    }
}