package dev.rayh.domain;

public class Client {
    private String name;
    private String ipAddress;

    public Client(String name, String ipAddress) {
        this.name = name;
        this.ipAddress = ipAddress;
    }

    public String getName() {
        return name;
    }

    public String getIpAddress() {
        return ipAddress;
    }
}
