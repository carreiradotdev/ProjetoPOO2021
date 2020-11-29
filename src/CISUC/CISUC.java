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
        cisuc.firstRun();
    }

    public void firstRun() {
        readFromFile("efetive.csv", "publicacoes.csv", "pessoas.csv");
        System.out.println(investigators);
        System.out.println(works);
    }

    public void readFromFile(String efetive, String publicacoes, String pessoas) {
        String line;
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(efetive));
            BufferedReader br2 = new BufferedReader(new FileReader(publicacoes));
            BufferedReader br3 = new BufferedReader(new FileReader(pessoas));
            while((line = br1.readLine()) != null) {
                String[] split = line.split(",");
                investigators.add(new EfetiveMember(split[0],split[1],split[2],split[3],Long.parseLong(split[4])));
            }
            while((line = br2.readLine()) != null) {
                String[] split = line.split(",");
                works.add(new Chapter(split[0],split[1],split[2],Integer.parseInt(split[3]),split[4],Integer.parseInt(split[5]),split[6],Integer.parseInt(split[7]),split[8],Integer.parseInt(split[9]),Integer.parseInt(split[10])));
            }
            while((line = br3.readLine()) != null) {
                String[] split = line.split(",");
                investigators.add(new Student(split[0], split[1], split[2], split[3], split[4], split[5]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
