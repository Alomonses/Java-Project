import java.util.Scanner;

public class App {
    static Scanner input = new Scanner(System.in);
    final static int num = 4;
    static Airport airports[] = new Airport[num];

    public static void main(String[] args) {
        insertData(airports);
        menu();
    }

    public static void insertData(Airport aero[]) {
        aero[0] = new PublicAirport(800000, "Jorge Chavez", "Lima", "Peru");
        aero[0].insertCompany(new Company("AeroPeru"));
        aero[0].insertCompany(new Company("LATAM"));
        aero[0].getCompany("AeroPeru").insertFlight(new Flight("IB20", "Lima", "Mexico", 150.90, 150));
        aero[0].getCompany("AeroPeru").insertFlight(new Flight("IB20", "Lima", "Buenos Aires", 180.99, 120));
        aero[0].getCompany("LATAM").insertFlight(new Flight("FC12", "Lima", "London", 500.90, 150));
        aero[0].getCompany("AeroPeru").getFlight("IB20")
                .insertPassenger(new Passenger("Alejando", "20GHSD", "Peru"));
        aero[0].getCompany("AeroPeru").getFlight("IB20")
                .insertPassenger(new Passenger("Alondra", "34IUHS", "Mexicana"));
        aero[0].getCompany("LATAM").getFlight("FC12").insertPassenger(new Passenger("Raul", "45IJESS", "Colombian"));

        aero[1] = new PrivateAirport("Central Ciudad Real", "Ciudad real", "Spain");
        aero[1].insertCompany(new Company("AirEuropa"));
        String empresas[] = { "Cobresol", "Anguila34" };
        ((PrivateAirport) aero[1]).insertCompany(empresas);
        aero[1].getCompany("AirEuropa").insertFlight(new Flight("AE025", "Madrid", "Buenos Aires", 190, 43));
        aero[1].getCompany("AirEuropa").getFlight("AE025").insertPassenger(new Passenger(null, null, null));

        aero[2] = new PublicAirport(2000000, "Airport Bogota", "Bogota", "Colombia");
        aero[2].insertCompany(new Company("AirAmerica"));
        aero[2].insertCompany(new Company("VuelaBogota"));
        aero[2].getCompany("AirAmerica").insertFlight(new Flight("AE030", "Bogota", "Lima", 130.90, 80));
        aero[2].getCompany("AirAmerica").insertFlight(new Flight("AE031", "Bogota", "Lima", 230, 50));
        aero[2].getCompany("AirAmerica").getFlight("AE030")
                .insertPassenger(new Passenger("Paco", "34IOSD", "Peruvian"));
        aero[2].getCompany("AirAmerica").getFlight("AE030")
                .insertPassenger(new Passenger("Mateo", "23AWER", "Brasieleño"));

        aero[3] = new PublicAirport(345000, "Airport Mexico", "CDMX", "Mexico");
        aero[3].insertCompany(new Company("AeroMexico"));
        aero[3].getCompany("AeroMexico").insertFlight(new Flight("IB2040", "Mexico", "New York", 130.90, 80));
        aero[3].getCompany("AeroMexico").insertFlight(new Flight("IB2040", "Mexico", "Lima", 230, 50));
        aero[3].getCompany("AeroMexico").getFlight("IB2040")
                .insertPassenger(new Passenger("Nagisa", "12POUY", "Japanese"));
    }

    public static void menu() {
        int option;
        String nameAiport, nameCompany, origen, destiny;
        Airport airport;
        Company company;

        do {
            System.out.println("\t: MENU");
            System.out.println("\n1. Show airports managed  ( Public or Private)");
            System.out.println("2. Show companys");
            System.out.println("3. Airport company list");
            System.out.println("4. List of flights by company");
            System.out.println("5. List possible flights from origin to destination");
            System.out.println("6.Done");
            System.out.println("\nSelect an option");
            System.out.print("Opcion: ");
            option = input.nextInt();

            switch (option) {
                case 1://
                    System.out.println("");
                    ShowDataAirports(airports);
                    break;
                case 2:// show companys (private o subvencion)
                    System.out.println("");
                    ShowPs(airports);
                    break;
                case 3:// list companys of airport
                    input.nextLine();
                    System.out.println("Enter the name of the airport: ");
                    nameAiport = input.nextLine(); // save input
                    airport = findAirport(nameAiport, airports);
                    System.out.println("");

                    if (airport == null) {
                        System.out.println("The Airport does not exist");
                    } else {
                        showCompanies(airport);
                    }
                    break;
                case 4:
                    input.nextLine();
                    System.out.println("Enter the name of the airport:");
                    nameAiport = input.nextLine();
                    airport = findAirport(nameAiport, airports);

                    if (airport == null) {
                        System.out.println("The Airport does not exist");
                    } else {
                        System.out.println("Enter the name of the company:");
                        nameCompany = input.nextLine();
                        company = airport.getCompany(nameCompany);
                        showFlights(company);
                    }
                    break;
                case 5:// Listar posibles vuelos de Origen a Destino
                    input.nextLine();
                    System.out.println("\nEnter city of origin:");
                    origen = input.nextLine();
                    System.out.println("\nEnter city of destiny:");
                    destiny = input.nextLine();
                    showFlightsOrigenDestiny(origen, destiny, airports);

                    break;
                case 6:
                    break;

                default:
                    break;
            }

        } while (option != 6);
    }

