package com.example.coap.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.Utils;
import org.eclipse.californium.elements.exception.ConnectorException;

/**
 * @author : jiangzh
 * @program : com.example.coap.client
 * @description : CoAP的Client代码
 * @date : 2019-09-23 15:57
 **/
public class CoAPClient {

  public static void main(String[] args) throws URISyntaxException, ConnectorException, IOException {
    // 待连接的CoAP Server
    URI coapServerUri = new URI("coap://127.0.0.1:5683/jiangzh/v1");

    CoapClient coapClient = new CoapClient(coapServerUri);
    // 发送get请求
//    CoapResponse coapResponse = coapClient.get();
    // post请求，format：50 = application/json类型
    CoapResponse coapResponse = coapClient.post("{\"a\":\"b\"}",50);
    // 将结果打印出来
    if (coapResponse!=null) {
      System.err.println("coapResponse code : "+coapResponse.getCode());
      System.err.println("coapResponse options : "+coapResponse.getOptions());
      System.err.println("coapResponse response : "+coapResponse.getResponseText());
      System.err.println(Utils.prettyPrint(coapResponse));
    }else{
      System.err.println("CoAP Server no response.");
    }
    // 不要忘记关闭连接哦
    coapClient.shutdown();
  }

}
