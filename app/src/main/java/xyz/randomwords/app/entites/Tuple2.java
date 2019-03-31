package xyz.randomwords.app.entites;

public class Tuple2<T1, T2> {

    private T1 component1;
    private T2 component2;

    public Tuple2( T1 component1, T2 component2 ){
        this.component1 = component1;
        this.component2 = component2;
    }

    public T1 c1(){
        return component1;
    }

    public void c1( T1 component1 ){
        this.component1 = component1;
    }

    public void c2( T2 component2 ){
        this.component2 = component2;
    }

    public T2 c2(){
        return component2;
    }
}
