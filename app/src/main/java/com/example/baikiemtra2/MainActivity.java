package com.example.baikiemtra2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Item> listItem;
    ItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        listItem = new ArrayList<>();
        getData();
        adapter = new ItemAdapter(this,R.layout.line_item, listItem);
        listView.setAdapter(adapter);
    }
    private void getData()
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference byRef = database.getReference("dbNgonNgu");
        byRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Item item = snapshot.getValue(Item.class);
                    item.setId(dataSnapshot.getKey());
                    listItem.add(item);
                }
                Toast.makeText(MainActivity.this, "Thành công", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Thất bại", Toast.LENGTH_SHORT).show();
            }
        });
    }

}