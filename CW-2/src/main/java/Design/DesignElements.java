package Design;
public class DesignElements {

    // --------- welcome msg display method ---------- //
    public static void display_welcome_message() {
        System.out.println("\n\n\t\t\t\t\t\t____    __    ____  _______  __        ______   ______   .___  ___.  _______      \n" +
                "\t\t\t\t\t\t\\   \\  /  \\  /   / |   ____||  |      /      | /  __  \\  |   \\/   | |   ____|     \n" +
                "\t\t\t\t\t\t \\   \\/    \\/   /  |  |__   |  |     |  ,----'|  |  |  | |  \\  /  | |  |__        \n" +
                "\t\t\t\t\t\t  \\            /   |   __|  |  |     |  |     |  |  |  | |  |\\/|  | |   __|       \n" +
                "\t\t\t\t\t\t   \\    /\\    /    |  |____ |  `----.|  `----.|  `--'  | |  |  |  | |  |____      \n" +
                "\t\t\t\t\t\t    \\__/  \\__/     |_______||_______| \\______| \\______/  |__|  |__| |_______|     ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t _          _   _          \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t| |_ ___   | |_| |__   ___ \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t| __/ _ \\  | __| '_ \\ / _ \\\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t| || (_) | | |_| | | |  __/\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t \\__\\___/   \\__|_| |_|\\___|");
        System.out.println(" ____  _                    __  __                                                   _                       _ _           _   _             \n" +
                "|  _ \\| | __ _ _ __   ___  |  \\/  | __ _ _ __   __ _  __ _  ___ _ __ ___   ___ _ __ | |_    __ _ _ __  _ __ | (_) ___ __ _| |_(_) ___  _ __  \n" +
                "| |_) | |/ _` | '_ \\ / _ \\ | |\\/| |/ _` | '_ \\ / _` |/ _` |/ _ \\ '_ ` _ \\ / _ \\ '_ \\| __|  / _` | '_ \\| '_ \\| | |/ __/ _` | __| |/ _ \\| '_ \\ \n" +
                "|  __/| | (_| | | | |  __/ | |  | | (_| | | | | (_| | (_| |  __/ | | | | |  __/ | | | |_  | (_| | |_) | |_) | | | (_| (_| | |_| | (_) | | | |\n" +
                "|_|   |_|\\__,_|_| |_|\\___| |_|  |_|\\__,_|_| |_|\\__,_|\\__, |\\___|_| |_| |_|\\___|_| |_|\\__|  \\__,_| .__/| .__/|_|_|\\___\\__,_|\\__|_|\\___/|_| |_|\n" +
                "                                                     |___/                                      |_|   |_|                                    ");
    }

    // --------- title Design Method ---------- //
    public static void title_Design(String title){
        System.out.println("\n+-------------------------------------------------------+");
        System.out.printf("*                   %-24s            *\n", title);
        System.out.println("+-------------------------------------------------------+");
    }

    // --------- display menu method ---------- //
    public static void display_menu() {
        title_Design("MENU OPTIONS");
        System.out.println("\n 1) Buy a Seat");
        System.out.println(" 2) Cancel a Seat");
        System.out.println(" 3) Find First Available Seat");
        System.out.println(" 4) Show Seating Plan");
        System.out.println(" 5) Print Tickets Info");
        System.out.println(" 6) Search Ticket");
        System.out.print("\nPlease Enter your option : ");
    }
}
