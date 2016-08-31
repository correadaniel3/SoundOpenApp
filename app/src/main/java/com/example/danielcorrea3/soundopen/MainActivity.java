package com.example.danielcorrea3.soundopen;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.musicg.wave.Wave;
import com.musicg.fingerprint.FingerprintSimilarity;

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Wave w1 = new Wave(getResources().openRawResource(R.raw.prueba));
        Wave w2 = new Wave(getResources().openRawResource(R.raw.prueba));
        Wave w3 = new Wave(getResources().openRawResource(R.raw.prueba2));
        Wave w4 = new Wave(getResources().openRawResource(R.raw.prueba4));
        FingerprintSimilarity fps = w1.getFingerprintSimilarity(w2);
        FingerprintSimilarity fps2 = w1.getFingerprintSimilarity(w3);
        FingerprintSimilarity fps3 = w1.getFingerprintSimilarity(w4);
        float score = fps.getScore();
        TextView info=(TextView)findViewById(R.id.info);
        info.append(Float.toString(fps.getSimilarity())+"\n"+ Float.toString(fps2.getSimilarity())+"\n"+ Float.toString(fps3.getSimilarity()));
        // System.out.println(waveRecording);
        //FingerprintSimilarity similarity = waveRecording.getFingerprintSimilarity(waveBeep);
        //float score = similarity.getScore();
        //Log.d("score", score+"");

    }
    public void listar(View v){
        final PackageManager pm = getPackageManager();
//get a list of installed apps.
        List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

        for (ApplicationInfo packageInfo : packages) {
            TextView info=(TextView)findViewById(R.id.apps);
            info.append("Installed package :" + packageInfo.packageName +"\n");
            //+ " "+ "Installed package :" + packageInfo.sourceDir+" "+ "Launch Activity :" + pm.getLaunchIntentForPackage(packageInfo.packageName)
        }

    }
}
