package controller;

import model.Nature;
import model.Pokemon;

/**
 * Created by TheDinoSlayer on 26/08/2016.
 */
public class CalculationStats {
    public int calculateHP(Pokemon pokemon, int iv, int ev) {
        return (2 * pokemon.getHP() + iv + (ev / 4)) * pokemon.getLevel() / 100 + pokemon.getLevel() + 10;
    }

    public int calculateAtk(Pokemon pokemon, int iv, int ev) {
        int stat = (2 * pokemon.getAtk() + iv + (ev / 4)) * pokemon.getLevel() / 100 + 5;
        if(pokemon.getNature() == Nature.ADAMANT || pokemon.getNature() == Nature.BRAVE || pokemon.getNature() == Nature.LONELY || pokemon.getNature() == Nature.NAUGHTY) {
            stat *= 1.1;
        } else if(pokemon.getNature() == Nature.BOLD || pokemon.getNature() == Nature.CALM || pokemon.getNature() == Nature.MODEST || pokemon.getNature() == Nature.TIMID) {
            stat *= 0.9;
        }
        return stat;
    }

    public int calculateDef(Pokemon pokemon, int iv, int ev) {
        int stat = (2 * pokemon.getDef() + iv + (ev / 4)) * pokemon.getLevel() / 100 + 5;
        if(pokemon.getNature() == Nature.BOLD || pokemon.getNature() == Nature.IMPISH || pokemon.getNature() == Nature.LAX || pokemon.getNature() == Nature.RELAXED) {
            stat *= 1.1;
        } else if(pokemon.getNature() == Nature.GENTLE || pokemon.getNature() == Nature.HASTY || pokemon.getNature() == Nature.LONELY || pokemon.getNature() == Nature.MILD) {
            stat *= 0.9;
        }
        return stat;
    }

    public int calculateSpa(Pokemon pokemon, int iv, int ev) {
        int stat = (2 * pokemon.getSpA() + iv + (ev / 4)) * pokemon.getLevel() / 100 + 5;
        if(pokemon.getNature() == Nature.MILD || pokemon.getNature() == Nature.MODEST || pokemon.getNature() == Nature.RASH || pokemon.getNature() == Nature.QUIET) {
            stat *= 1.1;
        } else if(pokemon.getNature() == Nature.ADAMANT || pokemon.getNature() == Nature.CAREFUL || pokemon.getNature() == Nature.IMPISH || pokemon.getNature() == Nature.JOLLY) {
            stat *= 0.9;
        }
        return stat;
    }

    public int calculateSpd(Pokemon pokemon, int iv, int ev) {
        int stat = (2 * pokemon.getSpD() + iv + (ev / 4)) * pokemon.getLevel() / 100 + 5;
        if(pokemon.getNature() == Nature.CALM || pokemon.getNature() == Nature.CAREFUL || pokemon.getNature() == Nature.GENTLE || pokemon.getNature() == Nature.SASSY) {
            stat *= 1.1;
        } else if(pokemon.getNature() == Nature.LAX || pokemon.getNature() == Nature.NAIVE || pokemon.getNature() == Nature.NAUGHTY || pokemon.getNature() == Nature.RASH) {
            stat *= 0.9;
        }
        return stat;
    }

    public int calculateSpe(Pokemon pokemon, int iv, int ev) {
        int stat = (2 * pokemon.getSpe() + iv + (ev / 4)) * pokemon.getLevel() / 100 + 5;
        if(pokemon.getNature() == Nature.HASTY || pokemon.getNature() == Nature.JOLLY || pokemon.getNature() == Nature.NAIVE || pokemon.getNature() == Nature.TIMID) {
            stat *= 1.1;
        } else if(pokemon.getNature() == Nature.BRAVE || pokemon.getNature() == Nature.QUIET || pokemon.getNature() == Nature.RELAXED || pokemon.getNature() == Nature.SASSY) {
            stat *= 0.9;
        }
        return stat;
    }
}
