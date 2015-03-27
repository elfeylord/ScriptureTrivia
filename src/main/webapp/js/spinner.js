var speed = 50;
var slowDown = false;
var category;
var finalPos = -1;
var counter = -1;
var startCountDown = false;
var spinsound = new Audio("sounds/spinner.wav");
    spinsound.play();
var loopsound = setInterval(function () {spinsound.currentTime = 0;}, 1000);
var categories = ["Doctrine &amp; Covenants", "Book of Mormon", "General Conference", "New Testament", "Old Testament"];
function spin(){
    var pos = $(".spinner").css("background-position-y");
    if (parseInt(pos)>(300*categories.length)+150){
        pos = 150;
    };
    if (slowDown){
        if (finalPos == -1){
            finalPos = (parseInt(parseInt(pos)/parseInt(300)) * 300) + 100;
            counter = (finalPos - parseInt(pos)) / speed
        }
        if (parseInt(pos) - (speed*(speed+1)/2 - 300 * categories.length) <= finalPos + ((speed/2)+1) &&
             parseInt(pos) - (speed*(speed+1)/2 - 300 * categories.length) >= finalPos - ((speed/2)+1)   ){
         
           startCountDown = true; 
        }
        if (startCountDown)
            speed--;
        if(speed <= 0){
            
           clearInterval(spinner);
           clearInterval(loopsound);
           
           category = ((finalPos-100)/300)-1;
            setTimeout(function(){ $.redirect('/ScriptureTrivia/Game', {'category': categories[category]}); }, 2000);
        }
    }
    $(".spinner").css("background-position-y", parseInt(pos)+speed +"px");
}
var spinner = setInterval(function () {spin();}, 20);

function stop(){
    slowDown = true;
}
