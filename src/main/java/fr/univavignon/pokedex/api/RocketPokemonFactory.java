package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.collections4.map.UnmodifiableMap;

/**
 * This class represents a factory for creating Pokemon instances,
 * specifically designed for Rocket Team.
 */
public class RocketPokemonFactory implements IPokemonFactory {

/**
 * Map to store the association between Pokemon index and their names.
 */
private static Map<Integer, String> indexToName;
static {
Map<Integer, String> aMap = new HashMap<Integer, String>();
aMap.put(-1, "Ash's Pikachu");
aMap.put(0, "MISSINGNO");
aMap.put(1, "Bulbasaur");
indexToName = UnmodifiableMap.unmodifiableMap(aMap);
}

/**
 * Generates a random stat value.
 *
 * @return Randomly generated stat value
 */
private static int generateRandomStat() {
int total = 0;
for (int i = 0; i < 1000000; i++) {
Random rn = new Random();
int r = rn.nextInt(2);
total += r;
}
System.out.println(total / 10000);
return total / 10000;
}

/**
 * Creates a Pokemon instance.
 *
 * @param index The index of the Pokemon
 * @param cp The combat power of the Pokemon
 * @param hp The hit points of the Pokemon
 * @param dust The dust needed to power up the Pokemon
 * @param candy The candy needed to evolve the Pokemon
 * @return The created Pokemon instance
 */
@Override
public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
String name;
if(!indexToName.containsKey(index)) {
name = indexToName.get(0);
} else {
name = indexToName.get(index);
}
int attack;
int defense;
int stamina;
double iv;
if(index < 0) {
attack = 1000;
defense = 1000;
stamina = 1000;
iv = 0;
} else {
attack = RocketPokemonFactory.generateRandomStat();
defense = RocketPokemonFactory.generateRandomStat();
stamina = RocketPokemonFactory.generateRandomStat();
iv = 1;
}
return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);
}

}