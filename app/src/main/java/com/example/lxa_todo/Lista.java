package com.example.lxa_todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Lista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        Button btnAddNew = findViewById(R.id.btnAddNew);
        ListView listView = findViewById(R.id.listView);

        Item item = new Item();
        item.setItem("asdf1");
        item.setStatus(false);
        item.setDate("asdf");
        item.setTime("asdf");

        Item item2 = new Item();
        item2.setItem("asdf2");
        item2.setStatus(false);
        item2.setDate("hj");
        item2.setTime("asdngdsfsf");

        Item item3 = new Item();
        item3.setItem("asdf3");
        item3.setStatus(false);
        item3.setDate("afg");
        item3.setTime("hdfsgnjdgfm");

        List<Item> data = new ArrayList<>();
        data.add(item);
        data.add(item2);
        data.add(item3);

        ToDoAdapter ada = new ToDoAdapter();
        ada.setData(data);

        listView.setAdapter(ada);
    }


}
