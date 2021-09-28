package one.digitalinnovation.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {

    /*
     * These are all values possible to PhoneType
     * */

    HOME("home"),
    MOBILE("mobile"),
    COMMERCIAL("commercial");

    private final String description;
}
