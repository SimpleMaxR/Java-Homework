package hw3;

public class MyStringBuilder1 {
    private String str;
    public MyStringBuilder1(String s) {
        this.str = s;
    }

    public MyStringBuilder1 append(MyStringBuilder1 s){
        this.str += s.str;
        return this;
    }

    public MyStringBuilder1 append(int i){
        this.str += i;
        return this;
    }

    public int length(){
        return this.str.length();
    }

    public char charAt(int index){
        return this.str.charAt(index);
    }

    public MyStringBuilder1 toLowerCase(){
        this.str = this.str.toLowerCase();
        return this;
    }

    public MyStringBuilder1 substring(int begin, int end){
        this.str = this.str.substring(begin, end);
        return this;
    }

    public String toString(){
        return this.str;
    }
}
