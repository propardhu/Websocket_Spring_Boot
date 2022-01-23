package com.pardhu.demoWebsocket;

import com.sun.security.auth.UserPrincipal;
import java.security.Principal;
import java.util.Map;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

public class ClientHandshakeHandler extends DefaultHandshakeHandler {

  private final Logger logger = LoggerFactory.getLogger(ClientHandshakeHandler.class);

  @Override
  protected Principal determineUser(ServerHttpRequest req, WebSocketHandler weHandler, Map<String, Object> attributes) {
    final String randId = UUID.randomUUID().toString();
    logger.info("{}",attributes.get("name"));
    logger.info("User opened client unique ID {}, ipAddress {}",randId,req.getRemoteAddress());
    return new UserPrincipal(randId);
  }

}
