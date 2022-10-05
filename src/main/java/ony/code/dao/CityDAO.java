package ony.code.dao;

import ony.code.dto.City;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class CityDAO {

    private static final String URL ="jdbc:postgresql://localhost:5432/web_app_db?useUnicode=yes&characterEncoding=UTF-8";
    private static final String USERNAME ="postgres";
    private static final String PASSWORD = "root";

    private static Connection connection;

    static {
        try{
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            connection= DriverManager.getConnection(URL, USERNAME, PASSWORD );
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

    }
public City getCity(String title){

    City cityReturn = new City();

    try {
        Statement statement = connection.createStatement();

        String SQL = "select title_en from CITIES where title_en= '" + title + "';";

            ResultSet resultSet = statement.executeQuery(SQL);

            if(resultSet.next()){

                cityReturn.setTitle(resultSet.getString("title_en"));

                }
                else {

                cityReturn = null;

                }
        }catch (SQLException e){

            throw new RuntimeException(e);

        }
        return cityReturn;
}



     public City getCityByFirstChar(String title){
        City cityReturn = new City();
         System.out.println("City title" + title);
        char firstLetter = title.charAt(title.length()-1);
        try {
            Statement statement = connection.createStatement();
            String SQL = "select title_en from CITIES where title_en like UPPER('" + firstLetter + "%') FETCH FIRST 1 ROWS ONLY;";
            ResultSet resultSet = statement.executeQuery(SQL);

            if(resultSet.next()){

                cityReturn.setTitle(resultSet.getString("title_en"));
            }
            else{
                return null;
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return cityReturn;
    }

}
