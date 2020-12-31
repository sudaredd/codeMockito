package app.mockito.testDouble.dummy.service;

import app.mockito.testDoubles.dummy.service.EmailService;

public class DummyEmailService implements EmailService {
    @Override
    public void sendEmail(String msg) {
        throw new AssertionError("Method is not implemented");
    }
}
