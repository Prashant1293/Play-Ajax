if (window.console) {
  console.log("Welcome to Ajax-Play Assignment JavaScript!");
};

$(document).ready(function(){
         $('#btn').on("click",function(){
         jsRoutes.controllers.HomeController.signUp().ajax({
                      success: function(data){
                        $('#body').html(data);
                        },
                      error: function(){
                      $('#body').html("Bye-Bye");
                      alert("fail")
                    }

          })



      })

      $('#btn1').on("click",function(){
                jsRoutes.controllers.HomeController.signIn().ajax({
                            success: function(data){
                              $('#body').html(data);
                            },
                            error: function(){
                            $('#body').html("Bye-Bye");
                            alert("fail")
                          }

                })


            })



});

