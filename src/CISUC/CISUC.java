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
        readFromFile("EfetiveMemberList.csv", "ArticleConferenceList.csv", "BookChapterList.csv", "BookConferenceList.csv", "StudentList.csv", "ArticleMaganizeList.csv");
        System.out.println(works);
        System.out.println(investigators);
        printWorks();
        printInvestigators();
        totalMem();
        print5years();
    }

    public void readFromFile(String efetiveFile, String maganizeFile, String chapterFile, String conferenceFile, String studentFile, String articleMaganizeFile ) {
        String line;
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(efetiveFile));
            BufferedReader br2 = new BufferedReader(new FileReader(maganizeFile));
            BufferedReader br3 = new BufferedReader(new FileReader(chapterFile));
            BufferedReader br4 = new BufferedReader(new FileReader(conferenceFile));
            BufferedReader br5 = new BufferedReader(new FileReader(studentFile));
            BufferedReader br6 = new BufferedReader(new FileReader(articleMaganizeFile));
            while((line = br1.readLine()) != null) {
                String[] split = line.split(",");
                investigators.add(new EfetiveMember(split[0],split[1],split[2],split[3],Long.parseLong(split[4])));
            }
            System.out.println("Leitura bem-sucedida");
            while((line = br2.readLine()) != null) {
                String[] split = line.split(",");
                works.add(new ArticleMaganize(split[0],split[1],split[2],Integer.parseInt(split[3]),split[4],Integer.parseInt(split[5]),split[6],Integer.parseInt(split[7]),split[8]));
            }
            System.out.println("Leitura bem-sucedida");
            while((line = br3.readLine()) != null) {
                String[] split = line.split(",");
                works.add(new BookChapter(split[0],split[1],split[2],Integer.parseInt(split[3]),split[4],Integer.parseInt(split[5]),split[6],Integer.parseInt(split[7]),split[8],Integer.parseInt(split[9]),Integer.parseInt(split[10])));
            }
            System.out.println("Leitura bem-sucedida");
            while((line = br4.readLine()) != null) {
                String[] split = line.split(",");
                works.add(new ArticleConference(split[0], split[1], split[2], Integer.parseInt(split[3]), split[4], Integer.parseInt(split[5]), split[6], Integer.parseInt(split[7]), split[8]));
            }
            System.out.println("Leitura bem-sucedida");
            while((line = br5.readLine()) != null) {
                String[] split = line.split(",");
                investigators.add(new Student(split[0], split[1], split[2], split[3], split[4], split[5]));
            }
            System.out.println("Leitura bem-sucedida");
            while((line = br6.readLine()) != null) {
                String[] split = line.split(",");
                works.add(new ArticleMaganize(split[0], split[1], split[2], Integer.parseInt(split[3]), split[4], Integer.parseInt(split[5]), split[6], Integer.parseInt(split[7]), split[8]));
            }
            System.out.println("Leitura bem-sucedida");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void totalMem() {
        int total = investigators.size();
        System.out.println(total);
    }
/*    public void countMem() {
        for (Student student: )

    }*/

    private void printInvestigators() {
        if (investigators.isEmpty()) {
            System.out.println("There are no investigators.");
        }
        for (Investigator investigator: investigators) {
            System.out.printf("%s, \"%s\", %s\n" , investigator.getName(), investigator.getEmail(), investigator.getInvestigationGroup());
        }
    }

    private void printWorks() {
        if (works.isEmpty()) {
            System.out.println("There are no works in record.");
        }
        for (Work work: works) {
            Investigator investigator = getInvestigator(work);
            try {
                System.out.printf("%s\n", investigator.getPublicationName());
            } catch (NullPointerException e) {
                System.out.println("Investigador não existe");
            }
        }
    }

    private void print5years() {
        if (works.isEmpty()) {
            System.out.println("There are no works in record.");
        }
        for (Work work: works) {
            if (work.getYearPublished() >= 2015) {
                System.out.println(work);

            }
            return;
        }
    }

    private Investigator getInvestigator(Work work) {
        for (Investigator investigator: investigators) {
            if (investigator.getName().equalsIgnoreCase(work.getAuthor())) {
                return investigator;
            }
        }
        return null;
    }

}
