package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IPokedexFactoryTest {
    private PokedexFactory pokedexFactory;
    private PokemonMetadataProvider metadataProvider;
    private PokemonFactory pokemonFactory;

    @Before
    public void setUp() throws PokedexException {
        pokedexFactory = new PokedexFactory();
    }

    @Test
    public void testCreatePokedex() throws PokedexException {
        // Créer un pokedex à l'aide de la factory
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        // Vérifier que le pokedex a été créé avec succès
        assertNotNull(pokedex);
    }
}
