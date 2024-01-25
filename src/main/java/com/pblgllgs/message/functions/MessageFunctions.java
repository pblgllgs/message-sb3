package com.pblgllgs.message.functions;
/*
 *
 * @author pblgl
 * Created on 25-01-2024
 *
 */

import com.pblgllgs.message.dto.AccountsMsgDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class MessageFunctions {

    public static final Logger log = LoggerFactory.getLogger(MessageFunctions.class);

    @Bean
    public Function<AccountsMsgDto,AccountsMsgDto> email(){
        return accountsMsgDto -> {
              log.info("sending email with details: " + accountsMsgDto.toString());
              return accountsMsgDto;
        };
    }

    @Bean
    public Function<AccountsMsgDto,Long> sms(){
        return accountsMsgDto -> {
            log.info("sending sms with details: " + accountsMsgDto.toString());
            return accountsMsgDto.accountNumber();
        };
    }
}
