$(document).ready(function(){
    var toggle = true;
    
    $("#mybutton").click(function(){  
        var div = $("#green");
        if(toggle) {                       // if user hasn't pressed the 'more info' button,
            div.css({                      // a new 'info' container will appear
                opacity:'0.4', 
                visibility:"visible"
            }).animate({ 
                left: '20%',
                height: '150px',
                width: '70%',
                opacity: '1'
            }, "slow");                
            div.animate({
                height: '300px', 
            }, "slow");
            toggle = false;
        }
        else {                          // Close 'info' container
            div.animate({
                height: '100px',
                opacity: '0.4'
            }, "slow");
            div.animate({
                left: '0',
                height: '100px',
                width: '100px',
                opacity: '0'
            },"slow");
            toggle = true;                      // NEED TO ADD VISIBILITY:HIDDEN !! How to do this without affecting transition?
        }        
    });
}); 
        
       
