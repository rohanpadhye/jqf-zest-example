package examples;

public class A implements B {

    @Override
    public int foo(int i) {

        int j;

        if(i%2==0)
            j = i*2;
        else if(i%3==0)
            j = i/3;
        else
            j = i*4;
        return j;

    }

    public int foo1(int i) {

        int j;

        if(i%2==0)
            j = i*2;
        else if(i%3==0)
            j = i/3;
        else
            j = i*4;
        return j;

    }
}
