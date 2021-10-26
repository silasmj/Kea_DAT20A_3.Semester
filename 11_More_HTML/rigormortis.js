const characterGalleryDiv = document.getElementById("character-gallery")
let characters;
let filteredCharacters;

fetch("https://rickandmortyapi.com/api/character")
        .then(response => response.json())
        .then(result => {
            characters = result.results;
            filteredCharacters = characters;
            characters.map(character => createCharacterCard(character));
        });


 function createCharacterCard(character) {
     const cardElement = document.createElement("div")

     cardElement.innerHTML = `
        <p>${escapeHTML(character.name)}</p>
        <img src="${escapeHTML(character.image)}"></img>
     `;

     characterGalleryDiv.appendChild(cardElement)
 }

 document.getElementById("search").addEventListener("click", searchCharacters); // Uden parantes - Det skal ikke kaldes, når siden bliver loadet. Uden parantes, giver man kun referencen. Så når eventet bliver triggered, begynder den at søge.
document.getElementById("name-search").addEventListener("input", handleSearchName)

function handleSearchName(event) {
    characterGalleryDiv.innerHTML = "";
    filteredCharacters.filter(character => character.name.toLowerCase().includes(event.target.value.toLowerCase())).map(createCharacterCard);
}

function searchCharacters() {
     const selectedStatus = document.getElementById("status-dropdown").value;
     characterGalleryDiv.innerHTML = "";
     if (selectedStatus === "All") {
         filteredCharacters = characters;
         characters.map(createCharacterCard)
     }else{
         filteredCharacters = characters.filter(character => character.status === selectedStatus);
         filteredCharacters.map(createCharacterCard);
     }
 }

