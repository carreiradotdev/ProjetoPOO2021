/*
 * Projeto Final - POO2021
 * @author Francisco Carreira - 2019222462
 */

package CISUC;

import java.io.*;
import java.util.*;
import java.time.LocalDate;

/**
 * The type Cisuc.
 */
public class CISUC implements Serializable {
    private ArrayList<Investigator> investigators;
    private ArrayList<InvestigationTeam> investigationTeams;
    private ArrayList<Work> works;

    private CISUC() {
        generalCount = new int[8];
        investigators = new ArrayList<>();
        investigationTeams = new ArrayList<>();
        works = new ArrayList<>();
    }
    /**
     * The object file (may not exist) that serves as input file as default.
     */
    static File objectFile = new File("data/CISUC.ser");
    /**
     * The text file, that serves as input file when the object file doesn't exist.
     */
    static File textFile = new File("data/input.csv");

    /**
     * Array to track amount of different object types while being read in readFromFile() function.
     */
    private int[] generalCount; // team, efetive, student, book chapter, article magazine, article conference, book article conference, book

    /**
     * The constant scanner.
     */
    public static final Scanner sc = new Scanner(System.in);

    /**
     * Boolean value of the only one-time run menu feature.
     */
    private boolean hasntRun = true;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        CISUC cisuc = new CISUC();
        if (objectFile.exists()) {
            cisuc = cisuc.reader();
            cisuc.hasntRun = false;
        } else {
            System.out.println("Object file doesn't exist! Reading from text files.");
            if (textFile.exists()) {
                cisuc.firstRun();
            }
        }
        cisuc.run();
    }

    /**
     * Method that reads previously saved object file.
     */
    private void firstRun() {
        readFromFile();
        hasntRun = false;
    }

    /**
     * Method that runs the menu.
     */
    private void run() {
        System.out.println("Welcome to CISUC!");
        Collections.sort(works);
        Collections.sort(investigators); // sorts both work and investigators list
        int choice = -1;
        do {
            System.out.print("1: Show CISUC indicators.\n" +
                    "2: Show team indicators, sorted by year.\n" +
                    "3: List Team work.\n" +
                    "4: List Team members.\n" +
                    "5: List Investigation Teams.\n" +
                    "6: List works of the lastest five years.\n" +
                    "7: List all researchers from CISUC.\n" +
                    "8. List all works from CISUC.\n" +
                    "9. List works from (to-be referenced) investigator.\n" +
                    "10. Exit and save.\n" +
                    "Enter your choice: ");
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice!");
            }
            sc.nextLine(); // makes sure that the newline character isn't in the scanner,
            switch (choice) {
                case 1:
                    if (works.isEmpty()) {
                        System.out.println("There are no works in record.");
                        break;
                    }
                    option2();
                    break;
                case 2:
                    if (works.isEmpty()) {
                        System.out.println("There are no works in record.");
                        break;
                    }
                    runIndicators();
                    break;
                case 3:
                    if (works.isEmpty()) {
                        System.out.println("There are no works in record.");
                        break;
                    }
                    option3();
                    break;
                case 4:
                    if (investigators.isEmpty()) {
                        System.out.println("There are no researchers in our Database.");
                        break;
                    }
                    option4();
                    break;
                case 5:
                    if (investigationTeams.isEmpty()) {
                        System.out.println("There are no investigation teams in record.");
                        break;
                    }
                    printTeams();
                    break;
                case 6:
                    if (works.isEmpty()) {
                        System.out.println("There are no works in record.");
                        break;
                    }
                    printLastestWork();
                    break;
                case 7:
                    printInvestigators();
                    break;
                case 8:
                    printWorks();
                    break;
                case 9:
                    System.out.print("Insert name: ");
                    String name = sc.nextLine();
                    listResearcherWork(name);
                    break;
                case 10:
                    sc.close(); // closes scanner
                    writer(); // writes CISUC object to the outputFile
                    System.exit(0); // closes application
                    break;
                /*case 12: // doesnt show in the menu, debug method only
                    sc.close(); // closes scanner
                    System.exit(0); // closes application
                    break;*/
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        } while (true);
    }

    /**
     * Method to add work to authors' corresponding team list.
     *
     * @param work the work object to add to team
     * @param authors the arraylist with authors get Team from and add work to corresponding team.
     */
    private void addWorkToTeam(Work work, ArrayList<Investigator> authors) {
        for (Investigator author: authors) {
            InvestigationTeam team = getTeam(author);
            assert team != null;
            if (!team.getWorks().contains(work)) {
                team.addWork(work);
            }
        }
    }

