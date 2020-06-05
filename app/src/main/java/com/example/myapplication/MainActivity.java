package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
import android.widget.TextView;

import java.lang.String;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    enum operationType { NONE, ADD, SUB, MUL, DIV};
    boolean btnEqualClicked = false;
    operationType opType = operationType.NONE;
    float x, y;
    EditText editor;
    TextView cache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createObject();
    }

    private void createObject() {
        cache = (TextView) findViewById(R.id.editTextCache);
        editor = findViewById(R.id.editText);
    }

    @Override
    public void onClick(View v) {

        if( v instanceof Button ) {
            Button btn = (Button) v;
            String btnText = "" + btn.getText();
            String inputText = editor.getText().toString();

            if ( "c".equalsIgnoreCase(btnText) ) {
                editor.setText("");
                cache.setText("");
            }
            else if ( "=".equalsIgnoreCase(btnText) ) {

                String str = inputText + "";
                btnEqualClicked = true;
                if ( (str.substring(1) ).isEmpty())
                    y = 0;
                else y = Float.parseFloat(str.substring(1));
                cache.setText( x + " " + str.substring(0, 2) + " " + y );

                switch (opType) {
                    case ADD:
                        editor.setText(x + y + "");
                        break;

                    case SUB:
                        editor.setText(x - y + "");
                        break;

                    case MUL:
                        editor.setText(x * y + "");
                        break;

                    case DIV:
                        editor.setText(x / y + "");
                        break;
                }
                opType = operationType.NONE;
            }
            else if (Character.isDigit(btnText.toCharArray()[0]) || ".".equalsIgnoreCase(btnText)) {

                if( btnEqualClicked && isNumeric(( inputText + "").trim() )) {
                    cache.setText( inputText );
                    inputText = "";
                    btnEqualClicked = false;
                }
                editor.setText( inputText + btnText);
            }
            else {
                if(opType == operationType.NONE ) {
                    cache.setText(inputText);       // update cache

                    if ((inputText.toString()).isEmpty())     // check if first value empty
                        x = 0;
                    else
                        x = Float.parseFloat(inputText.toString());     //otherwise extract number value
                }

                switch(btnText.toCharArray()[0]) {
                    case '+':
                        opType = operationType.ADD;
                        break;
                    case '-':
                        opType = operationType.SUB;
                        break;
                    case '*':
                        opType = operationType.MUL;
                        break;
                    case '/':
                        opType = operationType.DIV;
                        break;
                    default: System.out.println("btnText is " + btnText);
                }
                editor.setText(btnText + " ");
            }
        }
    }

    public static boolean isNumeric(String str) {

        try {
            Float.parseFloat(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
