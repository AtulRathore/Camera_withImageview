package com.example.atul.camera1;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button button;
    ImageView imageView;
    Bitmap bmp;
    int a =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.imageView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,a);

//                WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
            }
        });

    }

    protected void onActivityResult(int reqcode, int resultcode, Intent data){
        super.onActivityResult(reqcode,resultcode,data);
        if(reqcode==1){
            Bundle b = data.getExtras();
            bmp = (Bitmap) b.get("data");
            imageView.setImageBitmap(bmp);
        }
    }

}
