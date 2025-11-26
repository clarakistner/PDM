package com.example.myapplication;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ArrayAdapter extends android.widget.ArrayAdapter<ApplicationInfo> {

    int nResource;
    public ArrayAdapter(@NonNull Context context, int resource, @NonNull List<ApplicationInfo> objects) {
        super(context, resource, objects);
        nResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View v = layoutInflater.inflate(nResource, parent, false);
        ApplicationInfo applicationInfo = getItem(position);
        TextView name = v.findViewById(R.id.app_name);
        ImageView icon = v.findViewById(R.id.app_icon);

        name.setText(applicationInfo.loadLabel(getContext().getPackageManager()));
        icon.setImageDrawable(applicationInfo.loadIcon(getContext().getPackageManager()));
        return v;
    }
}
