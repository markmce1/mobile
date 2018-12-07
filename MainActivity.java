package c16315146.mydit.ie.myandroidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button button2;
    EditText BookText;
    ListView listView;
    TextView BookView;
    TextView authorView;
    TextView categoryView;
    MyDBhandler dbhandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BookText = findViewById(R.id.BookText);
        listView = findViewById(R.id.listView);
        authorView = findViewById(R.id.authorView);
        categoryView = findViewById(R.id.categoryView);
        BookView = findViewById(R.id.BookView);
        dbhandler = new MyDBhandler(this, null, null, 1);
        printDatabase();

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openactivity2();

            }
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openlistact();

            }
        });
    }

    public void openactivity2() {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    public void openlistact() {
        Intent intent = new Intent(this, listact.class);
        startActivity(intent);
    }

    //Add a book to the database
    public void addButtonClicked(View view){
        library book = new  library(BookText.getText().toString());
        dbhandler.addBook(book);
        printDatabase();
    }

    public void printDatabase(){
        String dbString = dbhandler.databaseToString();
        if(dbString.length() !=  0)
        {
            BookView.setText(dbString);
            BookText.setText("");
        }
        else
        {
            Toast.makeText(MainActivity.this, "please enter a value",Toast.LENGTH_LONG).show();
        }

    }



    }


