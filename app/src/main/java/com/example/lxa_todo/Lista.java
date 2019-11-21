package com.example.lxa_todo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Lista extends AppCompatActivity {

    private ToDoAdapter ada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        Button btnAddNew = findViewById(R.id.btnAddNew);
        ListView listView = findViewById(R.id.listView);

        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lista.this, MainActivity.class);
                startActivityForResult(intent, 1);
            }
        });

//        Item item = new Item();
//        item.setItem("asdf1");
//        item.setStatus(false);
//        item.setDate("asdf");
//        item.setTime("asdf");
//
//        Item item2 = new Item();
//        item2.setItem("asdf2");
//        item2.setStatus(false);
//        item2.setDate("hj");
//        item2.setTime("asdngdsfsf");
//
//        Item item3 = new Item();
//        item3.setItem("asdf3");
//        item3.setStatus(false);
//        item3.setDate("afg");
//        item3.setTime("hdfsgnjdgfm");
//
//        List<Item> data = new ArrayList<>();
//        data.add(item);
//        data.add(item2);
//        data.add(item3);

        ada = new ToDoAdapter();
//        ada.setData(data);

        listView.setAdapter(ada);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 1 && resultCode == Activity.RESULT_OK) {
            Item item = new Item();
            item.setItem(data.getStringExtra("item"));
            item.setStatus(!data.getBooleanExtra("status",true));
            item.setDate(data.getStringExtra("date"));
            item.setTime(data.getStringExtra("time"));
            ada.addItem(item);
        }
    }


}
