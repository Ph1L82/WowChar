package cl.philipsoft.ph1l.wowchar.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import java.util.List;

import cl.philipsoft.ph1l.wowchar.R;
import cl.philipsoft.ph1l.wowchar.models.Faction;
import cl.philipsoft.ph1l.wowchar.models.Race;

public class ChooseFactionRaceActivity extends AppCompatActivity {
    private Faction faction;
    private Race race;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_faction_race);
        final ImageButton allianceBtn = (ImageButton) findViewById(R.id.AllianceIbtn);
        final ImageButton hordeBtn = (ImageButton) findViewById(R.id.HordeIbtn);
        final RadioGroup allianceRg = (RadioGroup) findViewById(R.id.racesAllianceRg);
        final RadioGroup hordeRg = (RadioGroup) findViewById(R.id.racesHordeRg);
        allianceRg.setEnabled(false);
        hordeRg.setEnabled(false);
        final Button sendBtn = (Button) findViewById(R.id.sendBtn);
        sendBtn.setEnabled(false);
        allianceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hordeBtn.setEnabled(false);
                hordeBtn.setVisibility(View.GONE);
                hordeRg.setVisibility(View.GONE);
                allianceRg.setEnabled(true);
                List<Faction> factionList = Faction.find(Faction.class, "name = ?", "Alliance");
                sendBtn.setBackgroundColor(getResources().getColor(R.color.allianceBackground));
                sendBtn.setTextColor(getResources().getColor(R.color.allianceFront));
                faction = factionList.get(0);
                Log.d("WOWC", "onCheckedChanged: Facción seleccionada : " + faction.getName());
            }
        });

        hordeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allianceBtn.setEnabled(false);
                allianceBtn.setVisibility(View.GONE);
                allianceRg.setVisibility(View.GONE);
                hordeRg.setEnabled(true);
                List<Faction> factionList = Faction.find(Faction.class, "name = ?", "Horde");
                sendBtn.setBackgroundColor(getResources().getColor(R.color.hordeBackground));
                sendBtn.setTextColor(getResources().getColor(R.color.hordeFront));
                faction = factionList.get(0);
                Log.d("WOWC", "onCheckedChanged: Facción seleccionada : " + faction.getName());
            }
        });

        allianceRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                String raceName = getResources().getResourceEntryName(checkedId).replace("race", "");
                raceName = raceName.replace("Rb", "");
                Log.d("WOWC", "onCheckedChanged: Raza seleccionada : [" + raceName + "]");
                List<Race> raceList = Race.find(Race.class, "race_name = ?", raceName);
                Log.d("WOWC", "onCheckedChanged: 1 raceList.size" + raceList.size());
                if (raceList != null && raceList.size() > 0) {
                    Log.d("WOWC", "onCheckedChanged: 2 raceList.size : " + raceList.size());
                    race = raceList.get(0);
                } else {
                    Log.d("WOWC", "onCheckedChanged: 3 raceList.size : " + raceList.size());
                }

            }
        });

        hordeRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                String raceName = getResources().getResourceEntryName(checkedId).replace("race", "");
                raceName = raceName.replace("Rb", "");
                Log.d("WOWC", "onCheckedChanged: Raza seleccionada : [" + raceName + "]");
                List<Race> raceList = Race.find(Race.class, "race_name = ?", raceName);
                Log.d("WOWC", "onCheckedChanged: 1 raceList.size" + raceList.size());
                if (raceList != null && raceList.size() > 0) {
                    Log.d("WOWC", "onCheckedChanged: 2 raceList.size : " + raceList.size());
                    race = raceList.get(0);
                } else {
                    Log.d("WOWC", "onCheckedChanged: 3 raceList.size : " + raceList.size());
                }

            }
        });


        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseFactionRaceActivity.this, ChooseClassActivity.class);
                intent.putExtra("Faction", faction);
                intent.putExtra("Race", race);
                startActivity(intent);
            }
        });
    }
}
