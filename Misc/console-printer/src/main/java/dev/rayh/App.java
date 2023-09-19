package dev.rayh;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ConsolePrinter.ERROR("App", "deu algum erro...");
        ConsolePrinter.WARNING("Amigo", "quem avisa amigo é:");
        ConsolePrinter.INFO("info", "informação para mudar o mundo");
        ConsolePrinter.custom("%s para %s", "teste", "aff");

    
    }
}
