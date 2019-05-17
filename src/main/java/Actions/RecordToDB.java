package Actions;



import java.sql.*;

public class RecordToDB {
    public void insertDBNamemodelsPrice(String PRICE, String NAMEMODELS ) {
        Connection connection;

        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sakila?serverTimezone=Europe/Moscow&useSSL=false", "root", "123456");
                Statement st = connection.createStatement ();
                st.executeUpdate(String.format("Insert into `namemodels_Price` (`price`,`namemodels`) VALUES ('%s', '%s')",
                        PRICE, NAMEMODELS)) ;
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
