package CISUC;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CISUC implements Serializable {
    private ArrayList<Investigator> investigators;
    private ArrayList<InvestigationTeam> investigationTeams;
    private ArrayList<Work> works;

    public static final Scanner sc = new Scanner(System.in);

    private CISUC() {
        investigators = new ArrayList<>();
        investigationTeams = new ArrayList<>();
        works = new ArrayList<>();
    }

    public static void main(String[] args) {
        CISUC cisuc = new CISUC();
        cisuc.run();
    }

    public void firstRun() {
        readFromFile("EfetiveMemberList.csv", "ArticleMagazineList.csv", "BookChapterList.csv", "BookConferenceList.csv", "StudentList.csv", "ArticleConferenceList.csv", "InvestigationTeamList.csv");
        printWorks();
        printInvestigators();
        print5years();
        listTeamWork();
        countMembers();
        countWorks();
        return;
    }

    public void run() {
        do {
            System.out.println("1: Inicial Run.");
            System.out.println("2: Shows CISUC indicators.");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    firstRun();
                    break;
                case 2:
                    option2();
                    break;
                case 3:
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:

                    }
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (true) ;
    }

    private void option2() {
        countMembers();
        countWorks();
    }

    public void readFromFile(String efetiveFile, String magazineFile, String chapterFile, String conferenceFile, String studentFile, String articleConferenceFile, String InvestigationTeamFile) {
        String line;
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(efetiveFile));
            BufferedReader br2 = new BufferedReader(new FileReader(magazineFile));
            BufferedReader br3 = new BufferedReader(new FileReader(chapterFile));
            BufferedReader br4 = new BufferedReader(new FileReader(conferenceFile));
            BufferedReader br5 = new BufferedReader(new FileReader(studentFile));
            BufferedReader br6 = new BufferedReader(new FileReader(articleConferenceFile));
            BufferedReader br7 = new BufferedReader(new FileReader(InvestigationTeamFile));
            while ((line = br7.readLine()) != null) {
                String[] split = line.split(",");
                boolean found = false;
                for (Investigator i: investigators) {
                    if (i.getName().equalsIgnoreCase(split[2])) {
                        found = true;
                        }
                    investigationTeams.add(new InvestigationTeam(split[0], split[1], getInvestigator(split[2])));
                    }
                if (!found) {
                    EfetiveMember temp = new EfetiveMember(split[2],null,null,null,0);
                    investigators.add(temp);
                    investigationTeams.add(new InvestigationTeam(split[0], split[1], getInvestigator(split[2])));
                    investigators.remove(temp);
                }
            }
            System.out.println("Leitura bem-sucedida");
            while ((line = br1.readLine()) != null) {
                String[] split = line.split(",");
                investigators.add(new EfetiveMember(split[0],split[1],getTeam(split[2]),split[3],Long.parseLong(split[4])));
            }
            System.out.println("Leitura bem-sucedida");
            while ((line = br2.readLine()) != null) {
                String[] split = line.split(",");
                works.add(new ArticleMagazine(split[0], split[1], split[2], Integer.parseInt(split[3]), Integer.parseInt(split[4]), split[5], Integer.parseInt(split[6]), split[7]));
            }
            System.out.println("Leitura bem-sucedida");
            while ((line = br3.readLine()) != null) {
                String[] split = line.split(",");
                works.add(new BookChapter(split[0], split[1], split[2], Integer.parseInt(split[3]), Integer.parseInt(split[4]), split[5], Integer.parseInt(split[6]), split[7], Integer.parseInt(split[8]), Integer.parseInt(split[9])));
            }
            System.out.println("Leitura bem-sucedida");
            while ((line = br4.readLine()) != null) {
                String[] split = line.split(",");
                works.add(new ArticleConference(split[0], split[1], split[2], Integer.parseInt(split[3]), Integer.parseInt(split[4]), split[5], Integer.parseInt(split[6]), split[7]));
            }
            System.out.println("Leitura bem-sucedida");
            while ((line = br5.readLine()) != null) {
                String[] split = line.split(",");
                investigators.add(new Student(split[0], split[1], getTeam(split[2]), split[3], split[4], split[5]));
            }
            System.out.println("Leitura bem-sucedida");
            while ((line = br6.readLine()) != null) {
                String[] split = line.split(",");
                works.add(new ArticleConference(split[0], split[1], split[2], Integer.parseInt(split[3]), Integer.parseInt(split[4]), split[5], Integer.parseInt(split[6]), split[7]));
            }
            System.out.println("Leitura bem-sucedida");
            System.err.println("LEITURA CONCLUÍDA.");
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void countMembers() {
        int students = 0; int efetives = 0;
        for (Investigator investigator: investigators) {
            if(investigator.getType() == (Investigator.TYPE_STUDENT)) {
                students++;
            } else {
                efetives++;
            }
        }
        int total = students + efetives;
        System.out.printf("CURRENT COUNT OF STUDENTS: %d\n" +
                          "CURRENT COUNT OF EFETIVE RESEARCHERS: %d\n" +
                          "TOTAL COUNT OF RESEARCHERS: %d\n", students, efetives, total);
    }

    public void countWorks() {
        int ac = 0; int am = 0; int bac = 0; int bc = 0; int b = 0;
        for (Work work: works) {
            if(work.getType() == (Work.TYPE_ARTICLE_CONFERENCE)) { ac++; }
            if(work.getType() == (Work.TYPE_ARTICLE_MAGAZINE)) { am++; }
            if(work.getType() == (Work.TYPE_BOOK_ARTICLE_CONFERENCE)) { bac++; }
            if(work.getType() == (Work.TYPE_BOOK_CHAPTER)) { bc++; }
            else { b++; }
        }
        System.out.printf("Article Conference Count: %d\n" + "Magazine Article Count: %d\n" + "Article Conference Books Count: %d\n" + "Chapter Book Count: %d\n" + "Book Count: %d\n",ac,am,bac,bc,b);
    }

    private void printInvestigators() {
        if (investigators.isEmpty()) {
            System.out.println("There are no works in record.");
        }
        System.err.println("LISTING INVESTIGATORS IN RECORD:");
        for (Investigator investigator: investigators) {
            try {
                InvestigationTeam i = getTeam(investigator);
                System.out.printf("| %s | %s | %s |\n", investigator.getName(), investigator.getEmail(), i.getAcronym());
            } catch (NullPointerException e) {
                System.out.println("ERROR.");  //TODO: acabar esta função.
            }
        }
        System.err.println("DONE LISTING.");
    }

    private void printWorks() {
        if (works.isEmpty()) {
            System.out.println("There are no works in record.");
        }
        System.err.println("LISTING WORKS IN RECORD:");
        for (Work work : works) {
            try {
                Investigator investigator = getInvestigator(work);
                System.out.println(work.getTitle() + ", written by " + investigator.getPublicationName() + " in " + work.getYearPublished() + ".");
            } catch (NullPointerException e) {
                System.out.println("ERROR.");  //TODO: acabar esta função.
            }
        }
        System.err.println("DONE LISTING.");
    }

    private void print5years() {
        if (works.isEmpty()) {
            System.out.println("There are no works in record.");
        }
        System.out.println("Presenting Work after 2015...");
        for (Work work : works) {
            if (work.getYearPublished() >= 2015) {
                Investigator investigator = getInvestigator(work);
                System.out.printf("| %d | %s | %s |\n",work.getYearPublished(),work.getTitle(),investigator.getPublicationName());

            }
            return;
        }
    }

    private Investigator getInvestigator(String name) {
        for (Investigator investigator : investigators) {
            if (investigator.getName().equalsIgnoreCase(name)) {
                return investigator;
            }
        }
        return null;
    }

    private Investigator getInvestigator(Work work) {
        for (Investigator investigator : investigators) {
            if (investigator.getName().equalsIgnoreCase(work.getAuthor())) {
                return investigator;
            }
        }
        return null;
    }

    private InvestigationTeam getTeam(String group) {
        for(InvestigationTeam team : investigationTeams) {
            if (team.getAcronym().equalsIgnoreCase(group)) {
                return team;
            }
        }
        return null;
    }

    private InvestigationTeam getTeam(Investigator investigator) {
        for(InvestigationTeam team : investigationTeams) {
            if (team == investigator.getInvestigationGroup()) {
                return team;
            }
        }
        return null;
    }

    private void listTeamWork() {
        System.out.println("Equipas de Investigação");
        for (InvestigationTeam investigationTeam : investigationTeams) {
            try {
                System.out.printf("| %s | %s | %s |\n", investigationTeam.getAcronym(), investigationTeam.getGroup(), investigationTeam.getHeadLeader().getName());
            } catch (NullPointerException e) {
                System.out.println("Researcher doesn't exist in database.");
            }
        }
    }
}
