package dev.rayh;

import dev.rayh.domain.ConsoleColors;

public class ConsolePrinter {
    
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
