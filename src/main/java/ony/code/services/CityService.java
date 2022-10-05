package ony.code.services;


import ony.code.dao.CityDAO;
import ony.code.dto.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    private CityDAO cityDAO;

    @Autowired
    public CityService(CityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }

    public String generateCity(City city){

        String message;

        if(city.getTitle()==null || city.getTitle().length() == 0){
            message = " ";
            return message;
        }


        if(cityDAO.getCity(city.getTitle())==null){

            message = "There's no such city. Try again you little bich";
             return message;
         }

        if(cityDAO.getCityByFirstChar(city.getTitle())!=null){
        message=cityDAO.getCityByFirstChar(city.getTitle()).getTitle();
        }
        else {
            message = "Game is over. You won, bastard";
        }
        return message;

    }




}
