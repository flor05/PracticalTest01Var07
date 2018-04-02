package practicaltest01var07.eim.systems.cs.pub.ro.practicaltest01var07;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var07MainActivity extends Activity {

    private EditText firstInput;
    private EditText secondInput;
    private EditText thirdInput;
    private EditText fourthInput;
    private Button setButton;
    public static final int SECONDARY_ACTIVITY_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_main);

        firstInput = (EditText)findViewById(R.id.firstinput);
        secondInput = (EditText)findViewById(R.id.secondinput);
        thirdInput = (EditText)findViewById(R.id.thirdinput);
        fourthInput  = (EditText)findViewById(R.id.fourthinput);
        setButton = (Button)findViewById(R.id.setButton);

        firstInput.setText(String.valueOf(0));
        secondInput.setText(String.valueOf(0));
        thirdInput.setText(String.valueOf(0));
        fourthInput.setText(String.valueOf(0));

        Intent intent = new Intent(getApplicationContext(), PracticalTest01Var07Service.class);
        int first = Integer.parseInt(firstInput.getText().toString());
        int second = Integer.parseInt(secondInput.getText().toString());
        int third = Integer.parseInt(thirdInput.getText().toString());
        int fourth = Integer.parseInt(fourthInput.getText().toString());

        intent.putExtra("first", first);
        intent.putExtra("second", second);
        intent.putExtra("third", third);
        intent.putExtra("fourth", fourth);

        setButton.setOnClickListener(buttonClickListener);


    }

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.setButton:
                    setResult(RESULT_OK, null);
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var07SecondaryActivity.class);
                    int first = Integer.parseInt(firstInput.getText().toString());
                    int second = Integer.parseInt(secondInput.getText().toString());
                    int third = Integer.parseInt(thirdInput.getText().toString());
                    int fourth = Integer.parseInt(fourthInput.getText().toString());

                    intent.putExtra("first", first);
                    intent.putExtra("second", second);
                    intent.putExtra("third", third);
                    intent.putExtra("fourth", fourth);
                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;
            }
            finish();
        }
    }

}
