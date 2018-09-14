package com.basaki.actuate.myhealth;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MyHealth {

    private Map<String, Object> details;

    @JsonAnyGetter
    public Map<String, Object> getDetails() {
        return this.details;
    }
}
