package cl.philipsoft.ph1l.wowchar.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

import cl.philipsoft.ph1l.wowchar.R;
import cl.philipsoft.ph1l.wowchar.models.Character;
import cl.philipsoft.ph1l.wowchar.models.Class;
import cl.philipsoft.ph1l.wowchar.models.Faction;
import cl.philipsoft.ph1l.wowchar.models.Race;

public class ChooseClassActivity extends AppCompatActivity implements CharacterCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_class);
        final Faction charFaction = (Faction) getIntent().getSerializableExtra("Faction");
        final Race charRace = (Race) getIntent().getSerializableExtra("Race");
        final TextView name = (TextView) findViewById(R.id.nameEt);
        final RadioGroup classRg = (RadioGroup) findViewById(R.id.classesRg);
        classRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                Log.d("WOWC", "onCheckedChanged: " + getResources().getResourceEntryName(classRg.getCheckedRadioButtonId()).replace("class", ""));
            }
        });


        Button saveBtn = (Button) findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Class> charClassList = Class.find(Class.class, "class_name = ?", getResources().getResourceEntryName(classRg.getCheckedRadioButtonId()).replace("class", ""));
                if (!charClassList.isEmpty()) {
                    Class charClass = charClassList.get(0);
                    Log.d("WOWC", "onClick: charClass: " + charClass.getClassName());
                    CreateCharacter createCharacter = new CreateCharacter(ChooseClassActivity.this);
                    Character character = new Character(charFaction, charRace, charClass, name.getText().toString());
                    createCharacter.validation(character);
                    Intent intent = new Intent(ChooseClassActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void created(Character character) {

    }

    @Override
    public void noName() {

    }

    @Override
    public void noFaction() {

    }

    @Override
    public void noClass() {

    }
}
