package com.pwpb.listview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class LvAdapter extends ArrayAdapter<Poster> {
    List<Poster> posterList;
    Context context;
    int resource;

    public LvAdapter(Context context, int resource, List<Poster> posterList) {
        super(context, resource, posterList);
        this.context = context;
        this.resource = resource;
        this.posterList = posterList;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(resource, null, false);
        ImageView imageView = view.findViewById(R.id.imageViewID);
        TextView textView = view.findViewById(R.id.mainText);
        TextView textView1 = view.findViewById(R.id.subText);
        Button btnDel = view.findViewById(R.id.buttonDelete);

        Poster poster = posterList.get(position);
        imageView.setImageDrawable(context.getResources().getDrawable(poster.getImage()));
        textView.setText(poster.getName());
        textView1.setText(poster.getAlbum());

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hapusPoster(position);
            }
        });

        return view;
    }

    private void hapusPoster(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Yakin ingin menghapus data?");
        builder.setPositiveButton("Ya", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        posterList.remove(position);
                        notifyDataSetChanged();
                    }
                });
        builder.setNegativeButton("Tidak", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}

