package humanity.nishcha.com.humanity0;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Adminlogin extends AppCompatActivity {


    private EditText name,password;
    private TextInputLayout namelayout,passwordlayout;
    private Button register,login;
    Databasehandler databasehandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
        name=findViewById(R.id.name);
        password=findViewById(R.id.password);
        namelayout=findViewById(R.id.layoutname);
        passwordlayout=findViewById(R.id.layoutpassword);
        login=findViewById(R.id.login);
        databasehandler=new Databasehandler(Adminlogin.this);
        register=findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Adminlogin.this,Login.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(submitform()){
                    String sname=name.getText().toString();
                    String spassword=password.getText().toString();
                    ArrayList<Admin> admins=databasehandler.readallAdmin(databasehandler);
                    for(Admin response:admins){
                        Log.i("TAG",response.getName());
                        if(sname.equals(response.getName()) && spassword.equals(response.getPassword())){
                            Intent intent=new Intent(Adminlogin.this,AdminEnter.class);
                            intent.putExtra("id",response.getId());
                            intent.putExtra("name",response.getName());
                            intent.putExtra("email",response.getEmail());
                            intent.putExtra("ngo",response.getNgo());
                            intent.putExtra("address",response.getAddress());
                            intent.putExtra("phone",response.getPhone());
                            intent.putExtra("password",response.getPassword());
                            startActivity(intent);
                            finish();
                        }
                    }


                }
            }
        });


    }
    private boolean validateName() {
        if (name.getText().toString().trim().isEmpty()) {
            name.setError("Enter Correct Details");
            return false;
        } else {
            namelayout.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatepassword() {
        if (password.getText().toString().trim().isEmpty()) {
            password.setError("Enter Correct Details");
            return false;
        } else {
            passwordlayout.setErrorEnabled(false);
        }

        return true;
    }

    private boolean submitform(){
        if(!validateName()){
            return false;
        }
        if(!validatepassword()){
            return false;
        }
        return true;
    }


}