// Menu methods.

    /**
     * Method that switches between cases in the second option apresented in the menu.
     */
    private void option2() {
        System.out.printf("Current count of Teacher members: %d\n" +
                "Current count of Student members: %d\n" +
                "Total count of staff: %d\n", generalCount[1], generalCount[2], investigators.size());
        System.out.printf("Total count of publications: %d\n" + "Publications in the last five years: %d\n" + "Article Conference Count: %d\n" + "Magazine Article Count: %d\n" + "Article Conference Books Count: %d\n" + "Chapter Book Count: %d\n" +
                "Book Count: %d\n", works.size(), countLatestWorks(), generalCount[5], generalCount[4], generalCount[5], generalCount[3],generalCount[7]);
    }

    /**
     * Method that switches between cases in the third option apresented in the menu.
     */
    private void option3() {
        System.out.println("1: Adaptive Computation\n" +
                "2: Cognitive and Media Systems\n" +
                "3: Evolutionary and Complex Systems\n" +
                "4: Information Systems\n" +
                "5: Communications and Telematics\n" +
                "6: Software and Systems Engineering\n" +
                "Enter your choice: ");
    int choice = -1;
    try {
        choice = sc.nextInt();
    } catch (InputMismatchException e) {
        System.out.println("Invalid input!");
    }
    InvestigationTeam team;
    switch (choice) {
        case 1:
            team = getTeam("AC");
            for (Work work: team.getWorks()) {
                System.out.println("====================");
                System.out.println(work);
            }
            break;
        case 2:
            team = getTeam("CMS");
            for (Work work: team.getWorks()) {
                System.out.println("====================");
                System.out.println(work);
            }
            break;
        case 3:
            team = getTeam("ECS");
            for (Work work: team.getWorks()) {
                System.out.println("====================");
                System.out.println(work);
            }
            break;
        case 4:
            team = getTeam("IS");
            for (Work work: team.getWorks()) {
                System.out.println("====================");
                System.out.println(work);
            }
            break;
        case 5:
            team = getTeam("LCT");
            for (Work work: team.getWorks()) {
                System.out.println("====================");
                System.out.println(work);
            }
            break;
        case 6:
            team = getTeam("SSE");
            for (Work work: team.getWorks()) {
                System.out.println("====================");
                System.out.println(work);
            }
            break;
        case 7:
            return;
        default:
            System.out.println("Invalid input!");
            break;
        }
        System.out.println("====================");
    }

    /**
     * Method that switches between cases in the fourth option apresented in the menu.
     */
    private void option4() {
        System.out.println("1: Adaptive Computation\n" +
                "2: Cognitive and Media Systems\n" +
                "3: Evolutionary and Complex Systems\n" +
                "4: Information Systems\n" +
                "5: Communications and Telematics\n" +
                "6: Software and Systems Engineering\n" +
                "Enter your choice: ");
        int choice = -1;
        try {
            choice = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
        }
        switch (choice) {
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
            case 7:
                return;
            default:
                System.out.println("Invalid input!");
                break;
        }
    }

