package cl.philipsoft.ph1l.wowchar.models;

import com.orm.SugarRecord;

/**
 * Created by phil_ on 11-02-2017.
 * Faction : Agrupacion de razas
 */

public class Faction extends SugarRecord {
    private String name;

    public Faction() {
    }

    public Faction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
