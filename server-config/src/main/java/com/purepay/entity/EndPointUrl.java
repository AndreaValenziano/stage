package com.purepay.entity;

import org.springframework.http.HttpMethod;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by AndreaValenziano on 28/05/18.
 */
public class EndPointUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String endPointName;
    private String url;
    private HttpMethod method;
    private int port;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndPointName() {
        return endPointName;
    }

    public void setEndPointName(String endPointName) {
        this.endPointName = endPointName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "EndPointUrl{" +
                "id=" + id +
                ", endPointName='" + endPointName + '\'' +
                ", url='" + url + '\'' +
                ", method=" + method +
                ", port=" + port +
                '}';
    }
}
