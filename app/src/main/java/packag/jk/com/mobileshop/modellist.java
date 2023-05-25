package packag.jk.com.mobileshop;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class modellist extends ArrayAdapter<model> {
    private Activity context;
    public static List<model> modellist;
    public static String name, add, model_name, model_issue, date;

    public modellist(Activity context, List<model> modellist) {
        super(context, R.layout.activity_main, modellist);
        this.context = context;
        this.modellist = modellist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listview = inflater.inflate(R.layout.activity_model_color, null, true);

        /*
        TextView tv = listview.findViewById(R.id.tv);
        TextView tv1 = listview.findViewById(R.id.tv1);
        TextView tv2 = listview.findViewById(R.id.tv2);
        TextView tv3 = listview.findViewById(R.id.tv3);
        TextView tv4 = listview.findViewById(R.id.tv4);*/

        model m = modellist.get(position);

        /*tv.setText(m.model_color);
        tv1.setText(m.second_model_color);
        tv2.setText(m.third_model_color);
        tv3.setText(m.four_model_color);
        tv4.setText(m.five_model_color);*/
        return listview;
    }
}

