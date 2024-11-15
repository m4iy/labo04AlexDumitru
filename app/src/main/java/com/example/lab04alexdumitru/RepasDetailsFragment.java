package com.example.lab04alexdumitru;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RepasDetailsFragment extends Fragment {

    private TextView categorieTextView;
    private TextView descriptionTextView;
    private TextView prixTextView;

    public RepasDetailsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflater le layout pour ce fragment
        View vue = inflater.inflate(R.layout.fragment_repas_details, container, false);

        // Initialiser les TextView
        categorieTextView = vue.findViewById(R.id.tv_categorie_repas);
        descriptionTextView = vue.findViewById(R.id.tv_description_repas);
        prixTextView = vue.findViewById(R.id.tv_prix_repas);

        // Récupérer les arguments passés par RepasFragment
        if (getArguments() != null) {
            String categorie = getArguments().getString("categorie");
            String description = getArguments().getString("description");
            double prix = getArguments().getDouble("prix");

            // Afficher les détails dans les TextView
            categorieTextView.setText(categorie);
            descriptionTextView.setText(description);
            prixTextView.setText(String.format("$%.2f", prix));
        }

        return vue;
    }
}
