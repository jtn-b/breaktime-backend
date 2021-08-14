self.addEventListener('push', function(event) {
  if (!(self.Notification && self.Notification.permission === 'granted')) {
    return;
  }

  var data = {};
  if (event.data) {
    data = event.data.json();
  }
  var title = data.title || "This is a title";
  var message = data.message || "This is the body";
  var iconLoc = "images/icon.png";

  var obj = {
  body : message,
  icon : iconLoc
  }
  self.registration.showNotification(title,obj);


//  notification.addEventListener('click', function() {
//    if (clients.openWindow) {
//      clients.openWindow('https://www.google.com');
//    }
//  });
//
});