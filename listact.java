package c16315146.mydit.ie.myandroidproject;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class listact extends AppCompatActivity {


    ListView myListView;
    String[] bookNames;
    String[] bookAuthor;
    String[] bookCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listact);



        myListView = findViewById(R.id.myListView);


        //begining of list stuff
        Resources res = getResources();
        bookNames = res.getStringArray(R.array.bookNames);
        bookAuthor = res.getStringArray(R.array.bookAuthor);
        bookCategory = res.getStringArray(R.array.bookCategory);

        myListView =  findViewById(R.id.myListView);

        bookAdapter BookAdapter = new bookAdapter(this, bookNames, bookAuthor, bookCategory);
        myListView.setAdapter(BookAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adapterView, View view,int i, long l){
                Intent showlistDetailact = new Intent(getApplicationContext(), listdetails.class);
                        showlistDetailact.putExtra("c16315146.mydit.ie.BOOK_INDEX", i );
                startActivity(showlistDetailact);
            }
        });



    }


    //end of list stuff*/
}
