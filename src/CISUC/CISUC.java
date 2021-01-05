package CISUC;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

/**
 * The type Cisuc.
 */
public class CISUC implements Serializable {
    private ArrayList<Investigator> investigators;
    private ArrayList<InvestigationTeam> investigationTeams;
    private ArrayList<Work> works;

    /**
     * The constant sc.
     */
    public static final Scanner sc = new Scanner(System.in);

    /**
     * Boolean value of the only one-time run menu feature.
     */
    private boolean hasntRun = true;

    private CISUC() {
        investigators = new ArrayList<>();
        investigationTeams = new ArrayList<>();
        works = new ArrayList<>();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        CISUC cisuc = new CISUC();
        try {
            FileInputStream readData = new FileInputStream("CISUC.ser");
            ObjectInputStream readStream = new ObjectInputStream(readData);
            cisuc = (CISUC) readStream.readObject();
            readStream.close();
        } catch (Exception e) {
            System.out.println("Input file doesn't exist or is empty, no data in database.");
        }
        cisuc.run();
        //cisuc.debugMethod();
    }
    
    /**
     * Method that reads previously saved object file.
     */
    private void firstRun() {
        //oldReadFromFile("EfetiveMemberList.csv", "ArticleMagazineList.csv", "BookChapterList.csv", "ArticleConferenceList.csv", "StudentList.csv", "BookConferenceList.csv", "InvestigationTeamList.csv");
        readFromFile("input.csv");
    }

    /**
     * Method that runs the menu.
     */
    private void run() {
        do {
            System.out.println("1: Inicial Run.\n"  +
            "2: Shows CISUC indicators.\n" +
            "3: List Team Work.\n"  +
            "4: List Team Members.\n" +
            "5: List Investigation Teams.\n" +
            "6: Print works of the lastest 5 years.\n" +
            "7: Print all researchers from CISUC.\n" +
            "8. Print all works from CISUC.\n" +
            "9. Print works from said investigator.\n" +
            "10. Exit and save.\n" +
            "11. Exit w/o saving.\n" +
            "Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    debugMethod();
                    break;
                case 1:
                    if (hasntRun) {
                        firstRun();
                        hasntRun = false;
                    } else {
                        System.out.println("Inicial run has already run once, cannot run again or else objects will appear duplicated.");
                    }
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
                            "6: Software and Systems Engineering\n" +
                            "Enter your choice: ");
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
                            "6: Software and Systems Engineering\n" +
                            "What team? ");
                    option4();
                    break;
                case 5:
                    listTeams();
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
                    sc.nextLine();
                    System.out.print("Insert name: ");
                    String name = sc.nextLine();
                    listResearcherWork(name);
                    break;
                case 10:
                    sc.close();
                    writer("CISUC.ser");
                    System.exit(0);
                    break;
                case 11:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (true) ;
    }

    private void debugMethod() {
    }

// Menu methods.

    /**
     * Method that switches between cases in the second option apresented in the menu.
     */
    private void option2() {
        int[] count = countMembers(investigators);
        System.out.printf("Current count of Students members: %d\n" +
                "Current count of Teacher members: %d\n" +
                "Total count of staff: %d\n", count[0], count[1], investigators.size());
        countWorks();
    }

