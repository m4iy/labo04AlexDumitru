package com.example.lab04alexdumitru;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RepasFragment extends Fragment {

    private ListView listeRepasView; // ListView pour afficher la liste des repas
    private List<Repas> listeRepas; // Liste d'objets Repas
    private RepasAdaptateur repasAdaptateur; // Adaptateur personnalisé pour le ListView

    public RepasFragment() {
        // Constructeur public vide requis
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vue = inflater.inflate(R.layout.fragment_repas, container, false);

        // Initialiser la ListView
        listeRepasView = vue.findViewById(R.id.meal_list);

        // Charger les données du menu à partir du JSON
        listeRepas = chargerMenuDepuisJSON();

        // Initialiser l'adaptateur avec la liste des repas
        repasAdaptateur = new RepasAdaptateur(getContext(), listeRepas);
        listeRepasView.setAdapter(repasAdaptateur);

        // Gérer les clics sur les éléments pour afficher les détails dans RepasDetailsFragment
        listeRepasView.setOnItemClickListener((parent, view, position, id) -> {
            Repas repasSelectionne = listeRepas.get(position);
            afficherDetailsRepas(repasSelectionne);
        });

        return vue;
    }

    // Charger et analyser les données JSON de menu.json
    private List<Repas> chargerMenuDepuisJSON() {
        List<Repas> repasList = new ArrayList<>();
        try {
            // Lire le JSON depuis les ressources
            InputStream fluxEntree = getContext().getAssets().open("menu.json");
            BufferedReader lecteur = new BufferedReader(new InputStreamReader(fluxEntree));
            StringBuilder jsonString = new StringBuilder();
            String ligne;
            while ((ligne = lecteur.readLine()) != null) {
                jsonString.append(ligne);
            }
            lecteur.close();

            // Analyse du JSON
            JSONArray jsonArray = new JSONArray(jsonString.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject repasObject = jsonArray.getJSONObject(i);
                String numero = repasObject.getString("numero");
                String nom = repasObject.getString("nom");
                String description = repasObject.getString("description");
                String categorie = repasObject.getString("categorie");
                double prix = repasObject.getDouble("prix");

                int numeroInt = Integer.parseInt(numero);
                // Créer l'objet Repas et ajouter à la liste
                Repas repas = new Repas(numeroInt, nom, description, categorie, prix);
                repasList.add(repas);
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return repasList;
    }

    private void afficherDetailsRepas(Repas repas) {
        // Passer les détails du repas sélectionné à RepasDetailsFragment
        Bundle bundle = new Bundle();
        bundle.putString("categorie", repas.getCategorie());
        bundle.putString("description", repas.getDescription());
        bundle.putDouble("prix", repas.getPrix());

        RepasDetailsFragment detailsFragment = new RepasDetailsFragment();
        detailsFragment.setArguments(bundle);

        // Remplacer le conteneur avec RepasDetailsFragment
        getParentFragmentManager().beginTransaction()
                .replace(R.id.conteneur_fragment_details_repas, detailsFragment)
                .commit();
    }
}
