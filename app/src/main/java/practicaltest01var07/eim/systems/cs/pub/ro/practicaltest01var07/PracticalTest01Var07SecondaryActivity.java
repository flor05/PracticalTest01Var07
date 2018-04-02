package practicaltest01var07.eim.systems.cs.pub.ro.practicaltest01var07;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var07SecondaryActivity extends Activity{

    TextView first;
    TextView second;
    TextView third;
    TextView fourth;

    Button sumB;
    Button prodB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test_01_var_07_second);

        first = (TextView) findViewById(R.id.firstview);
        second = (TextView)findViewById(R.id.secondview);
        third = (TextView)findViewById(R.id.thirdview);
        fourth = (TextView)findViewById(R.id.fourthview);

        sumB = (Button)findViewById(R.id.sum);
        prodB = (Button)findViewById(R.id.prod);


        Intent intent = getIntent();
        if (intent != null ) {
            if(intent.getExtras().containsKey("first")) {
                int f = intent.getIntExtra("first", -1);
                first.setText(String.valueOf(f));
            }

            if(intent.getExtras().containsKey("second")) {
                int s = intent.getIntExtra("second", -1);
                second.setText(String.valueOf(s));
            }

            if(intent.getExtras().containsKey("third")) {
                int t = intent.getIntExtra("third", -1);
                third.setText(String.valueOf(t));
            }

            if(intent.getExtras().containsKey("fourth")) {
                int ft = intent.getIntExtra("fourth", -1);
                fourth.setText(String.valueOf(ft));
            }
        }

        sumB.setOnClickListener(buttonClickListener);
        prodB.setOnClickListener(buttonClickListener);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        if (savedInstanceState.containsKey("firstview")) {
            first.setText(savedInstanceState.getString("firstview"));
        } else {
            first.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("secondview")) {
            second.setText(savedInstanceState.getString("secondview"));
        } else {
            second.setText(String.valueOf(0));
        }

        if (savedInstanceState.containsKey("thirdview")) {
            third.setText(savedInstanceState.getString("thirdview"));
        } else {
            third.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("fourthview")) {
            fourth.setText(savedInstanceState.getString("fourthview"));
        } else {
            fourth.setText(String.valueOf(0));
        }

//        Intent intent = new Intent(getApplicationContext(), PracticalTest01Var07Service.class);
//        if (intent != null ) {
//            if(intent.getExtras().containsKey("first")) {
//                f = intent.getIntExtra("first", -1);
//            }
//
//            if(intent.getExtras().containsKey("second")) {
//                s = intent.getIntExtra("second", -1);
//            }
//
//            if(intent.getExtras().containsKey("third")) {
//                t = intent.getIntExtra("third", -1);
//            }
//
//            if(intent.getExtras().containsKey("fourth")) {
//                ft = intent.getIntExtra("fourth", -1);
//            }
//        }
//        getApplicationContext().startService(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("firstview", first.getText().toString());
        savedInstanceState.putString("secondview", second.getText().toString());
        savedInstanceState.putString("thirdview", third.getText().toString());
        savedInstanceState.putString("fourthview", fourth.getText().toString());
    }

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int firstN = Integer.parseInt(first.getText().toString());
            int secondN = Integer.parseInt(second.getText().toString());
            int thirdN = Integer.parseInt(third.getText().toString());
            int fourthN = Integer.parseInt(fourth.getText().toString());
            switch(view.getId()) {
                case R.id.sum:
                    setResult(RESULT_OK, null);
                    int sum = firstN + secondN + thirdN + fourthN;
                    Toast.makeText(getApplicationContext(), "The activity returned with result " + sum, Toast.LENGTH_LONG).show();
                    break;
                case R.id.prod:
                    setResult(RESULT_OK, null);

                    int prod = firstN * secondN * thirdN * fourthN;
                    Toast.makeText(getApplicationContext(), "The activity returned with result " + prod, Toast.LENGTH_LONG).show();
                    break;
            }
         //   finish();
        }
    }
}
