package jsc.com.lampstudio.Models;

import com.orm.SugarRecord;

/**
 * Created by khoa on 6/12/2017.
 */

public class Book extends SugarRecord {
    String name;
    String ISBN;
    String title;
    String shortSummary;

    public Book(){
    }

    public Book(String name, String ISBN, String title, String shortSummary) {
        this.name = name;
        this.ISBN = ISBN;
        this.title = title;
        this.shortSummary = shortSummary;
    }
}