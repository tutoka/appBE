package com.example.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;

import com.example.messagingstompwebsocket.Warn;


/**
 * This class is an implementation for <code>StompSessionHandlerAdapter</code>.
 * Once a connection is established, We subscribe to /topic/warns and 
 * send a sample warn to server.
 * 
 * @author Kalyan
 *
 */
public class MyStompSessionHandler extends StompSessionHandlerAdapter {

    private Logger logger = LogManager.getLogger(MyStompSessionHandler.class);
    // private AddWarn addWarn = new AddWarn();

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        logger.info("New session established : " + session.getSessionId());
        // session.subscribe("/topic/greetings", this);
        // logger.info("Subscribed to /topic/greetings");
        // session.send("/app/hello", "addWarn.getWarn()");
        // logger.info("Warn sent to websocket server");
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        logger.error("Got an exception", exception);
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return Warn.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        Warn msg = (Warn) payload;
        logger.info("Received : " + msg.getWarnType() + " from : " + msg.getWarnContent());
    }

    /**
     * A warn instance.
     * @return instance of <code>Warn</code>
     */
    // private Warn getWarn() {
    //     Warn warn = new Warn();
    //     warn.setWarnId("Nicky");
    //     warn.setWarnType("Howdy!!");
    //     warn.setWarnContent("Nicky");
    //     warn.setWarnState("Howdy!!");
    //     return warn;
    // }
}