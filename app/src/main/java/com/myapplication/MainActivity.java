package com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * 2. Создайте приложение, которое:
 * 1. Отслеживает жизненный цикл активити и показывает его на экране (или в логах)
 * 2. При переходе на кнопку открывается второй экран
 */
public class MainActivity extends AppCompatActivity {

    //TextView textView;

    Button toastButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(MainActivity.this, "активность создается", Toast.LENGTH_LONG).show();
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //textView=findViewById(R.id.textview);

        toastButton = findViewById(R.id.toast);

        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "кнопка нажата", Toast.LENGTH_LONG).show();
                //Log.d("MainActivity", "Мы нажали кнопку");
                // явный вызов
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                //неявный вызов
//                Uri adress = Uri.parse("www.google.com");
//                Intent intent = new Intent(Intent.ACTION_VIEW, adress);
//                // если нет предустановленного браузера
//                if (intent.resolveActivity(getPackageManager()) != null) {
//                    startActivity(intent);
//                } else {
//                    //Log.d("er", "Ошибка");
//                    Toast.makeText(MainActivity.this,"ошибка", Toast.LENGTH_SHORT).show();
//
//                }

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this, "активность становится видимой для пользователя", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, "активность выходит на передний план", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this, "активность уходит с переднего плана", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this, "активность перестает быть видимой", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this, "активность уничтожается", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(MainActivity.this, "пользователь переходит к активности", Toast.LENGTH_LONG).show();
    }
}