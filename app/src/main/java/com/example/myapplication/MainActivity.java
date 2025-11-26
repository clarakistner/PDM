package com.example.myapplication;

import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        PackageManager packageManager = getPackageManager();
        List<ApplicationInfo> appList = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);

        ArrayAdapter adapter = new ArrayAdapter(
                this, R.layout.app_lista,
                appList
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ApplicationInfo applicationInfo = (ApplicationInfo) parent.getItemAtPosition(position);
                String packageName = applicationInfo.packageName;
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();

                Intent intent = packageManager.getLaunchIntentForPackage(packageName);
                if (intent != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Não foi possível abrir o aplicativo", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}