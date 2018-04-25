package humanity.nishcha.com.humanity0;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddVolunterPost extends AppCompatActivity {

    private Button submit;
    private int id;
    Databasehandler databasehandler;

    private EditText volunter,location,date,time,duration;
    private TextInputLayout lvolunter,llocation,ldate,ltime,lduration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_volunter_post);
        volunter=findViewById(R.id.volunter);
        location=findViewById(R.id.location);
        date=findViewById(R.id.date);
        time=findViewById(R.id.time);
        duration=findViewById(R.id.duration);
        lvolunter=findViewById(R.id.layoutvolunter);
        llocation=findViewById(R.id.layoutlocation);
        ldate=findViewById(R.id.layoutdate);
        ltime=findViewById(R.id.layouttime);
        lduration=findViewById(R.id.layoutDuration);
        submit=findViewById(R.id.submit);
        databasehandler=new Databasehandler(AddVolunterPost.this);
        Intent intent=getIntent();
        if(intent!=null){
            id=intent.getIntExtra("id",0);

        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(submitform()){
                    String svolunter=volunter.getText().toString();
                    String slocation=location.getText().toString();
                    String sdate=date.getText().toString();
                    String stime=time.getText().toString();
                    String sduration=duration.getText().toString();
                    Post post=new Post();
                    post.setId(id);
                    post.setVolunter(svolunter);
                    post.setLocation(slocation);
                    post.setDate(sdate);
                    post.setTime(stime);
                    post.setDuratiom(sduration);
                    if(databasehandler.addPost(post,databasehandler)==-1){
                        Toast.makeText(AddVolunterPost.this,"NOT SAVED",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(AddVolunterPost.this,"SAVED",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AddVolunterPost.this,AdminEnter.class));
                        finish();

                    }

                }

            }
        });


    }
    private boolean validateVolunter() {
        if (volunter.getText().toString().trim().isEmpty()) {
            volunter.setError("Enter Correct Details");
            return false;
        } else {
            lvolunter.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validatelocation() {
        if (location.getText().toString().trim().isEmpty()) {
            location.setError("Enter Correct Details");
            return false;
        } else {
            llocation.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateDate() {
        if (date.getText().toString().trim().isEmpty()) {
            date.setError("Enter Correct Details");
            return false;
        } else {
            ldate.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatetime() {
        if (time.getText().toString().trim().isEmpty()) {
            time.setError("Enter Correct Details");
            return false;
        } else {
            ltime.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validateduration() {
        if (duration.getText().toString().trim().isEmpty()) {
            duration.setError("Enter Correct Details");
            return false;
        } else {
            lduration.setErrorEnabled(false);
        }

        return true;
    }

    private boolean submitform(){
        if(!validateVolunter()){
            return false;
        }
        if(!validatelocation()){
            return false;
        }
        if(!validateDate()){
            return false;
        }
        if(!validatetime()){
            return false;
        }
        if(!validateduration()){
            return false;
        }
        return true;
    }

}
