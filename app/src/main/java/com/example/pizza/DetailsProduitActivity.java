package com.example.pizza;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailsProduitActivity extends AppCompatActivity {

    private TextView nom, detailsIngredient, description, preparation;
    private ImageView image;
    private ImageView share;

    private static final String TAG = "DetailsProductActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details_produit);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nom = findViewById(R.id.nom);
        detailsIngredient = findViewById(R.id.detailsIngredient);
        description = findViewById(R.id.description);
        preparation = findViewById(R.id.preparation);
        image = findViewById(R.id.image);
        share = findViewById(R.id.share);

        nom.setText(getIntent().getStringExtra("nom"));
        detailsIngredient.setText(getIntent().getStringExtra("detailsIngredient"));
        description.setText(getIntent().getStringExtra("description"));
        preparation.setText(getIntent().getStringExtra("preparation"));
        image.setImageResource(Integer.parseInt((getIntent().getStringExtra("photo"))));

        share.setOnClickListener(
                view -> {
                    String shareText = "Nom: " + nom.getText().toString() + "\n\n" +
                            "Ingredients: " + detailsIngredient.getText().toString() + "\n\n" +
                            "Description: " + description.getText().toString() + "\n\n" +
                            "Preparation: " + preparation.getText().toString();

                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);

                    shareIntent.setPackage("com.whatsapp");

                    startActivity(shareIntent);
                }
        );

        //debug
        Log.d(TAG, "product image id : " + getIntent().getStringExtra("photo"));

    }

}
