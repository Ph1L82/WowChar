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
                character.save();
                callback.created(character);
            } else {
                callback.noName();
            }
        }
    }
}
