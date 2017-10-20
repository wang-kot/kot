package cn.znufew.kot.entity;

public class Student {
    private Long id;

    private Boolean identify;

    private Long studentId;

    private String nickName;

    private String name;

    private Boolean sex;

    private Long birthday;

    private String homeCode;

    private String classCode;

    private String email;

    private Long phone;

    private String commentPermissions;

    private Long registTime;

    private Long identifyTime;

    private String passw;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIdentify() {
        return identify;
    }

    public void setIdentify(Boolean identify) {
        this.identify = identify;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public String getHomeCode() {
        return homeCode;
    }

    public void setHomeCode(String homeCode) {
        this.homeCode = homeCode == null ? null : homeCode.trim();
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode == null ? null : classCode.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getCommentPermissions() {
        return commentPermissions;
    }

    public void setCommentPermissions(String commentPermissions) {
        this.commentPermissions = commentPermissions == null ? null : commentPermissions.trim();
    }

    public Long getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Long registTime) {
        this.registTime = registTime;
    }

    public Long getIdentifyTime() {
        return identifyTime;
    }

    public void setIdentifyTime(Long identifyTime) {
        this.identifyTime = identifyTime;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw == null ? null : passw.trim();
    }
}