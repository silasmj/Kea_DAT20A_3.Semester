const galleriesTableBody = document.getElementById("galleries-tbody");

fetch(baseURL + "/galleries")
    .then(response => response.json())
    .then(galleries => {
        galleries.map(gallery => {
            const galleryTableRow = document.createElement("tr");

            galleryTableRow.innerHTML = `
            <td>
            <a href="./gallery.html?galleryId=${gallery.id}">
                <p>${escapeHTML(gallery.name)}</p>
            </a>
            </td>
            
        `;

            galleriesTableBody.appendChild(galleryTableRow);
        });
    });