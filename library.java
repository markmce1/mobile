package c16315146.mydit.ie.myandroidproject;

public class library {

    private int _id;
    private String _bookname;
    private String _category;
    private String _author;

    public library(String bookname) {
        this._bookname = bookname;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_category(String _category) {
        this._category = _category;
    }

    public void set_author(String _author) {
        this._author = _author;
    }

    public void set_bookname(String _bookname) {
        this._bookname = _bookname;
    }

    public int get_id() {
        return _id;
    }

    public String get_bookname() {
        return _bookname;
    }


    public String get_category() {
        return _category;
    }

    public String get_author() {
        return _author;
    }
}
