package top.chopper.apis;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import top.chopper.entities.Pay;
import top.chopper.entities.Result;
/*
   @Author:ROBOT
   @DateTime:2025/2/4 17:37
   @Version:1.0.0
   @Description:
   */
@FeignClient("cloud-gateway9527")
//@FeignClient("cloud-payment-service")
public interface PayFeignApi {
    @PostMapping("/pay")
    public Result<String> addPay(@RequestBody Pay pay);

    @GetMapping("/pay/byId")
    public Result<String> deletePay(@RequestParam("id") Integer id);

    @PutMapping("/pay")
    public Result<String> updatePay(@RequestBody Pay pay);

    @GetMapping("/pay/byId")
    public Result<Pay> getPayById(Integer id);

    @GetMapping("/pay/all")
    public Result getAll();

    @GetMapping("/pay/circuit/{id}")
    public String myCircuit(@PathVariable("id") Integer id);

    @GetMapping("/pay/bulkhead/{id}")
    public String myBulkhead(@PathVariable("id") Integer id);

    @GetMapping("/pay/ratelimter/{id}")
    public String myRatelimt(@PathVariable("id") Integer id);

    @GetMapping("/pay/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id);

    @GetMapping("/pay/gateway/get/{id}")
    public Result<Pay> getByIdGateway(@PathVariable("id") Integer id);

    @GetMapping("/pay/gateway/getInfo")
    public String getInfoByConsulGateWay();

    @GetMapping("/pay/gateway/filter/addRequestHeader")
    public String handleGateWayFilter();

    @GetMapping("/sca/name")
    public String getName();
}
