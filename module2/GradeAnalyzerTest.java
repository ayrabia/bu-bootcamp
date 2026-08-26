package module2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GradeAnalyzerTest {
    
    @Test
    void calculateAverage_returnsZero_WhenListIsEmpty(){
        ArrayList<Integer> scores = new ArrayList<>();
        assertEquals(0.0, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    void calculateAverage_returnsCorrectAverage_forTypicalScores(){
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(80,90,100));
        assertEquals(90.0, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    void calculateAverage_returnsSingleValue_whenListHasOneItem(){
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(75));
        assertEquals(75.0, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    void calculateAverage_returnsDouble_notInteger(){
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(1, 2));
        assertEquals(1.5, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    void calculateAverage_handlesAllSameValues(){
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(88,88,88));
        assertEquals(88.0, GradeAnalyzer.calculateAverage(scores));
    }

    @Test
    void calculateExactAverage_usingTenScores(){
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(88,80,70,65,48,21,95,96,86,99));
        assertEquals(74.8, GradeAnalyzer.calculateAverage(scores));
    }
}
