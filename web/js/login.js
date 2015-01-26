
function onFormSubmit(event)
{
  //prevent Default functionality
  event.preventDefault();

  console.log("In login button clicked...");
  //hang on event of form with id=myform
  var creds = {
    userName: $("#userName").val(),
    password: $("#password").val()
  };
  //do your own request an handle the results
  $.ajax({
    url: 'http://localhost:8080/JavaSpringJbossRestFulPlayground_war_exploded/login',
    type: 'post',
    dataType: 'html',
    contentType: 'application/json',
    data: JSON.stringify(creds),
    success: function(data) {
      console.log("submit was successful");
      document.write(data);
    },
    error: function(data)
    {
      console.log("There was an error submitting the form: "+data.msg);
    }
  });
    console.log("submitted form");

}


$(document).ready(function()
{
  console.log("In document ready...");
  $("#loginForm").submit(onFormSubmit);
  console.log('setup completed in ready function.');
});
