package com.example.icon;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button rotateButton;
    private Button toggleButton;
    private float rotationAngle = 0;
    private boolean isImageVisible = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imageView = findViewById(R.id.imageView);
        rotateButton = findViewById(R.id.rotateButton);
        toggleButton = findViewById(R.id.toggleButton);


        rotateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotationAngle += 90; // زيادة الزاوية بمقدار 90 درجة
                imageView.setRotation(rotationAngle); // تطبيق الدوران
            }
        });


        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isImageVisible) {
                    imageView.setVisibility(View.GONE); // إخفاء الصورة
                } else {
                    imageView.setVisibility(View.VISIBLE); // إظهار الصورة
                }
                isImageVisible = !isImageVisible; // تغيير حالة الظهور
            }
        });
    }
}