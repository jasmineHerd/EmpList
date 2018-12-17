package business;


/**
 * @author 
 */
public class Employee {
    private long empno, phone;
    private String lastnm, firstnm, middlenm, suffix;
    private String address1, address2, city, state, zip, gender;
    private String status, hiredt, terminatedt;
    private int paycd;

    public Employee() {
        this.empno = 0;
        phone = 0;
        lastnm = "";
        firstnm = "";
        middlenm = "";
        suffix = "";
        address1 = "";
        address2 = "";
        city = "";
        state = "";
        zip = "";
        gender = "";
        status = "";
        hiredt = "";
        terminatedt = "";
        paycd = 0;
    }
    public Long getEmpno() {
        return empno;
    }
    public void setEmpno(Long empno) {
        this.empno = empno;
    }
    public Long getPhone() {
        return phone;
    }
    public void setPhone(Long phone) {
        this.phone = phone;
    }
    public String getLastnm() {
        return lastnm;
    }
    public void setLastnm(String lastnm) {
        this.lastnm = lastnm;
    }
    public String getFirstnm() {
        return firstnm;
    }
    public void setFirstnm(String firstnm) {
        this.firstnm = firstnm;
    } 
    public String getMiddlenm() {
        return middlenm;
    }
    public void setMiddlenm(String middlenm) {
        this.middlenm = middlenm;
    }
    public String getSuffix() {
        return suffix;
    }
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
    public String getAddress1() {
        return address1;
    }
    public void setAddress1(String addr1) {
        this.address1 = addr1;
    }
    public String getAddress2() {
        return address2;
    }
    public void setAddress2(String addr2) {
        this.address2 = addr2;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    } 
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getHiredt() {
        return hiredt;
    } 
    public void setHiredt(String hiredt) {
        this.hiredt = hiredt;
    }
    public String getTerminatedt() {
        return terminatedt;
    }
    public void setTerminatedt(String terminateddt) {
        this.terminatedt = terminateddt;
    }
    public Integer getPaycd() {
        return paycd;
    }
    public void setPaycd(Integer paycd) {
        this.paycd = paycd;
    }
}
