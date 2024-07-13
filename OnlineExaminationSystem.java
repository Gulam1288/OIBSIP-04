import java.util.*;

class Account {
    private String userId;
    private String password;
    private String profileInfo;

    public Account(String userId, String password, String profileInfo) {
        this.userId = userId;
        this.password = password;
        this.profileInfo = profileInfo;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getProfileInfo() {
        return profileInfo;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void setProfileInfo(String profileInfo) {
        this.profileInfo = profileInfo;
    }
}

class Exam {
    private List<String> questions;
    private Map<Integer, String> answers;
    private Map<Integer, String> userAnswers;

    public Exam() {
        questions = new ArrayList<>();
        answers = new HashMap<>();
        userAnswers = new HashMap<>();
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add("Q1: What is the default value of a boolean variable in Java?\nA) true\nB) false\nC) 0\nD) 1");
        answers.put(1, "B");

        questions.add("Q2: Which method is used to start a thread in Java?\nA) start()\nB) run()\nC) init()\nD) main()");
        answers.put(2, "A");

        questions.add("Q3: What is the size of an int variable in Java?\nA) 4 bytes\nB) 8 bytes\nC) 2 bytes\nD) 1 byte");
        answers.put(3, "A");

        questions.add("Q4: Which of the following is not a Java keyword?\nA) static\nB) void\nC) main\nD) try");
        answers.put(4, "C");

        questions.add("Q5: What is the return type of the hashCode() method?\nA) int\nB) Object\nC) long\nD) void");
        answers.put(5, "A");

        questions.add("Q6: Which exception is thrown when a thread is interrupted?\nA) InterruptedException\nB) IOException\nC) SQLException\nD) RemoteException");
        answers.put(6, "A");

        questions.add("Q7: Which of the following is a marker interface?\nA) Serializable\nB) Comparable\nC) Cloneable\nD) Both A and C");
        answers.put(7, "D");

        questions.add("Q8: Which of these classes are part of Java Collection Framework?\nA) HashSet\nB) ArrayList\nC) LinkedList\nD) All of the above");
        answers.put(8, "D");

        questions.add("Q9: What is the superclass of all classes in Java?\nA) Object\nB) Class\nC) Interface\nD) None of the above");
        answers.put(9, "A");

        questions.add("Q10: Which of these statements is correct?\nA) A constructor can be called directly.\nB) A constructor cannot be synchronized.\nC) A constructor can be overloaded.\nD) A constructor can return a value.");
        answers.put(10, "C");
    }

    public void printSeparator() {
        for (int i = 0; i < 70; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    public void startExam(Scanner scanner) {
        System.out.println("Starting exam. You have 5 minutes to complete.");
        printSeparator();
        long endTime = System.currentTimeMillis() + 5 * 60 * 1000; // 5 minutes timer

        for (int i = 0; i < questions.size(); i++) {
            System.out.println(questions.get(i));
            System.out.print("Enter your answer: ");
            String answer = scanner.nextLine();
            userAnswers.put(i + 1, answer);

            if (System.currentTimeMillis() >= endTime) {
                System.out.println("Time is up! Auto-submitting your answers.");
                break;
            }

            if (i < questions.size() - 1) {
                printSeparator();
            }
        }

        evaluateExam();
    }

    private void evaluateExam() {
        int score = 0;
        for (int i = 1; i <= questions.size(); i++) {
            String correctAnswer = answers.get(i);
            String userAnswer = userAnswers.get(i);
            if (correctAnswer != null && correctAnswer.equalsIgnoreCase(userAnswer)) {
                score++;
            }
        }
        printSeparator();
        System.out.println("Exam finished. Your score: " + score + "/" + questions.size());
    }
}

class PracticeExam extends Exam {
    private List<String> practiceQuestions;
    private Map<Integer, String> practiceAnswers;
    private Map<Integer, String> practiceUserAnswers;

    public PracticeExam() {
        practiceQuestions = new ArrayList<>();
        practiceAnswers = new HashMap<>();
        practiceUserAnswers = new HashMap<>();
        loadPracticeQuestions();
    }

    private void loadPracticeQuestions() {
        practiceQuestions.add("Q1: What does JVM stand for?\nA) Java Virtual Machine\nB) Java Very Machine\nC) Java Verified Machine\nD) Java Variable Machine");
        practiceAnswers.put(1, "A");

        practiceQuestions.add("Q2: What is the default value of a local variable?\nA) 0\nB) null\nC) undefined\nD) None");
        practiceAnswers.put(2, "D");

        practiceQuestions.add("Q3: Which of these is a superclass of all classes?\nA) Java\nB) lang\nC) Object\nD) None");
        practiceAnswers.put(3, "C");
    }

    public void startPractice(Scanner scanner) {
        System.out.println("Starting practice exam. You can take your time.");
        printSeparator();

        for (int i = 0; i < practiceQuestions.size(); i++) {
            System.out.println(practiceQuestions.get(i));
            System.out.print("Enter your answer: ");
            String answer = scanner.nextLine();
            practiceUserAnswers.put(i + 1, answer);

            if (i < practiceQuestions.size() - 1) {
                printSeparator();
            }
        }

        evaluatePractice();
    }

    private void evaluatePractice() {
        int score = 0;
        for (int i = 1; i <= practiceQuestions.size(); i++) {
            String correctAnswer = practiceAnswers.get(i);
            String userAnswer = practiceUserAnswers.get(i);
            if (correctAnswer != null && correctAnswer.equalsIgnoreCase(userAnswer)) {
                score++;
            }
        }
        printSeparator();
        System.out.println("Practice exam finished. Your score: " + score + "/" + practiceQuestions.size());
    }
}

public class OnlineExaminationSystem {
    private Set<Account> accounts;
    private Account currentAccount;
    private Scanner scanner;

    public OnlineExaminationSystem() {
        accounts = new HashSet<>();
        accounts.add(new Account("user123", "password123", "I am user123"));
        accounts.add(new Account("user456", "password456", "I am user456"));
        scanner = new Scanner(System.in);
    }

    public void printSeparator() {
        System.out.println("---------------------------------------------------");
    }

    public void start() {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Login");
            System.out.println("2. Practice Exam");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            printSeparator();

            switch (choice) {
                case 1:
                    if (authenticate()) {
                        showMainMenu();
                    } else {
                        authenticate();
                    }
                    break;
                case 2:
                    startPractice();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.out.println("Thank you for using the Online Examination System!\n");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
            printSeparator();
        }
    }

    private boolean authenticate() {
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (Account account : accounts) {
            if (account.getUserId().equals(userId) && account.getPassword().equals(password)) {
                currentAccount = account;
                System.out.println("Login successful.");
                printSeparator();
                return true;
            }
        }
        System.out.println("Invalid user ID or password. Please try again.");
        printSeparator();
        return false;
    }

    private void showMainMenu() {
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Update Profile");
            System.out.println("2. Update Password");
            System.out.println("3. Start Exam");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            printSeparator();

            switch (choice) {
                case 1:
                    updateProfile();
                    break;
                case 2:
                    updatePassword();
                    break;
                case 3:
                    startExam();
                    break;
                case 4:
                    logout();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            printSeparator();
        }
    }

    private void updateProfile() {
        System.out.print("Enter new profile info: ");
        String newProfileInfo = scanner.nextLine();
        currentAccount.setProfileInfo(newProfileInfo);
        System.out.println("Profile updated successfully.");
    }

    private void updatePassword() {
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        currentAccount.setPassword(newPassword);
        System.out.println("Password updated successfully.");
    }

    private void startExam() {
        Exam exam = new Exam();
        exam.startExam(scanner);
    }

    private void startPractice() {
        PracticeExam practiceExam = new PracticeExam();
        practiceExam.startPractice(scanner);
    }

    private void logout() {
        currentAccount = null;
        System.out.println("Logged out successfully.");
    }

    public static void main(String[] args) {
        OnlineExaminationSystem system = new OnlineExaminationSystem();
        system.start();
    }
}
