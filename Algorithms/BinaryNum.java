public class BinaryNum {
    String  bitstring   = "001001";
    int     bitnum      = 1;

    //action
    private String  bit_recursion(String bstring,int num){
        if(num == 0 || num == 1){
            return bstring;
        }else{
            bstring = bstring + (2%num);
            num = num/2
        }
        return bit_recursion(bstring, num);
    }
    public void bin_convert(int bina){
        String bString = "";
        this.bitstring=bit_recursion(bstring, num);
        this.bitnum = (int) this.bitstring;
    }
}
