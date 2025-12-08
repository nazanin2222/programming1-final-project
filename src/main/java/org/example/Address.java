package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {

    @Getter @Setter private int streetNo;
    @Getter @Setter private String street;
    @Getter @Setter private String city;
    @Getter @Setter private Province province;
    @Setter private String postalCode;

    public enum Province {
        AB, BC, MB, NB, NL, NS, NT, NU, ON, PE, QC, SK, YT
    }

    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode == null || postalCode.length() != 6) return false;
        for (int i = 0; i < 6; i++) {
            char c = postalCode.charAt(i);
            if (i % 2 == 0) {
                if (!Character.isLetter(c)) return false;
            } else {
                if (!Character.isDigit(c)) return false;
            }
        }
        return true;
    }

    public Address(int streetNo, String street, String city, Province province, String postalCode, boolean validate) {
        if (validate && !isPostalCodeValid(postalCode)) {
            this.streetNo = 0;
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
        } else {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode != null ? postalCode.toUpperCase() : null;
        }
    }
}
