package humanity.nishcha.com.humanity0;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserResponse extends AppCompatActivity {

    private EditText name,email,address,phone,password;
    String iname,iemail,iaddress,iphone;
    int iid;
    private Button submit;
    Databasehandler databasehandler;
    private TextInputLayout namelayout,emaillayout,addresslayout,phonelayout,passwordlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_response);
        Intent intent = getIntent();
        if (intent != null) {
            iname = intent.getStringExtra("name");
            iemail = intent.getStringExtra("email");
            iaddress = intent.getStringExtra("address");
            iphone = intent.getStringExtra("phone");
            iid = intent.getIntExtra("id", 0);
        }
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        namelayout = findViewById(R.id.layoutname);
        emaillayout = findViewById(R.id.layoutemail);
        addresslayout = findViewById(R.id.layoutaddress);
        phonelayout = findViewById(R.id.layoutphone);
        passwordlayout = findViewById(R.id.layoutpassword);
        name.setText(iname);
        email.setText(iemail);
        address.setText(iaddress);
        phone.setText(iphone);
        submit = findViewById(R.id.submit);
        databasehandler = new Databasehandler(UserResponse.this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (submitForm()) {
                    String svolunter = name.getText().toString();
                    String slocation = email.getText().toString();
                    String sdate = address.getText().toString();
                    String stime = phone.getText().toString();
                    String sduration = password.getText().toString();
                    Post post = new Post();
                    post.setId(iid);
                    post.setVolunter(svolunter);
                    post.setLocation(slocation);
                    post.setDate(sdate);
                    post.setTime(stime);
                    post.setDuratiom(sduration);
                    if (databasehandler.addResponse(post, databasehandler) == -1) {
                        Toast.makeText(UserResponse.this, "NOT SAVED", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(UserResponse.this, "SAVED", Toast.LENGTH_SHORT).show();
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
