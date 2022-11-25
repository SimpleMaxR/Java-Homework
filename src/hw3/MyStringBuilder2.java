package hw3;

public class MyStringBuilder2 {
    private char[] chars;
    private int size;

    public MyStringBuilder2(){
        this.chars = new char[16];
        this.size = 0;
    }

    public MyStringBuilder2(char[] chars){
        this.chars = chars;
        this.size = chars.length;
    }

    public MyStringBuilder2(String s){
        this.chars = s.toCharArray();
        this.size = s.length();
    }

    public MyStringBuilder2 insert(int offset, MyStringBuilder2 s){
        if (offset < 0 || offset > this.size) {
            throw new IndexOutOfBoundsException();
        }
        if (this.size + s.size > this.chars.length) {
            this.resize(this.size + s.size);
        }
        for (int i = this.size - 1; i >= offset; i--) {
            this.chars[i + s.size] = this.chars[i];
        }
        for (int i = 0; i < s.size; i++) {
            this.chars[offset + i] = s.chars[i];
        }
        this.size += s.size;
        return this;
    }

    private void resize(int i) {
        char[] newChars = new char[i];
        for (int j = 0; j < this.size; j++) {
            newChars[j] = this.chars[j];
        }
        this.chars = newChars;
        this.size = i;
    }

    public MyStringBuilder2 reverse(){
        char [] newChars = new char[this.size];
        for (int i = 0; i < this.size / 2; i++) {
            newChars[i] = this.chars[this.size - 1 - i];
        }
        return new MyStringBuilder2(newChars);
    }

    public MyStringBuilder2 substring(int begin){
        if (begin < 0 || begin > this.size) {
            throw new IndexOutOfBoundsException();
        }
        char [] newChars = new char[this.size - begin];
        for (int i = begin; i < this.size; i++) {
            newChars[i - begin] = this.chars[i];
        }
        return new MyStringBuilder2(newChars);
    }

    public MyStringBuilder2 toUpperCase(){
        char [] newChars = new char[this.size];
        for (int i = 0; i < this.size; i++) {
            newChars[i] = Character.toUpperCase(this.chars[i]);
        }
        return new MyStringBuilder2(newChars);
    }
}