// Getters and setters.

    /**
     * Method to set one or multiple authors in one publication
     *
     * @param array string of authors to be split.
     * @return arraylist with all investigator objects in the publication
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
     * @return investigator object
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
     * Method to retrive Team object from given team acronym.
     *
     * @param acronym team acronym
     * @return team object
     */
    private InvestigationTeam getTeam(String acronym) {
        for(InvestigationTeam team : investigationTeams) {
            if (team.getAcronym().equalsIgnoreCase(acronym)) {
                return team;
            }
        }
        return null;
    }

    /**
     * Method to retrive Team from given researcher's object.
     *
     * @param investigator researcher object
     * @return team object from researcher object
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
     * Method to count work from less than 5 years ago in database.
     *
     * @return Returns an integer containing the count.
     */
    private int countLatestWorks() {
        int count = 0;
        for (Work work: works) {
            if (work.getYearPublished() >= (LocalDate.now().getYear() - 5)) {
                count++;
            }
        }
        return count;
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
        for (InvestigationTeam team: investigationTeams) {
            for (Investigator investigator : team.getMembers()) {
                try {
                    System.out.println("====================");
                    System.out.println(investigator);
                } catch (NullPointerException e) {
                    System.out.println("Error printing researcher.");
                }
            }
        }
        System.out.println("====================");
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
     * Method to list team members from given InvestigationTeam object.
     *
     * @param team InvestigationTeam object
     */
    private void listTeamMembers(InvestigationTeam team) {
        for (Investigator member : team.getMembers()) {
            System.out.println("===================");
            System.out.println(member);
        }
        System.out.println("===================");
    }

    /**
     * Method to list works from given researcher's name.
     *
     * @param name researcher's name
     */
    private void listResearcherWork(String name) {
        Investigator author = getInvestigator(name);
        if (author == null) {
            System.out.println("Invalid input!");
            return;
        }
        if (works.isEmpty()) {
            System.out.println("There are no works in record.");
            return;
        }
        for (Work work:works) {
            if (work.getAuthors().contains(author)) {
                System.out.println("====================");
                System.out.println(work);
            }
        }
        System.out.println("====================");
    }

    /**
     * Method to list works from until five years ago.
     */
    private void printLastestWork() {
        for (Work work: works) {
            if (work.getYearPublished() >= (LocalDate.now().getYear() - 5)) {
                System.out.println("===================");
                System.out.println(work);
            }
        }
        System.out.println("===================");
    }

    /**
     * Method to list teams and their information.
     */
    private void printTeams() {
        if (investigationTeams.isEmpty()) {
            System.out.println("No investigation teams in our database.");
            return;
        }
        try {
            System.out.println("INVESTIGATION TEAMS:");
            for (InvestigationTeam investigationTeam : investigationTeams) {
                System.out.println(investigationTeam);
            }
        } catch (NullPointerException e) {
            System.out.println("Researching team doesn't exist in database.");
        }
    }

    /**
     * Method to list the indicators for publications from five years ago, sorted by year, type and impact value.
     *
     * @param year year to show indicators from
     * @param team team to show indicators from
     */
    private void yearIndicators(int year, InvestigationTeam team) {
        ArrayList<Work> worksInYear = new ArrayList<>();
        for (Work work : team.getWorks()) {
            if (work.getYearPublished() == year) {
                worksInYear.add(work);
            }
        }
        if (worksInYear.isEmpty()) {
            System.out.println("No publications made on " + year + '!');
        } else {
            System.out.printf("Publications made in %d: %d\n", year, worksInYear.size());
            for (int type = 0; type <= 4; type++) {
                int countA = 0, countB = 0, countC = 0;
                for (Work work : worksInYear) {
                    if (work.getType() == type) {
                        if (work.getImpactValue() == 'A') {
                            countA++; // impact value A type counter increases
                        } else if (work.getImpactValue() == 'B') {
                            countB++; // impact value B type counter increases
                        } else {
                            countC++; // impact value C type counter increases
                        }
                    }
                }
                switch (type) {
                    case 0:
                        if ((countA + countB + countC) != 0) // if the sum equals 0, there is no need in printing.
                            System.out.printf("CONFERENCE ARTICLE\nIMPACT VALUE A: %d\nIMPACT VALUE B: %d\nIMPACT VALUE C: %d\n", countA, countB, countC);
                        break;
                    case 1:
                        if ((countA + countB + countC) != 0) // if the sum equals 0, there is no need in printing.
                            System.out.printf("MAGAZINE ARTICLE\nIMPACT VALUE A: %d\nIMPACT VALUE B: %d\nIMPACT VALUE C: %d\n", countA, countB, countC);
                        break;
                    case 2:
                        if ((countA + countB + countC) != 0) // if the sum equals 0, there is no need in printing.
                            System.out.printf("BOOK\nIMPACT VALUE A: %d\nIMPACT VALUE B: %d\nIMPACT VALUE C: %d\n", countA, countB, countC);
                        break;
                    case 3:
                        if ((countA + countB + countC) != 0) // if the sum equals 0, there is no need in printing.
                            System.out.printf("BOOK CHAPTER\nIMPACT VALUE A: %d\nIMPACT VALUE B: %d\nIMPACT VALUE C: %d\n", countA, countB, countC);
                        break;
                    case 4:
                        if ((countA + countB + countC) != 0) // if the sum equals 0, there is no need in printing.
                            System.out.printf("BOOK CONFERENCE\nIMPACT VALUE A: %d\nIMPACT VALUE B: %d\nIMPACT VALUE C: %d\n", countA, countB, countC);
                        break;
                }
            }
        }
        System.out.println("====================");
    }

    /**
     * Method to run lastestIndicators(year, team) with parameters.
     */
    private void runIndicators() {
        String[] teams = {"AC", "CMS", "ECOS", "IS", "LCT", "SSE"};
        for (int i = 0; i < 6; i++) {
            InvestigationTeam team = getTeam(teams[i]);
            System.out.println("\n====================");
            System.out.println("TEAM: " + team.getGroup());
            System.out.println("====================");
            for (int j = 0; j < 5; j++) {
                yearIndicators(LocalDate.now().getYear() - j, team);
            }
        }
    }

// Reading and writing methods.

    /**
     * Method to read from text file.
     */
    private void readFromFile() {
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(textFile));
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                String type = split[0];
                if (type.equalsIgnoreCase("team")) {
                    Teacher temp = new Teacher(split[3]); // creates a temporary teacher object that only has name, the other atributes will soon be updated.
                    investigators.add(temp); // adds Teacher object to the investigators arraylist
                    investigationTeams.add(new InvestigationTeam(split[1], split[2], temp)); // adds team to the investigationTeams list
                    generalCount[0]++; // increases investigation team count
                }
                else if (type.equalsIgnoreCase("efetivemember")) {
                    Investigator investigator = getInvestigator(split[1]);
                    try {
                        Teacher teacher = (Teacher) investigator;  // the only way this down cast is possible is if we know the order on which the objects are added, which we know bc there is no user interaction.
                        assert teacher != null; // cannot be null since only investigators added are only head leaders.
                        InvestigationTeam team = getTeam(split[3]); // gets team object so the teacher object can be added to the team member list.
                        teacher.setEmail(split[2]); //updates email on temporary Teacher object
                        teacher.setInvestigationGroup(team); //updates team on temporary Teacher object
                        teacher.setRoom(split[4]); //updates room on temporary Teacher object
                        teacher.setCellphone(Long.parseLong(split[5])); // updates already existing teacher object
                        assert team != null;
                        team.addMember(teacher); // adds member to the team member list
                        generalCount[1]++; // increases teacher count
                    } catch (NullPointerException e) { // if getInvestigator returns null that means that object doesn't exist, therefore it needs to be created.
                        InvestigationTeam team = getTeam(split[3]); // gets team from team acronym
                        Investigator teacher = new Teacher(split[1], split[2], team, split[4], Long.parseLong(split[5]));
                        investigators.add(teacher);
                        assert team != null;
                        team.addMember(teacher);
                        generalCount[1]++; // increases teacher count
                    }
                }
                else if (type.equalsIgnoreCase("student")) {
                    InvestigationTeam team = getTeam(split[3]);
                    Student student = new Student(split[1], split[2], team, split[4], split[5], getInvestigator(split[6])); // creates new student object
                    investigators.add(student);
                    assert team != null;
                    team.addMember(student);
                    generalCount[2]++; // increases student count
                }
                else if (type.equalsIgnoreCase("bookchapter")) {
                    ArrayList<Investigator> authors = setAuthors(split[1]);
                    Work work = new BookChapter(setAuthors(split[1]), split[2], split[3].split(";"), Integer.parseInt(split[4]), Integer.parseInt(split[5]), split[6], Integer.parseInt(split[7]), split[8], Integer.parseInt(split[9]), Integer.parseInt(split[10]));
                    addWorkToTeam(work, authors);
                    works.add(work);
                    generalCount[3]++; // increases book chapter type count
                }
                else if (type.equalsIgnoreCase("articlemagazine")) {
                    ArrayList<Investigator> authors = setAuthors(split[1]);
                    Work work = new ArticleMagazine(setAuthors(split[1]), split[2], split[3].split(";"),Integer.parseInt(split[4]), Integer.parseInt(split[5]), split[6], Integer.parseInt(split[7]), split[8]);
                    addWorkToTeam(work, authors);
                    works.add(work);
                    generalCount[4]++; // increases article magazine type count
                }
                else if (type.equalsIgnoreCase("articleconference")) {
                    ArrayList<Investigator> authors = setAuthors(split[1]);
                    Work work = new ArticleConference(setAuthors(split[1]), split[2], split[3].split(";"), Integer.parseInt(split[4]), Integer.parseInt(split[5]), split[6], Integer.parseInt(split[7]), split[8]);
                    addWorkToTeam(work, authors);
                    works.add(work);
                    generalCount[5]++; // increases conference article type count
                }
                else if (type.equalsIgnoreCase("bookarticleconference")) {
                    ArrayList<Investigator> authors = setAuthors(split[1]);
                    Work work = new BookArticleConference(authors, split[2], split[3].split(";"), Integer.parseInt(split[4]), Integer.parseInt(split[5]), split[6], Integer.parseInt(split[7]), split[8], Integer.parseInt(split[9]));
                    addWorkToTeam(work, authors);
                    works.add(work);
                    generalCount[6]++; // increases article conference book type count
                }
                else if (type.equalsIgnoreCase("book")) {
                    ArrayList<Investigator> authors = setAuthors(split[1]);
                    Work work = new Book(authors, split[2], split[3].split(";"), Integer.parseInt(split[4]), Integer.parseInt(split[5]), split[6], Integer.parseInt(split[7]));
                    addWorkToTeam(work, authors);
                    works.add(work);
                    generalCount[7]++; // increases book type count
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Error reading line.");
        }
    }

    /**
     * Method to write CISUC object to object file.
     */
    private void writer() {
        try{
            FileOutputStream writeData = new FileOutputStream(objectFile);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            if (works.isEmpty() && investigators.isEmpty() && investigationTeams.isEmpty()) {
                System.out.println("No data to save, program will exit.");
                return;
            }
            writeStream.writeObject(this);
            writeStream.flush();
            writeStream.close();
        } catch (IOException e) {
            System.out.println("An IOException was thrown.");
        }
    }

    /**
     * Method to read CISUC object from object file.
     *
     * @return the CISUC object
     */
    private CISUC reader() {
        CISUC cisuc = null;
        try {
            FileInputStream readData = new FileInputStream(objectFile);
            ObjectInputStream readStream = new ObjectInputStream(readData);
            cisuc = (CISUC) readStream.readObject();
            readStream.close();
            hasntRun = false;
        } catch (FileNotFoundException e) {
            System.out.println("Input object file doesn't exist, no data in database.");
        } catch (IOException e) {
            System.out.println("Error reading a line..!");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found expection, have there been any changes made in the backend?");
        }
        return cisuc;
    }
}