package ro.pub.cs.systems.eim.lab03.phonedialer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;
import java.util.List;

public class PhoneDialerActivity extends AppCompatActivity {
    class PhoneNumberListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Button pressedButton = (Button) view;
            ((EditText) findViewById(R.id.phone_number_edit_text)).append(pressedButton.getText());
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);

        ((EditText)findViewById(R.id.phone_number_edit_text)).setInputType(InputType.TYPE_NULL);

        List<Integer> numberButtonsIdList = Arrays.asList(
            R.id.button1, R.id.button2, R.id.button3,
            R.id.button4, R.id.button5, R.id.button6,
            R.id.button7, R.id.button8, R.id.button9,
            R.id.button_asterisk, R.id.button0, R.id.button_hashtag
        );

        View.OnClickListener phoneNumberListener = new PhoneNumberListener();
        for (Integer id : numberButtonsIdList) {
            findViewById(id).setOnClickListener(phoneNumberListener);
        }

        findViewById(R.id.delete_image_button).setOnClickListener((v) -> {
            EditText phoneNumberEditText = findViewById(R.id.phone_number_edit_text);
            int textLength = phoneNumberEditText.getText().length();

            if (textLength > 0) {
                phoneNumberEditText.getText().delete(textLength-1, textLength);
            }
        });

        
    }
}