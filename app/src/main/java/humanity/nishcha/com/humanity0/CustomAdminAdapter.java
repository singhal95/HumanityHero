package humanity.nishcha.com.humanity0;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Nitin on 4/26/2018.
 */

public class CustomAdminAdapter extends BaseAdapter {

    private ArrayList<Post> arrayList;
    private Context context;

    public CustomAdminAdapter(ArrayList<Post> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       Viewhilder viewhilder;
        if(convertView==null){
            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.singleadminresponse,null);
            viewhilder=new Viewhilder();
            viewhilder.volunter=convertView.findViewById(R.id.volunter);
            viewhilder.location=convertView.findViewById(R.id.location);
            viewhilder.date=convertView.findViewById(R.id.date);
            viewhilder.time=convertView.findViewById(R.id.time);
            viewhilder.duration=convertView.findViewById(R.id.duration);
            convertView.setTag(viewhilder);
        }
        viewhilder= (Viewhilder) convertView.getTag();
        viewhilder.volunter.setText(arrayList.get(position).getVolunter());
        viewhilder.location.setText(arrayList.get(position).getLocation());
        viewhilder.date.setText(arrayList.get(position).getDate());
        viewhilder.time.setText(arrayList.get(position).getTime());
        viewhilder.duration.setText(arrayList.get(position).getDuratiom());

        return convertView;
    }
    public class Viewhilder {
        TextView id,volunter,location,date,time,duration;
    }
}
