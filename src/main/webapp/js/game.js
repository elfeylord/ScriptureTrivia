function checkAnswer(id){
    if(!$('#ans'+id).attr("disabled")){
        if(id != 0){
            //If wrong
            $('#ans'+id).css("background-color", "#f2dede")
            setTimeout(function(){window.location.href = "FacebookParser"}, 2000);
        }
        else{
            //If correct
            setTimeout(function(){ $.redirect('/ScriptureTrivia/Category', {'correct': true}); }, 2000);
        }
        $('#ans0').css("background-color", "#dff0d8");
        $('.ans').attr( "disabled", "true" );
    }
    
}