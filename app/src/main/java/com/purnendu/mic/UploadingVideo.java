package com.purnendu.mic;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class UploadingVideo extends AppCompatActivity {

    View included_video_card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploading_video);
        ActionBar action = getSupportActionBar();
        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        assert action != null;
        Toolbar toolbar=(Toolbar)action.getCustomView().getParent();
        toolbar.setContentInsetsAbsolute(0, 0);
        toolbar.getContentInsetEnd();
        toolbar.setPadding(0, 0, 0, 0);

        included_video_card=findViewById(R.id.included_video_card);
        View choose_video=included_video_card.findViewById(R.id.choose_video);
        choose_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog= new AlertDialog.Builder(UploadingVideo.this);
                LayoutInflater inflater=LayoutInflater.from(UploadingVideo.this);
                View myView= inflater.inflate(R.layout.confirm_details,null);
                alertDialog.setView(myView);
                AlertDialog dialog=alertDialog.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                Button save=myView.findViewById(R.id.save);
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(UploadingVideo.this,PaymentDetails.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}