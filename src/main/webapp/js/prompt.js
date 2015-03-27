function confirmStart(name, id){
    bootbox.dialog({
      message: "Begin game with " + name + "?",
      title: "Friend Challenge",
      buttons: {
        success: {
          label: "Yes",
          className: "btn-success",
          callback: function() {
            $.redirect("CreateGame", {'id': id, 'name': name});
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
function confirmCont(name, gameId){
    bootbox.dialog({
      message: "Continue game with " + name + "?",
      title: "Friend Challenge",
      buttons: {
        success: {
          label: "Yes",
          className: "btn-success",
          callback: function() {
            $.redirect("LoadGame", {'gameId': gameId});
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
