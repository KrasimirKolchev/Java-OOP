package WorkingWithAbstraction.studentSystem;

public class StudentSystem {
    private StudentRepository repo;

    public StudentSystem() {
        this.repo = new StudentRepository();
    }

    @Deprecated
    public StudentRepository getRepo() {
        return this.repo;
    }

    public void ParseCommand(String[]args) {

        if (args[0].equals("Create")) {
            var name = args[1];
            var age = Integer.parseInt(args[2]);
            var grade = Double.parseDouble(args[3]);
            if (!repo.containStudentName(name)) {
                var student = new Student(name, age, grade);
                repo.addStudent(name,student);
            }
        } else if (args[0].equals("Show")) {
            var name = args[1];
            if (repo.containStudentName(name)) {
                System.out.println(repo.findStudentByName(name).toString());
            }
        }
    }
}
