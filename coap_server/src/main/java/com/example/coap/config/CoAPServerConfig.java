package com.example.coap.config;

import com.example.coap.config.properties.CoAPServerProperties;
import java.net.InetSocketAddress;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.network.CoapEndpoint;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : jiangzh
 * @program : com.example.coap.config
 * @description : CoAP服务端配置
 * @date : 2019-09-23 14:53
 **/
@Configuration
public class CoAPServerConfig {

  @Autowired
  private CoAPServerProperties serverProperties;

  @Bean
  public CoapServer coapServer(InetSocketAddress bindToAddress){
    CoapServer server = new CoapServer();

    // 构建CoAP Endpoint
    CoapEndpoint.Builder builder = new CoapEndpoint.Builder();
    builder.setNetworkConfig(NetworkConfig.getStandard());

    // UDP协议支持
    builder.setInetSocketAddress(bindToAddress);

    // TCP协议支持
//    TcpServerConnector connector = new TcpServerConnector(bindToAddress, serverProperties.getCoapTcpThreads(), serverProperties.getCoapTcpIdleTimeout());
//    builder.setConnector(connector);

    // 加入CoAP Endpoint支持
    server.addEndpoint(builder.build());

    return server;
  }

  @Bean
  public InetSocketAddress inetSocketAddress(){
    InetSocketAddress bindToAddress = new InetSocketAddress(serverProperties.getCoapHostName(), serverProperties.getCoapPort());
    return bindToAddress;
  }

}
