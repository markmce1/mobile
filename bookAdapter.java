package c16315146.mydit.ie.myandroidproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class bookAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] bookNames;
    String[] bookAuthor;
    String[] bookCategory;


    public bookAdapter(Context c,String[] n, String[] a, String[] cate)
    {
        bookNames = n;
        bookAuthor = a;
        bookCategory = cate;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return bookNames.length;
    }

    @Override
    public Object getItem(int i) {
        return bookNames[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.my_listview_detail, null);
        TextView nameTextView =  (TextView) v.findViewById(R.id.nameTextView);
        TextView authorTextView =  (TextView) v.findViewById(R.id.authorTextView);
        TextView categoryTextView =  (TextView) v.findViewById(R.id.categoryTextView);

        String name = bookNames[i];
        String auth = bookAuthor[i];
        String cate = bookCategory[i];

        nameTextView.setText(name);
        authorTextView.setText(auth);
        categoryTextView.setText(cate);
        return v;
    }
}
