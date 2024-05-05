package fit.se2.se02_project.dto;

public class FeedbackDTO {
    private String name;
    private String comment;

    public FeedbackDTO(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    public FeedbackDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
