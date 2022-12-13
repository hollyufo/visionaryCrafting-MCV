//
function addtoCart() {
    // getting the id of the product
    var productId = document.getElementById("p_id").value;
    // getting the quantity of the product user wants to buy
    var quantity = document.getElementById("quantity").value;
    // adding both value to a array
    var data = [productId, quantity];
    //checking if the cart json if exists
    if (localStorage.getItem("cart") == null) {
        // if not exists then create a new json
        var cart = {};
        // adding the array to the json as array
        cart[productId] = data;
        // saving the json to the local storage
        localStorage.setItem("cart", JSON.stringify(cart));
    } else {
        // if the json exists then get the json from the local storage
        var cart = JSON.parse(localStorage.getItem("cart"));
        // checking if the product id already exists in the json
        if (cart[productId] == null) {
            // if not exists then add the array to the json
            cart[productId] = data;
        }
        // saving the json to the local storage
        localStorage.setItem("cart", JSON.stringify(cart));
        console.log(cart);
    }

}
// when page is finished loading
window.onload = function () {
    // getting the quantity of the product
    var quantity = document.getElementById("p_quantity").innerHTML;
    // setting the max attribute of the quantity input
    document.getElementById("quantity").setAttribute("max", quantity);
}
