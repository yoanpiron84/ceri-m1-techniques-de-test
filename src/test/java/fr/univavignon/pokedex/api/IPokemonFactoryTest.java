package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public abstract class IPokemonFactoryTest {

    @Mock
    public IPokemonFactory pokemonFactory;

    @BeforeEach
    public void setUp() throws PokedexException {
        when(pokemonFactory.createPokemon(0,613,64,4000,4)).thenReturn(new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56));
    }

    @Test
    public void shouldReturnNegatifWhenCPNegatif() throws PokedexException {
        when(pokemonFactory.createPokemon(0,-1,64,4000,4)).thenThrow(new PokedexException("CP Négatif"));
        PokemonMetadata pokemonMetadata = pokemonFactory.createPokemon(0,-1,64,4000,4);
    }
}
