package humanity.nishcha.com.humanity0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdminEnter extends AppCompatActivity {

    int id;
    String sname,semail,sphone,sngo;
    private TextView name,email,ngo,address,phone,password;
    private Button add,response;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_enter);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        ngo=findViewById(R.id.ngo);
        address=findViewById(R.id.address);
        phone=findViewById(R.id.phone);
        password=findViewById(R.id.password);
        add=findViewById(R.id.add);
        response=findViewById(R.id.post);
        final Intent intent=getIntent();
        if(intent!=null){
            id=intent.getIntExtra("id",0);
            sname=intent.getStringExtra("name");
            name.setText(sname);
            semail=intent.getStringExtra("email");
            email.setText(semail);
            sngo=intent.getStringExtra("ngo");
            ngo.setText(sngo);
            address.setText(intent.getStringExtra("address"));
            sphone=intent.getStringExtra("phone");
            phone.setText(sphone);
            password.setText(intent.getStringExtra("password"));

        }
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent1=new Intent(AdminEnter.this,AddVolunterPost.class);
                intent1.putExtra("id",id);
            startActivity(intent1);
            finish();

            }
        });
        response.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent2=new Intent(AdminEnter.this,AdminViewResponse.class);
                intent2.putExtra("id",id);
                startActivity(intent2);

                finish();
            }
        });


    }
}
