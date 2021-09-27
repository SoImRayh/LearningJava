public class modifiers {
    
    /*
    *static and public are diferent,
    *static methods can be calleds whitout objects are createds ex 'method();'
    *public methods only can be calleds by objects already createds ex 'obj.method()';
    */

    public static void init(){
        
    }
    //a 'public' modifier give permission on all classes/objects to use exemple:
    public static int age_sum(int x, int y){
        int sum;

        sum = x + y;

        return sum;
    }

    //A 'private' modifier give permission of only self-classes/objects (classes and objects out of arquive.java not can use)
    private static void sum_private(){
        System.out.println("isso aê");
        return;
    }
    public static void main(String[] args){
        int age;
        age=age_sum(10,30);
        sum_private();
        System.out.format("a sum of you age is: %d",age);
    }
}
