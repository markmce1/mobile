package c16315146.mydit.ie.myandroidproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class listdetails extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdetails);


        Intent in = getIntent();
        int index = in.getIntExtra("c16315146.mydit.ie.BOOK_INDEX", -1 );

        if(index > -1){
            int pic = getimage(index);
            ImageView img = findViewById(R.id.imageView);
            scaleimage(img, pic);
        }
    }

    private int getimage(int index){
        switch(index){
            case 0: return R.drawable.artofthedeal;
            case 1: return R.drawable.ditlogo;
            default: return -1;
        }
    }
    private void scaleimage(ImageView img, int pic){
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(),pic,options);
        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();
        if(imgWidth > screenWidth){
            int ratio = Math.round( (float)imgWidth / (float)screenWidth);
            options.inSampleSize = ratio;

        }

        options.inJustDecodeBounds = false;
        Bitmap scaledimage = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaledimage);
    }


}
