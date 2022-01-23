package com.pardhu.demoWebsocket;

import dto.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WSService {

  private final SimpMessagingTemplate messagingTemplate;

  @Autowired
  public WSService(SimpMessagingTemplate messagingTemplate){
    this.messagingTemplate = messagingTemplate;
  }

  public void sendMessage(final String message){
    ResponseMessage res = new ResponseMessage(message);
    messagingTemplate.convertAndSend("/receive/message",res);
  }
  public void sendPrivateMessage(final String message, final String id){
    ResponseMessage res = new ResponseMessage(message);
    messagingTemplate.convertAndSendToUser(id,"/receive/private-message", res);
   }
   public void sendNotification(final String message) {
     ResponseMessage res = new ResponseMessage(message);
     messagingTemplate.convertAndSend("/receive/global-notification",res);
   }
  public void sendPrivateNotification(final String message,final String id) {
    ResponseMessage res = new ResponseMessage(message);
    messagingTemplate.convertAndSendToUser(id,"/receive/private-notification",res);
  }

}
