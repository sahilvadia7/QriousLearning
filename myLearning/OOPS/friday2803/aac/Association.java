import java.util.ArrayList;
import java.util.List;

class Code {

    private int lineOfCode;
    private String language;
    private String compilationTime;

    public int getLineOfCode() {
        return lineOfCode;
    }

    public void setLineOfCode(int lineOfCode) {
        this.lineOfCode = lineOfCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCompilationTime() {
        return compilationTime;
    }

    public void setCompilationTime(String compilationTime) {
        this.compilationTime = compilationTime;
    }

    @Override
    public String toString() {
        return (
            "code{" +
            "lineOfCode=" +
            lineOfCode +
            ", language='" +
            language +
            '\'' +
            ", compilationTime='" +
            compilationTime +
            '\'' +
            '}'
        );
    }
}

class Project {

    private String projectTitle;
    private List<Code> code;

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public List<Code> getCode() {
        return code;
    }

    public void setCode(List<Code> code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return (
            "Project{" +
            "projectTitle='" +
            projectTitle +
            '\'' +
            ", code=" +
            code +
            '}'
        );
    }
}

public class Association {

    public static void main(String[] args) {
        List<Code> codes = new ArrayList<>();

        Code code = new Code();
        code.setLanguage("Java");
        code.setLineOfCode(2000);
        code.setCompilationTime("1.0MS");

        Code code1 = new Code();
        code1.setLanguage("go-lang");
        code1.setLineOfCode(1000);
        code1.setCompilationTime("2.0MS");

        codes.add(code);
        codes.add(code1);

        Project scoreBoard = new Project();
        scoreBoard.setProjectTitle("ScoreBoard");
        scoreBoard.setCode(codes);

        System.out.println(scoreBoard);
    }
}
