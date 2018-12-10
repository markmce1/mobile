package c16315146.mydit.ie.myandroidproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    Button addButton;
    Button button;
    Button button2;
    EditText BookText;
    EditText authorView;
    EditText categoryView;
    MyDBhandler myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BookText = findViewById(R.id.BookText);
        myDB = new MyDBhandler(this);
        addButton = findViewById(R.id.addButton);



        //begining of button stuff for navigation
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openactivity2();

            }
        });


        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openlistact();

            }
        });
        //end of buttons
    }

    public void openactivity2() {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    public void openlistact() {
        Intent intent = new Intent(this, listact.class);
        startActivity(intent);
    }

    public void addButtonClicked(View v){
        String newEntry = BookText.getText().toString();
        if(BookText.length() != 0) {
            AddData(newEntry);

            BookText.setText("");
            authorView.setText("");
            categoryView.setText("");
        }
        else {
            Toast.makeText(MainActivity.this, "Please enter text",Toast.LENGTH_LONG).show();
        }
    }

    public void AddData(String newEntry){
        boolean insertData = myDB.addData(newEntry);
        if(insertData==true){
            Toast.makeText(MainActivity.this, "Its done boi",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(MainActivity.this, "error",Toast.LENGTH_LONG).show();
        }

    }


}







