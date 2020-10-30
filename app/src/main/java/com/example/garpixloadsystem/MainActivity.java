package com.example.garpixloadsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends BaseActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setScreenParams();
        setContentView(R.layout.activity_main);

        startAnimation();

        listView = findViewById(R.id.list_view_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.item_list, getResources().getStringArray(R.array.titles));

        listView.setAdapter(adapter);

        findViewById(R.id.continue_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DemoActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    }

    public void onBackPressed(){
        Intent intent = new Intent(MainActivity.this, LaunchActivity.class);
        startActivity(intent);
    }
}