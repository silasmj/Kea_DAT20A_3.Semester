let artists;
const artistGalleryDiv = document.getElementById("artists-gallery")

fetch("http://localhost:8080/artists")
    .then(response => response.json()) //Får et svar som konverteres til Json
    .then(result => {
        result.map(createArtistCard)
    });

function createArtistCard (artist) {
    const artistElement = document.createElement("div")
    artistElement.innerHTML = `
        <p>${artist.name}</p>
        <img src="${artist.image}"/>
     `;

    artistGalleryDiv.appendChild(artistElement);
}

document.getElementById("create-artist-button").addEventListener("click", createNewArtist)
function createNewArtist() {
    const name = document.getElementById("create-artist-name").value;
    const age = document.getElementById("create-artist-age").value;
    const image = document.getElementById("create-artist-image").value;
    const primaryStyle = document.getElementById("create-artist-primaryStyle").value;
    const gender = document.getElementById("create-artist-gender").value;

    const newArtist = {
        name: name,
        age: Number(age),
        image: image,
        primaryStyle: primaryStyle,
        gender: gender
    };

    fetch("http://localhost:8080/artists", {
        method: "POST",
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        },
        body: JSON.stringify(newArtist)
    })
        .then(response => {
            if (response.status === 200) {
                createArtistCard(newArtist)
            }else {
                console.log("Artist not created.", response.status)
            }
        })
        .catch(error => console.log("Network related error", error))

}