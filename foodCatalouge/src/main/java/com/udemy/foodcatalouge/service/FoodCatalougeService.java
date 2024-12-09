package com.udemy.foodcatalouge.service;

import com.udemy.foodcatalouge.dto.FoodCatalougePage;
import com.udemy.foodcatalouge.dto.FoodItemDTO;
import com.udemy.foodcatalouge.dto.Resturant;
import com.udemy.foodcatalouge.entity.FoodItem;
import com.udemy.foodcatalouge.mapper.FoodItemMapper;
import com.udemy.foodcatalouge.repo.FoodItemRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodCatalougeService {

    private final FoodItemRepo foodItemRepo;

    private final RestTemplate restTemplate;

    public FoodCatalougeService(FoodItemRepo foodItemRepo, RestTemplate restTemplate) {
        this.foodItemRepo = foodItemRepo;
        this.restTemplate = restTemplate;
    }

    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem foodItemSaveInDB= foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOtoFoodItem(foodItemDTO));
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(foodItemSaveInDB);
    }


    public FoodCatalougePage fetchRestaurantDetailsWithFoodMenu(Integer resturantId) {
        List<FoodItem> foodItemList = fetchFoodItemList(resturantId);
        Resturant resturant = fetchResturantDetails(resturantId);
       return createFoodCatalougePage(foodItemList, resturant);

    }

    private FoodCatalougePage createFoodCatalougePage(List<FoodItem> foodItemList, Resturant resturant) {
        FoodCatalougePage foodCatalougePage = new FoodCatalougePage();
        foodCatalougePage.setFoodItemsList(foodItemList);
        foodCatalougePage.setResturant(resturant);
        return foodCatalougePage;
    }

    private Resturant fetchResturantDetails(Integer resturantId) {
      return  restTemplate.getForObject("http://RESTURANTLISTING/resturant/fetchResturantById/"+resturantId, Resturant.class);
    }

    private List<FoodItem> fetchFoodItemList(Integer resturantId) {
       return  foodItemRepo.findByRestaurantId(resturantId);

    }

}
