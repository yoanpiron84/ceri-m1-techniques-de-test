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
            Team team = invocation.getArgument(1);
            if (pokemonName.equals("")) {
                throw new PokedexException("Pas de nom !");
            } else if (team == null) {
                throw new PokedexException("Team non définie !");
            } else if (team == null) {
                throw new PokedexException("Team non définie !");
            } else if(pokedexFactoryMock == null){
                throw new PokedexException("Mock non défini !");
            } else {
                return trainer;
            }
        });
    }

    @Test
    public void shouldReturnTrainerWhenCreate() {
        PokemonTrainer pokemonTrainer = new PokemonTrainer("Enzo", Team.MYSTIC, pokedexMock);
        assertEquals(trainer.getName(), pokemonTrainer.getName());
    }

    @Test
    public void shouldReturnTrainerWhenTeam() {
        PokemonTrainer pokemonTrainer = new PokemonTrainer("Enzo", Team.MYSTIC, pokedexMock);
        assertEquals(trainer.getTeam(), pokemonTrainer.getTeam());
    }

    @Test
    public void shouldReturnTrainerWhenPokedex() {
        PokemonTrainer pokemonTrainer = new PokemonTrainer("Enzo", Team.MYSTIC, pokedexMock);
        assertEquals(trainer.getPokedex(), pokemonTrainer.getPokedex());
    }

    /*@Test
    public void testCreateTrainerError() {
        PokemonTrainer pokemonTrainer = new PokemonTrainer("", Team.MYSTIC, pokedexMock);
        assertEquals(trainer.getName(), pokemonTrainer.getName());
    }*/
}