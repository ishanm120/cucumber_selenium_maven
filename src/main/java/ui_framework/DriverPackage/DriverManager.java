package ui_framework.DriverPackage;

public abstract class DriverManager {
            private static final DriverFactory WEB_DRIVER_MANAGER = new DriverFactory();

            public static DriverFactory getWebDriverManager() {
                return WEB_DRIVER_MANAGER;
            }
        }
