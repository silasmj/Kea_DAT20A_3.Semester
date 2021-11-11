const paintingsGalleryDiv = document.getElementById("paintings-gallery")


fetch(baseURL + "/paintings")
    .then(response => response.json())
    .then(result => {
        result.map(createAPaintingCard)
    })


function createAPaintingCard(painting) {
    const paintingCardDiv = document.createElement("div");
    paintingsGalleryDiv.appendChild(paintingCardDiv);

    constructAPaintingCard(paintingCardDiv, painting);

}

function constructAPaintingCard(paintingsDiv, painting) {
    paintingsDiv.innerHTML = `
    <h2>${escapeHTML(painting.title)}</h2>
    <h3>${"$"+escapeHTML(painting.price.toString())}</h3>
    <h3>${escapeHTML(painting.genre)}</h3>
    <h3>${escapeHTML(painting.year.toString())}</h3>
    `;
}


function createPainting() {

}


document.getElementById("create-painting-button").addEventListener("click", createPainting)