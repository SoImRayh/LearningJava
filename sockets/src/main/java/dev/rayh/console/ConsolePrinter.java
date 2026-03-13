package dev.rayh.console;

public class ConsolePrinter {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";
    
    private static final String BASE_STRING = "%s[%s] -> %s%s\n";

    public static void ERROR(String who, String text){
        System.out.format(BASE_STRING, ANSI_RED, who, ANSI_RESET, text);
    }

    public static void WARNING(String who, String text){
        System.out.format(BASE_STRING, ANSI_YELLOW, who, ANSI_RESET, text);
    }

    public static void INFO(String who, String text){
        System.out.format(BASE_STRING, ANSI_BLUE, who, ANSI_RESET, text);
    }

    
    public static void custom(String pattern, String... strings){
        System.out.format(pattern.concat("\n"),(Object[]) strings);
    }
}