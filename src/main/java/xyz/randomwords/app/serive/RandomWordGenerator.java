package xyz.randomwords.app.serive;

import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.randomwords.app.configuration.DixConfig;
import xyz.randomwords.app.entites.ResponseObject;
import xyz.randomwords.app.entites.Tuple2;
import xyz.randomwords.app.utils.MathUtils;

import javax.swing.plaf.synth.SynthTabbedPaneUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class RandomWordGenerator {

    private static int MAX_TIMEOUT = 5;
    private static int MAX_ATTEMPTS = 20;

    private DixConfig dix;

    @Autowired
    public void setDix( DixConfig dix ){
        this.dix = dix;
    }

    public ResponseObject generate( String beginningWith, int length ) {

        long startTime = System.currentTimeMillis();
        Double confidence = 1.0;
        Tuple2<String, Double> tuple = recursive( beginningWith, length, confidence, -1, 0 );
        return new ResponseObject( tuple.c1(), ( System.currentTimeMillis()-startTime )/1000.0, tuple.c2() );
    }

    private Tuple2<String, Double> recursive(String word, int wordLen, Double confidence, long startTime, int attempts) {

        if( word.length() == wordLen ) {
            return new Tuple2<>( word, confidence );
        }
        if( startTime == -1 ) {
            startTime = System.currentTimeMillis();
        }
        if( attempts > MAX_ATTEMPTS || ( System.currentTimeMillis()-startTime ) > MAX_TIMEOUT*1000  ) {
            return null;
        }

        List<String> alphaSet = new ArrayList<>( Arrays.asList( "abcdefghijklmnopqrstuvwxyz".split("") ) );

        while( alphaSet.size() > 0 ) {

            int i = MathUtils.random(0, alphaSet.size() - 1);
            String alpha = alphaSet.get(i);
            final String k1 =  word.length()>0 ? word.charAt(word.length() - 1) + "" : null;

            if( word.length() == 0 || (
                    ( dix.markov( k1, alpha ) / dix.maxMarkovComb() > 0.2
                    || dix.markov( k1, alpha ) / dix.dixLen() > 0.06 )
                    && dix.position( alpha, word.length()+"" ) / dix.alphaFrequency( alpha ) > 0.05 ) ) {

                Tuple2<String, Double> tuple;
                String newWord = "";
                tuple = recursive(word + alpha, wordLen,
                        confidence+ word.length() == 0 ? 1 : ( 0.1 + dix.markov( k1, alpha ) / dix.maxMarkovComb() ),
                        startTime, attempts+1 );
                newWord = tuple.c1();
                confidence = tuple.c2();

                if( newWord == null || newWord.length() == wordLen )
                    return new Tuple2<>( newWord, confidence );
            }
            alphaSet.remove( alpha );
        }
        return new Tuple2<>( word, confidence );
    }
}
