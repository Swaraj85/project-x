package com.swaraj.projectx.solid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AccountService {
    public void withdrawAmount(int amount) {
    }

    public void submitAmount(int amount) {
    }
}

class NotificationService {
    public void sendNotification(String medium) {
        if (medium.equalsIgnoreCase("mobile")) {
            // send logic via twillio
        }
        if (medium.equalsIgnoreCase("mail")) {
            // send logic via mail
        }
    }
}

class BankService {
    private AccountService accountService;
    private NotificationService notificationService;
}

public class SingleResponsibilityTests {
    @Test
    void test_srp_principle(){
        // class AccountService and NotificationService have separate responsibility
    }
}
