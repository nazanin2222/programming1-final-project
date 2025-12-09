package org.example;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Address {
    @Getter @Setter private int streetNo;
    @Getter @Setter private String street;
    @Getter @Setter private String city;
    @Getter @Setter private Province province;
    private String postalCode;

    public enum Province {
        AB, BC, MB, NB, NL, NS, NT, NU, ON, PE, QC, SK, YT
    }

    /**
     * checks if postal code is valid
     * @param postalCode the postal code to validate
     * @return true if valid, false if not
     */
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

    public Address(int streetNo, String street, String city, Province province, String postalCode) {
        if (isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode.toUpperCase();
        } else {
            this.streetNo = 0;
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
        }
    }

    public void setPostalCode(String postalCode) {
        if (isPostalCodeValid(postalCode)) {
            this.postalCode = postalCode.toUpperCase();
        }
    }
}
