package com.pwpb.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Poster> posterList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        posterList = new ArrayList<>();
        listView = findViewById(R.id.lv1);

        posterList.add(new Poster(R.drawable.atlas, "FM-84", "Atlas"));
        posterList.add(new Poster(R.drawable.atlas, "TESTHAPUS", "Atlas"));
        posterList.add(new Poster(R.drawable.bendandbreak, "FM-84", "Bend And Break"));
        posterList.add(new Poster(R.drawable.darkallday, "GUNSHIP", "Dark All Day"));
        posterList.add(new Poster(R.drawable.gunship, "GUNSHIP", "GUNSHIP"));
        posterList.add(new Poster(R.drawable.nocturnal, "The Midnight", "Nocturnal"));
        posterList.add(new Poster(R.drawable.tdrl, "GUNSHIP", "The Drone Racing League"));

        LvAdapter adapter = new LvAdapter(this, R.layout.listview_row, posterList);
        listView.setAdapter(adapter);
    }
}
