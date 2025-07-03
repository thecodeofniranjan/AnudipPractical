import java.sql.*;
import java.util.Scanner;

public class SecureVaultApp {
      static final String DB_URL = "jdbc:mysql://localhost:3306/securevault";
      static final String USER = "Securevault";
      static final String PASS = "#niranjan123#";

      public static void main(String[] args) {
            Scanner nk = new Scanner(System.in);
            try {
                  Class.forName("com.mysql.cj.jdbc.Driver");
                  Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                  while (true) {
                        System.out.println("\n--- SecureVault ---");
                        System.out.println("1. Insert Credential");
                        System.out.println("2. Read All");
                        System.out.println("3. Read by ID");
                        System.out.println("4. Update by ID");
                        System.out.println("5. Delete by ID");
                        System.out.println("6. Exit");
                        int choice = nk.nextInt();
                        nk.nextLine();

                        switch (choice) {
                              case 1:
                                    System.out.print("Service Name: ");
                                    String service = nk.nextLine();
                                    System.out.print("Username: ");
                                    String username = nk.nextLine();
                                    System.out.print("Password: ");
                                    String password = nk.nextLine();
                                    System.out.print("Email: ");
                                    String email = nk.nextLine();
                                    System.out.print("Notes: ");
                                    String notes = nk.nextLine();

                                    String insertSQL = "INSERT INTO credentials (service_name, username, password, email, notes) VALUES (?, ?, ?, ?, ?)";
                                    PreparedStatement psInsert = conn.prepareStatement(insertSQL);
                                    psInsert.setString(1, service);
                                    psInsert.setString(2, username);
                                    psInsert.setString(3, password);
                                    psInsert.setString(4, email);
                                    psInsert.setString(5, notes);
                                    psInsert.executeUpdate();
                                    System.out.println("Inserted Successfully");
                                    break;

                              case 2:
                                    Statement stmtReadAll = conn.createStatement();
                                    ResultSet rs = stmtReadAll.executeQuery("SELECT * FROM credentials");
                                    while (rs.next()) {
                                          System.out.println(rs.getInt("id") + " | " + rs.getString("service_name")
                                                      + " | " + rs.getString("username") + " | "
                                                      + rs.getString("password") + " | " + rs.getString("email") + " | "
                                                      + rs.getString("notes"));
                                    }
                                    break;

                              case 3:
                                    System.out.print("Enter ID to read: ");
                                    int idRead = nk.nextInt();
                                    nk.nextLine();
                                    PreparedStatement psReadById = conn
                                                .prepareStatement("SELECT * FROM credentials WHERE id = ?");
                                    psReadById.setInt(1, idRead);
                                    ResultSet rsById = psReadById.executeQuery();
                                    if (rsById.next()) {
                                          System.out.println(rsById.getInt("id") + " | "
                                                      + rsById.getString("service_name") + " | "
                                                      + rsById.getString("username") + " | "
                                                      + rsById.getString("password") + " | " + rsById.getString("email")
                                                      + " | " + rsById.getString("notes"));
                                    } else {
                                          System.out.println("Record Not Found");
                                    }
                                    break;

                              case 4:
                                    System.out.print("Enter ID to update: ");
                                    int idUpdate = nk.nextInt();
                                    nk.nextLine();
                                    System.out.print("New Service Name: ");
                                    String newService = nk.nextLine();
                                    System.out.print("New Username: ");
                                    String newUser = nk.nextLine();
                                    System.out.print("New Password: ");
                                    String newPass = nk.nextLine();
                                    System.out.print("New Email: ");
                                    String newEmail = nk.nextLine();
                                    System.out.print("New Notes: ");
                                    String newNote = nk.nextLine();

                                    PreparedStatement psUpdate = conn.prepareStatement(
                                                "UPDATE credentials SET service_name=?, username=?, password=?, email=?, notes=? WHERE id=?");
                                    psUpdate.setString(1, newService);
                                    psUpdate.setString(2, newUser);
                                    psUpdate.setString(3, newPass);
                                    psUpdate.setString(4, newEmail);
                                    psUpdate.setString(5, newNote);
                                    psUpdate.setInt(6, idUpdate);
                                    int rowsUpdated = psUpdate.executeUpdate();
                                    if (rowsUpdated > 0) {
                                          System.out.println("Updated Successfully");
                                    } else {
                                          System.out.println("ID Not Found");
                                    }
                                    break;

                              case 5:
                                    System.out.print("Enter ID to delete: ");
                                    int idDelete = nk.nextInt();
                                    nk.nextLine();
                                    PreparedStatement psDelete = conn
                                                .prepareStatement("DELETE FROM credentials WHERE id = ?");
                                    psDelete.setInt(1, idDelete);
                                    int rowsDeleted = psDelete.executeUpdate();
                                    if (rowsDeleted > 0) {
                                          System.out.println("Deleted Successfully");
                                    } else {
                                          System.out.println("ID Not Found");
                                    }
                                    break;

                              case 6:
                                    conn.close();
                                    nk.close();
                                    System.exit(0);
                        }
                  }
            } catch (Exception e) {
                  e.printStackTrace();
            }
      }
}
