package com.redhat.eipractice.karaf_cxf_playpen;

import org.apache.camel.builder.RouteBuilder;

public class OrderServiceRouteBuilder extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    
    from("{{cxfOrderEndpoint}}")
      .to("seda:incomingOrders")
      .transform(constant("OK"))
      ;

    from("seda:incomingOrders")
      .to("{{dispensingValidationQueue}}")
      ;
  }

}
