var speed = 50;
var slowDown = false;
var category = 1;
var categories = ["Old Testament", "Book of Mormon", "Doctrine &amp; Covenants", "General Conference", "New Testament"];
function spin(){
    var pos = $(".spinner").css("background-position-y");
    if (parseInt(pos)>(300*categories.length)+150){
        pos = 150;
    };
    if (slowDown){
        speed--;
        if(speed <= 0){
           clearInterval(spinner);
           if(parseInt(pos)==150){
               category = 0;
           }
            setTimeout(function(){ $.redirect('/ScriptureTrivia/Game', {'category': categories[category]}); }, 2000);
        }
    }
    $(".spinner").css("background-position-y", parseInt(pos)+speed +"px");
}
var spinner = setInterval(function () {spin();}, 20);

function stop(){
    slowDown = true;
}