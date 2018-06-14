package com.purepay;

import com.purepay.entity.Payment;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by AndreaValenziano on 23/05/18.
 */
@Component
@FeignClient(name = "api-gateway")
@RibbonClient(name="check-limits")
public interface StartBillingServiceProxy {

    @PostMapping("/check-limits/check-day-limits")
    boolean checkDayLimits(@RequestBody Payment payment);

    @PostMapping("/check-limits/check-month-limits")
    boolean checkMonthLimits(@RequestBody double sum);


}
