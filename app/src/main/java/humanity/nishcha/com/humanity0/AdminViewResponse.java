package humanity.nishcha.com.humanity0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdminViewResponse extends AppCompatActivity {


    ListView listView;
    int id;
    Databasehandler databasehandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_response);
        listView=findViewById(R.id.list);
        Intent intent=getIntent();
        if(intent!=null){
            id=intent.getIntExtra("id",0);
        }
        databasehandler=new Databasehandler(AdminViewResponse.this);
        ArrayList<Post> arrayList=databasehandler.readallResponse(databasehandler);
        if(arrayList.size()>0) {
            ArrayList<Post> arrayList1 = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).getId() == id) {
                    arrayList1.add(arrayList.get(i));
                }
            }

            CustomAdminAdapter customAdminAdapter = new CustomAdminAdapter(arrayList1, AdminViewResponse.this);
            listView.setAdapter(customAdminAdapter);
        }
    }
}
