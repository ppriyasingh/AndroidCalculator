package com.example.myapplication;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import java.lang.String;    

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    enum operationType { NONE, ADD, SUB, MUL, DIV, EQUAL};
    boolean btnEqualClicked = false;
    operationType opType = operationType.NONE;
    float x, y;
    EditText editer, cache;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btnClear, btnEqual, btnSum, btnSub, btnMul, btnDiv;

    public static boolean isNumeric(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createObject();     //Create object
        createButtonClickEvent();       // Create button click event
    }

    private void createObject() {
        btn0 = (Button) findViewById(R.id.button0);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btn10 = (Button) findViewById(R.id.button10);
        btnClear = (Button) findViewById(R.id.buttonClear);
        btnEqual = (Button) findViewById(R.id.buttonEqual);

        cache = (EditText) findViewById(R.id.editTextCache);
        editer = (EditText) findViewById(R.id.editText);

        btnSum = (Button) findViewById(R.id.buttonAdd);
        btnSub = (Button) findViewById(R.id.buttonSub);
        btnMul = (Button) findViewById(R.id.buttonMul);
        btnDiv = (Button) findViewById(R.id.buttonDiv);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();


        switch (id) {
            case R.id.button0:
                updateCacheForNumberClicked();
                editer.setText(editer.getText() + "0");
                break;
            
            case R.id.button1:
                updateCacheForNumberClicked();
                editer.setText(editer.getText() + "1");
                break;
            
            case R.id.button2:
                updateCacheForNumberClicked();
                editer.setText(editer.getText() + "2");
                break;
            
            case R.id.button3:
                updateCacheForNumberClicked();
                editer.setText(editer.getText() + "3");
                break;
            
            case R.id.button4:
                updateCacheForNumberClicked();
                editer.setText(editer.getText() + "4");
                break;
            
            case R.id.button5:
                updateCacheForNumberClicked();
                editer.setText(editer.getText() + "5");
                break;
            
            case R.id.button6:
                updateCacheForNumberClicked();
                editer.setText(editer.getText() + "6");
                break;
            
            case R.id.button7:
                updateCacheForNumberClicked();
                editer.setText(editer.getText() + "7");
                break;
            
            case R.id.button8:
                updateCacheForNumberClicked();
                editer.setText(editer.getText() + "8");
                break;
            
            case R.id.button9:
                updateCacheForNumberClicked();
                editer.setText(editer.getText() + "9");
                break;
            
            case R.id.button10:
                updateCacheForNumberClicked();
                editer.setText(editer.getText() + ".");
                break;
            
            case R.id.buttonAdd:
                cache.setText( editer.getText());       // update cache

                if((editer.getText().toString()).isEmpty())     // check if first value empty
                    x = 0;
                else x = Float.parseFloat(editer.getText().toString());     //otherwise extract number value

                opType = operationType.ADD;
                editer.setText("+ ");
                break;
            
            case R.id.buttonSub:
                cache.setText( editer.getText());       // update cache

                if((editer.getText().toString()).isEmpty())     // check if first value empty
                    x = 0;
                else x = Float.parseFloat(editer.getText().toString());     //otherwise extract number value

                opType = operationType.SUB;
                editer.setText("- ");
                break;
            
            case R.id.buttonMul:
                cache.setText( editer.getText());       // update cache

                if((editer.getText().toString()).isEmpty())     // check if first value empty
                    x = 0;
                else x = Float.parseFloat(editer.getText().toString());     //otherwise extract number value

                opType = operationType.MUL;
                editer.setText("* ");
                break;
            
            case R.id.buttonDiv:
                cache.setText( editer.getText());

                if((editer.getText().toString()).isEmpty())
                    x = 0;
                else x = Float.parseFloat(editer.getText().toString());
                opType = operationType.DIV;
                editer.setText("/ ");
                break;
            
            case R.id.buttonClear:
                editer.setText("");
                cache.setText("");
                break;
            
            case R.id.buttonEqual:
                String str = editer.getText()+"";

                btnEqualClicked = true;

                if((str.substring(1)).isEmpty())
                    y = 0;
                else y = Float.parseFloat(str.substring(1));
                cache.setText(x + " "+ str.substring(0,2) + " " + y);

                switch (opType) {
                    case ADD:
                        editer.setText(x + y + "");
                        break;
            
                    case SUB:
                        editer.setText(x - y + "");
                        break;
            
                    case MUL:
                        editer.setText(x * y + "");
                        break;
            
                    case DIV:
                        editer.setText(x / y + "");
                        break;
            
                }
                opType = operationType.NONE;
                break;
        }
    }

    private void updateCacheForNumberClicked() {

        if( btnEqualClicked && isNumeric(( editer.getText() + "").trim() )) {
            cache.setText( editer.getText() );
            editer.setText( "" );
            btnEqualClicked = false;
        }
    }

    private void createButtonClickEvent() {

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnSum.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnEqual.setOnClickListener(this);

    }
}
