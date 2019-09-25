package com.example.coap.resources;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
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

  /**
   * @Description: 处理GET请求
   * @Param: [exchange]
   * @return: void
   * @Author: jiangzh
   * @Date: 2019/9/25
   */
  @Override
  public void handleGET(CoapExchange exchange) {
    // 获取CoAP请求对象的封装
    // 注意：想访问CoapExchange对象，要先调用advanced方法
    Request request = exchange.advanced().getRequest();

    log.info("handleGET coapExchange:{}", exchange.advanced());
    log.info("handleGET request:{}", request);

    // 设置GET请求的返回值
    exchange.respond("RestResource invoker success");
  }

  /**
   * @Description: 处理POST请求
   * @Param: [exchange]
   * @return: void
   * @Author: jiangzh
   * @Date: 2019/9/25
   */
  @Override
  public void handlePOST(CoapExchange exchange) {
    Request request = exchange.advanced().getRequest();
    String payload = request.getPayloadString();
    List<String> uriPath = request.getOptions().getUriPath();

    log.info("handlePOST coapExchange:{}", exchange.advanced());
    log.info("handlePOST request:{}", request);
    log.info("handlePOST uriPath:{}", uriPath);
    log.info("handlePOST payload:{}", payload);

    // 设置POST请求的返回值
    exchange.respond(ResponseCode.CHANGED);
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
