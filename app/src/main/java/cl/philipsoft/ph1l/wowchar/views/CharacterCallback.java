package cl.philipsoft.ph1l.wowchar.views;

import cl.philipsoft.ph1l.wowchar.models.Character;

/**
 * Created by phil_ on 04-03-2017.
 */

public interface CharacterCallback {
    void created(Character character);

    void noName();

    void noFaction();

    void noClass();
}
