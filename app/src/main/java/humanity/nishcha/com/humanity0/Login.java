package humanity.nishcha.com.humanity0;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {


    private EditText name,email,ngo,address,phone,password;
    private Button submit;
    Databasehandler databasehandler;
    private TextInputLayout namelayout,emaillayout,ngolayout,addresslayout,phonelayout,passwordlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        ngo=findViewById(R.id.ngo);
        address=findViewById(R.id.address);
        phone=findViewById(R.id.phone);
        password=findViewById(R.id.password);
        namelayout=findViewById(R.id.layoutname);
        emaillayout=findViewById(R.id.layoutemail);
        ngolayout=findViewById(R.id.layoutngo);
        addresslayout=findViewById(R.id.layoutaddress);
        phonelayout=findViewById(R.id.layoutphone);
        passwordlayout=findViewById(R.id.layoutpassword);
        submit=findViewById(R.id.submit);
        databasehandler=new Databasehandler(Login.this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(submitForm()){
                   String sname=name.getText().toString();
                   String semail=email.getText().toString();
                   String sngo=ngo.getText().toString();
                   String saddress=address.getText().toString();
                   String sphone=phone.getText().toString();
                   String spassword=password.getText().toString();
                    Admin admin=new Admin();
                    admin.setName(sname);
                    admin.setEmail(semail);
                    admin.setNgo(sngo);
                    admin.setAddress(saddress);
                    admin.setPhone(sphone);
                    admin.setPassword(spassword);
                    if(databasehandler.addAdmin(admin,databasehandler)==-1){
                        Toast.makeText(Login.this,"NOT SAVED",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Login.this,"SAVED",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login.this,Adminlogin.class));
                        finish();

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
    private boolean validateemail() {
        if (email.getText().toString().trim().isEmpty()) {
            email.setError("Enter Correct Details");
            return false;
        } else {
            emaillayout.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validateNgo() {
        if (ngo.getText().toString().trim().isEmpty()) {
            ngo.setError("Enter Correct Details");
            return false;
        } else {
            ngolayout.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validateAdress() {
        if (address.getText().toString().trim().isEmpty()) {
            address.setError("Enter Correct Details");
            return false;
        } else {
            addresslayout.setErrorEnabled(false);
        }

        return true;
    }
    private boolean validatePhone() {
        if (phone.getText().toString().trim().isEmpty()) {
            phone.setError("Enter Correct Details");
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

    private boolean submitForm() {
        if (!validateName()) {
            return false;
        }


        if (!validateemail()) {
            return false;
        }

        if(!validateNgo()){
            return false;
        }

        if(!validateAdress())
        {
            return false;

        }

        if(!validatePhone()){
            return false;
        }

        if(!validatepassword()){
            return false;
        }
        return true;

    }


}
