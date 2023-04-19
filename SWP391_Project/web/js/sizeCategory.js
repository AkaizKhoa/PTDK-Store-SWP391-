
// Get references to the category and size <select> elements
const categorySelect = document.getElementById("categorySelect");
const sizeSelect = document.getElementById("sizeSelect");

// Add an event listener to the category <select> element
categorySelect.addEventListener("change", () => {
    // Get the selected category ID
    const categoryId = categorySelect.value;

    // Send an AJAX request to the server to retrieve the list of sizes for the selected category
    fetch(`/getSizes?categoryId=${categoryId}`)
            .then(response => response.json())
            .then(sizes => {
                // Clear the existing size options
                sizeSelect.innerHTML = "";

                // Add the new size options to the <select> element
                sizes.forEach(size => {
                    const option = document.createElement("option");
                    option.value = size;
                    option.text = size;
                    sizeSelect.appendChild(option);
                });
            })
            .catch(error => console.error(error));
});


