package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {
    @Mock
    private IPokemonTrainerFactory pokemonTrainerFactory;
    @Mock
    private IPokedexFactory pokedexFactoryMock;

    @Mock
    private IPokedex pokedexMock;

    private PokemonTrainer trainer;

    @Before
    public void setUp() throws PokedexException {
        pokemonTrainerFactory = mock(IPokemonTrainerFactory.class);
        pokedexFactoryMock = mock(IPokedexFactory.class);
        trainer = new PokemonTrainer("Enzo", Team.MYSTIC, pokedexMock);


        Mockito.when(pokemonTrainerFactory.createTrainer("", Team.MYSTIC, pokedexFactoryMock)).thenAnswer(invocation -> {
            String pokemonName = invocation.getArgument(0);
            if (pokemonName.equals("")) {
                throw new PokedexException("Pas de nom !");
            } else {
                return trainer;
            }
        });
    }

    @Test
    public void testCreateTrainer() {
        PokemonTrainer pokemonTrainer = new PokemonTrainer("Enzo", Team.MYSTIC, pokedexMock);
        assertEquals(trainer.getName(), pokemonTrainer.getName());
    }

    /*@Test
    public void testCreateTrainerError() {
        PokemonTrainer pokemonTrainer = new PokemonTrainer("", Team.MYSTIC, pokedexMock);
        assertEquals(trainer.getName(), pokemonTrainer.getName());
    }*/
}