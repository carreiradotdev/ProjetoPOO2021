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
        cisuc.reader();
        cisuc.run();
    }

    private void firstRun() {
        readFromFile("EfetiveMemberList.csv", "ArticleMagazineList.csv", "BookChapterList.csv", "ArticleConferenceList.csv", "StudentList.csv", "BookConferenceList.csv", "InvestigationTeamList.csv");
    }

    private void run() {
        do {
            System.out.println("1: Inicial Run.");
            System.out.println("2: Shows CISUC indicators.");
            System.out.println("3: List Team Work.");
            System.out.println("4: List Team Members.");
            System.out.println("5: List Investigation Teams.");
            System.out.println("6: Print works of the lastest 5 years.");
            System.out.println("7: Print all researchers from CISUC.");
            System.out.println("8. Print all works from CISUC.");
            System.out.println("9. test writer");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    firstRun();
                    break;
                case 2:
                    if (works.isEmpty()) {
                        System.out.println("There are no works in record.");
                        break;
                    }
                    option2();
                    break;
                case 3:
                    if (works.isEmpty()) {
                        System.out.println("There are no works in record.");
                        break;
                    }
                    System.out.println("1: Adaptive Computation\n" +
                            "2: Cognitive and Media Systems\n" +
                            "3: Evolutionary and Complex Systems\n" +
                            "4: Information Systems\n" +
                            "5: Communications and Telematics\n" +
                            "6: Software and Systems Engineering");
                    System.out.print("Enter your choice: ");
                    option3();
                    break;
                case 4:
                    if (investigators.isEmpty()) {
                        System.out.println("There are no researchers in our Database.");
                        break;
                    }
                    System.out.println("1: Adaptive Computation\n" +
                            "2: Cognitive and Media Systems\n" +
                            "3: Evolutionary and Complex Systems\n" +
                            "4: Information Systems\n" +
                            "5: Communications and Telematics\n" +
                            "6: Software and Systems Engineering");
                    System.out.print("What team? ");
                    option4();
                    break;
                case 5:
                    listTeamWork();
                    break;
                    case 6:
                    if (works.isEmpty()) {
                        System.out.println("There are no works in record.");
                        break;
                    }
                    print5years();
                    break;
                case 7:
                    printInvestigators();
                    break;
                case 8:
                    printWorks();
                    break;
                case 9:
                    writer();
                    break;
                case 10:
                    reader();
                    break;
                case 11:
                    System.out.println(investigators);
                default:
                    break;
            }
        } while (true) ;
    }

    private void option4() {
        int team = sc.nextInt();
        switch (team) {
            case 1: listTeamMembers(getTeam("AC")); break;
            case 2: listTeamMembers(getTeam("CMS")); break;
            case 3: listTeamMembers(getTeam("ECOS")); break;
            case 4: listTeamMembers(getTeam("IS")); break;
            case 5: listTeamMembers(getTeam("LCT")); break;
            case 6: listTeamMembers(getTeam("SSE")); break;
            default:
                System.out.println("Wrong input!");
                break;
        }
    }

    private void option2() {
        countMembers();
        countWorks();
    }

    private void option3() {
        int team = sc.nextInt();
        switch (team) {
            case 1:
                for (Work work : works) {
                    if (work.getYearPublished() >= 2015 && work.getTeam().getAcronym().equalsIgnoreCase("AC")) {
                        System.out.println(work);
                    }
                }
                break;
            case 2:
                for (Work work : works) {
                    if (work.getYearPublished() >= 2015 && work.getTeam().getAcronym().equalsIgnoreCase("CMS")) {
                        System.out.println(work);
                    }
                }
                break;
            case 3:
                for (Work work : works) {
                    if (work.getYearPublished() >= 2015 && work.getTeam().getAcronym().equalsIgnoreCase("ECS")) {
                        System.out.println(work);
                    }
                }
                break;
            case 4:
                for (Work work : works) {
                    if (work.getYearPublished() >= 2015 && work.getTeam().getAcronym().equalsIgnoreCase("IS")) {
                        System.out.println(work);
                    }
                }
                break;
            case 5:
                for (Work work : works) {
                    if (work.getYearPublished() >= 2015 && work.getTeam().getAcronym().equalsIgnoreCase("LCT")) {
                        System.out.println(work);
                    }
                }
                break;
            case 6:
                for (Work work : works) {
                    if (work.getYearPublished() >= 2015 && work.getTeam().getAcronym().equalsIgnoreCase("SSE")) {
                        System.out.println(work);
                    }
                }
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public void readFromFile(String efetiveFile, String magazineFile, String chapterFile, String conferenceFile, String studentFile, String bookArticleConferenceFile, String InvestigationTeamFile) {
        String line;
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(efetiveFile));
            BufferedReader br2 = new BufferedReader(new FileReader(magazineFile));
            BufferedReader br3 = new BufferedReader(new FileReader(chapterFile));
            BufferedReader br4 = new BufferedReader(new FileReader(conferenceFile));
            BufferedReader br5 = new BufferedReader(new FileReader(studentFile));
            BufferedReader br6 = new BufferedReader(new FileReader(bookArticleConferenceFile));
            BufferedReader br7 = new BufferedReader(new FileReader(InvestigationTeamFile));
            br7.readLine();
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
            br1.readLine();
            while ((line = br1.readLine()) != null) {
                String[] split = line.split(",");
                investigators.add(new EfetiveMember(split[0],split[1],getTeam(split[2]),split[3],Long.parseLong(split[4])));
            }
            br2.readLine();
            while ((line = br2.readLine()) != null) {
                String[] split = line.split(",");
                works.add(new ArticleMagazine(split[0], split[1], split[2], getTeam(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]), split[6], Integer.parseInt(split[7]), split[8]));
            }
            br3.readLine();
            while ((line = br3.readLine()) != null) {
                String[] split = line.split(",");
                works.add(new BookChapter(split[0], split[1], split[2], getTeam(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]), split[6], Integer.parseInt(split[7]), split[8], Integer.parseInt(split[9]), Integer.parseInt(split[10])));
            }
            br4.readLine();
            while ((line = br4.readLine()) != null) {
                String[] split = line.split(",");
                works.add(new ArticleConference(split[0], split[1], split[2], getTeam(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]), split[6], Integer.parseInt(split[7]), split[8]));
            }
            br5.readLine();
            while ((line = br5.readLine()) != null) {
                String[] split = line.split(",");
                investigators.add(new Student(split[0], split[1], getTeam(split[2]), split[3], split[4], split[5]));
            }
            br6.readLine();
            while ((line = br6.readLine()) != null) {
                String[] split = line.split(",");
                works.add(new BookArticleConference(split[0], split[1], split[2], getTeam(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]), split[6], Integer.parseInt(split[7]), split[8], Integer.parseInt(split[9])));
            }
            System.out.println("LEITURA CONCLUÍDA.");
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
            if(work.getType() == (Work.TYPE_BOOK)) { b++; }
        }
        System.out.printf("Article Conference Count: %d\n" + "Magazine Article Count: %d\n" + "Article Conference Books Count: %d\n" + "Chapter Book Count: %d\n" + "Book Count: %d\n",ac,am,bac,bc,b);
    }

    private void printInvestigators() {
        if (investigators.isEmpty()) {
            System.out.println("There are no researchers in record.");
        }
        for (Investigator investigator: investigators) {
            try {
                InvestigationTeam team = getTeam(investigator);
                System.out.printf("| %d | %s | %s | %s |\n", investigator.getType(), investigator.getName(), investigator.getEmail(), team.getAcronym());
            } catch (NullPointerException e) {
                System.out.println("erro.");  //TODO: acabar esta função.
            }
        }
    }

    private void printWorks() {
        if (works.isEmpty()) {
            System.out.println("There are no works in record.");
        }
        for (Work work : works) {
            try {
                Investigator investigator = getInvestigator(work);
                System.out.println(work.getTitle() + ", written by " + investigator.getPublicationName() + " in " + work.getYearPublished() + ".");
            } catch (NullPointerException e) {
                System.out.println("ERROR.");  //TODO: acabar esta função.
            }
        }
    }

    private void writer() {
        try{
            FileOutputStream writeData1 = new FileOutputStream("investigators.ser");
            FileOutputStream writeData2 = new FileOutputStream("investigationTeams.ser");
            FileOutputStream writeData3 = new FileOutputStream("works.ser");
            ObjectOutputStream writeStream1 = new ObjectOutputStream(writeData1);
            ObjectOutputStream writeStream2 = new ObjectOutputStream(writeData2);
            ObjectOutputStream writeStream3 = new ObjectOutputStream(writeData3);
            writeStream1.writeObject(investigators);
            writeStream2.writeObject(investigationTeams);
            writeStream3.writeObject(works);
            writeStream1.flush();
            writeStream2.flush();
            writeStream3.flush();
            writeStream1.close();
            writeStream2.close();
            writeStream3.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void reader() {
        try {
            FileInputStream readData2 = new FileInputStream("investigationTeams.ser");
            FileInputStream readData1 = new FileInputStream("investigators.ser");
            FileInputStream readData3 = new FileInputStream("works.ser");
            ObjectInputStream readStream2 = new ObjectInputStream(readData2);
            ObjectInputStream readStream1 = new ObjectInputStream(readData1);
            ObjectInputStream readStream3 = new ObjectInputStream(readData3);
            ArrayList<Investigator> investigatorsFromFile = (ArrayList<Investigator>) readStream1.readObject();
            ArrayList<InvestigationTeam> investigationTeamsFromFile = (ArrayList<InvestigationTeam>) readStream2.readObject();
            ArrayList<Work> worksFromFile = (ArrayList<Work>) readStream3.readObject();
            investigators = investigatorsFromFile;
            investigationTeams = investigationTeamsFromFile;
            works = worksFromFile;
            readStream1.close();
            readStream2.close();
            readStream3.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void print5years() { //TODO: ver se esta merda está broken
        int year = 2020;
        int ascii = 65;
        int type = 0;
        do {
            for (Work work : works) {
                if (work.getType() == type) {
                    do {
                        if (work.getImpactValue() == ascii) {
                            do {
                                if (work.getYearPublished() == year) {
                                    Investigator investigator = getInvestigator(work);
                                    System.out.printf("| %d | | %s | %d | %s | %s |\n", work.getType(), work.getImpactValue(), work.getYearPublished(), work.getTitle(), investigator.getPublicationName());
                                }
                                year--;
                            } while (year != 2014);
                            year = 2020;
                        }
                        ascii++;
                    } while (ascii != 68);
                    ascii = 65;
                }
            }
            type++;
        } while (type != 5);
    }

    private void listTeamMembers(InvestigationTeam investigationTeam) {
        if (investigators.isEmpty()) {
            System.out.println("There are no works in record.");
        }
        for (Investigator investigator: investigators) {
            try {
                if (investigator.getInvestigationGroup() == investigationTeam) {
                    System.out.println(investigator);
                }
            } catch (NullPointerException e) {
                System.out.println("ERROR.");  //TODO: acabar esta função.
            }
        }
            System.out.println("DONE LISTING.");
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
            if (team.getAcronym() == investigator.getInvestigationGroup().getAcronym()) {
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
