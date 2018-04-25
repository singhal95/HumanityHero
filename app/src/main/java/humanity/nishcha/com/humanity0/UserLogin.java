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

public class UserLogin extends AppCompatActivity {

    private EditText name,password;
    private TextInputLayout namelayout,passwordlayout;
    private Button register,login;
    Databasehandler databasehandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        name=findViewById(R.id.name);
        password=findViewById(R.id.password);
        namelayout=findViewById(R.id.layoutname);
        passwordlayout=findViewById(R.id.layoutpassword);
        login=findViewById(R.id.login);
        databasehandler=new Databasehandler(UserLogin.this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(submitform()){
                    String sname=name.getText().toString();
                    String spassword=password.getText().toString();
                    ArrayList<User> admins=databasehandler.readalluser(databasehandler);
                    if(admins.size()>0) {
                        for (User admin : admins) {
                            if (sname.equals(admin.getName()) && spassword.equals(admin.getPassword())) {
                                Intent intent=new Intent(UserLogin.this, UserEntry.class);
                                intent.putExtra("name",admin.getName());
                                intent.putExtra("address",admin.getAddress());
                                intent.putExtra("email",admin.getEmail());
                                intent.putExtra("phone",admin.getPhone());
                                intent.putExtra("password",admin.getPassword());
                                startActivity(intent);
                                break;
                            }
                        }
                    }
                }
            }
        });
        register=findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserLogin.this,UserSignUp.class));
                finish();
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
