package dev.rayh;

import dev.rayh.domain.ConsoleColors;

public class ConsolePrinter {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    private static final String BASE_STRING = "%s[%s] -> %s%s\n";

    static void ERROR(String who, String text){
        System.out.format(BASE_STRING, ConsoleColors.ANSI_RED, who, ConsoleColors.ANSI_RESET, text);
    }

    static void WARNING(String who, String text){
        System.out.format(BASE_STRING, ConsoleColors.ANSI_YELLOW, who, ConsoleColors.ANSI_RESET, text);
    }

    static void INFO(String who, String text){
        System.out.format(BASE_STRING, ConsoleColors.ANSI_BLUE, who, ConsoleColors.ANSI_RESET, text);
    }

    
    static void custom(String pattern, String... strings){
        System.out.format(pattern.concat("\n"),(Object[]) strings);
    }
}

    
