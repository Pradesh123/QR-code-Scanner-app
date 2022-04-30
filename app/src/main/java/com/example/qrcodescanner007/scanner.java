package com.example.qrcodescanner007;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;

import java.util.Objects;

public class scanner extends AppCompatActivity {
    private Button decode,browser,back;
    public static final String NAME = "NAME";
    private TextView nameText;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.purple_700)));
        browser=(Button) findViewById(R.id.browserbtn);
        back=(Button) findViewById(R.id.backbtn);
        nameText=findViewById(R.id.mName);
        Intent i=getIntent();
        name=i.getStringExtra(NAME);
        nameText.setText(name);
        browser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openbrowser();
            }
        });
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                back();
            }
        });
    }
    public void openbrowser(){
        Intent intent= new Intent(this, browser.class);
        intent.putExtra(scanner.NAME,name);
        startActivity(intent);
    }
    public void back(){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
        //frontpage fact=new frontpage();
        //fact.openmainActivity2();

    }

}