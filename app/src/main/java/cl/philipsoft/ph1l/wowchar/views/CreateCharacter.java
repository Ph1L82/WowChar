package cl.philipsoft.ph1l.wowchar.views;

import cl.philipsoft.ph1l.wowchar.models.Character;

/**
 * Created by phil_ on 04-03-2017.
 */

public class CreateCharacter {
    private CharacterCallback callback;

    public CreateCharacter(CharacterCallback callback) {
        this.callback = callback;
    }

    public void validation(Character character) {
        if ((character.getCharacterFaction() != null) && (character.getCharacterClass() != null)) {
            if (character.getCharacterName().trim().length() > 0) {
                character.setCharacterLevel(1);
                character.setStatsByLvl(character.getCharacterLevel());
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
