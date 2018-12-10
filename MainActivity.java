package c16315146.mydit.ie.myandroidproject;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static c16315146.mydit.ie.myandroidproject.MyDBhandler.TABLE_BOOKS;

public class MainActivity extends AppCompatActivity {


    Button button;
    Button usefulLinks;
    Button button2;
    EditText BookText;
    TextView authorView;
    TextView categoryView;
    MyDBhandler dbhandler;
    String[] bookNames;
    String[] bookAuthor;
    String[] bookCategory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BookText = findViewById(R.id.BookText);
        authorView = findViewById(R.id.authorView);
        categoryView = findViewById(R.id.categoryView);
        dbhandler = new MyDBhandler(this, null, null, 1);



        //begining of button stuff
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openactivity2();

            }
        });

        usefulLinks = findViewById(R.id.usefulLinks);
        usefulLinks.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openusefullinks();

            }
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openlistact();

            }
        });
    }
    public void openusefullinks() {
        Intent intent = new Intent(this, usefulWebsites.class);
        startActivity(intent);
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
    public void addButtonClicked(View view) {
        if (BookText.length() != 0) {
        library book = new library(BookText.getText().toString());
        dbhandler.addBook(book);

        } else {
            Toast.makeText(MainActivity.this, "please enter a value", Toast.LENGTH_LONG).show();
        }

    }


}