    // caso 1
    public static void ShowDataAirports(Airport airports[]) {
        for (int i = 0; i < airports.length; i++) {
            if (airports[i] instanceof PrivateAirport) {
                System.out.println("Aeropuerto Privado");
                System.out.println("Nombre: " + airports[i].getName());
                System.out.println("Ciudad: " + airports[i].getCity());
                System.out.println("Pais: " + airports[i].getCountry());
            } else {
                System.out.println("Aeropuerto Privado");
                System.out.println("Nombre: " + airports[i].getName());
                System.out.println("Ciudad: " + airports[i].getCity());
                System.out.println("Pais: " + airports[i].getCountry());

            }
            System.out.println("");

        }

    }

    // caso 2
    public static void ShowPs(Airport airports[]) {
        String companys[];

        for (int i = 0; i < airports.length; i++) {
            if (airports[i] instanceof PrivateAirport) {
                System.out.println("Aeropuerto Privado: " + airports[i].getName());
                companys = ((PrivateAirport) airports[i]).getListCompanies();
                System.out.println("Empresas: ");

                for (int j = 0; j < companys.length; j++) {
                    System.out.println(companys[j]);
                }
            } else {
                System.out.println("Aeropuerto Publico " + airports[i].getName());
                System.out.println("Subvencion: " + ((PublicAirport) airports[i]).getSubvencion());

            }
            System.out.println("");
        }
    }

    // caso 3
    public static Airport findAirport(String name, Airport airports[]) {
        boolean find = false;
        int i = 0;
        Airport aero = null;
        while ((!find) && (i < airports.length)) {
            if (name.equals(airports[i].getName())) {
                find = true;
                aero = airports[i];
            }
            i++;
        }
        return aero;
    }

    public static void showCompanies(Airport airports) {
        System.out.println("\nAirport companies: " + airports.getName());
        for (int i = 0; i < airports.getNumCompany(); i++) {
            System.out.println(airports.getCompany(i).getName());
        }
    }

    // caso 4

    public static void showFlights(Company company) {
        Flight flight;
        System.out.println("Company flights " + company.getName());
        for (int i = 0; i < company.getNumFlight(); i++) {
            flight = company.getFlight(i);
            System.out.println("ID Flight: " + flight.getidFlight());
            System.out.println("Origin City: " + flight.getOrigen());
            System.out.println("Destination city: " + flight.getDestiny());
            System.out.println("Price: $" + flight.getPrice());
            System.out.println((""));
        }
    }

    // caso 5

    public static Flight[] findFlightsOrigenDestiny(String origen, String destiny, Airport airports[]) {
        Flight flight;
        int counter = 0;
        Flight FlightList[];

        for (int i = 0; i < airports.length; i++) { // recorremos los aeropuertos
            for (int j = 0; j < airports[i].getNumCompany(); j++) { // recorremos las compañias
                for (int k = 0; k < airports[i].getCompany(j).getNumFlight(); k++) { // recorremos los vuelos
                    flight = airports[i].getCompany(j).getFlight(k);
                    if ((origen.equals(flight.getOrigen())) && (destiny.equals(flight.getDestiny()))) {
                        counter++;
                    }
                }
            }
        }
        FlightList = new Flight[counter];
        int q = 0;

        for (int i = 0; i < airports.length; i++) {
            for (int j = 0; j < airports[i].getNumCompany(); j++) {
                for (int k = 0; k < airports[i].getCompany(j).getNumFlight(); k++) {
                    flight = airports[i].getCompany(j).getFlight(k);
                    if ((origen.equals(flight.getOrigen())) && (destiny.equals(flight.getDestiny()))) {
                        FlightList[q] = flight;
                        q++;
                    }
                }
            }
        }
        return FlightList;
    }

    public static void showFlightsOrigenDestiny(String origen, String destiny, Airport airports[]) {
        Flight flight[];
        flight = findFlightsOrigenDestiny(origen, destiny, airports);
        if (flight.length == 0) {
            System.out.println("There are no flights from that city origin to destination");
        } else {
            System.out.println("\nFlights found: ");
            System.out.println("");
            for (int i = 0; i < flight.length; i++) {
                System.out.println("Flight ID " + flight[i].getidFlight());
                System.out.println("Origin city: " + flight[i].getOrigen());
                System.out.println("Destination city: " + flight[i].getDestiny());
                System.out.println("Price: $" + flight[i].getPrice());
                System.out.println("");
            }
        }
    }

}