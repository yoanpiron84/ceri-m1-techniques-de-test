package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNull;

public class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider dataProvider;
    PokemonMetadata bulbizarreMetadata;
    PokemonMetadata aqualiMetadata;

    @Before
    public void setUp() throws PokedexException {
        dataProvider = new PokemonMetadataProvider();

        bulbizarreMetadata = dataProvider.getPokemonMetadata(0);
        aqualiMetadata = dataProvider.getPokemonMetadata(133);
    }

    @Test
    public void MetadataNotFoundTest() throws PokedexException {
        assertNull(dataProvider.getPokemonMetadata(126));
    }
    @Test
    public void getPokemonMetadataTest() throws PokedexException {
        assertEquals(dataProvider.getPokemonMetadata(0), bulbizarreMetadata);
        assertEquals(dataProvider.getPokemonMetadata(133), aqualiMetadata);
    }

    @Test
    public void shouldReturnPokemonIndex() throws PokedexException {
        int index = dataProvider.getPokemonMetadata(0).getIndex();
        assertEquals(bulbizarreMetadata.getIndex(), index);
    }

    @Test
    public void shouldReturnPokemonName() throws PokedexException {
        String pokemonName = dataProvider.getPokemonMetadata(0).getName();
        assertEquals(bulbizarreMetadata.getName(), pokemonName);
    }

    @Test
    public void shouldReturnPokemonAttack() throws PokedexException {
        int attack = dataProvider.getPokemonMetadata(0).getAttack();
        assertEquals(bulbizarreMetadata.getAttack(), attack);
    }

    @Test
    public void shouldReturnPokemonDefense() throws PokedexException {
        int defense = dataProvider.getPokemonMetadata(0).getDefense();
        assertEquals(bulbizarreMetadata.getDefense(), defense);
    }

    @Test
    public void shouldReturnPokemonStamina() throws PokedexException {
        int stamina = dataProvider.getPokemonMetadata(0).getStamina();
        assertEquals(bulbizarreMetadata.getStamina(), stamina);
    }

    @Test(expected = PokedexException.class)
    public void shouldThrowWhenInvalidIndex() throws PokedexException {
        dataProvider.getPokemonMetadata(-2);
    }

    @Test
    public void throwPokedexException() {
        assertThrows(PokedexException.class, () -> {
            dataProvider.getPokemonMetadata(-1);
        });
        assertThrows(PokedexException.class, () -> {
            dataProvider.getPokemonMetadata(172);
        });
    }
}
