 fetch("https://rickandmortyapi.com/api/character")
        .then(response => response.json())
        .then(result => {
            result.results.map(character => createCharacterCard(character));
        });


 function createCharacterCard(character) {
     console.log(character);
 }

