const publicKey ="BIssLw6qwhRo7m3MYG1heK8dIHw11OKytikkGiNgj-Y-lQuCPe6dV_F2gpi11yo6xwR4c6lBm1RgE2LPUdh1ttE";

function urlBase64ToUint8Array(base64String) {
    const padding = "=".repeat((4 - base64String.length % 4) % 4);
    const base64 = (base64String + padding)
      .replace(/\-/g, "+")
      .replace(/_/g, "/");

    const rawData = window.atob(base64);
    const outputArray = new Uint8Array(rawData.length);

    for (let i = 0; i < rawData.length; ++i) {
      outputArray[i] = rawData.charCodeAt(i);
    }
    return outputArray;
}



function submitForm(){

    console.log('inside submitForm function');

    if('serviceWorker' in navigator){
        send().catch(err => console.error(err));
    }
    else{
        document.getElementById('messageSpace').innerHTML = "Your browser doesn't support service workers";
    }

}



//register the service worker, register our push api, send the notification
async function send(){
    //register service worker
    console.log('inside send function');

    const register = await navigator.serviceWorker.register('/sw.js', {
        scope: '/'
    });

    await navigator.serviceWorker.ready;

    //register push
    const subscription = await register.pushManager.subscribe({
        userVisibleOnly: true,
        //public vapid key
        applicationServerKey: urlBase64ToUint8Array(publicKey)
    });

    var usr_email = document.getElementById('email').value;

    var obj = {
            email : usr_email,
            subscriptionData : subscription
    }
    console.log(obj);
    console.log('payload ready')
    //Send push notification
    await fetch("/subscribe", {
        method: "POST",
        body: JSON.stringify(obj),
        headers: {
            "content-type": "application/json"
        }
    });

    document.getElementById('messageSpace').innerHTML = "Welcome to BreakTime ! You have been successfully registered :)";
}