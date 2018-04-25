package humanity.nishcha.com.humanity0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class UserEntry extends AppCompatActivity {

    ListView listView;
    String name,email,address,phone,password;
    Databasehandler databasehandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_entry);
        listView=findViewById(R.id.list);
        Intent intent=getIntent();
        if(intent!=null){
            name=intent.getStringExtra("name");
            email=intent.getStringExtra("email");
            address=intent.getStringExtra("address");
            phone=intent.getStringExtra("phone");
            password=intent.getStringExtra("password");
        }
        databasehandler=new Databasehandler(UserEntry.this);
        ArrayList<Post> arrayList=databasehandler.readallPost(databasehandler);
        if(arrayList.size()!=0){
            CustomUserAdapter customUserAdapter=new CustomUserAdapter(UserEntry.this,arrayList,name,email,address,phone);
            listView.setAdapter(customUserAdapter);
        }
    }
}
