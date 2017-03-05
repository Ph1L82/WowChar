package cl.philipsoft.ph1l.wowchar.adapters;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import java.util.List;

import cl.philipsoft.ph1l.wowchar.R;
import cl.philipsoft.ph1l.wowchar.data.Queries;
import cl.philipsoft.ph1l.wowchar.models.Character;

import static cl.philipsoft.ph1l.wowchar.R.drawable.bg_alliance;
import static cl.philipsoft.ph1l.wowchar.R.drawable.bg_horde;

/**
 * Created by phil_ on 04-03-2017.
 */

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.ViewHolder> {

    private List<Character> characters = new Queries().characters();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_character, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int textColor = Color.parseColor(String.valueOf(R.color.textColorPrimary));
        Character character = characters.get(position);

        // TODO: 05-03-2017 modificar modelos forzar id en la data preguardada. Evaluar facciones, razas y clases en base a ID especifico.
        if (character.getCharacterFaction().getName() == "Horda") {
            holder.factionBadge.setImageResource(R.mipmap.ic_wow_flag_horde_24dp);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                holder.itemView.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), bg_horde));
                textColor = Color.parseColor(String.valueOf(R.color.hordeBackground));
            } else {
                holder.itemView.setBackgroundResource(bg_alliance);
            }
        } else if (character.getCharacterFaction().getName() == "Alianza") {
            holder.factionBadge.setImageResource(R.mipmap.ic_wow_flag_alliance_24dp);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                holder.itemView.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), bg_alliance));
                textColor = Color.parseColor(String.valueOf(R.color.allianceBackground));
            } else {
                holder.itemView.setBackgroundResource(bg_alliance);
            }
        }
        holder.charRace.setTextColor(textColor);
        holder.charClass.setTextColor(textColor);
        holder.charName.setTextColor(textColor);
        holder.charRace.setText(character.getCharacterRace().getRaceName());
        holder.charClass.setText(character.getCharacterClass().getClassName());
        holder.charName.setText(character.getCharacterName());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

// ====>>>>   Clase interna ViewHolder

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final QuickContactBadge factionBadge;
        private final TextView charRace, charClass, charName;
        View row;

        public ViewHolder(View itemView) {
            super(itemView);
            factionBadge = (QuickContactBadge) itemView.findViewById(R.id.charFactionQcb);
            charRace = (TextView) itemView.findViewById(R.id.charRaceTv);
            charClass = (TextView) itemView.findViewById(R.id.charClassTv);
            charName = (TextView) itemView.findViewById(R.id.charNameTv);
            row = itemView.findViewById(R.id.characterLl);
        }
    }
}
