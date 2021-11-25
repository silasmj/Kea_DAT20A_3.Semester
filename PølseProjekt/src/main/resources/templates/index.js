const baseURL = "http://localhost:8080";
const productTableBody = document.getElementById("products-tbody");
let tableRow;

fetch(baseURL + "/products")
    .then(response => response.json())
        .then(result => {
            result.map(createProductTableRow)
        })



function createProductTableRow(product) {
    const productTableRow = document.createElement("tr")
    productTableRow.id = product.id;

    productTableBody.appendChild(productTableRow);

    constructProductTableRow(productTableRow, product)

}

function constructProductTableRow(productTableRow, product) {
    productTableRow.innerHTML = `
        <td>
             <p class="row-product-name">${product.name}</p>
        </td>
        <td>
            <p class="row-product-category">${product.category}</p>
        </td>
        <td>
            <p class="row-product-country">${product.country}</p>
        </td>
        <td>
            <p class="row-product-price">${product.price}</p>
        </td> 
    `;
}


function createNewProduct() {
    tableRow = document.createElement("tr")
    productTableBody.appendChild(tableRow);
    tableRow.innerHTML = `
    <td>
        <input id="create-product-name" placeholder="Navn..">
    </td>
    <td>
        <input id="create-product-category" placeholder="Kategori..">
    </td>
     <td>
        <input id="create-product-country" placeholder="Land..">
    </td>
     <td>
        <input id="create-product-price" placeholder="Pris">
    </td>
    `;
}
function removeCreateForm() {
    tableRow.style.display ="none"
}

document.addEventListener("keyup", function (event) {
    if (event.keyCode === 13) {
        createProduct();
    }
})
function createProduct() {
    const productToCreate = {
        name: document.getElementById("create-product-name").value,
        category: document.getElementById("create-product-category").value,
        country: document.getElementById("create-product-country").value,
        price: document.getElementById("create-product-price").value
    }
    fetch(baseURL + "/products", {
        method: "POST",
        headers: { "Content-type": "application/json; charset=UTF-8" },
        body: JSON.stringify(productToCreate)
    }).then(response => response.json())
        .then(result => {
            removeCreateForm();
            createProductTableRow(result);
        })
}