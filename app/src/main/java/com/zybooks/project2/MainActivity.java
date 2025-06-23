package com.zybooks.project2;

import android.os.Bundle;
import android.widget.TextView;
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

        // Get the TextView by its ID
        TextView quoteTextView = findViewById(R.id.quoteTextView);

        // Define an array of motivational quotes
        String[] quotes = {
                "The only way to do great work is to love what you do.",
                "Believe you can and you're halfway there.",
                "Success is not final, failure is not fatal: It is the courage to continue that counts.",
                "It always seems impossible until it's done.",
                "You are never too old to set another goal or to dream a new dream."
        };

        // Get a random index to select a random quote from the array
        int randomIndex = (int) (Math.random() * quotes.length);

        // Set the random quote to the TextView
        quoteTextView.setText(quotes[randomIndex]);

        // Apply window insets to avoid overlapping with system UI (e.g., status bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
