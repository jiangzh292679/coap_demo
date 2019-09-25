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
 * @description : Restful风格的Resource处理器
 * @date : 2019-09-25 18:58
 **/
@Slf4j
public class RestResource extends CoapResource {

  /**
   * @Description: 初始化构造方法
   * @Param: [name]
   * @return:
   * @Author: jiangzh
   * @Date: 2019/9/25
   */
  public RestResource(String name) {
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

  /**
  * @Description: RESTful风格的核心内容修改
  * @Param: [name]
  * @return: org.eclipse.californium.core.server.resources.Resource
  * @Author: jiangzh
  * @Date: 2019/9/25
  */
  @Override
  public Resource getChild(String name) {
    return this;
  }
}
