fetch("http://localhost:8080/prices")
    .then(response => response.json())
    .then(result => {
        console.log(result)
    })