function confirmStart(name, id){
    bootbox.dialog({
      message: "Begin game with " + name + "?",
      title: "Friend Challenge",
      buttons: {
        success: {
          label: "Yes",
          className: "btn-success",
          callback: function() {
            window.location = "/ScriptureTrivia/Game/"+id;
          }
        },
        danger: {
          label: "No",
          className: "btn-danger",
          callback: function() {
          }
        }
      }
    });
}
