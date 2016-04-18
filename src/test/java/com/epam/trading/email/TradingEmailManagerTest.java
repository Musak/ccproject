package com.epam.trading.email;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.subethamail.wiser.Wiser;
import org.subethamail.wiser.WiserMessage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by musak on 14/04/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/email-context.xml")
public class TradingEmailManagerTest {

    @Autowired
    private TradingEmailManager tradingEmailManager;

    private static Wiser wiser;

    @Before
    public void setup() {
        wiser = new Wiser();
        wiser.setPort(25555);
        wiser.start();
    }

    @After
    public void tearDown() {
        wiser.stop();
    }

    @Test
    public void shouldSendEmailWithParams() {
        Map<String, Object> model = new HashMap<>();
        model.put("name", "My TEST Name");
        String template = "templates/test-template.vm";

        tradingEmailManager.sendMail(model, template);

        List<WiserMessage> messages = wiser.getMessages();
        Assert.assertEquals(1, messages.size());
    }

}
