package com.epam.trading.email;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by musak on 14/04/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/email-context.xml")
public class TradingEmailManagerTest {

    @Autowired
    private TradingEmailManager tradingEmailManager;

    @Test
    public void shouldSendEmail() {
        tradingEmailManager.sendMail();
    }

}
