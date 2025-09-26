package top.chopper.IRoutePredicateFactory;

/*
   @Author:ROBOT
   @DateTime:2025/8/13 23:34
   @Version:1.0.0
   @Description: 自定义路由断言
   自定义会员等级userType,按照钻/金/银和yml配置id会员等级以适配是否可以访问。
   */

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.lang.annotation.After;
import org.springframework.cloud.gateway.handler.predicate.*;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
@Component
public class MyRoutePredicateFactory extends AbstractRoutePredicateFactory<MyRoutePredicateFactory.Config> {
    
    
   public MyRoutePredicateFactory(){
       super(Config.class);
       System.out.println("创建成功..........");
    }

    @Override
    public List<String> shortcutFieldOrder() {
       // 自定义shortcut 字段名称
        return Collections.singletonList("userType");
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                String userType = serverWebExchange.getRequest().getQueryParams().getFirst("userType");
                if(userType==null) return false;
                if(userType.equals(config.getUserType())){
                    return true;
                }
                return false;
            }

            @Override
            public Object getConfig() {
                return config;
            }

            @Override
            public String toString() {
                return String.format("After: %s", config.getUserType());
            }
        };
    }
    
    @Getter@Setter
    public static class Config {
        @NotNull
        private String userType; // 会员等级

        public void setUserType(String userType) {
            this.userType = userType;
        }
    }
}
