package jsc.com.lampstudio.sugarormdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import jsc.com.lampstudio.Models.Book;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAdd,btnShow;
        btnAdd = (Button) findViewById(R.id.btn_addLesson);
        btnShow = (Button) findViewById(R.id.btn_getAllLesson);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Korean book = new Korean( 11,"Title english", "Title Korea","pronount","name_pronount",
//                        2);
//                book.save();
                Book book = new Book("name", "ISBN 1", "title 1","good book ");
                book.save();
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
