var timeout = 180;
var clockTick = 0;

function setFocus(field) {
   if (field != null) {
      document.getElementById(field.value).focus();
   }
}

function enterToTab(e) {

   if (!e) {
      e = window.event;
   }

   if (e.target != null) {
      source = e.target
   } else if (window.event != null && window.event.srcElement != null) {
      source = window.event.srcElement;
   }

   if (e.keyCode == 13) {
      elementsDescription = '';
      elements = document.forms[0].elements;
      i = 0;
      while (i < elements.length && elements[i].id != source.id) {
         i++;
      }
      if (i < (elements.length - 1)) {
         document.getElementById(elements[i + 1].id).focus();
      }
      return false;
   }
   return true;
}

function redirect(url) {
   window.location = url;
   return false;
}

function applyMask(source, mask) {
   var i = source.value.length;
   var output = mask.substring(0, 1);
   var text = mask.substring(i)
   if (text.substring(0, 1) != output) {
      source.value += text.substring(0, 1);
   }
}

function confirmOperation(message) {
   return confirm(message);
}

function showSplashScreen(splashScreen) {
   var div = document.getElementById(splashScreen);
   if (div) {
      div.style.visibility = 'visible';
   }
}

function hideSplashScreen(splashScreen) {
   var div = document.getElementById(splashScreen);
   if (div) {
      div.style.visibility = 'hidden';
   }
}

function alterSplashScreenVisibility(splashScreen) {
   var div = document.getElementById(splashScreen);
   if (div) {
      alert('visibility: ' + div.style.visibility);
      div.style.visibility = (div.style.visibility == 'hidden' ? 'visible' : 'hidden');
   }
}

function clickButton(buttonId) {
   document.getElementById(buttonId).click();
}

function clickButtonByPressingEnter(e, buttonId) {

   if (!e) {
      e = window.event;
   }

   if (e.target != null) {
      source = e.target
   } else if (window.event != null && window.event.srcElement != null) {
      source = window.event.srcElement;
   }

   if (e.keyCode == 13) {
      clickButton(buttonId);
      return false;
   } else {
      return true;
   }
}