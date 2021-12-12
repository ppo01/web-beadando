package web.beadando.service.domain;

import java.util.Objects;

public class CompanyDto {

    private Long companyId;
    private String companyName;
    private String address;
    private String mainActivity;

    public CompanyDto() {
    }

    public CompanyDto(Long companyId, String companyName, String address, String mainActivity) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.address = address;
        this.mainActivity = mainActivity;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(String mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyDto that = (CompanyDto) o;
        return Objects.equals(companyId, that.companyId) && Objects.equals(companyName, that.companyName) && Objects.equals(address, that.address) && Objects.equals(mainActivity, that.mainActivity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, companyName, address, mainActivity);
    }

    @Override
    public String toString() {
        return "PositionDto{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", mainActivity='" + mainActivity + '\'' +
                '}';
    }
}
