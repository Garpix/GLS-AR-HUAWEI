package com.example.garpixloadsystem;

import android.os.Bundle;

import fragments.ExamplesFragment;

public class DemoActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setScreenParams();
        setContentView(R.layout.activity_demo);
        startAnimation();



       openFragment(ExamplesFragment.newInstance(), R.id.container);

    }
}