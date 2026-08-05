package ui_framework.DriverPackage;

public abstract class DriverManager {
            private static DriverFactory webDriverManager;

            public static DriverFactory getWebDriverManager() {
                if (webDriverManager != null) {
                    return webDriverManager;
                }
                synchronized (DriverManager.class) {
                    if (webDriverManager == null) {
                        try {
                            webDriverManager = (DriverFactory) Class.forName("ui_framework.DriverPackage.DriverFactory").newInstance();
                        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return webDriverManager;
            }
        }
