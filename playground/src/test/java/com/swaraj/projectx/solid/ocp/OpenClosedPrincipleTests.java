package com.swaraj.projectx.solid.ocp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class OpenClosedPrincipleTests {

    @Test
    void test_ocp_principle() {
        // class AccountService and NotificationService have separate responsibility

        NotifierService notifierService = new NotifierService(new EmailNotificationServiceImpl());
        notifierService.sendNotification();

        List<NotifierService> notifiers = new ArrayList<>();
        notifiers.add(new AdvancedNotifierService(new MobileNotificationServiceImpl()));
        notifiers.get(0).sendNotification();
    }
}
