package com.example.coap.server;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.californium.core.CoapServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author : jiangzh
 * @program : com.example.coap.server
 * @description : CoAP启动Server
 * @date : 2019-09-23 15:40
 **/
@Slf4j
@Component
public class CoAPServerRunner implements ApplicationRunner {

  @Autowired
  private CoapServer coapServer;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    log.info("CoAP Server start ==================================================> ");
    coapServer.start();
  }

}
