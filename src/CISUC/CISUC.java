package CISUC;

import java.io.*;
import java.util.ArrayList;

public class CISUC implements Serializable{
    private ArrayList<Investigator> investigators;
    private ArrayList<InvestigationTeam> investigationTeams;
    private ArrayList<Work> works;

    private CISUC() {
        investigators = new ArrayList<>();
        investigationTeams = new ArrayList<>();
        works = new ArrayList<>();
    }
    public static void main(String[] args) {
        CISUC cisuc = new CISUC();
        cisuc.run();
    }

    public void run() {
        readFromFile("pessoas.csv");
        System.out.println(investigators);
    }

    public void readFromFile(String file) {
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null) {
                String[] split = line.split(",");
                investigators.add(new Student(split[0],split[1],split[2],split[3],split[4],split[5]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
