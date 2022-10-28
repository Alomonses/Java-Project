public class PrivateAirport extends Airport {
    private String listCompanies[] = new String[10];
    private int numCompanies;

    // constructor
    public PrivateAirport(String name, String city, String country) {
        super(name, city, country);
    }

    public PrivateAirport(String name, String city, String country, Company c[], String e[]) {
        super(name, city, country, c);
        this.listCompanies = e;
        numCompanies = e.length;
    }

    public void insertCompany(String e[]) {
        this.listCompanies = e;
        this.numCompanies = e.length;
    }

    public void insertCompany(String e) {
        listCompanies[numCompanies] = e;
        numCompanies++;
    }

    // Getters
    public String[] getListCompanies() {
        return listCompanies;
    }

    public int getNumCompanies() {
        return numCompanies;
    }

}
