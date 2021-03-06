package cl.philipsoft.ph1l.wowchar.views;

import cl.philipsoft.ph1l.wowchar.models.Character;
import cl.philipsoft.ph1l.wowchar.models.Class;
import cl.philipsoft.ph1l.wowchar.models.Faction;
import cl.philipsoft.ph1l.wowchar.models.Race;

/**
 * Created by phil_ on 04-03-2017.
 */

public class CreateCharacter {
    private CharacterCallback callback;

    public CreateCharacter(CharacterCallback callback) {
        this.callback = callback;
    }

    public void validation(Character character, long charFaction, long charRace, long charClass) {
        if ((character.getCharacterFaction() != null) && (character.getCharacterClass() != null)) {
            if (character.getCharacterName().trim().length() > 0) {
                character.setCharacterLevel(1);
                character.setStatsByLvl(character.getCharacterLevel());
                Faction characterFaction = Faction.findById(Faction.class, charFaction);
                characterFaction.save();
                Race characterRace = Race.findById(Race.class, charRace);
                characterRace.save();
                Class characterClass = Class.findById(Class.class, charClass);
                characterClass.save();
                character.save();
                callback.created(character);
            } else {
                callback.noName();
            }
        } else if (character.getCharacterFaction() != null) {
            callback.noClass();
        } else {
            callback.noFaction();
        }
    }
}
