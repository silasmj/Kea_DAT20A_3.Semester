const list = [1, 2, 3, 4, 5];

const squareList = list.map(number => number + number);

console.log(squareList);

const isOdd = list.filter(number => number % 2 !== 0);
console.log(isOdd);

/*  Type inference
* Man kan samligne '1' == 1; - Dette vil give true.
* Men '1' == 1; - Vil give false
* 2 * = - Vil ikke sammenligne typer.
* */

const kajkager = [{
    type: "Andrea",
    color: "blue",
    deliciousness: 8
    },
    {

        type: "Kaj",
        color: "brown",
        deliciousness: 1

    }
];

// Man kan push eller pop til en liste.

kajkager.push({
    type: "Kaj",
    color: "Green",
    deliciousness: 10
    }
);

const tbodyElement = document.getElementById("cake-tbody");

const hardCaketData = {
    type: "Kaj",
    color: "Green",
    deliciousness: 10
}

kajkager.map(cake => {
    const tableRowElement = document.createElement("tr");

    tableRowElement.innerHTML = `
    <tr>
        <td>${escapeHTML(cake.type)}</td>
        <td>${escapeHTML(cake.color)}</td>
        <td>${escapeHTML(cake.deliciousness.toString())}/10</td>
    </tr>
`;
    tbodyElement.appendChild(tableRowElement);
});


