package top.chopper.MyFilter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/*
   @Author:ROBOT
   @DateTime:2025/9/24 14:54
   @Version:1.0.0
   @Description: 注意这里已经实现了GlobalFilter接口在程序启动的时候，会自动的扫描实现该接口的类，并且视频@Component注解后自动注入到
   spring 容器中，所以这里已经全局生效，无需再进行任何配置

   */
@Component
@Slf4j
public class MyGlobalFilter implements GlobalFilter, Ordered {
    private static final String BEGIN_VISIT_TIME = "begin_visit_time";
    /**
     * 自定义全局过滤器执行逻辑
     */

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put(BEGIN_VISIT_TIME,System.currentTimeMillis()); // 记录请求开始时间
        // 这里的then()是在过滤器先把请求交给下一个过滤器链去处理（可能最终到达下游服务，
        // 等前面 filter 执行完并且响应返回后，再执行指定逻辑。
        return chain.filter(exchange).then(Mono.fromRunnable(()->{
            Long beginVisitTime = (Long) exchange.getAttributes().get(BEGIN_VISIT_TIME);
            if(beginVisitTime!=null){
                log.info("访问接口主机:{}",exchange.getRequest().getURI().getHost());
                log.info("访问接口端口号:{}",exchange.getRequest().getURI().getPort());
                log.info("访问接口URL:{}",exchange.getRequest().getURI().getPath());
                log.info("访问接口参数:{}",exchange.getRequest().getURI().getRawQuery());
                log.info("访问接口耗时:{}ms",System.currentTimeMillis() - beginVisitTime);
            }
        }));
    }

    @Override
    // 返回数值越小，优先级越高~~~ 可以为负数
    public int getOrder() {
        return -100;
    }
}
