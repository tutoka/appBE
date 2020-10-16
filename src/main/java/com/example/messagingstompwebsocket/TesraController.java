package com.example.messagingstompwebsocket;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// public class TesraController {
//     @RequestMapping(value="/sa",method= RequestMethod.GET)
//     public String sayHello(@RequestParam Integer id){
//         return "id:"+id;
//     }
// }
import java.util.concurrent.atomic.AtomicLong;

// import com.example.client.AddWarn;
import com.example.client.MyStompSessionHandler;
// import com.example.client.StompClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

@RestController
@Configuration
public class TesraController {
	@Value("${server.port}")
	private String port;
	// @Autowired
	// private StompClient stompClient;
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	// private final AddWarn addWarn = new AddWarn();
	// private static String URL = "ws://localhost:8380/gs-guide-websocket";

    WebSocketClient client = new StandardWebSocketClient();
    StompSessionHandler sessionHandler = new MyStompSessionHandler();
	private StompSession session;
	private String warn_type = null;
	private String warn_content = null;
	private String warn_state = null;
	
	int warn_id = 0;// 这里的warn_id不是数据库中的warn_id
    public void stompClient() throws Exception {
	// public TesraController() throws Exception {
		String URL = "ws://localhost:" + port + "/gs-guide-websocket";
        System.out.print(port);

		final WebSocketStompClient stompClient = new WebSocketStompClient(client);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());
		session = stompClient.connect(URL, sessionHandler).get();
		// StompHeaders
        // System.out.print("init send");
        // new Scanner(System.in).nextLine(); // Don't close immediately.
    }
    // public void sendMsg(final Warn warn) {
	// 	System.out.print("sendMsg");
	// 	synchronized (session) {
	// 		session.send("/app/hello", warn);
	// 	}
    // }
	@GetMapping("/warn")
	public Warn Warn(
		@RequestParam(value = "warn_type", defaultValue = "World") final String warn_type, 
		@RequestParam(value = "warn_content", defaultValue = "World") final String warn_content,
		@RequestParam(value = "warn_state", defaultValue = "未读") final String warn_state
	) throws Exception {
				
		this.warn_type = new String(warn_type.getBytes("ISO-8859-1"), "gbk");
		this.warn_content = new String(warn_content.getBytes("ISO-8859-1"), "gbk");
		this.warn_state = new String(warn_state.getBytes("ISO-8859-1"), "gbk");
		Warn warn = new Warn(String.format(template, warn_type), String.format(template, warn_content), String.format(template, warn_state));
		String warnString = "{\"warn_id\": " + warn_id + ", \"warn_type\": \"" + warn_type
		 + "\", \"warn_content\": \"" + warn_content + "\", \"warn_state\": \"" + warn_state + "\"}";

		stompClient();
		synchronized (session) {
			// session.send("/app/hello", warnString);
			session.send("/topic/greetings", warnString);
			session.disconnect();
		}
		// sendMsg(warn);
		warn_id++;

		return warn;
	}
}