package com.purepay;

import com.purepay.entity.Payment;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by AndreaValenziano on 22/05/18.
 */
@RestController
@EnableAutoConfiguration
public class CheckLimitsController {



    @PostMapping("/check-day-limits")
    public boolean checkDayLimits(@RequestBody Payment payment) {
        return (payment.getPrice() <= Limits.DAY.getMaxAmount()) ? true : false;
    }

    @PostMapping("/check-month-limits")
    public boolean checkMonthLimits(@RequestBody double sum) {

        return (sum <= Limits.MONTH.getMaxAmount()) ? true : false;

    }


}
