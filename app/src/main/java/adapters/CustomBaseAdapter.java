package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.garpixloadsystem.R;

import java.util.ArrayList;
import java.util.List;

public class CustomBaseAdapter extends BaseAdapter {

    Context ctx;
    LayoutInflater lInflater;
    List<String> titles = new ArrayList<>();

    public CustomBaseAdapter(Context context, List<String> titles) {
        this.ctx = context;
        this.titles = titles;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public String getItem(int i) {
        return titles.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = lInflater.inflate(R.layout.item_example, viewGroup, false);

        }

        ((TextView) view.findViewById(R.id.title)).setText(titles.get(i));

        return view;
    }
}
