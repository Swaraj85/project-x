package com.swaraj.projectx.solid.ocp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
 class EmailNotificationServiceImpl implements NotificationService {
    @Override
    public void send() throws NotificationException {
        log.info("sending notification via email");
    }
}
