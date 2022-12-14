// looping through tags that has class "p_ids" and getting the value of each tag
window.onload = function () {
    var p_ids = document.getElementsByClassName("p_ids");
    var p_quantity = document.getElementsByClassName("p_quantity");
    var p_id = '';
    var p_quan = '';
    for (var i = 0; i < p_ids.length; i++) {
        // concatenating the values of the tags
        p_id += p_ids[i].value + ',';
    }
    for (var i = 0; i < p_quantity.length; i++) {
        // concatenating the values of the tags
        p_quan += p_quantity[i].innerHTML + ',';
    }
    console.log(p_quan);
    console.log(p_id);
    // removing the last comma from the string
    p_id = p_id.substring(0, p_id.length - 1);
    p_quan = p_quan.substring(0, p_quan.length - 1);
    console.log(p_quan);
    console.log(p_id);
    // setting the value of the hidden input
    document.getElementById("pids").value = p_id;
    document.getElementById("pquantity").value = p_quan;
}