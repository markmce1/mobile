package c16315146.mydit.ie.myandroidproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
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
            case 2: return R.drawable.ditlogo2;
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

    String url1 = ("https://www.youtube.com/results?search_query=book+review+");
    String url2 = ("https://www.amazon.co.uk/s/ref=nb_sb_noss?url=search-alias%3Daps&field-keywords=");
    public void open(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url2));
        startActivity(browserIntent);


    }

    public void openYoutube(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url1));
        startActivity(browserIntent);

    }


}
