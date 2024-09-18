package com.fyp.tryone.product;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.fyp.tryone.options.CartListActivity;
import com.fyp.tryone.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class checkout extends AppCompatActivity {

    EditText name, mail,phone, address;
    Button submit;
    TextView price;

    private DatabaseReference dbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout);

       dbref= FirebaseDatabase.getInstance().getReference("orders");

       String text1= Integer.toString(CartListActivity.paymentcount);
        final TextView newtext = findViewById(R.id.totalprice);
        newtext.setText("Rs. " + text1);

        name = findViewById(R.id.etname);
        mail = findViewById(R.id.etmail);
        phone = findViewById(R.id.etphone);
        address = findViewById(R.id.etadd);
        price = findViewById(R.id.totalprice);

        submit = findViewById(R.id.buttonsub);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addorder();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
    }

    public void addorder()
    {
        String uname = name.getText().toString();
        String umail = mail.getText().toString();
        String uph = phone.getText().toString();
        String uadd = address.getText().toString();
        String total = price.getText().toString();

        if ((!TextUtils.isEmpty(uname))&&(!TextUtils.isEmpty(umail))&&(!TextUtils.isEmpty(uph))&&(!TextUtils.isEmpty(uadd)))
        {
            String id= dbref.push().getKey();
            order o = new order(id, uname,umail,uph,uadd,total);
            dbref.child(id).setValue(o);

            Toast.makeText(this,"Details submitted successfully",Toast.LENGTH_LONG).show();
        }
        else
            {
                Toast.makeText(this, "Please enter all the details", Toast.LENGTH_LONG).show();
        }
    }
}

