package com.example.lab04alexdumitru;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


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
        Button ouvrirCommanderButton = findViewById(R.id.btn_choisir_repas); // Replace with your button's ID
        EditText et_nom = findViewById(R.id.et_nom);
        EditText et_telephone = findViewById(R.id.et_telephone);
        ouvrirCommanderButton.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, Activity_Commander.class);

            intent.putExtra("nom", et_nom.getText().toString());
            intent.putExtra("telephone", et_telephone.getText().toString());


            startActivity(intent);
        });

    }
}
