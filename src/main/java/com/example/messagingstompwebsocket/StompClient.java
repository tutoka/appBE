// // package com.example.client;

// // import java.util.Scanner;
// // import java.util.concurrent.ExecutionException;
// // import java.util.concurrent.TimeUnit;
// // import java.util.concurrent.TimeoutException;

// // import org.springframework.context.annotation.Bean;
// // import org.springframework.context.annotation.Configuration;
// // import org.springframework.messaging.converter.MappingJackson2MessageConverter;
// // import org.springframework.messaging.simp.stomp.StompSessionHandler;
// // import org.springframework.web.socket.client.WebSocketClient;
// // import org.springframework.web.socket.client.standard.StandardWebSocketClient;
// // import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
// // import org.springframework.web.socket.messaging.WebSocketStompClient;
// // import org.springframework.messaging.simp.stomp.StompSession;

// // @Configuration
// // @EnableWebSocketMessageBroker
// // public class StompClient {

// //     @Bean
// //     public WebSocketClient webSocketClient() {
// //         final WebSocketClient client = new StandardWebSocketClient();

// //         final WebSocketStompClient stompClient = new WebSocketStompClient(client);
// //         stompClient.setMessageConverter(new MappingJackson2MessageConverter());
// //         session = stompClient.connect(URL, sessionHandler).get();

// //         final StompSessionHandler sessionHandler = new MyStompSessionHandler();
// //         stompClient.connect("ws://localhost:8080/gs-guide-websocket", sessionHandler);
// //         return client;
// //     }
// // }

// package com.example.client;

// import java.util.Scanner;
// import java.util.concurrent.ExecutionException;
// import java.util.concurrent.TimeUnit;
// import java.util.concurrent.TimeoutException;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.messaging.converter.MappingJackson2MessageConverter;
// import org.springframework.messaging.simp.stomp.StompSessionHandler;
// import org.springframework.web.socket.client.WebSocketClient;
// import org.springframework.web.socket.client.standard.StandardWebSocketClient;
// import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
// import org.springframework.web.socket.messaging.WebSocketStompClient;
// import org.springframework.messaging.simp.stomp.StompSession;

// /**
//  * Stand alone WebSocketStompClient.
//  *  Not Used
//  */
// @Configuration
// @EnableWebSocketMessageBroker
// public class StompClient {
//     private static String URL = "ws://localhost:8080/gs-guide-websocket";
//     WebSocketClient client = new StandardWebSocketClient();
//     StompSessionHandler sessionHandler = new MyStompSessionHandler();
//     private StompSession session;
//     public StompClient() throws Exception {
//         WebSocketStompClient stompClient = new WebSocketStompClient(client);
//         stompClient.setMessageConverter(new MappingJackson2MessageConverter());
//         session = stompClient.connect(URL, sessionHandler).get();
//         System.out.print("init send");
//         // new Scanner(System.in).nextLine(); // Don't close immediately.
//     }
//     // @Bean
//     // public void sendMsg(String msg) {
//     //     System.out.print("sendMsg");
//     //     session.send("/topic/greeting", "msg");
//     // }

// }
