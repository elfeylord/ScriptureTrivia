var countdown = 15;
var bookofmormon_song = new Audio("sounds/TheGoldenPlates.mp3");
    bookofmormon_song.play()
    bookofmormon_song.loop = true;
function checkAnswer(id){
    if(!$('#ans'+id).attr("disabled")){
        if(id != 0){
            //If wrong
            $('#ans'+id).css("background-color", "#f2dede")
            wrong();
        }
        else{
            //If correct
            correct();
        }
        showAnswer();
    }
    
}
function wrong(){
    setTimeout(function(){window.location.href = "FacebookParser"}, 2000);
}

function correct(){ 
    setTimeout(function(){ $.redirect('/ScriptureTrivia/Category', {'correct': true}); }, 2000);
}
function showAnswer(){
    console.log("colormepink");
    $('#ans0').css("background-color", "#dff0d8");
    $('.ans').attr( "disabled", "true" );
}

var timer = setInterval(function() {
    $("#countdown").html(countdown);
    countdown--;
    if(countdown <= -1){
        wrong();
        $('.ans').css("background-color", "#f2dede")
        showAnswer();
        clearInterval(timer);
    }
}, 1000);
