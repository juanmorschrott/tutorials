"use strict";

$(document).ready(function () {
    var stompClient = null;

    connect();

    $("#send").click(function (e) {
        e.preventDefault();
        stompClient.send("/app/broadcast", {}, JSON.stringify({'text': $("#message-input").val(), 'from': ""}));
        $("#message-input").val("");
    });

    function connect() {
        var socket = new SockJS("/ws");
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/broadcast', function (message) {
                var $chatMessage = $("<div class='chat-message'></div>").append(JSON.parse(message.body).text + "<br>");
                $("#chat").append($chatMessage);
                if ($(".chat-message").length >= 14) {
                    $("#chat > .chat-message")[0].remove();
                }
            });
        });
    }
});

