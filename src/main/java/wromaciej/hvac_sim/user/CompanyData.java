package wromaciej.hvac_sim.user;

import wromaciej.hvac_sim.simulation.view.PaperSheet;
import wromaciej.hvac_sim.thermo.unitSystems.UnitSystem;

import java.util.ArrayList;
import java.util.List;

public class CompanyData {

    private final int companyID;
    private final String companyName;
    private final String country;
    private final String taxNumber;
    private final UserVersion userVersion;
    private final Language language;
    private final UnitSystem defaultUnitSystem;
    private final PaperSheet defaultPaperSheet;
    private List<UserData> companyUsers;
    private String logo; //TODO change logo to a image file

    public CompanyData(int companyID, String companyName, String country, String taxNumber, UserVersion userVersion, Language language, UnitSystem defaultUnitSystem, PaperSheet defaultPaperSheet) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.country = country;
        this.taxNumber = taxNumber;
        this.userVersion = userVersion;
        this.language = language;
        this.defaultUnitSystem = defaultUnitSystem;
        this.defaultPaperSheet = defaultPaperSheet;
        this.companyUsers = new ArrayList<>();
    }

    public boolean addNewCompanyUser(int UserID, String personalTitle, String firstName, String lastName){
        //TODO generate unique id
        UserData newUser = new UserData(0, personalTitle, firstName, lastName, this, language, defaultUnitSystem, defaultPaperSheet);
        companyUsers.add(newUser);
        return true;
    }

    public List<UserData> getCompanyUsers() {
        return companyUsers;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCountry() {
        return country;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public UserVersion getUserVersion() {
        return userVersion;
    }

    public Language getLanguage() {
        return language;
    }

    public UnitSystem getDefaultUnitSystem() {
        return defaultUnitSystem;
    }

    public PaperSheet getDefaultPaperSheet() {
        return defaultPaperSheet;
    }
}