package cn.znufew.kot.entity;

public class Teacher {
    private Long id;

    private Boolean identify;

    private String teacherId;

    private String nickName;

    private String name;

    private Boolean sex;

    private String homeCode;

    private String classCode;

    private String email;

    private Long phone;

    private Long commPermissions;

    private Long createTime;

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

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
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

    public Long getCommPermissions() {
        return commPermissions;
    }

    public void setCommPermissions(Long commPermissions) {
        this.commPermissions = commPermissions;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
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