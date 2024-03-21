package com.swaraj.projectx.solid.ocp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class NotifierService {
    private NotificationService notificationService;

    public NotifierService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void sendNotification() {
        try {
            notificationService.send();
        } catch (NotificationException e) {
            log.error("unable to send notification", e);
        }
    }
}

class AdvancedNotifierService extends NotifierService {
    public AdvancedNotifierService(NotificationService notificationService) {
        super(notificationService);
    }
}
