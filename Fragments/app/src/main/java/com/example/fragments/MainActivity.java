package com.example.fragments;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.util.EventLogTags;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<List_Meme> elements;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init(){
        elements=new ArrayList<>();
        elements.add(new List_Meme("cereal_guy","Cereal Guy",R.drawable.cereal_guy));
        elements.add(new List_Meme("f_yeah","F!@# Yeah",R.drawable.f_yeah));
        elements.add(new List_Meme("forever_alone","Forever Alone",R.drawable.forever_alone));
        elements.add(new List_Meme("freddie_mercury","Freddie Mercury",R.drawable.freddie_mercury));
        elements.add(new List_Meme("lol_guy","LOL Guy",R.drawable.lol_guy));
        elements.add(new List_Meme("neil_degrasse_tyson","Neil deGrasse Tyson",R.drawable.neil_degrasse_tyson));
        elements.add(new List_Meme("oh_crap","Oh Crap/OMG Face",R.drawable.oh_crap));
        elements.add(new List_Meme("okay","Okay Guy",R.drawable.okay));
        elements.add(new List_Meme("rage_guy","Rage Guy",R.drawable.rage_guy));
        elements.add(new List_Meme("troll_face","Trollface/Problem?",R.drawable.troll_face));
        elements.add(new List_Meme("y_u_no_guy","Y U No\" Guy",R.drawable.y_u_no_guy));
        elements.add(new List_Meme("yao_ming","Yao Ming Face",R.drawable.yao_ming));


        List_Adapter List_Adater = new List_Adapter(elements, this, new List_Adapter.OnItemClikListener() {
            @Override
            public void onItemClik(List_Meme item) {
                moveToDescription(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(List_Adater);
    }

    public void moveToDescription(List_Meme item) {
        Intent intent = new Intent(this, DetallesMemes.class);
        intent.putExtra("List_Meme",item);
        startActivity(intent);
    }

}