package ui_framework.DriverPackage;

public abstract class DriverManager {
    private static DriverFactory webDriverManager;
    public static DriverFactory getWebDriverManager() {
        if (webDriverManager != null) {
            //Added this for optimization
            return webDriverManager;
        }
        synchronized (DriverManager.class) {
            if (webDriverManager != null) {
                //added this check for first time initialization to stop multiple thread creating multiple driver manager
                return webDriverManager;
            }
            try {
                DriverFactory newObject = (DriverFactory) Class.forName("ui_framework.DriverPackage.DriverFactory").newInstance();
                webDriverManager = newObject;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return webDriverManager;
    }
}
