package org.test.appium.project.exception;

public class PlatformNotSupportedException extends IllegalStateException {

    public PlatformNotSupportedException(String reason) {
        super(reason);
    }
}
