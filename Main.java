import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Show {
    private String title;
    private String duration;
    private String venue;
    private List<String> ageCategories;
    private List<TicketType> ticketTypes;

    public Show(String title, String duration, String venue) {
        this.title = title;
        this.duration = duration;
        this.venue = venue;
        this.ageCategories = new ArrayList<>();
        this.ticketTypes = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }

    public String getVenue() {
        return venue;
    }

    public List<String> getAgeCategories() {
        return ageCategories;
    }

    public void addAgeCategory(String category) {
        ageCategories.add(category);
    }

    public void addTicketType(TicketType ticketType) {
        ticketTypes.add(ticketType);
    }

    public List<TicketType> getTicketTypes() {
        return ticketTypes;
    }
}

class TicketType {
    private String type;
    private double price;

    public TicketType(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}

class Ticket {
    private Show show;
    private TicketType ticketType;

    public Ticket(Show show, TicketType ticketType) {
        this.show = show;
        this.ticketType = ticketType;
    }

    public Show getShow() {
        return show;
    }

    public TicketType getTicketType() {
        return ticketType;
    }
}

class Customer {
    private String name;
    private List<Ticket> tickets;

    public Customer(String name) {
        this.name = name;
        this.tickets = new ArrayList<>();
    }

    public void buyTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public String getName() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Show> shows = new ArrayList<>();


        Show musical1 = new Show("The Lion King", "2 hours", "Peacock Theatre");
        musical1.addTicketType(new TicketType("Adult", 50.0));
        musical1.addTicketType(new TicketType("Senior", 40.0));
        musical1.addTicketType(new TicketType("Student", 30.0));
        shows.add(musical1);

        Show musical2 = new Show("Frozen the Musical", "2.5 hours", "Prince of Wales Theatre");
        musical2.addTicketType(new TicketType("Adult", 55.0));
        musical2.addTicketType(new TicketType("Senior", 45.0));
        musical2.addTicketType(new TicketType("Student", 35.0));
        shows.add(musical2);

        Show musical3 = new Show("A Christmas Carol", "1.5 hours", "Gillian Lynne Theatre");
        musical3.addTicketType(new TicketType("Adult", 55.0));
        musical3.addTicketType(new TicketType("Senior", 45.0));
        musical3.addTicketType(new TicketType("Student", 35.0));
        shows.add(musical3);

        Show musical4 = new Show("Crazy For You", "2 hours", "Bridge Theatre");
        musical4.addTicketType(new TicketType("Adult", 55.0));
        musical4.addTicketType(new TicketType("Senior", 45.0));
        musical4.addTicketType(new TicketType("Student", 35.0));
        shows.add(musical4);

        Show musical5 = new Show("Edward Scissorhands", "2 hours", "Sadler's Wells");
        musical5.addTicketType(new TicketType("Adult", 55.0));
        musical5.addTicketType(new TicketType("Senior", 45.0));
        musical5.addTicketType(new TicketType("Student", 35.0));
        shows.add(musical5);

        Show musical6 = new Show("Sister Act", "1 hours", "The Actors' Church");
        musical6.addTicketType(new TicketType("Adult", 55.0));
        musical6.addTicketType(new TicketType("Senior", 45.0));
        musical6.addTicketType(new TicketType("Student", 35.0));
        shows.add(musical6);

        Show musical7 = new Show("The Little Big Things", "3 hours", "The OVO Arena Wembley");
        musical7.addTicketType(new TicketType("Adult", 55.0));
        musical7.addTicketType(new TicketType("Senior", 45.0));
        musical7.addTicketType(new TicketType("Student", 35.0));
        shows.add(musical7);

        Show musical8 = new Show("The Mongol Khan", "2 hours", "Riverside Studios");
        musical8.addTicketType(new TicketType("Adult", 55.0));
        musical8.addTicketType(new TicketType("Senior", 45.0));
        musical8.addTicketType(new TicketType("Student", 35.0));
        shows.add(musical8);

        Show musical9 = new Show("Unbelievable", "3 hours", "Adelphi Theatre");
        musical9.addTicketType(new TicketType("Adult", 55.0));
        musical9.addTicketType(new TicketType("Senior", 45.0));
        musical9.addTicketType(new TicketType("Student", 35.0));
        shows.add(musical9);

        Show musical10 = new Show("The Time Traveller's Wife", "2 hours", "Savoy Theatre");
        musical10.addTicketType(new TicketType("Adult", 55.0));
        musical10.addTicketType(new TicketType("Senior", 45.0));
        musical10.addTicketType(new TicketType("Student", 35.0));
        shows.add(musical10);


        JFrame frame = new JFrame("Musical Booking System");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JTextArea musicalListTextArea = new JTextArea(10, 30);
        musicalListTextArea.setEditable(false); // Make the text area non-editable

