package c16315146.mydit.ie.myandroidproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class usefulWebsites extends AppCompatActivity {

    EditText bookSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useful_websites);
        bookSearch = findViewById(R.id.bookSearch);

    }
    String url1 = ("https://www.youtube.com/results?search_query=book+review+" + bookSearch);
    public void open(View view) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.co.uk/s/ref=nb_sb_noss?url=search-alias%3Daps&field-keywords=" + bookSearch));
            startActivity(browserIntent);


    }

    public void openYoutube(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url1));
        startActivity(browserIntent);

    }
}
