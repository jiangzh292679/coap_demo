package com.example.coap.resources;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.eclipse.californium.core.server.resources.Resource;

/**
 * @author : jiangzh
 * @program : com.example.coap.resources
 * @description : Resource演示
 * @date : 2019-09-25 10:17
 **/
@Slf4j
public class HelloWorldResource extends CoapResource {

  /**
  * @Description: 初始化构造方法
  * @Param: [name]
  * @return:
  * @Author: jiangzh
  * @Date: 2019/9/25
  */
  public HelloWorldResource(String name){
    super(name);
  }

  @Override
  public void handleGET(CoapExchange exchange) {

    Request request = exchange.advanced().getRequest();

    List<String> uriPath = request.getOptions().getUriPath();

    log.info("handleGET coapExchange:{} , request:{}, uriPath:{}", exchange.advanced() , request, uriPath);

    super.handleGET(exchange);
  }

  @Override
  public void handlePOST(CoapExchange exchange) {
    Request request = exchange.advanced().getRequest();
    String payload = request.getPayloadString();
    List<String> uriPath = request.getOptions().getUriPath();

    log.info("handlePOST coapExchange:{} , request:{}, uriPath:{}, payload:{}", exchange.advanced() , request, uriPath, payload);

    super.handleGET(exchange);
  }

  @Override
  public void handlePUT(CoapExchange exchange) {
    super.handlePUT(exchange);
  }

  @Override
  public void handleDELETE(CoapExchange exchange) {
    super.handleDELETE(exchange);
  }

  @Override
  public void handleFETCH(CoapExchange exchange) {
    super.handleFETCH(exchange);
  }

  @Override
  public void handlePATCH(CoapExchange exchange) {
    super.handlePATCH(exchange);
  }

  @Override
  public void handleIPATCH(CoapExchange exchange) {
    super.handleIPATCH(exchange);
  }

}
