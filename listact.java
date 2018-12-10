package c16315146.mydit.ie.myandroidproject;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class listact extends AppCompatActivity {


    ListView myListView;
    String[] bookNames;
    String[] bookAuthor;
    String[] bookCategory;
    MyDBhandler myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listact);

        myDB = new MyDBhandler(this);


        myListView = findViewById(R.id.myListView);


        //new lists stuff
        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.getListContents();

        if(data.getCount() == 0)
        {
                Toast.makeText(listact.this, "Its done boi",Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                theList.add(data.getString(1));//for book name
                //theList.add(data.getString(2); //for author
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                myListView.setAdapter(listAdapter);

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
    }
}
