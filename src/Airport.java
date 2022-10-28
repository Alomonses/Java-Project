public class Airport {
    private String name;
    private String city;
    private String country;
    private Company companylist[] = new Company[10];
    private int numCompany;

    // constructor
    public Airport(String name, String city, String country) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.numCompany = 0;
    }

    public Airport(String name, String city, String country, Company c[]) {
        this.name = name;
        this.city = city;
        this.country = country;
        companylist = c;
        this.numCompany = c.length;
    }

    // methods

    public void insertCompany(Company company) {
        companylist[numCompany] = company;
        numCompany++;
    }

    // getters

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Company[] getCompanylist() {
        return companylist;
    }

    public int getNumCompany() {
        return numCompany;
    }

    public Company getCompany(int i) {
        return companylist[i];
    }

    public Company getCompany(String name) {
        boolean find = false;
        int i = 0;
        Company c = null;
        while ((!find) && (i < companylist.length)) {
            if (name.equals(companylist[i].getName())) {
                find = true;
                c = companylist[i];
            }
            i++;
        }
        return c;
    }

}
