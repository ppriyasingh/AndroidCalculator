package com.example.myapplication;

        import androidx.appcompat.app.AppCompatActivity;
        import android.annotation.SuppressLint;
        import android.os.Bundle;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.EditText;
        import java.lang.String;

public class MainActivity extends AppCompatActivity {

    boolean badd, bsub, bmul, bdiv, beql;
    float x, y;
    EditText result, cache;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btnC, btnEqual, btnsum, btnsub, btnmul, btndiv;

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

        //Create object
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
        btnC = (Button) findViewById(R.id.buttonC);
        btnEqual = (Button) findViewById(R.id.buttonEqual);

        cache = (EditText) findViewById(R.id.editTextCache);
        result = (EditText) findViewById(R.id.editText);

        btnsum = (Button) findViewById(R.id.buttonadd);
        btnsub = (Button) findViewById(R.id.buttonsub);
        btnmul = (Button) findViewById(R.id.buttonmul);
        btndiv = (Button) findViewById(R.id.buttondiv);


        // Create button click event
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(beql && isNumeric((result.getText()+"").trim())) {
                    cache.setText( result.getText());
                    result.setText("");
                    beql= false;
                }
                result.setText(result.getText() + "0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(beql && isNumeric((result.getText()+"").trim())) {
                    cache.setText( result.getText());
                    result.setText("");
                    beql= false;
                }
                result.setText(result.getText() + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(beql && isNumeric((result.getText()+"").trim())) {
                    cache.setText( result.getText());
                    result.setText("");
                    beql= false;
                }
                result.setText(result.getText() + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(beql && isNumeric((result.getText()+"").trim())) {
                    cache.setText( result.getText());
                    result.setText("");
                    beql= false;
                }
                result.setText(result.getText() + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(beql && isNumeric((result.getText()+"").trim())) {
                    cache.setText( result.getText());
                    result.setText("");
                    beql= false;
                }
                result.setText(result.getText() + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(beql && isNumeric((result.getText()+"").trim())) {
                    cache.setText( result.getText());
                    result.setText("");
                    beql= false;
                }
                result.setText(result.getText() + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(beql && isNumeric((result.getText()+"").trim())) {
                    cache.setText( result.getText());
                    result.setText("");
                    beql= false;
                }
                result.setText(result.getText() + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(beql && isNumeric((result.getText()+"").trim())) {
                    cache.setText( result.getText());
                    result.setText("");
                    beql= false;
                }
                result.setText(result.getText() + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(beql && isNumeric((result.getText()+"").trim())) {
                    cache.setText( result.getText());
                    result.setText("");
                    beql= false;
                }
                result.setText(result.getText() + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(beql && isNumeric((result.getText()+"").trim())) {
                    cache.setText( result.getText());
                    result.setText("");
                    beql= false;
                }
                result.setText(result.getText() + "9");
            }
        });

        btnsum.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(result==null) {
                    result.setText("");
                }
                else {
                    cache.setText( result.getText());

                    if((result.getText().toString()).isEmpty())
                        x = 0;
                    else x = Float.parseFloat(result.getText().toString());
                    badd= true;
                    result.setText("+ ");
                }
            }
        });

        btnsub.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(result==null) {
                    result.setText("");
                }
                else {
                    cache.setText( result.getText());

                    if((result.getText().toString()).isEmpty())
                        x = 0;
                    else x = Float.parseFloat(result.getText().toString());
                    bsub = true;
                    result.setText("- ");
                }
            }
        });

        btnmul.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(result==null) {
                    result.setText("");
                }
                else {
                    cache.setText( result.getText());

                    if((result.getText().toString()).isEmpty())
                        x = 0;
                    else x = Float.parseFloat(result.getText().toString());
                    bmul = true;
                    result.setText("* ");
                }
            }
        });

        btndiv.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(result==null) {
                    result.setText("");
                }
                else {
                    cache.setText( result.getText());

                    if((result.getText().toString()).isEmpty())
                        x = 0;
                    else x = Float.parseFloat(result.getText().toString());
                    bdiv = true;
                    result.setText("/ ");
                }
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = result.getText()+"";

                beql = true;
                if((str.substring(1)).isEmpty())
                    y = 0;
                else y = Float.parseFloat(str.substring(1));
                cache.setText(x+" "+str.substring(0,2)+" "+y);

                if (badd) {
                    result.setText(x + y + "");
                    badd = false;
                }

                if (bsub) {
                    result.setText(x - y + "");
                    bsub = false;
                }

                if (bmul) {
                    result.setText(x * y + "");
                    bmul = false;
                }

                if (bdiv) {
                    result.setText(x / y + "");
                    bdiv = false;
                }
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
                cache.setText("");
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(beql && isNumeric((result.getText()+"").trim())) {
                    cache.setText( result.getText());
                    result.setText("");
                    beql= false;
                }
                result.setText(result.getText() + ".");
            }
        });
    }
}
