const galleryFormParentDiv = document.getElementById("create-gallery-form");
const galleryFormExpandButton = document.getElementById("expand-gallery-form");
const createGalleryForm = `<form>
    <label>Name</label>
    <input id="create-gallery-name" placeholder="name">
    <label>Location</label>
    <input id="create-gallery-location" placeholder="location">
    <label>Owner</label>
    <input id="create-gallery-owner" placeholder="owner">
    <label>Square Feet</label>
    <input id="create-gallery-square-feet" placeholder="square feet">
    <button onclick="removeGalleryForm()">Cancel</button>
    <button onclick="console.log("Created the gallery")">Create a new Gallery</button>
</form>`;

function showGalleryForm() {
    galleryFormExpandButton.style.display = "none";
    galleryFormParentDiv.innerHTML = createGalleryForm;
}

function removeGalleryForm() {
    galleryFormExpandButton.style.display = "block";
    galleryFormParentDiv.innerHTML = "";
}

function createGallery() {
     fetch(baseURL + "/galleries", {
         method: "POST",
         headers: { "Content-type": "application/json; charset=UTF-8" },
         body: JSON.stringify({
             name: "New hardcoded gallery",
             location: "Atlantis",
             owner: "Apollo"
         })
        }).then(response => response.json())
            .then(gallery => {
                createGalleryTableRow(gallery);
            });
    }


document.getElementById("expand-gallery-form").addEventListener("click", showGalleryForm);