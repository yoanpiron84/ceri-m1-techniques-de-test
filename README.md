Piron Yoan M1 ILSEN Classique

[![CircleCI](https://dl.circleci.com/status-badge/img/gh/yoanpiron84/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/yoanpiron84/ceri-m1-techniques-de-test/tree/master)

[![codecov](https://codecov.io/gh/yoanpiron84/ceri-m1-techniques-de-test/graph/badge.svg?token=NH78G9RX04)](https://codecov.io/gh/yoanpiron84/ceri-m1-techniques-de-test)

En ce qui concerne les choix d'implémentation, j'ai d'abord commencé par implémenter la classe PokemonMetadataProvider:

	-> Dans cette classe, j'ai choisi d'utiliser une HashMap pour stocker les métadonnées des Pokémon.
	   Ce choix minimise la redondance de données et me servira pour l'implémentation de la classe Pokedex.


Ensuite, j'ai implémenté la classe PokemonFactory
	-> La classe PokemonFactory implémente IPokemonFactory et utilise un metadataProvider pour créer des Pokémon
	   en récupérant leurs métadonnées. 
	   Si les métadonnées sont disponibles, elle crée un Pokémon avec ces informations et un IV généré aléatoirement. 
	   Sinon, elle crée un Pokémon avec des valeurs par défaut.
	   
	   
Ces deux classes me permettent donc d'implémenter la classe Pokedex:

	-> La classe Pokedex implémente IPokedex et stocke une liste de Pokémon.
	   Elle utilise un fournisseur de métadonnées de Pokémon pour récupérer les informations nécessaires à la création de nouveaux Pokémon.
	   La méthode createPokemon génère un Pokémon en utilisant ces informations.
	   Par ailleurs, le pokedex est une liste de Pokemons.
	   
	   
Ensuite, j'ai implémenté la classe PokedexFactory:

	-> La classe PokedexFactory implémente IPokedexFactory et crée une instance de Pokedex en utilisant un fournisseur de métadonnées de Pokémon.
	
	
Enfin, j'ai implémenté la classe PokemonTrainerFactory:

	-> La classe PokemonTrainerFactory implémente l'interface IPokemonTrainerFactory, avec une méthode createTrainer qui crée une instance de PokemonTrainer.
	   Cette méthode prend en paramètres le nom du dresseur, son équipe et une instance de IPokedexFactory pour créer le Pokédex associé au dresseur.