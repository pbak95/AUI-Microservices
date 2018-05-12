package pl.aui.DateAndTime.rest.model;

public class DateResponse {

    private String serviceName;

    private String date;

    public DateResponse(String serviceName, String date) {
        this.serviceName = serviceName;
        this.date = date;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getDate() {
        return date;
    }
}
