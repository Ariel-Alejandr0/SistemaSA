import React, { useEffect, useState } from "react";
import useWebSocket, { ReadyState } from "react-use-websocket";

const WebSocket = () => {
    const [messageHistory, setMessageHistory] = useState([]);

    const { sendMessage, lastMessage, readyState } = useWebSocket(
        "ws://localhost:8080/ws",
        {
            onOpen: () => console.log("Connected to WebSocket"),
            onClose: () => console.log("Disconnected from WebSocket"),
            onMessage: (message) => {
                setMessageHistory((prev) => [...prev, message.data]);
            },
            onError: (event) => console.error("WebSocket error:", event),
            shouldReconnect: (closeEvent) => true, // Automatically reconnect
        }
    );

    useEffect(() => {
        if (lastMessage !== null) {
            setMessageHistory((prev) => [...prev, lastMessage.data]);
        }
    }, [lastMessage]);

    const handleClickSendMessage = () => sendMessage("Hello, World!");

    const connectionStatus = {
        [ReadyState.CONNECTING]: "Connecting",
        [ReadyState.OPEN]: "Open",
        [ReadyState.CLOSING]: "Closing",
        [ReadyState.CLOSED]: "Closed",
        [ReadyState.UNINSTANTIATED]: "Uninstantiated",
    }[readyState];

    return (
        <div>
            <button
                onClick={handleClickSendMessage}
                disabled={readyState !== ReadyState.OPEN}
            >
                Send Message
            </button>
            <span>The WebSocket is currently {connectionStatus}</span>
            <ul>
                {messageHistory.map((message, idx) => (
                    <li key={idx}>{message}</li>
                ))}
            </ul>
        </div>
    );
};

export default WebSocket;
