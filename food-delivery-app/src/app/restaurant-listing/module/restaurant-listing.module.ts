import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HttpClientModule} from '@angular/common/http';
import {RestaurantListingRoutingModule} from './restaurant-listing-routing.module';
import {RestaurantListingComponent} from '../component/restaurant-listing.component';
import {RestaurantListingService} from '../service/restaurant-listing.service';
import {FoodCatalogueModule} from '../../food-catalouge/module/food-catalogue.module';
import {FoodItemService} from '../../food-catalouge/service/food-item.service';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    HttpClientModule,
    RestaurantListingRoutingModule,
    FoodCatalogueModule,
    RestaurantListingComponent
  ],
  providers: [RestaurantListingService, FoodItemService]
})
export class RestaurantListingModule { }
