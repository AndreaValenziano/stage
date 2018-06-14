package com.purepay;

import com.purepay.entity.Sms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

/**
 * Created by AndreaValenziano on 25/05/18.
 */
@Repository
public interface SmsRepository extends JpaRepository<Sms,Integer> {

    Sms findFirstByMsisdnOrderByCreationTimeDesc( String msisdn);

    @Modifying
    @Transactional
    @Query("update Sms s set s.updateTime = :updateTime, s.receivedCode = :receivedCode where s.id = :id")
     Integer setSmsInfoById(@Param("updateTime") LocalDateTime updateTime,
                              @Param("receivedCode") Long receivedCode,
                              @Param("id") int id);

}
