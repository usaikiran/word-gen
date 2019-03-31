package xyz.randomwords.app.utils;

public class MathUtils {

    public static int random( int minInclusive, int maxInclusive ){
        return minInclusive + (int)( Math.random() * ( maxInclusive - minInclusive ) );
    }
}
