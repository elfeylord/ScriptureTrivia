var speed = 50;
var slowDown = false;
var category = "Old Testament";
function spin(){
    var pos = $(".spinner").css("background-position-y");
    if (parseInt(pos)>1650){
        pos = 150;
    };
    if (slowDown){
        speed--;
        if(speed <= 0){
           clearInterval(spinner);
           if(parseInt(pos)==150){
               category = "Book of Mormon";
           }
            setTimeout(function(){ $.redirect('/ScriptureTrivia/Game', {'category': category}); }, 2000);
        }
    }
    $(".spinner").css("background-position-y", parseInt(pos)+speed +"px");
}
var spinner = setInterval(function () {spin();}, 20);

function stop(){
    slowDown = true;
}