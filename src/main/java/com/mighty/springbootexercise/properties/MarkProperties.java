package com.mighty.springbootexercise.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties(prefix = "mark")
public class MarkProperties {

    private Integer prefect;

    private Integer good;

    private Integer qualified;

    public Integer getPrefect() {
        return prefect;
    }

    public void setPrefect(Integer prefect) {
        this.prefect = prefect;
    }

    public Integer getGood() {
        return good;
    }

    public void setGood(Integer good) {
        this.good = good;
    }

    public Integer getQualified() {
        return qualified;
    }

    public void setQualified(Integer qualified) {
        this.qualified = qualified;
    }
}
