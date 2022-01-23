package com.pardhu.demoWebsocket;

import dto.Message;
import dto.ResponseMessage;
import java.security.Principal;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessageController {

  @MessageMapping("/message")
  @SendTo("/receive/message")
  public ResponseMessage getMessage(final Message message) throws InterruptedException {
    Thread.sleep(1000);
    System.out.println("recived message");
    return new ResponseMessage(HtmlUtils.htmlEscape(message.getMessageContent()));
  }

  @MessageMapping("/private-message")
  @SendToUser("/receive/private-message")
  public ResponseMessage getPrivateMessage(final Message mess, final Principal principal) throws InterruptedException {
    Thread.sleep(1000);
    System.out.println("recived message private"+principal.getName());
    return new ResponseMessage(HtmlUtils.htmlEscape("Sending personal message to user"+principal.getName()+": "+ mess.getMessageContent()));
  }

}
