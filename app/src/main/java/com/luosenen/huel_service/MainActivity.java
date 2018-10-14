package com.luosenen.huel_service;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    String[]  permissions = new String[]{
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
    };
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private Button One,Two,Three;
    private TextView app;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        One = findViewById(R.id.One);
        Two = findViewById(R.id.Two);
        app = findViewById(R.id.appName);
        AssetManager assets = getAssets();
        Typeface fromAsset = Typeface.createFromAsset(assets, "font/font.ttf");
        app.setTypeface(fromAsset);
        Three = findViewById(R.id.Three);
        One.setOnClickListener(this);
        Two.setOnClickListener(this);
        Three.setOnClickListener(this);
        requestPower();
    }

    public void requestPower() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        permissions,
                        1);
            }
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.One:

                startActivity(new Intent(getApplicationContext(),OneActivity.class));
                overridePendingTransition(R.anim.anim_in,R.anim.anim_out);
                break;
            case R.id.Two:
                startActivity(new Intent(getApplicationContext(),TwoActivity.class));
                overridePendingTransition(R.anim.anim_in,R.anim.anim_out);
                break;
            case R.id.Three:
                startActivity(new Intent(getApplicationContext(),ThreeActivity.class));
                overridePendingTransition(R.anim.anim_in,R.anim.anim_out);
                break;
        }
    }
}
