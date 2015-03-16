function confirmStart(name, id){
    bootbox.dialog({
      message: "Begin game with " + name + "?",
      title: "Friend Challenge",
      buttons: {
        success: {
          label: "Yes",
          className: "btn-success",
          callback: function() {
            window.location = "/ScriptureTrivia/Game";
          }
        },
        danger: {
          label: "No",
          className: "btn-default",
          callback: function() {
          }
        }
      }
    });
}
