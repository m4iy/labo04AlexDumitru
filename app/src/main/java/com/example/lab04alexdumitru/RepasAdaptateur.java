package com.example.lab04alexdumitru;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class RepasAdaptateur extends ArrayAdapter<Repas> {

    public RepasAdaptateur(Context context, List<Repas> repasList) {
        super(context, 0, repasList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Récupérer l'élément Repas pour cette position
        Repas repas = getItem(position);

        // Vérifier si une vue existante est réutilisée, sinon en créer une nouvelle
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_repas, parent, false);
        }

        // Récupérer les TextView pour le nom et le prix du repas
        TextView nomTextView = convertView.findViewById(R.id.tv_nom_repas);
        TextView prixTextView = convertView.findViewById(R.id.tv_prix_repas);

        // Définir le texte pour le nom et le prix
        if (repas != null) {
            nomTextView.setText(repas.getNom());
            prixTextView.setText(String.format("$%.2f", repas.getPrix()));
        }

        // Retourner la vue complète pour afficher sur l'écran
        return convertView;
    }
}
