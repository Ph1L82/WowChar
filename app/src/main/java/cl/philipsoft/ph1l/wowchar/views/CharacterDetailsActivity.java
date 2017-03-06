package cl.philipsoft.ph1l.wowchar.views;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import cl.philipsoft.ph1l.wowchar.R;
import cl.philipsoft.ph1l.wowchar.models.Character;
import cl.philipsoft.ph1l.wowchar.models.Class;
import cl.philipsoft.ph1l.wowchar.models.Faction;
import cl.philipsoft.ph1l.wowchar.models.Race;

public class CharacterDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        Character character = (Character) getIntent().getSerializableExtra("Character");
        final Character character = Character.findById(Character.class, getIntent().getLongExtra("characterID", 1));
        Log.d("WOWC", "onCreate: CHARACTER NAME : " + character.getCharacterName());
        Log.d("WOWC", "onCreate: CHARACTER ID : " + character.getId());
        final Faction characterFaction = Faction.findById(Faction.class, getIntent().getLongExtra("factionID", 1));
        Log.d("WOWC", "onCreate: FACTION NAME : " + characterFaction.getName());
        Log.d("WOWC", "onCreate: FACTION ID : " + characterFaction.getId());
        final Race characterRace = Race.findById(Race.class, getIntent().getLongExtra("raceID", 1));
        Log.d("WOWC", "onCreate: RACE NAME : " + characterRace.getRaceName());
        Log.d("WOWC", "onCreate: RACE ID : " + characterRace.getId());
        final Class characterClass = Class.findById(Class.class, getIntent().getLongExtra("classID", 1));
        Log.d("WOWC", "onCreate: CLASS NAME : " + characterClass.getClassName());
        Log.d("WOWC", "onCreate: CLASS ID : " + characterClass.getId());
        ImageView factionShield = (ImageView) findViewById(R.id.factionShield);
        Faction faction = character.getCharacterFaction();
//        switch can't manage long.... u.u
        if (characterFaction.getId() == 1) {
            factionShield.setImageResource(R.mipmap.ic_wow_alliance_48dp);
            factionShield.setBackgroundColor(getResources().getColor(R.color.allianceBackground));
            setTitleColor(getResources().getColor(R.color.allianceFront));
        } else if (faction.getId() == 2) {
            factionShield.setImageResource(R.mipmap.ic_wow_horde_48dp);
            factionShield.setBackgroundColor(getResources().getColor(R.color.hordeBackground));
            setTitleColor(getResources().getColor(R.color.hordeFront));
        } else {
            factionShield.setImageResource(R.mipmap.ic_wow_48dp);
        }
        setTitle(character.getCharacterName());

//        TextView nameTv = (TextView) findViewById(R.id.nameTv);
//        nameTv.setText(character.getCharacterName().toString());
//        TextView factionTv = (TextView) findViewById(R.id.charFactionTv);
//        factionTv.setText(character.getCharacterFaction().getName());
//        TextView raceTv = (TextView) findViewById(R.id.charRaceTv);
//        raceTv.setText(character.getCharacterRace().getRaceName());
//        TextView classTv = (TextView) findViewById(R.id.charClassTv);
//        classTv.setText(character.getCharacterClass().getClassName());

//        TextView levelTextView = (TextView) findViewById(R.id.levelTv);
//        levelTextView.setText(character.getCharacterLevel());
//        TextView staminaTextView = (TextView) findViewById(R.id.staminaTv);
//        staminaTextView.setText(character.getStamina());
//        TextView strengthTextView = (TextView) findViewById(R.id.strengthTv);
//        strengthTextView.setText(character.getStrength());
//        TextView agilityTextView = (TextView) findViewById(R.id.agilityTv);
//        agilityTextView.setText(character.getAgility());
//        TextView intellectTextView = (TextView) findViewById(R.id.intellectTv);
//        intellectTextView.setText(character.getIntellect());
//        TextView spiritTextView = (TextView) findViewById(R.id.spiritTv);
//        spiritTextView.setText(character.getSpirit());


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.charDetailFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(CharacterDetailsActivity.this)
                        .setTitle("Eliminar personaje: " + character.getCharacterName().toString())
                        .setMessage("¿Está seguro?")
                        .setIcon(android.R.drawable.ic_input_delete)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                character.delete();
                                Intent intent = new Intent(CharacterDetailsActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton(android.R.string.no, null).show();
            }
        });
    }

}
