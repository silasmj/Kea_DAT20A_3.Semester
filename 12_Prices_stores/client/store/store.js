const queryString = window.location.search;
const urlParams = URLSearchParams(queryString);
const storeId = parseInt(urlParams.get("storeId"));

const pricesDiv = document.getElementById("prices-display-case")

const prices = [
    {
        id: 1, price: 84.00, size: "10px", color: "green"
    },
    {
        id: 2, price: 8.40, size: "44px", color: "purple"
    },
];
prices.map(displayPrice)

function displayPrice(price) {
    const priceTagParagraph = document.createElement("p");
    priceTagParagraph.innerText = price.price.toFixed(2);
    priceTagParagraph.style.position = "absolute";
    priceTagParagraph.style.fontSize = price.size;
    priceTagParagraph.style.color = price.color;

    pricesDiv.append(priceTagParagraph);
}