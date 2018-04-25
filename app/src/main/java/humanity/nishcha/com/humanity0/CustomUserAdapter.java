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

public class CustomUserAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Post> arrayList;
    String name,email,address,phone;

    public CustomUserAdapter(Context context, ArrayList<Post> arrayList, String name, String email, String address, String phone) {
        this.context = context;
        this.arrayList = arrayList;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        Viewhilder viewhilder;
        if(convertView==null){
            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.singleuserpost,null);
           viewhilder=new Viewhilder();
           viewhilder.id=convertView.findViewById(R.id.id);
           viewhilder.volunter=convertView.findViewById(R.id.volunter);
           viewhilder.location=convertView.findViewById(R.id.location);
           viewhilder.date=convertView.findViewById(R.id.date);
           viewhilder.time=convertView.findViewById(R.id.time);
           viewhilder.duration=convertView.findViewById(R.id.duration);
           viewhilder.cardView=convertView.findViewById(R.id.card);
           convertView.setTag(viewhilder);
        }
        viewhilder= (Viewhilder) convertView.getTag();
        viewhilder.id.setText(String.valueOf(arrayList.get(position).getId()));
        viewhilder.volunter.setText(arrayList.get(position).getVolunter());
        viewhilder.location.setText(arrayList.get(position).getLocation());
        viewhilder.date.setText(arrayList.get(position).getDate());
        viewhilder.time.setText(arrayList.get(position).getTime());
        Toast.makeText(context,arrayList.get(position).getDuratiom(),Toast.LENGTH_SHORT).show();
        viewhilder.duration.setText(arrayList.get(position).getDuratiom());
        viewhilder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,UserResponse.class);
                intent.putExtra("name",name);
                intent.putExtra("address",address);
                intent.putExtra("email",email);
                intent.putExtra("phone",phone);
                intent.putExtra("id",arrayList.get(position).getId());
                context.startActivity(intent);

            }
        });
        return convertView;
    }

    public class Viewhilder {
        TextView id,volunter,location,date,time,duration;
        CardView cardView;
    }
}
