package top.chopper.MyFilter;

import lombok.Data;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import java.util.Arrays;
import java.util.List;

/*
   @Author:ROBOT
   @DateTime:2025/9/24 15:41
   @Version:1.0.0
   @Description:
   */
@Component
public class MyGatewayFilterFactory extends AbstractGatewayFilterFactory<MyGatewayFilterFactory.MyGatewayFilterFactoryConfig> {


    /** 具体实现逻辑 */
    @Override
    public GatewayFilter apply(MyGatewayFilterFactory.MyGatewayFilterFactoryConfig config) {
        return new GatewayFilter() {
            /** 这里的exchange还是一样能够获取到系统的上下文信息,chain为过滤链 */
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                ServerHttpRequest request = exchange.getRequest();
                System.out.println("自定义条件过滤器创建成功，开始进行过滤处理~~~~  key="+config.getKey() + "====value" + config.getValue());
                System.out.println("keys"+request.getQueryParams());
                System.out.println("value="+request.getQueryParams().get(config.getKey()));
                if (request.getQueryParams().containsKey(config.getKey()) && request.getQueryParams().getFirst(config.key).equals(config.getValue())) {
                    return chain.filter(exchange); // 放行
                }
                // 配置失效
                exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
                return exchange.getResponse().setComplete(); // 放行失败，返回处理结果
            }
        };
    }
    /** 短链接写法 */
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("key","value");
    }

    public MyGatewayFilterFactory(){
        super(MyGatewayFilterFactoryConfig.class);
    }

    @Data
    public static class MyGatewayFilterFactoryConfig{
        private String key; // 设定一个状态值， 当state时才可以进行访问
        private String value; // 当value = open时才进行放行
    }

}

