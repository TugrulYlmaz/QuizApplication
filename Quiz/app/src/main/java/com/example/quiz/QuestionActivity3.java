package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuestionActivity3 extends AppCompatActivity {



    String questions[] = {
            "Aşağıdaki ifadelerden hangisi Python dilinde bir yorum satırını belirtir?",
            "Aşağıdaki fonksiyonlardan hangisi bir listeye eleman eklemek için kullanılır?",
            "Python dilinde aşağıdaki ifadelerden hangisi doğru bir şekilde değişken tanımlar?",
            "Python dilinde bir sözlük (dictionary) tanımlamak için hangi semboller kullanılır?",
            "def func(a, b=5):\n" +
                    "    return a + b\n" +
                    "\n" +
                    "result = func(3)\n" +
                    "print(result)\n",
    };
    String answer[] = {
            "#",
            "append()",
            "x = 10",
            "{}",
            "8",
    };
    String opt[] = {
            "//","#","/*","--",

            "append()","add()","insert()","push()",

            "var x = 10","int x = 10","x = 10","x := 10",

            "[]","()","{}","<>",

            "3","5","8","10",
    };

    int flag=0;

    public static int marks=0,correct=0,wrong=0;

    TextView tv;
    Button submitbutton,quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;
    private TextView questionnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question3);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final TextView score = (TextView) findViewById(R.id.textView4);
        TextView textView = (TextView) findViewById(R.id.DispName);
        Intent intent = getIntent();

        questionnumber = findViewById(R.id.DispName);
        submitbutton = (Button) findViewById(R.id.button3);
        quitbutton = (Button) findViewById(R.id.buttonquit);
        tv = (TextView) findViewById(R.id.tvque);

        radio_g = (RadioGroup) findViewById(R.id.answergroup);
        rb1 = (RadioButton) findViewById(R.id.radiobutton);
        rb2 = (RadioButton) findViewById(R.id.radiobutton2);
        rb3 = (RadioButton) findViewById(R.id.radiobutton3);
        rb4 = (RadioButton) findViewById(R.id.radiobutton4);

        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(QuestionActivity3.this, "please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();

                if (ansText.equals(answer[flag])) {
                    correct++;
                    Toast.makeText(QuestionActivity3.this, "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    wrong++;
                    Toast.makeText(QuestionActivity3.this, "Wrong", Toast.LENGTH_SHORT).show();
                }
                flag++;
                if (score != null) {
                    score.setText("" + correct);

                    if (flag < questions.length) {
                        tv.setText(questions[flag]);
                        rb1.setText(opt[flag * 4]);
                        rb2.setText(opt[flag * 4 + 1]);
                        rb3.setText(opt[flag * 4 + 2]);
                        rb4.setText(opt[flag * 4 + 3]);
                        questionnumber.setText(flag + "/" + questions.length + " Question");
                    } else {
                        marks = correct;
                        Intent in = new Intent(QuestionActivity3.this, ResultActivity3.class);
                        startActivity(in);
                    }

                    radio_g.clearCheck();
                }

            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), ResultActivity3.class);
                startActivity(intent1);
            }
        });
    }
}