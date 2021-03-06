var countdown = 15;
var result;
var songnames = ["TheGoldenPlates.mp3", "TheHandcartSong.mp3", "scrpowr.mp3"];
var randomPick = Math.floor(Math.random() * songnames.length);
var song = new Audio("sounds/"+ songnames[randomPick]);
var wrongsound = new Audio("sounds/wrong.mp3");
var rightsound = new Audio("sounds/Correct-answer.mp3");
    song.play();
    song.loop = true;
function checkAnswer(id){
    if(!$('#ans'+id).attr("disabled")){
        if(id != (check/5)-3 && !result){
            //If wrong
            $('#ans'+id).css("background-color", "#FF4C3C");
            wrong();
        }
        else{
            //If correct
            if(!result)
            correct();
        }
        showAnswer();
    }
    
}
function wrong(){
    result="wrong";
    song.pause();
    wrongsound.play();
    setTimeout(function(){ $.redirect('GameStatus', {'correct': "false"}); }, 2000);
}

function correct(){ 
    result="correct";
    song.pause();
    rightsound.play();
    setTimeout(function(){ $.redirect('GameStatus', {'correct': "true"}); }, 2000);
}
function showAnswer(){
    clearInterval(timer);
    var newCheck = (check/5)-3;
    $('#ans'+newCheck).css("background-color", "#71E834");
    $('.ans').attr( "disabled", "true" );
}

var timer = setInterval(function() {
    $("#countdown").html(countdown);
    countdown--;
    if(countdown <= -1){
        wrong();
        $('.ans').css("background-color", "#FF4C3C")
        showAnswer();
        clearInterval(timer);
    }
}, 1000);