        JButton musicalListButton = new JButton("Musical List");
        JButton showScheduleButton = new JButton("Show Schedule");
        JButton bookTicketsButton = new JButton("Book Tickets");
        JButton exitButton = new JButton("Exit");

        buttonPanel.add(musicalListButton);
        buttonPanel.add(showScheduleButton);
        buttonPanel.add(bookTicketsButton);
        buttonPanel.add(exitButton);

        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(musicalListTextArea), BorderLayout.CENTER); // Add text area to display musical list

        // Add action listeners for buttons
        musicalListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display list of musicals
                StringBuilder showList = new StringBuilder("London Musical Tickets:\n");
                for (Show show : shows) {
                    showList.append("Title: ").append(show.getTitle()).append("\n");
                    showList.append("Duration: ").append(show.getDuration()).append("\n");
                    showList.append("Venue: ").append(show.getVenue()).append("\n");
                    showList.append("Age Categories: ").append(show.getAgeCategories()).append("\n\n");
                }
                musicalListTextArea.setText(showList.toString());
            }
        });

        showScheduleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display show schedule (unchanged code for demonstration)
                // Simulated schedule details for demonstration purposes
                StringBuilder scheduleDetails = new StringBuilder("Show Schedule:\n");

                Map<String, String> scheduleInfo = new HashMap<>();
                scheduleInfo.put("The Lion King", "Date: Nov 15, 2023 | Time: 7:00 PM | Seats: 100");
                scheduleInfo.put("Frozen the Musical", "Date: Nov 20, 2023 | Time: 6:30 PM | Seats: 80");
                scheduleInfo.put("A Christmas Carol", "Date: Nov 25, 2023 | Time: 8:00 PM | Seats: 120");
                scheduleInfo.put("Crazy For You", "Date: Nov 17, 2023 | Time: 1:00 PM | Seats: 20");
                scheduleInfo.put("Edward Scissorhands", "Date: Nov 10, 2023 | Time: 3:00 PM | Seats: 220");
                scheduleInfo.put("Sister Act", "Date: Nov 19, 2023 | Time: 3:00 PM | Seats: 120");
                scheduleInfo.put("The Little Big Things", "Date: Nov 21, 2023 | Time: 5:00 PM | Seats: 130");
                scheduleInfo.put("The Mongol Khan", "Date: Nov 28, 2023 | Time: 1:00 PM | Seats: 170");
                scheduleInfo.put("Unbelievable", "Date: Nov 17, 2023 | Time: 2:00 PM | Seats: 140");
                scheduleInfo.put("The Time Traveller's Wife", "Date: Nov 12, 2023 | Time: 4:00 PM | Seats: 20");

                for (Show show : shows) {
                    if (scheduleInfo.containsKey(show.getTitle())) {
                        scheduleDetails.append("Title: ").append(show.getTitle()).append("\n");
                        scheduleDetails.append(scheduleInfo.get(show.getTitle())).append("\n\n");
                    }
                }

                JOptionPane.showMessageDialog(null, scheduleDetails.toString(), "Show Schedule", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Action listener for booking tickets
        bookTicketsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedShow = JOptionPane.showInputDialog(null, "Enter the name of the musical show:");

                boolean showFound = false;
                for (Show show : shows) {
                    if (show.getTitle().equalsIgnoreCase(selectedShow)) {
                        showFound = true;

                        String[] ticketTypes = { "Adult", "Senior", "Student" };
                        String selectedTicketType = (String) JOptionPane.showInputDialog(null, "Select Ticket Type:",
                                "Ticket Type", JOptionPane.QUESTION_MESSAGE, null, ticketTypes, ticketTypes[0]);

                        TicketType ticketType = null;
                        for (TicketType type : show.getTicketTypes()) {
                            if (type.getType().equalsIgnoreCase(selectedTicketType)) {
                                ticketType = type;
                                break;
                            }
                        }

                        if (ticketType != null) {
                            Customer customer = new Customer("John Doe");
                            Ticket ticket = new Ticket(show, ticketType);
                            customer.buyTicket(ticket);

                            String receipt = "Musical Show: " + show.getTitle() + "\nTicket Type: " + ticketType.getType()
                                    + "\nPrice: £" + ticketType.getPrice() + "\n\n";

                            saveReceiptToFile(receipt, "ticket_receipt.txt");
                            JOptionPane.showMessageDialog(null, "Ticket purchased. Receipt saved as ticket_receipt.txt",
                                    "Ticket Purchased", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid ticket type", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    }
                }

                if (!showFound) {
                    JOptionPane.showMessageDialog(null, "Musical show not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the application
            }
        });

        // Setting frame properties
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void saveReceiptToFile(String receipt, String filename) {
        try {
            FileWriter writer = new FileWriter(filename, true);
            writer.write(receipt);
            writer.close();
            System.out.println("Receipt saved as " + filename);
        } catch (IOException ex) {
            System.err.println("Error: Unable to save receipt");
        }
    }
}
