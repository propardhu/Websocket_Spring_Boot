package com.pardhu.demoWebsocket;

import dto.Message;
import dto.ResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessageController {

  @MessageMapping("/message")
  @SendTo("/do/message")
  public ResponseMessage getMessage(final Message message) throws InterruptedException {
    Thread.sleep(1000);
    System.out.println("recived message");
    return new ResponseMessage(HtmlUtils.htmlEscape(message.getMessageContent()));
  }

}
