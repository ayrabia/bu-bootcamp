package module2;

import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {
    
    public static void main(String[] args){
        // Step 1: read scores from file
        // Step 2: calculate statistics
        // Step 3: write and print report

        
        String filename = "module2/scores.txt";

        //Reads scores from file
        ArrayList<Integer> scores = readScores(filename);
        System.out.println("Scores Loaded: " + scores);
        
        //Calculate average
        double average = calculateAverage(scores);
        System.out.println("Average Score: " + average);

        if(scores.isEmpty()){
            System.out.println("No valid scores found in the file.");
            writeReport(scores, average, 0, 0, 0, 0, 0, 0, 0, "module2/report.txt");
        }else{
            int highest = Integer.MIN_VALUE;
            int lowest = Integer.MAX_VALUE;

            for(int score : scores){
                if (score > highest){
                    highest = score;
                }
                if (score < lowest){
                    lowest = score;
                }
            }

            System.out.println("Highest Score: " + highest);
            System.out.println("Lowest Score: " + lowest);


            //count the grade bands
            int countA = 0;
            int countB = 0;
            int countC = 0;
            int countD = 0;
            int countF = 0;

            for(int score : scores){
                if(score >=90){
                    countA++;
                }else if (score >=80){
                    countB++;
                }else if (score >= 70){
                    countC++;
                }else if (score >= 60){
                    countD++;
                }else {
                    countF++;
                }
        }

        writeReport(scores, average, highest, lowest, countA, countB, countC, countD, countF, "module2/report.txt");

        }
        // find highest and lowest values
        
        
        

        
    }

    public static ArrayList<Integer> readScores(String filename){
        ArrayList<Integer> validScores = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;

            while((line = reader.readLine()) != null){
            
                line = line.trim();
                    
                //handle blank spaces
                if (line.isEmpty()){
                    continue;
                }

                try{
                    int score = Integer.parseInt(line);
                    validScores.add(score);
                }catch (NumberFormatException e){
                    System.out.println("Skipped invalid line: "+ line);
                }
                        
                
            }
        }catch (IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }

        return validScores;

            
    }

    public static double calculateAverage(ArrayList<Integer> scores){
        if (scores.isEmpty()){
            return 0.0;
        }

        double total = 0.0;
        for (int score: scores){
            total += score;
        }

        return total / scores.size();
    }

    public static void writeReport(ArrayList<Integer> scores, double avg, int high, int low, int countA, int countB, int countC, int countD, int countF, String outputFile){
        String summary = String.format(
            "===Grade Analaysis Report ===" +
            "Total valid scores processed: %d%n" +
            "Average score: %.2f%n" +
            "Highest score: %d%n " +
            "Lowest score: %d%n%n" +
            "Grade Distribution: %n" +
            "   A (90-100): %d%n" +
            "   B (80-89): %d%n" +
            "   C (70-79): %d%n" +
            "   D (60-69): %d%n" +
            "   F (below 60): %d%n",
            scores.size(), avg, high, low, countA, countB, countC, countD, countF
        );
        
        System.out.println("\n" + summary);

        //write to report.txt
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))){
            writer.write(summary);
            System.out.println("Report written to " + outputFile);
        }catch (IOException e){
            System.out.println("Error writing report file" + e.getMessage() );
        }
    }
    
}
