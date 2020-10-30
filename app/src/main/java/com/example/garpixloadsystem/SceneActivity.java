package com.example.garpixloadsystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.activity.OnBackPressedCallback;

import java.util.Objects;

import views.SceneExampleView;

public class SceneActivity extends BaseActivity {

    private int id;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setScreenParams();
        setContentView(R.layout.activity_scene);

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(SceneActivity.this, DemoActivity.class);
                startActivity(intent);
            }
        };

        getOnBackPressedDispatcher().addCallback(this, callback);

        id = Objects.requireNonNull(getIntent().getExtras()).getInt("id");

        relativeLayout = findViewById(R.id.root_layout);
        SceneExampleView sceneExampleView = new SceneExampleView(this, id);
        RelativeLayout.LayoutParams relativeTextParams = new RelativeLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        relativeLayout.addView(sceneExampleView, relativeTextParams);

    }
}