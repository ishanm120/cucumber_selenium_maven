package DriverManager;

public enum Browser {

    CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge");

    private String value;

    Browser(String browserName){
        this.value= browserName;
    }

    public String getValue(){
        return value;
    }

}
