/**
 * Created by mcunningham on 1/26/2015.
 */

function editCustomerButtonClicked()
{
    console.log("toggling the readonly inputs");
    // toggle the readonly's...
    $(".toggleReadonly").readOnly(false);
}

$(document).ready(function()
{
    console.log("in the ready function...");
   $("#editCustomerButton").click(editCustomerButtonClicked);
});