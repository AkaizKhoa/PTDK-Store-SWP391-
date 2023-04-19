/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function showDelete(customerID, productID) {
    document.getElementById("customerId").value = customerID;
    document.getElementById("productId").value = productID;

    console.log(document.getElementById("customerId").value);
        console.log(document.getElementById("productId").value);

    const formIncludeDelete = document.querySelector('.form__include-delete');
    if (formIncludeDelete.classList.contains("active")) {
        formIncludeDelete.classList.remove('active')
    } else {
        formIncludeDelete.classList.add('active')
    }

}