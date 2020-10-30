package com.example.garpixloadsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;

import com.huawei.hms.scene.sdk.ARView;

import java.util.Objects;

public class ARActivity extends BaseActivity {

    private ARView arView;
    private Button setButton;
    private boolean isLoadResource;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setScreenParams();
        setContentView(R.layout.activity_a_r);
        id = Objects.requireNonNull(getIntent().getExtras()).getInt("id");
        arView = findViewById(R.id.ar_view);
        setButton = findViewById(R.id.set_button);

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(ARActivity.this, DemoActivity.class);
                startActivity(intent);
            }
        };

        getOnBackPressedDispatcher().addCallback(this, callback);
    }


    public void onButtonClick(View view) {

        if (!isLoadResource) {

            arView.loadAsset(id + "_pl.gltf");
            float[] scale = new float[]{0.001f, 0.001f, 0.001f};
            float[] rotation = new float[]{0.707f, 0.0f, -0.707f, 0.0f};
            arView.setInitialPose(scale, rotation);
            isLoadResource = true;
            Toast.makeText(this, "Tap to place for set model", Toast.LENGTH_LONG).show();
            setButton.setText(R.string.remove_model);
        } else {
            arView.clearResource();
            arView.loadAsset("");
            isLoadResource = false;
            setButton.setText(R.string.set_model);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        arView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        arView.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        arView.destroy();
    }
}