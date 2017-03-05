package cl.philipsoft.ph1l.wowchar.data;

import java.util.ArrayList;
import java.util.List;

import cl.philipsoft.ph1l.wowchar.models.Class;
import cl.philipsoft.ph1l.wowchar.models.Faction;
import cl.philipsoft.ph1l.wowchar.models.Race;

/**
 * Created by phil_ on 05-03-2017.
 */

public class DataSeeder {
    public List<Faction> createFactions() {
        List<Faction> factions = new ArrayList<>();
        Faction alliance = new Faction("Alianza");
        Faction horde = new Faction("Horda");

        factions.add(alliance);
        factions.add(horde);

        Faction.saveInTx(factions);

        return factions;
    }

    public List<Race> createRaces() {
        List<Race> races = new ArrayList<>();
        Race human = new Race(20, 20, 20, 20, 20, "Humano");
        Race dwarf = new Race(25, 16, 21, 19, 19, "Enano");
        Race nightElf = new Race(16, 24, 20, 20, 20, "Elfo Nocturno");
        Race gnome = new Race(15, 22, 20, 20, 22, "Gnomo");
        Race draenei = new Race(21, 17, 20, 20, 22, "Draenei");
        Race worgen = new Race(23, 22, 20, 16, 19, "Huargo");
        Race orc = new Race(23, 17, 21, 17, 22, "Orco");
        Race undead = new Race(19, 18, 20, 18, 25, "No-Muerto");
        Race tauren = new Race(25, 16, 21, 16, 22, "Tauren");
        Race troll = new Race(21, 22, 20, 16, 21, "Troll");
        Race bloodElf = new Race(17, 22, 20, 23, 18, "Elfo Nocturno");
        Race goblin = new Race(17, 22, 20, 23, 18, "Goblin");

        races.add(human);
        races.add(dwarf);
        races.add(nightElf);
        races.add(gnome);
        races.add(draenei);
        races.add(worgen);
        races.add(orc);
        races.add(undead);
        races.add(tauren);
        races.add(troll);
        races.add(bloodElf);
        races.add(goblin);

        Race.saveInTx(races);

        return races;
    }

    public List<Class> createClasses() {
        List<Class> classes = new ArrayList<>();
        Class priest = new Class(0, 0, 0, 2, 3, "Sacerdote");
        Class rogue = new Class(1, 3, 1, 0, 0, "Pícaro");
        Class warrior = new Class(3, 0, 2, 0, 0, "Guerrero");
        Class mage = new Class(0, 0, 0, 3, 2, "Mago");
        Class druid = new Class(1, 0, 0, 2, 2, "Druida");
        Class hunter = new Class(0, 3, 1, 0, 1, "Cazador");
        Class warlock = new Class(0, 0, 1, 2, 2, "Brujo");
        Class shaman = new Class(1, 0, 1, 1, 2, "Chamán");
        Class paladin = new Class(2, 0, 2, 0, 1, "Paladín");

        classes.add(priest);
        classes.add(rogue);
        classes.add(warrior);
        classes.add(mage);
        classes.add(druid);
        classes.add(hunter);
        classes.add(warlock);
        classes.add(shaman);
        classes.add(paladin);

        Class.saveInTx(classes);

        return classes;
    }
}
