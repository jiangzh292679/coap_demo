package com.example.coap.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author : jiangzh
 * @program : com.example.coap.config.properties
 * @description : CoAP的各项属性配置
 * @date : 2019-09-23 14:48
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = CoAPServerProperties.COAP_SERVER_PROPERTIES_PREFIX)
public class CoAPServerProperties {

  public static final String COAP_SERVER_PROPERTIES_PREFIX="coap.server";

  private String coapHostName = "127.0.0.1";
  private int coapPort = 5683;
  private int coapTcpThreads = 10;
  private int coapTcpIdleTimeout = 3000;

}
