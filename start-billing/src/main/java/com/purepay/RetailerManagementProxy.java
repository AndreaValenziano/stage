package com.purepay;

import com.purepay.entity.Product;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by AndreaValenziano on 07/06/18.
 */
@Component
@FeignClient(name = "api-gateway")
@RibbonClient(name="retailer-management")
public interface RetailerManagementProxy {

    @GetMapping("/retailer-management/product/{code}")
    Product getProduct(@PathVariable(value = "code") int productUniqueCode);

}
