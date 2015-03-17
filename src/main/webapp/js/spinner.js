var speed = 50;
var slowDown = false;
function spin(){
    if (slowDown){
        speed--;
        if(speed <= 0){
           clearInterval(spinner);
            setTimeout(function(){ window.location = "/ScriptureTrivia/Game"; }, 2000);
        }
    }
    var pos = $(".spinner").css("background-position-y");
    $(".spinner").css("background-position-y", parseInt(pos)+speed +"px");
}
var spinner = setInterval(function () {spin();}, 20);
function stop(){
    slowDown = true;
}