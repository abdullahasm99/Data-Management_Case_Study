public class DepartmentInfo {

    private Integer departmentId;
    private String departmentName;

    public DepartmentInfo(Integer departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
