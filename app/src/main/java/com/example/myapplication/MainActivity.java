package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
import android.widget.TextView;

import java.lang.String;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    enum operationType { NONE, ADD, SUB, MUL, DIV}

    boolean btnEqualClicked = false;
    operationType opType = operationType.NONE;
    float x = 0, y = 0;
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

            if ( "c".equalsIgnoreCase(btnText) ) {
                editor.setText("");
                cache.setText("");
            }
            else if ( "=".equalsIgnoreCase(btnText) ) {

                if( btnEqualClicked && opType == operationType.NONE) return;

                String str = editor.getText() + "";
                btnEqualClicked = true;

                if(str.length() >2) {
                    if (str.substring(1).isEmpty())
                        y = 0;
                    else y = Float.parseFloat(str.substring(1));
                    if (opType == operationType.NONE)
                        cache.setText( y + "");
                    else cache.setText( x + " " + str.substring(0, 2) + " " + y );
                }

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
            else if (Character.isDigit( btnText.toCharArray()[0] ) || ".".equalsIgnoreCase( btnText )) {

                if( editor.getText().toString().indexOf('.') >= 0 && ".".equalsIgnoreCase(btnText)) return;

                if( btnEqualClicked && isNumeric(( editor.getText() + "").trim() )) {
                    cache.setText( editor.getText() );
                    editor.setText("");
                    btnEqualClicked = false;
                }
                editor.setText( editor.getText() + btnText);
            }
            else {
                if(opType == operationType.NONE ) {
                    cache.setText(editor.getText());       // update cache

                    if (editor.getText().toString().isEmpty())     // check if first value empty
                        x = 0;
                    else
                        x = Float.parseFloat(editor.getText().toString());     //otherwise extract number value
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
