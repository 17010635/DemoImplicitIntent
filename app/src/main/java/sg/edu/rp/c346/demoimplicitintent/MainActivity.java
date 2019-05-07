package sg.edu.rp.c346.demoimplicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnEmail, btnRP;
    EditText editTextMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMessage = findViewById(R.id.editTextMessage);
        btnEmail = findViewById(R.id.buttonEmail);
        btnRP = findViewById(R.id.buttonRP);

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                //Put essentials like email address, subject & boyd text
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT, "Test Email from C347");
                email.putExtra(Intent.EXTRA_TEXT, editTextMessage.getText());
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });

        btnRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                //Set the URL to be used.
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });
    }
}