    /**
     * Method that switches between cases in the third option apresented in the menu.
     */
    private void option3() {
        int team = sc.nextInt();
        switch (team) {
            case 1:
                for (Work work : works) {
                    if (work.getYearPublished() >= 2015 && work.getTeam().getAcronym().equalsIgnoreCase("AC")) {
                        System.out.println("===================");
                        System.out.println(work);
                    }
                }
                break;
            case 2:
                for (Work work : works) {
                    if (work.getYearPublished() >= 2015 && work.getTeam().getAcronym().equalsIgnoreCase("CMS")) {
                        System.out.println("===================");
                        System.out.println(work);
                    }
                }
                break;
            case 3:
                for (Work work : works) {
                    if (work.getYearPublished() >= 2015 && work.getTeam().getAcronym().equalsIgnoreCase("ECS")) {
                        System.out.println("===================");
                        System.out.println(work);
                    }
                }
                break;
            case 4:
                for (Work work : works) {
                    if (work.getYearPublished() >= 2015 && work.getTeam().getAcronym().equalsIgnoreCase("IS")) {
                        System.out.println("===================");
                        System.out.println(work);
                    }
                }
                break;
            case 5:
                for (Work work : works) {
                    if (work.getYearPublished() >= 2015 && work.getTeam().getAcronym().equalsIgnoreCase("LCT")) {
                        System.out.println("===================");
                        System.out.println(work);
                    }
                }
                break;
            case 6:
                for (Work work : works) {
                    if (work.getYearPublished() >= 2015 && work.getTeam().getAcronym().equalsIgnoreCase("SSE")) {
                        System.out.println("===================");
                        System.out.println(work);
                    }
                }
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
        System.out.println("===================");
    }

    /**
     * Method that switches between cases in the fourth option apresented in the menu.
     */
    private void option4() {
        try {
            int team = sc.nextInt();
            switch (team) {
                case 1:
                    listTeamMembers(getTeam("AC"));
                    break;
                case 2:
                    listTeamMembers(getTeam("CMS"));
                    break;
                case 3:
                    listTeamMembers(getTeam("ECOS"));
                    break;
                case 4:
                    listTeamMembers(getTeam("IS"));
                    break;
                case 5:
                    listTeamMembers(getTeam("LCT"));
                    break;
                case 6:

                    listTeamMembers(getTeam("SSE"));
                    break;
                default:
                    System.out.println("Wrong input!");
                    break;
            }
        } catch (NullPointerException e) {
            System.out.println();
        }
    }

// Getters and setters.

    /**
     * Method to set one or multiple authors in one publication
     *
     * @param array string of authors to be split.
     */
    private ArrayList<Investigator> setAuthors(String array) {
        String[] list = array.split(";");
        ArrayList<Investigator> workAuthors = new ArrayList<>();
        for (String author : list) {
            workAuthors.add(getInvestigator(author));
        }
        return workAuthors;
    }

    /**
     * Method to retrieve Investigator object from given Investigator name.
     *
     * @param name investigator name
     */
    private Investigator getInvestigator(String name) {
        for (Investigator investigator : investigators) {
            if (investigator.getName().equalsIgnoreCase(name)) {
                return investigator;
            }
        }
        return null;
    }

    /**
     * Method to retrieve Investigator object from given Investigator object.
     *
     * @param work Work object
     */
    private ArrayList<Investigator> getInvestigator(Work work) {
        for (Work workIn : works) {
            if (work.equals(workIn)) {
                return work.getAuthors();
            }
        }
        return null;
    }

    /**
     * Method to retrive Team object from given team name.
     *
     * @param group team name
     */
    private InvestigationTeam getTeam(String group) {
        for(InvestigationTeam team : investigationTeams) {
            if (team.getAcronym().equalsIgnoreCase(group)) {
                return team;
            }
        }
        return null;
    }

    /**
     * Method to retrive Team from given researcher's object.
     *
     * @param investigator researcher object
     */
    private InvestigationTeam getTeam(Investigator investigator) {
        for(InvestigationTeam team : investigationTeams) {
            if (team.equals(investigator.getInvestigationGroup())) {
                return team;
            }
        }
        return null;
    }

// Counting methods.

    /**
     * Method to count works in database.
     */
    private void countWorks() {
        System.out.printf("Article Conference Count: %d\n" +
                "Magazine Article Count: %d\n" +
                "Article Conference Books Count: %d\n" +
                "Chapter Book Count: %d\n" +
                "Book Count: %d\n" +
                "Total Work Count: %d\n" +
                "Work Count in the last 5 years: %d\n",
                Work.articleConferenceCount,Work.articleMagazineCount,Work.bookArticleConferenceCount,Work.bookChapterCount,Work.bookCount, works.size() ,count5years());
    }

    /**
     * Method to count works from the last five years in database.
     */
    private int count5years() {
        int count = 0;
        for (Work work: works) {
            if (work.getYearPublished() <= (LocalDate.now().getYear() - 5)) {
                count++;
            }
        }
        return count;
    }

    private int[] countMembers(ArrayList<Investigator> investigators) {
        int students = 0;
        int efetives = 0;
        for (Investigator investigator : investigators) {
            if (investigator.getPublicationName().contains("Professor")) {
                efetives++;
            } else {
                students++;
            }
        }
        return new int[] {students,efetives};
    }

    private int[] countMembers(InvestigationTeam team) {
        int students = 0;
        int efetives = 0;
        for (Investigator investigator : team.getMembers()) {
            if (investigator.getPublicationName().contains("Professor")) {
                efetives++;
            } else {
                students++;
            }
        }
        return new int[] {students,efetives};
    }

    /**
     * Method to count works in database from given Investigation team.
     */
    private String countWorks(InvestigationTeam team) {
        int count = 0; int newest = 0;
        for (Work work:works) {
            if (work.getTeam().equals(team)) {
                count++;
            }
            if (work.getTeam().equals(team) && work.getYearPublished() >= 2015) {
                newest++;
            }
        }
        if (count == newest) {
            return count + " published papers, all in the last 5 years.";
        }
        return count + " published papers, " + newest + " in the last 5 years.";
    }

// Printing methods.

    /**
     * Method to list investigators in database.
     */
    private void printInvestigators() {
        if (investigators.isEmpty()) {
            System.out.println("There are no researchers in record.");
            return;
        }
        for (Investigator investigator: investigators) {
            try {
                System.out.println("===================");
                System.out.println(investigator);
            } catch (NullPointerException e) {
                System.out.println("erro.");  //TODO: acabar esta função.
            }
        }
        System.out.println("===================");
    }

    /**
     * Method to list works in database.
     */
    private void printWorks() {
        if (works.isEmpty()) {
            System.out.println("There are no works in record.");
            return;
        }
        for (Work work : works) {
            System.out.println("===================");
            System.out.println(work);
        }
        System.out.println("===================");
    }

    /**
     * Method to list last 5 years work and sort by year, impact value and type.
     */
    private void print5years() { //TODO: ver se esta merda está broken
        int year = 2020;
        int ascii = 65;
        int type = 0;
        do {
            for (Work work : works) {
                if (work.getType() == (type)) {
                    do {
                        if (work.getImpactValue() == ascii) {
                            do {
                                if (work.getYearPublished() == year) {
                                    for (Investigator author: work.getAuthors()) {
                                        System.out.println("===================");
                                        System.out.println(work);
                                    }
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
        System.out.println("===================");
    }

    /**
     * Method to list team members from given InvestigationTeam object.
     *
     * @param team InvestigationTeam object
     */
    private void listTeamMembers(InvestigationTeam team) {
        for (Investigator member: team.getMembers()) {
            System.out.println("===================");
            System.out.println(member);
        }
        System.out.println("===================");
    }

    public void listTeamMembers() {
        for (InvestigationTeam teams : investigationTeams) {
            for (Investigator member : teams.getMembers()) {
                System.out.println("===================");
                System.out.println(member);
            }
        }
        System.out.println("===================");
    } // TODO: EXCEPTIONS

    /**
     * Method to list works from given researcher's name.
     *
     * @param name researcher's name
     */
    private void listResearcherWork(String name) {
        if (works.isEmpty()) {
            System.out.println("There are no works in record.");
            return;
        }
        for (Work work:works) {
            Investigator author = getInvestigator(name);
            if (work.getAuthors().contains(author)) {
                System.out.println("===================");
                System.out.println(work);
            }
        }
        System.out.println("===================");
    }

    /**
     * Method to list teams and their information.
     */
    private void listTeams() {
        if (investigationTeams.isEmpty()) {
            System.out.println("No investigation teams in our database.");
            return;
        }
        try {
            System.out.println("Equipas de Investigação:");
            for (InvestigationTeam investigationTeam : investigationTeams) {
                System.out.println(investigationTeam + countWorks(investigationTeam));
            }
        } catch (NullPointerException e) {
            System.out.println("Researching team doesn't exist in database.");
        }
    }

// Reading and writing methods.

    /**
     * Updated method to read from file.
     *
     * @param inputFile the input file
     */
    private void readFromFile(String inputFile) {
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                String type = split[0];
                if (type.equalsIgnoreCase("team")) {
                    Teacher temp = new Teacher(split[3]);
                    investigators.add(temp);
                    investigationTeams.add(new InvestigationTeam(split[1], split[2], temp));
                }
                else if (type.equalsIgnoreCase("efetivemember")) {
                    Investigator investigator = getInvestigator(split[1]);
                    try {
                        Teacher teacher = (Teacher) investigator;  // the only way this down cast is possible is if we know the order on which the objects are added, which we know bc there is no user interaction.
                        assert teacher != null; // cannot be null since only investigators added are only head leaders.
                        InvestigationTeam team = getTeam(split[3]);
                        teacher.setEmail(split[2]);
                        teacher.setInvestigationGroup(team);
                        teacher.setRoom(split[4]);
                        teacher.setCellphone(Long.parseLong(split[5]));
                        assert team != null;
                        team.addMember(teacher);
                    } catch (NullPointerException e) { // if getInvestigator returns null that means that object doesn't exist, therefore it needs to be created.
                        InvestigationTeam team = getTeam(split[3]);
                        Investigator teacher = new Teacher(split[1], split[2], team, split[4], Long.parseLong(split[5]));
                        investigators.add(teacher);
                        assert team != null;
                        team.addMember(teacher);
                    }
                }
                else if (type.equalsIgnoreCase("student")) {
                    InvestigationTeam team = getTeam(split[3]);
                    Student student = new Student(split[1], split[2], team, split[4], split[5], getInvestigator(split[6]));
                    investigators.add(student);
                    assert team != null;
                    team.addMember(student);
                }
                else if (type.equalsIgnoreCase("bookchapter")) {
                    works.add(new BookChapter(setAuthors(split[1]), split[2], split[3], getTeam(split[4]), Integer.parseInt(split[5]), Integer.parseInt(split[6]), split[7], Integer.parseInt(split[8]), split[9], Integer.parseInt(split[10]), Integer.parseInt(split[11])));
                }
                else if (type.equalsIgnoreCase("articlemagazine")) {
                    works.add(new ArticleMagazine(setAuthors(split[1]), split[2], split[3], getTeam(split[4]), Integer.parseInt(split[5]), Integer.parseInt(split[6]), split[7], Integer.parseInt(split[8]), split[9]));
                }
                else if (type.equalsIgnoreCase("articleconference")) {
                    works.add(new ArticleConference(setAuthors(split[1]), split[2], split[3], getTeam(split[4]), Integer.parseInt(split[5]), Integer.parseInt(split[6]), split[7], Integer.parseInt(split[8]), split[9]));
                }
                else if (type.equalsIgnoreCase("bookarticleconference")) {
                    works.add(new BookArticleConference(setAuthors(split[1]), split[2], split[3], getTeam(split[4]), Integer.parseInt(split[5]), Integer.parseInt(split[6]), split[7], Integer.parseInt(split[8]), split[9], Integer.parseInt(split[10])));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Error reading line.");
        }
        System.out.println("New reading method has completed.");
    }

    /**
     * Method to write CISUC object to object file.
     *
     * @param outputFile name of the output object file
     */
    private void writer(String outputFile) {
        try{
            FileOutputStream writeData = new FileOutputStream(outputFile);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            if (works.isEmpty() && investigators.isEmpty() && investigationTeams.isEmpty()) {
                System.out.println("No data to save, program will exit.");
                return;
            }
            writeStream.writeObject(this);
            writeStream.flush();
            writeStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

// ======================= not used methods ========================== //

/**
 * Old method to count work in database.
 */
    /*
    private void countWorks() {
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
    */

/**
 * Old method to read from file.
 *
 * @param efetiveFile               the efetive input file
 * @param magazineFile              the magazine input file
 * @param chapterFile               the chapter input file
 * @param conferenceFile            the conference input file
 * @param studentFile               the student input file
 * @param bookArticleConferenceFile the book article conference input file
 * @param InvestigationTeamFile     the investigation team input file
 */
    /*public void oldReadFromFile(String efetiveFile, String magazineFile, String chapterFile, String conferenceFile, String studentFile, String bookArticleConferenceFile, String InvestigationTeamFile) {
        // NOT USED METHOD
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
                String[] split7 = line.split(",");
                boolean found = false;
                for (Investigator i: investigators) {
                    if (i.getName().equalsIgnoreCase(split7[2])) {
                        found = true;
                        }
                    investigationTeams.add(new InvestigationTeam(split7[0], split7[1], getInvestigator(split7[2])));
                    }
                if (!found) {
                    Teacher temp = new Teacher(split7[2],null,null,null,0);
                    investigators.add(temp);
                    investigationTeams.add(new InvestigationTeam(split7[0], split7[1], getInvestigator(split7[2])));
                    investigators.remove(temp);
                }
            }
            br1.readLine();
            while ((line = br1.readLine()) != null) {
                String[] split = line.split(",");
                    investigators.add(new Teacher(split[0],split[1],getTeam(split[2]),split[3],Long.parseLong(split[4])));
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
    }*/

/**
     * Old method to count members in database.
 */
    /*private void countMembers() {
        int students = 0; int efetives = 0;
        for (Investigator investigator: investigators) {
            if (investigator.getType().equalsIgnoreCase(Investigator.TYPE_STUDENT)) {
                students++;
            } else {
                efetives++;
            }
        }
        int total = students + efetives;
        System.out.printf("Current count of Students members: %d\n" +
                "Current count of Efetive members: %d\n" +
                "Total count of staff: %d\n", students, efetives, total);
    }*/

/*    *//**
 * Method to count members from given investigation team.
 * @return
 *//*
    private String countTeamMembers(InvestigationTeam team) {
        int student = 0; int efetive = 0;
        for (Investigator investigator: investigators) {
            if (investigator.getType().equalsIgnoreCase(Investigator.TYPE_STUDENT) && investigator.getInvestigationGroup().equals(team)) {
                student++;
            } else if (investigator.getInvestigationGroup() == team && investigator.getType().equals(Investigator.TYPE_TEACHER)) {
                efetive++;
            }
        }
        int total = student + efetive;
        return "Total count of members: " + total + ", which " + student + " are students and " + efetive + " are efetive members.";
    }*/

