function getKanyeQuote() {
    fetch("https://api.kanye.rest/")
        .then(response => response.json())
        .then(result => {
            const quote = document.getElementById("kanye-quote")
            quote.innerText = result.quote;
        });
}
getKanyeQuote();

//document.getElementById("new-quote").addEventListener("click", getKanyeQuote);
document.getElementById("btn-laugh").addEventListener("click", () => addQuoteToList("laugh"))
document.getElementById("btn-horny").addEventListener("click", () => addQuoteToList("horny"))
document.getElementById("btn-wtf").addEventListener("click", () => addQuoteToList("wtf"))
function addQuoteToList(listName) {
    const quote = document.getElementById("kanye-quote").innerText;
    const paragraph = document.createElement("p");
    paragraph.innerText = quote;
    document.getElementById("list-"+listName).appendChild(paragraph);
}

setInterval(getKanyeQuote, 5000);

