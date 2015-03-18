var countdown = 15;
var bookofmormon_song = new Audio("sounds/TheGoldenPlates.mp3");
    bookofmormon_song.play()
    bookofmormon_song.loop = true;
function checkAnswer(id){
    if(!$('#ans'+id).attr("disabled")){
        if(id != 0){
            //If wrong
            $('#ans'+id).css("background-color", "red")
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
    setTimeout(function(){ $.redirect('/ScriptureTrivia/GameStatus', {'correct': "false"}); }, 2000);
}

function correct(){ 
    setTimeout(function(){ $.redirect('/ScriptureTrivia/GameStatus', {'correct': "true"}); }, 2000);
}
function showAnswer(){
    $('#ans0').css("background-color", "green");
    $('.ans').attr( "disabled", "true" );
}

var timer = setInterval(function() {
    $("#countdown").html(countdown);
    countdown--;
    if(countdown <= -1){
        wrong();
        $('.ans').css("background-color", "red")
        showAnswer();
        clearInterval(timer);
    }
}, 1000);
